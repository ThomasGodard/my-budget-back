package com.tgodard.mybudget.config;

import com.tgodard.mybudget.models.dto.EstimatedTransactionDto;
import com.tgodard.mybudget.models.dto.TransactionDto;
import com.tgodard.mybudget.models.entities.EstimatedTransaction;
import com.tgodard.mybudget.models.entities.Transaction;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    private final ModelMapper modelMapper;

    public ModelMapperConfig() {
        this.modelMapper = new ModelMapper();
        modelMapper.createTypeMap(TransactionDto.class, Transaction.class);
        modelMapper.createTypeMap(Transaction.class, TransactionDto.class);
        modelMapper.createTypeMap(EstimatedTransactionDto.class, EstimatedTransaction.class);
        modelMapper.createTypeMap(EstimatedTransaction.class, EstimatedTransactionDto.class);
    }

    @Bean
    public ModelMapper getModelMapper() {
        return this.modelMapper;
    }
}
