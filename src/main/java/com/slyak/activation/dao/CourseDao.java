package com.slyak.activation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slyak.activation.model.Course;

public interface CourseDao extends JpaRepository<Course, String>{

}
