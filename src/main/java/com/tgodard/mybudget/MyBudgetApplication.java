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
        estimatedTransaction.setStartLevyDate(Instant.now());
        estimatedTransaction.setEndLevyDate(Instant.now());
        estimatedTransaction.setAmount(100.00);
        estimatedTransaction.setLabel("test");
        this.estimatedTransactionDao.save(estimatedTransaction);

        Transaction transaction = new Transaction();
        transaction.setLabel("test");
        transaction.setAmount(0.15);
        transaction.setLevyDate(Instant.now());
        this.transactionDao.save(transaction);
    }
}
