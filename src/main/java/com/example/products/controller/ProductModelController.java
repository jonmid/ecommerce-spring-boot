package com.example.products.controller;

import com.example.products.entity.ProductModel;
import com.example.products.repository.ProductModelRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-models")
@CrossOrigin(origins = "*")
public class ProductModelController {

    private final ProductModelRepository productModelRepository;

    public ProductModelController(ProductModelRepository productModelRepository) {
        this.productModelRepository = productModelRepository;
    }

    @GetMapping
    public List<ProductModel> findAll() {
        return productModelRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> findById(@PathVariable Long id) {
        return productModelRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductModel> create(@RequestBody ProductModel productModel) {
        ProductModel saved = productModelRepository.save(productModel);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductModel> update(@PathVariable Long id, @RequestBody ProductModel productModel) {
        return productModelRepository.findById(id)
                .map(existing -> {
                    productModel.setId(id);
                    return ResponseEntity.ok(productModelRepository.save(productModel));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!productModelRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        productModelRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}