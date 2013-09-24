package com.slyak.activation.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.slyak.activation.dao.ActivationRecordDAO;
import com.slyak.activation.dao.CourseDao;
import com.slyak.activation.dao.StudyCardDAO;
import com.slyak.activation.enums.Section;
import com.slyak.activation.ex.ActivationException;
import com.slyak.activation.ex.ErrorCode;
import com.slyak.activation.model.ActivationRecord;
import com.slyak.activation.model.ActivationRequest;
import com.slyak.activation.model.Course;
import com.slyak.activation.model.StudyCard;
import com.slyak.activation.service.ActivationService;
import com.slyak.activation.service.Md5ActivateCodeGenerator;
import com.slyak.user.dao.UserDao;
import com.slyak.user.util.LoginUserHelper;

@Service
public class ActivationServiceImpl implements ActivationService {

	@Autowired
	private StudyCardDAO studyCardDAO;
	
	@Autowired
	private CourseDao courseDao;
	
	@Autowired
	private ActivationRecordDAO activationRecordDAO;
	
	@Value("#{config['activate.eachhardcode.maxcount']}")
	private int eachHardCodeMaxCount = 1;
	
	@Value("#{config['activate.hardcode.maxcount']}")
	private int hardCodeMaxCount = 1;
	
	@Autowired
	private UserDao userDao;

	private static final String rolePrimaryUser = "pu";
	private static final String rolePrimaryAdmin = "pa";
	
	private static final String roleSeniorUser = "su";
	private static final String roleSeniorAdmin = "sa";
	
	private static final Set<String> primaryActivators = new HashSet<String>();
//	private static final Set<String> primaryRecordviewers = new HashSet<String>();
	
	private static final Set<String> seniorActivators = new HashSet<String>();
//	private static final Set<String> seniorRecordviewers = new HashSet<String>();
	
	private static final Map<Section,Set<String>> sectionActivators = new HashMap<Section, Set<String>>();
//	private static final Map<Section,Set<String>> sectionRecordviewers = new HashMap<Section, Set<String>>();
	
	private static final Map<String,Set<Section>> viewerAndSections = new HashMap<String, Set<Section>>();
	
	static {
		primaryActivators.add(rolePrimaryUser);
		primaryActivators.add(rolePrimaryAdmin);
		sectionActivators.put(Section.PRIMARY, primaryActivators);
		
//		primaryRecordviewers.add(rolePrimaryAdmin);
//		sectionRecordviewers.put(Section.PRIMARY, primaryRecordviewers);
		
		
		seniorActivators.add(roleSeniorUser);
		seniorActivators.add(roleSeniorAdmin);
		sectionActivators.put(Section.SENIOR, seniorActivators);
		
		viewerAndSections.put(rolePrimaryAdmin, Collections.singleton(Section.PRIMARY));
		viewerAndSections.put(roleSeniorAdmin, Collections.singleton(Section.SENIOR));
//		seniorRecordviewers.add(roleSeniorAdmin);
//		sectionRecordviewers.put(Section.SENIOR, seniorRecordviewers);
	}
	
	private boolean canActivate(Section section){
		try{
			Set<String> allowedRoles = sectionActivators.get(section);
			if(allowedRoles!=null){
				Subject subject = SecurityUtils.getSubject();
				for (String role : allowedRoles) {
					if(subject.hasRole(role)){
						return true;
					}
				}
			}
			return false;
		}catch (AuthorizationException ae){
			return false;
		}
	}
	
	public String activate(ActivationRequest request) throws ActivationException{
		String cardNo = request.getCardNo();
		StudyCard card = studyCardDAO.findOne(cardNo);
		if(card == null){
			throw new ActivationException(ErrorCode.CARDNO_OR_PASSWORD_ERROR);
		} else{
			Course course = courseDao.findOne(card.getCourseId());
			if(course == null){
				throw new ActivationException(ErrorCode.COURSE_NOT_EXIST_ERROR);
			}else if(!canActivate(course.getSection())){
				throw new ActivationException(ErrorCode.NO_SECTION_PERMISSION_ERROR);
			}else if (!card.getPassword().equalsIgnoreCase(request.getPassword())){
				throw new ActivationException(ErrorCode.CARDNO_OR_PASSWORD_ERROR);
			}else if (card.getExpireAt()!=null&&card.getExpireAt().before(new Date())){
				throw new ActivationException(ErrorCode.EXPIRED_CARD_ERROR);
			}else{
				String hardCode = request.getHardCode();
				List<ActivationRecord> arrs = activationRecordDAO.findByCardNo(cardNo);
				if(!CollectionUtils.isEmpty(arrs)&&arrs.size()>=hardCodeMaxCount){
					throw new ActivationException(ErrorCode.HARDCODE_OVER_TIMES_ERROR);
				}
				int eachHardCodeCount = 0;
				for (ActivationRecord ar : arrs) {
					if(hardCode.equals(ar.getHardCode())){
						eachHardCodeCount++;
					}
				}
				if(eachHardCodeCount>=eachHardCodeMaxCount){
					throw new ActivationException(ErrorCode.HARDCODE_OVER_TIMES_ERROR);
				}
				//“a学习卡号#密码#课程ID”+“数字1”+四位机器码
				String credStr = card.getCourseId()+"1"+hardCode;
				String verifyCode = Md5ActivateCodeGenerator.generate(credStr);
				
				ActivationRecord ar = new ActivationRecord();
				ar.setParentMobile(request.getParentMobile());
				ar.setParentName(request.getParentName());
				ar.setCardNo(request.getCardNo());
				ar.setSeller(request.getSeller());
				ar.setHardCode(hardCode);
				ar.setStudentName(request.getStudentName());
				ar.setActivateAt(new Date());
				ar.setVerifyCode(verifyCode);
				ar.setCourseId(card.getCourseId());
				ar.setOperator(LoginUserHelper.getLoginUserId());
				activationRecordDAO.save(ar);
				return verifyCode;
			}
		}
	}
	
	public Page<ActivationRecord> findAll(Pageable pageable){
		String[] roles = StringUtils.split(LoginUserHelper.getLoginUser().getRoles(),',');
		Set<Section> allowedSections = new HashSet<Section>();
		for (String role : roles) {
			Set<Section> tmp = viewerAndSections.get(role);
			if(tmp!=null){
				allowedSections.addAll(tmp);
			}
		}
		if(CollectionUtils.isEmpty(allowedSections)){
			return null;
		}
		Page<ActivationRecord> page = activationRecordDAO.findBySectionIn(pageable,allowedSections);
		if(page!=null && page.getTotalElements()>0){
			List<ActivationRecord> ars = page.getContent();
			for (ActivationRecord ar : ars) {
				Course course = courseDao.findOne(ar.getCourseId());
				if(course!=null){
					ar.setCourseName(course.getName());
				}
				ar.setOpUser(userDao.findOne(ar.getOperator()));
			}
		}
		return page;
	}
}
