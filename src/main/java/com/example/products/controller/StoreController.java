package com.example.products.controller;

import com.example.products.entity.Store;
import com.example.products.repository.StoreRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stores")
@CrossOrigin(origins = "*")
public class StoreController {

    private final StoreRepository storeRepository;

    public StoreController(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @GetMapping
    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Store> findById(@PathVariable Long id) {
        return storeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Store> create(@RequestBody Store store) {
        Store saved = storeRepository.save(store);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Store> update(@PathVariable Long id, @RequestBody Store store) {
        return storeRepository.findById(id)
                .map(existing -> {
                    store.setId(id);
                    return ResponseEntity.ok(storeRepository.save(store));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!storeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        storeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}