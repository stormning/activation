package com.slyak.activation.ex;

public class ActivationException extends Exception {

	private static final long serialVersionUID = 1L;
	private int code;
	
	public ActivationException(int code){
		super();
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
