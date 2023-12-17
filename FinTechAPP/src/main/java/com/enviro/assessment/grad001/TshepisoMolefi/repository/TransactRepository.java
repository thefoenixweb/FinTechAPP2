package com.enviro.assessment.grad001.TshepisoMolefi.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.enviro.assessment.grad001.TshepisoMolefi.models.Transact;

import java.time.LocalDateTime;

@Repository
public interface TransactRepository extends CrudRepository<Transact, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO transaction_history(account_id, transaction_type, amount,previous_balance,closing_balance, source, status, reason_code, created_at)" +
            "VALUES(:account_id, :transact_type, :amount,:previous_balance,:closing_balance, :source, :status, :reason_code, :created_at)", nativeQuery = true)
    void logTransaction(@Param("account_id")int account_id,
                        @Param("transact_type")String transact_type,
                        @Param("amount")double amount,
                        @Param("previous_balance")double previous_balance,
                        @Param("closing_balance")double closing_balance,
                        @Param("source")String source,
                        @Param("status")String status,
                        @Param("reason_code")String reason_code,
                        @Param("created_at") LocalDateTime created_at);

}
