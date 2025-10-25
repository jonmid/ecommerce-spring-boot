package com.example.products.controller;

import com.example.products.entity.StoreSellingPrice;
import com.example.products.repository.StoreSellingPriceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/store-selling-prices")
@CrossOrigin(origins = "*")
public class StoreSellingPriceController {

    private final StoreSellingPriceRepository storeSellingPriceRepository;

    public StoreSellingPriceController(StoreSellingPriceRepository storeSellingPriceRepository) {
        this.storeSellingPriceRepository = storeSellingPriceRepository;
    }

    @GetMapping
    public List<StoreSellingPrice> findAll() {
        return storeSellingPriceRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreSellingPrice> findById(@PathVariable Long id) {
        return storeSellingPriceRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StoreSellingPrice> create(@RequestBody StoreSellingPrice storeSellingPrice) {
        StoreSellingPrice saved = storeSellingPriceRepository.save(storeSellingPrice);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StoreSellingPrice> update(@PathVariable Long id, @RequestBody StoreSellingPrice storeSellingPrice) {
        return storeSellingPriceRepository.findById(id)
                .map(existing -> {
                    storeSellingPrice.setId(id);
                    return ResponseEntity.ok(storeSellingPriceRepository.save(storeSellingPrice));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!storeSellingPriceRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        storeSellingPriceRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}