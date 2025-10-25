package com.example.products.repository;

import com.example.products.entity.SubscriptionPayment;
import com.example.products.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionPaymentRepository extends JpaRepository<SubscriptionPayment, Long> {
    List<SubscriptionPayment> findByCompany(Company company);
}