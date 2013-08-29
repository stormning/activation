package com.slyak.activation.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ActivationRecord implements Serializable {

	private static final long serialVersionUID = 5242389669658337949L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "card_no", nullable = false)
	private String cardNo;

	@Column(name = "activate_at", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date activateAt;

	@Column(name = "hard_code", nullable = false)
	private String hardCode;

	@Column(name = "verify_code", nullable = false)
	private String verifyCode;

	@Column
	private String seller;

	@Column(name = "student_name")
	private String studentName;

	@Column(name = "parent_name")
	private String parentName;

	@Column(name = "parent_mobile")
	private String parentMobile;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Date getActivateAt() {
		return activateAt;
	}

	public void setActivateAt(Date activateAt) {
		this.activateAt = activateAt;
	}

	public String getHardCode() {
		return hardCode;
	}

	public void setHardCode(String hardCode) {
		this.hardCode = hardCode;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
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
