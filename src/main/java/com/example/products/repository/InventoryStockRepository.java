package com.example.products.repository;

import com.example.products.entity.InventoryStock;
import com.example.products.entity.Store;
import com.example.products.entity.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryStockRepository extends JpaRepository<InventoryStock, Long> {
    List<InventoryStock> findByStore(Store store);
    Optional<InventoryStock> findByStoreAndProductVariant(Store store, ProductVariant productVariant);
}