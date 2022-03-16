package com.tgodard.mybudget.services.impl;

import com.tgodard.mybudget.dao.EstimatedTransactionDao;
import com.tgodard.mybudget.models.entities.EstimatedTransaction;
import com.tgodard.mybudget.services.EstimatedTransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstimatedTransactionServiceImpl implements EstimatedTransactionService {

    private final EstimatedTransactionDao estimatedTransactionDao;

    public EstimatedTransactionServiceImpl(EstimatedTransactionDao estimatedTransactionDao) {
        this.estimatedTransactionDao = estimatedTransactionDao;
    }

    @Override
    public List<EstimatedTransaction> findAll() {
        return this.estimatedTransactionDao.findAll();
    }

    @Override
    public EstimatedTransaction save(EstimatedTransaction estimatedTransaction) {
        return this.estimatedTransactionDao.save(estimatedTransaction);
    }
}
