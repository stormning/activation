package com.slyak.activation.service;

import com.slyak.activation.ex.ActivationException;
import com.slyak.activation.model.ActivationRequest;

public interface ActivationService {

	String activate(ActivationRequest activationRequest) throws ActivationException;
}
