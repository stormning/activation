/**
 * Project name : activation
 * File name : ActivationException.java
 * Package name : com.slyak.activation.ex
 * Date : 2013-11-27
 * Copyright : 2013 , SLYAK.COM All Rights Reserved
 * Author : stormning@163.com
 */
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
