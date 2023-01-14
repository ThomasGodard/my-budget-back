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
import java.time.LocalDate;

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
        estimatedTransaction.setAmount(80);
        estimatedTransaction.setName("new name");
        estimatedTransaction.setCreationDate(Instant.now());
        estimatedTransaction.setStartDate(LocalDate.now());
        estimatedTransactionDao.save(estimatedTransaction);

        Transaction transaction = new Transaction();
        transaction.setAmount(100);
        transaction.setName("new name");
        transaction.setDate(LocalDate.now());
        transaction.setEstimatedTransaction(estimatedTransaction);

        transactionDao.save(transaction);

        estimatedTransactionDao.delete(estimatedTransaction);
    }
}
