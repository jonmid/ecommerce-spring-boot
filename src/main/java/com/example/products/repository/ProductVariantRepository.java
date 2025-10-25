package com.example.products.repository;

import com.example.products.entity.ProductVariant;
import com.example.products.entity.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductVariantRepository extends JpaRepository<ProductVariant, Long> {
    List<ProductVariant> findByProductModel(ProductModel productModel);
    Optional<ProductVariant> findBySku(String sku);
    Optional<ProductVariant> findByBarcode(String barcode);
}