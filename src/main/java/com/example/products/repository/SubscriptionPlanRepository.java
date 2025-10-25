package com.example.products.repository;

import com.example.products.entity.SubscriptionPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionPlanRepository extends JpaRepository<SubscriptionPlan, Long> {
}