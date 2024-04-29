package com.giuseppe.demo.repository;



import java.util.List;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.giuseppe.demo.model.Transaction;

import jakarta.transaction.Transactional;

@Transactional
public interface TransactionRepo extends JpaRepository<Transaction, Integer> {
	List<Transaction> findTransactionsByUserId(Integer userId);
	List<Transaction> findTransactionsByRecipientId(Integer userId);
	void deleteTransactionsByUserId(Integer userId);
	@Modifying
	@Query("update Transaction transaction set transaction.recipient = null where transaction.recipient.id = :userId")
	void updateRecipientIdToNull(Integer userId);

}
