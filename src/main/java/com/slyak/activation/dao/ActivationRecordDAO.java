package com.slyak.activation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.slyak.activation.model.ActivationRecord;

public interface ActivationRecordDAO extends
		JpaRepository<ActivationRecord, Long> {

	@Query("select count(*) from ActivationRecord where cardNo=?1 and hardCode=?2")
	int countByCardNoAndHardCode(String cardNo, String hardCode);

}
