package com.tgodard.mybudget.models.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
public class TransactionDto {
    
    private Long id;

    @NotNull
    private String label;
    
    @NotNull
    private Instant transactionDate;

    @NotNull
    private double amount;
}
