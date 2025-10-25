package com.example.products.repository;

import com.example.products.entity.Transfer;
import com.example.products.entity.Company;
import com.example.products.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
    List<Transfer> findByCompany(Company company);
    List<Transfer> findByOriginStoreOrDestinationStore(Store origin, Store destination);
}