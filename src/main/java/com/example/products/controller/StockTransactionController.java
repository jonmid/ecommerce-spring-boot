package com.example.products.controller;

import com.example.products.entity.StockTransaction;
import com.example.products.repository.StockTransactionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stock-transactions")
@CrossOrigin(origins = "*")
public class StockTransactionController {

    private final StockTransactionRepository stockTransactionRepository;

    public StockTransactionController(StockTransactionRepository stockTransactionRepository) {
        this.stockTransactionRepository = stockTransactionRepository;
    }

    @GetMapping
    public List<StockTransaction> findAll() {
        return stockTransactionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockTransaction> findById(@PathVariable Long id) {
        return stockTransactionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StockTransaction> create(@RequestBody StockTransaction stockTransaction) {
        StockTransaction saved = stockTransactionRepository.save(stockTransaction);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockTransaction> update(@PathVariable Long id, @RequestBody StockTransaction stockTransaction) {
        return stockTransactionRepository.findById(id)
                .map(existing -> {
                    stockTransaction.setId(id);
                    return ResponseEntity.ok(stockTransactionRepository.save(stockTransaction));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!stockTransactionRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        stockTransactionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}