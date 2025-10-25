package com.example.products.repository;

import com.example.products.entity.StockTransaction;
import com.example.products.entity.Store;
import com.example.products.entity.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockTransactionRepository extends JpaRepository<StockTransaction, Long> {
    List<StockTransaction> findByStore(Store store);
    List<StockTransaction> findByProductVariant(ProductVariant productVariant);
}