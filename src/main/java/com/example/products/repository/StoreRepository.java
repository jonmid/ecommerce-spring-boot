package com.example.products.repository;

import com.example.products.entity.Store;
import com.example.products.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findByCompany(Company company);
}