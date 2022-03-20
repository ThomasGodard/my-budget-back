package com.tgodard.mybudget;

import com.tgodard.mybudget.dao.EstimatedTransactionDao;
import com.tgodard.mybudget.dao.TransactionDao;
import com.tgodard.mybudget.models.entities.EstimatedTransaction;
import com.tgodard.mybudget.models.entities.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@Slf4j
@SpringBootApplication
public class MyBudgetApplication implements CommandLineRunner {

    private final TransactionDao transactionDao;

    private final EstimatedTransactionDao estimatedTransactionDao;

    public MyBudgetApplication(TransactionDao transactionDao, EstimatedTransactionDao estimatedTransactionDao) {
        this.transactionDao = transactionDao;
        this.estimatedTransactionDao = estimatedTransactionDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(MyBudgetApplication.class, args);
    }

    @Override
    public void run(String... args) {
        EstimatedTransaction estimatedTransaction = new EstimatedTransaction();
        estimatedTransaction.setStartDate(Instant.now());
        estimatedTransaction.setEndDate(Instant.now());
        estimatedTransaction.setAmount(100.00);
        estimatedTransaction.setLabel("tr1");
        EstimatedTransaction estimatedTransaction2 = new EstimatedTransaction();
        estimatedTransaction2.setStartDate(Instant.now().minus(1L, ChronoUnit.DAYS));
        estimatedTransaction2.setEndDate(Instant.now().minus(1L, ChronoUnit.DAYS));
        estimatedTransaction2.setAmount(100.25);
        estimatedTransaction2.setLabel("tr2");
        this.estimatedTransactionDao.saveAll(Arrays.asList(estimatedTransaction, estimatedTransaction2));

        Transaction transaction = new Transaction();
        transaction.setLabel("test");
        transaction.setAmount(0.15);
        transaction.setTransactionDate(Instant.now());
        this.transactionDao.save(transaction);
    }
}
