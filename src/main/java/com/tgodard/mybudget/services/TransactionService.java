package com.tgodard.mybudget.services;

import com.tgodard.mybudget.models.entities.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> findAll();

    Transaction save(Transaction transaction);
}
