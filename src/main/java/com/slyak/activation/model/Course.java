/**
 * Project name : activation
 * File name : Course.java
 * Package name : com.slyak.activation.model
 * Date : 2013-11-27
 * Copyright : 2013 , SLYAK.COM All Rights Reserved
 * Author : stormning@163.com
 */
package com.slyak.activation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.slyak.activation.enums.Section;

@Entity
@Table(name = "t_course")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Course {
	@Id
	private String id;
	
	@Column
	private String name;
	
	@Column
	private Section section;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
}
