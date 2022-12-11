package com.tgodard.mybudget.models.dto;

import com.tgodard.mybudget.models.entities.Category;
import com.tgodard.mybudget.models.entities.Transaction;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
public class EstimatedTransactionDto {

    private String label;

    private Instant transactionDate;

    private double amount;

    private Category category;

    private Transaction transaction;
}
