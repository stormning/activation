/**
 * Project name : activation
 * File name : ActivationRecordDAO.java
 * Package name : com.slyak.activation.dao
 * Date : 2013-11-27
 * Copyright : 2013 , SLYAK.COM All Rights Reserved
 * Author : stormning@163.com
 */
package com.slyak.activation.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.slyak.activation.enums.Section;
import com.slyak.activation.model.ActivationRecord;

public interface ActivationRecordDAO extends
		JpaRepository<ActivationRecord, Long> {

	@Query("select count(*) from ActivationRecord where cardNo=?1 and hardCode=?2")
	long countByCardNoAndHardCode(String cardNo, String hardCode);

	List<ActivationRecord> findByCardNo(String cardNo);

	@Query("select ar from ActivationRecord ar,Course c where ar.courseId=c.id and c.section in (?1)")
	Page<ActivationRecord> findBySectionIn(Pageable pageable,Set<Section> allowedSections);

}
