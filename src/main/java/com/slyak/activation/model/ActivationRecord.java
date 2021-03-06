/**
 * Project name : activation
 * File name : ActivationRecord.java
 * Package name : com.slyak.activation.model
 * Date : 2013-11-27
 * Copyright : 2013 , SLYAK.COM All Rights Reserved
 * Author : stormning@163.com
 */
package com.slyak.activation.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.slyak.user.model.User;

@Entity
@Table(name="t_activation_record")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ActivationRecord implements Serializable {

	private static final long serialVersionUID = 5242389669658337949L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "card_no", nullable = false)
	private String cardNo;
	
	@Column(name = "course_id", nullable = false)
	private String courseId;
	
	@Transient
	private String courseName;

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
	
	@Column(name = "operator")
	private Long operator;
	
	@Transient
	private User opUser;

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

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Long getOperator() {
		return operator;
	}

	public void setOperator(Long operator) {
		this.operator = operator;
	}

	public User getOpUser() {
		return opUser;
	}

	public void setOpUser(User opUser) {
		this.opUser = opUser;
	}
	
}
