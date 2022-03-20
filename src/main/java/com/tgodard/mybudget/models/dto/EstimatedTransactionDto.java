package com.tgodard.mybudget.models.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
public class EstimatedTransactionDto {
    
    private Long id;
    
    @NotNull
    private String label;

    @NotEmpty
    private String StartDate;

    private String EndDate;

    @NotNull
    private double amount;
}
