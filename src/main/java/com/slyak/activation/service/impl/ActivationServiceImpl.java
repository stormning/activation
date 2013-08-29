package com.slyak.activation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.slyak.activation.dao.ActivationRecordDAO;
import com.slyak.activation.dao.StudyCardDAO;
import com.slyak.activation.ex.ActivationException;
import com.slyak.activation.ex.ErrorCode;
import com.slyak.activation.model.ActivationRecord;
import com.slyak.activation.model.ActivationRequest;
import com.slyak.activation.model.StudyCard;
import com.slyak.activation.service.ActivationService;

@Service
public class ActivationServiceImpl implements ActivationService {

	@Autowired
	private StudyCardDAO studyCardDAO;
	
	@Autowired
	private ActivationRecordDAO activationRecordDAO;
	
	@Value("#{config['activate.eachhardcode.maxcount']}")
	private int eachHardCodeMaxCount = 1;
	

	public String activate(ActivationRequest activationRequest) throws ActivationException{
		String cardNo = activationRequest.getCardNo();
		StudyCard card = studyCardDAO.findOne(cardNo);
		if(card == null || !card.getPassword().equalsIgnoreCase(activationRequest.getPassword())){
			throw new ActivationException(ErrorCode.CARDNO_OR_PASSWORD_ERROR);
		}else{
			int count = activationRecordDAO.countByCardNoAndHardCode(cardNo,activationRequest.getHardCode());
			if(count >= eachHardCodeMaxCount){
				throw new ActivationException(ErrorCode.HARDCODE_OVER_TIMES_ERROR);
			}
			
			//get lessons and do md5
			//TODO
			String verifyCode = "";
			
			ActivationRecord ar = new ActivationRecord();
			
			ar.setVerifyCode(verifyCode);
//			Activa
			activationRecordDAO.save(ar);
			return null;
		}
	}
}
