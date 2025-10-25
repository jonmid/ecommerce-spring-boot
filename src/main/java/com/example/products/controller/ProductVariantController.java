package com.example.products.controller;

import com.example.products.entity.ProductVariant;
import com.example.products.repository.ProductVariantRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-variants")
@CrossOrigin(origins = "*")
public class ProductVariantController {

    private final ProductVariantRepository productVariantRepository;

    public ProductVariantController(ProductVariantRepository productVariantRepository) {
        this.productVariantRepository = productVariantRepository;
    }

    @GetMapping
    public List<ProductVariant> findAll() {
        return productVariantRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductVariant> findById(@PathVariable Long id) {
        return productVariantRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductVariant> create(@RequestBody ProductVariant productVariant) {
        ProductVariant saved = productVariantRepository.save(productVariant);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductVariant> update(@PathVariable Long id, @RequestBody ProductVariant productVariant) {
        return productVariantRepository.findById(id)
                .map(existing -> {
                    productVariant.setId(id);
                    return ResponseEntity.ok(productVariantRepository.save(productVariant));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!productVariantRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        productVariantRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}