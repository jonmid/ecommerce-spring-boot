package com.example.products.controller;

import com.example.products.entity.Transfer;
import com.example.products.repository.TransferRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transfers")
@CrossOrigin(origins = "*")
public class TransferController {

    private final TransferRepository transferRepository;

    public TransferController(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    @GetMapping
    public List<Transfer> findAll() {
        return transferRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transfer> findById(@PathVariable Long id) {
        return transferRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Transfer> create(@RequestBody Transfer transfer) {
        Transfer saved = transferRepository.save(transfer);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transfer> update(@PathVariable Long id, @RequestBody Transfer transfer) {
        return transferRepository.findById(id)
                .map(existing -> {
                    transfer.setId(id);
                    return ResponseEntity.ok(transferRepository.save(transfer));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!transferRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        transferRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}