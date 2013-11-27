/**
 * Project name : activation
 * File name : CourseDao.java
 * Package name : com.slyak.activation.dao
 * Date : 2013-11-27
 * Copyright : 2013 , SLYAK.COM All Rights Reserved
 * Author : stormning@163.com
 */
package com.slyak.activation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slyak.activation.model.Course;

public interface CourseDao extends JpaRepository<Course, String>{

}
