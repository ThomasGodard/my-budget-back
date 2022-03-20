package com.tgodard.mybudget.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgodard.mybudget.models.dto.EstimatedTransactionDto;
import com.tgodard.mybudget.models.entities.EstimatedTransaction;
import com.tgodard.mybudget.services.EstimatedTransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/estimated-transactions")
public class EstimatedTransactionController {

    private final ObjectMapper objectMapper;

    private final EstimatedTransactionService estimatedTransactionService;

    public EstimatedTransactionController(EstimatedTransactionService estimatedTransactionService, ObjectMapper objectMapper) {
        this.estimatedTransactionService = estimatedTransactionService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public ResponseEntity<List<EstimatedTransactionDto>> getEspenses() {
        List<EstimatedTransactionDto> transactions = this.estimatedTransactionService.findAll();
        return ResponseEntity.ok(transactions);
    }

    @PostMapping
    public ResponseEntity<EstimatedTransaction> saveTransaction(@Valid @RequestBody EstimatedTransactionDto estimatedTransactionDto) {
        EstimatedTransaction estimatedTransaction = this.objectMapper.convertValue(estimatedTransactionDto, EstimatedTransaction.class);
        estimatedTransaction = this.estimatedTransactionService.save(estimatedTransaction);
        return ResponseEntity.ok(estimatedTransaction);
    }
}
