package com.tgodard.mybudget.dao;

import com.tgodard.mybudget.models.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDao extends JpaRepository<Transaction, Long> {
    
}
