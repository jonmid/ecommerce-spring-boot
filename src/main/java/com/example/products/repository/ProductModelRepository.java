package com.example.products.repository;

import com.example.products.entity.ProductModel;
import com.example.products.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductModelRepository extends JpaRepository<ProductModel, Long> {
    List<ProductModel> findByBrand(Brand brand);
}