package com.tgodard.mybudget.services;

import com.tgodard.mybudget.models.dto.EstimatedTransactionDto;
import com.tgodard.mybudget.models.entities.EstimatedTransaction;

import java.util.List;

public interface EstimatedTransactionService {

    List<EstimatedTransactionDto> findAll();

    EstimatedTransaction save(EstimatedTransaction estimatedTransaction);
}
