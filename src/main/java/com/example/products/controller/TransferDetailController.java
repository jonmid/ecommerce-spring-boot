package com.example.products.controller;

import com.example.products.entity.TransferDetail;
import com.example.products.repository.TransferDetailRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transfer-details")
@CrossOrigin(origins = "*")
public class TransferDetailController {

    private final TransferDetailRepository transferDetailRepository;

    public TransferDetailController(TransferDetailRepository transferDetailRepository) {
        this.transferDetailRepository = transferDetailRepository;
    }

    @GetMapping
    public List<TransferDetail> findAll() {
        return transferDetailRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransferDetail> findById(@PathVariable Long id) {
        return transferDetailRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TransferDetail> create(@RequestBody TransferDetail transferDetail) {
        TransferDetail saved = transferDetailRepository.save(transferDetail);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransferDetail> update(@PathVariable Long id, @RequestBody TransferDetail transferDetail) {
        return transferDetailRepository.findById(id)
                .map(existing -> {
                    transferDetail.setId(id);
                    return ResponseEntity.ok(transferDetailRepository.save(transferDetail));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!transferDetailRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        transferDetailRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}