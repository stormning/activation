/**
 * Project name : activation
 * File name : ActivationService.java
 * Package name : com.slyak.activation.service
 * Date : 2013-11-27
 * Copyright : 2013 , SLYAK.COM All Rights Reserved
 * Author : stormning@163.com
 */
package com.slyak.activation.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.slyak.activation.ex.ActivationException;
import com.slyak.activation.model.ActivationRecord;
import com.slyak.activation.model.ActivationRequest;

public interface ActivationService {

	String activate(ActivationRequest activationRequest) throws ActivationException;
	
	Page<ActivationRecord> findAll(Pageable pageable);
}
