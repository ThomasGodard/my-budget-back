package com.tgodard.mybudget.dao;

import com.tgodard.mybudget.models.entities.EstimatedTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstimatedTransactionDao extends JpaRepository<EstimatedTransaction, Long> {
    
}
