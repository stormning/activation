/**
 * Project name : activation
 * File name : StudyCard.java
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
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "t_study_card")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class StudyCard implements Serializable {

	private static final long serialVersionUID = 8319129204768969941L;

	@Id
	@Column(name = "card_no")
	private String cardNo;

	@Column(nullable = true)
	private String password;
	
	@Column(name="course_id",nullable = true)
	private String courseId;
	
	@Column(name="expire_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expireAt;

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

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public Date getExpireAt() {
		return expireAt;
	}

	public void setExpireAt(Date expireAt) {
		this.expireAt = expireAt;
	}

}
