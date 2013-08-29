package com.slyak.activation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slyak.activation.model.StudyCard;

public interface StudyCardDAO extends JpaRepository<StudyCard, String> {

}
