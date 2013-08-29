package com.slyak.activation.model;

import java.io.Serializable;

public class ActivationRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cardNo;
	
	private String password;
	
	private String hardCode;
	
	private String seller;
	
	private String studentName;
	
	private String parentName;
	
	private String parentMobile;

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHardCode() {
		return hardCode;
	}

	public void setHardCode(String hardCode) {
		this.hardCode = hardCode;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getParentMobile() {
		return parentMobile;
	}

	public void setParentMobile(String parentMobile) {
		this.parentMobile = parentMobile;
	}
}
