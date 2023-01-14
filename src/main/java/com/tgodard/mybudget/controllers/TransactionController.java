package com.tgodard.mybudget.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgodard.mybudget.models.dto.TransactionDto;
import com.tgodard.mybudget.models.entities.Transaction;
import com.tgodard.mybudget.services.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final ObjectMapper objectMapper;
    
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService, ObjectMapper objectMapper) {
        this.transactionService = transactionService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getEspenses() {
        List<Transaction> transactions = this.transactionService.findAll();
        return ResponseEntity.ok(transactions);
    }

    @PutMapping
    public ResponseEntity<Transaction> saveTransaction(@Valid @RequestBody TransactionDto transactionDto) {
        Transaction transaction = this.objectMapper.convertValue(transactionDto, Transaction.class);
        transaction = this.transactionService.save(transaction);
        return ResponseEntity.ok(transaction);
    }
}
