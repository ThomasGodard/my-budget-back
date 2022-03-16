package com.tgodard.mybudget.services.impl;

import com.tgodard.mybudget.dao.TransactionDao;
import com.tgodard.mybudget.models.entities.Transaction;
import com.tgodard.mybudget.services.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionDao transactionDao;

    public TransactionServiceImpl(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    @Override
    public List<Transaction> findAll() {
        return this.transactionDao.findAll();
    }

    @Override
    public Transaction save(Transaction transaction) {
        return this.transactionDao.save(transaction);
    }
}
