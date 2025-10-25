package com.example.products.repository;

import com.example.products.entity.StoreSellingPrice;
import com.example.products.entity.Store;
import com.example.products.entity.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoreSellingPriceRepository extends JpaRepository<StoreSellingPrice, Long> {
    List<StoreSellingPrice> findByStore(Store store);
    Optional<StoreSellingPrice> findByStoreAndProductVariant(Store store, ProductVariant productVariant);
}