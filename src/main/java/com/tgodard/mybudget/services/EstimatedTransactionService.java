package com.tgodard.mybudget.services;

import com.tgodard.mybudget.models.entities.EstimatedTransaction;

import java.util.List;

public interface EstimatedTransactionService {

    List<EstimatedTransaction> findAll();

    EstimatedTransaction save(EstimatedTransaction estimatedTransaction);
}
