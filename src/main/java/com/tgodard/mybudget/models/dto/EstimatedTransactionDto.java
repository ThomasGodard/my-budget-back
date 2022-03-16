package com.tgodard.mybudget.models.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
public class EstimatedTransactionDto {
    
    private Long id;
    
    @NotNull
    private String label;

    @NotNull
    private Instant firstLevyDate;

    private Instant lastLevyDate;

    @NotNull
    private double amount;
}
