package com.slyak.activation.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.slyak.activation.dao.ActivationRecordDAO;
import com.slyak.activation.dao.CourseDao;
import com.slyak.activation.dao.StudyCardDAO;
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
	

	public String activate(ActivationRequest request) throws ActivationException{
		String cardNo = request.getCardNo();
		StudyCard card = studyCardDAO.findOne(cardNo);
		if(card == null || !card.getPassword().equalsIgnoreCase(request.getPassword())){
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
			String credStr = "a"+ cardNo+"#"+request.getPassword()+"#"+card.getCourseId()+"#1"+hardCode;
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
	
	public Page<ActivationRecord> findAll(Pageable pageable){
		Page<ActivationRecord> page = activationRecordDAO.findAll(pageable);
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
