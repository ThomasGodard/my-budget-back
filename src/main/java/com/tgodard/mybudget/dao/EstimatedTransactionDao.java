package com.tgodard.mybudget.dao;

import com.tgodard.mybudget.models.entities.EstimatedTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EstimatedTransactionDao extends JpaRepository<EstimatedTransaction, Long> {
    
}
