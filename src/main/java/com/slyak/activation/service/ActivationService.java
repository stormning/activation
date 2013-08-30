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
