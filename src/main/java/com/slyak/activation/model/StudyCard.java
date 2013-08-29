package com.slyak.activation.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_study_card")
public class StudyCard implements Serializable {

	private static final long serialVersionUID = 8319129204768969941L;

	@Id
	@Column(name = "card_no")
	private String cardNo;

	@Column(nullable = true)
	private String password;
	
	@Column(nullable = true)
	private String productLessons;

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

}
