package com.slyak.activation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.slyak.activation.model.ActivationRecord;

public interface ActivationRecordDAO extends
		JpaRepository<ActivationRecord, Long> {

	@Query("select count(*) from ActivationRecord where cardNo=?1 and hardCode=?2")
	long countByCardNoAndHardCode(String cardNo, String hardCode);

	List<ActivationRecord> findByCardNo(String cardNo);

}
