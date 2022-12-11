package com.tgodard.mybudget.models.dto;

import com.tgodard.mybudget.models.entities.Category;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
public class TransactionDto {

    private String name;

    private Instant transactionDate;

    private double amount;

    private Category category;
}
