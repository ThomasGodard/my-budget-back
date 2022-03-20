package com.tgodard.mybudget.services.impl;

import com.tgodard.mybudget.dao.EstimatedTransactionDao;
import com.tgodard.mybudget.models.dto.EstimatedTransactionDto;
import com.tgodard.mybudget.models.entities.EstimatedTransaction;
import com.tgodard.mybudget.services.EstimatedTransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstimatedTransactionServiceImpl implements EstimatedTransactionService {

    private final EstimatedTransactionDao estimatedTransactionDao;

    private final ModelMapper modelMapper;

    public EstimatedTransactionServiceImpl(EstimatedTransactionDao estimatedTransactionDao, ModelMapper modelMapper) {
        this.estimatedTransactionDao = estimatedTransactionDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EstimatedTransactionDto> findAll() {
        List<EstimatedTransaction> estimatedTransactions = this.estimatedTransactionDao.findAll();
        return estimatedTransactions.stream().map(el -> modelMapper.map(el, EstimatedTransactionDto.class)).collect(Collectors.toList());
    }

    @Override
    public EstimatedTransaction save(EstimatedTransaction estimatedTransaction) {
        return this.estimatedTransactionDao.save(estimatedTransaction);
    }
}
