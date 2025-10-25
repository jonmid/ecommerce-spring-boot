package com.example.products.controller;

import com.example.products.entity.Brand;
import com.example.products.repository.BrandRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/brands")
@CrossOrigin(origins = "*")
public class BrandController {

    private final BrandRepository brandRepository;

    public BrandController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @GetMapping
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brand> findById(@PathVariable Long id) {
        return brandRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Brand> create(@RequestBody Brand brand) {
        Brand saved = brandRepository.save(brand);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brand> update(@PathVariable Long id, @RequestBody Brand brand) {
        return brandRepository.findById(id)
                .map(existing -> {
                    brand.setId(id);
                    return ResponseEntity.ok(brandRepository.save(brand));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!brandRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        brandRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}