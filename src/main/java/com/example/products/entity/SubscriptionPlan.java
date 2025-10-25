package com.example.products.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "subscription_plan")
public class SubscriptionPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "monthly_price")
    private BigDecimal monthlyPrice;

    @Column(name = "store_limit")
    private Integer storeLimit;

    @Column(name = "user_limit")
    private Integer userLimit;

    @Column(columnDefinition = "text")
    private String features;

    public SubscriptionPlan() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getMonthlyPrice() { return monthlyPrice; }
    public void setMonthlyPrice(BigDecimal monthlyPrice) { this.monthlyPrice = monthlyPrice; }

    public Integer getStoreLimit() { return storeLimit; }
    public void setStoreLimit(Integer storeLimit) { this.storeLimit = storeLimit; }

    public Integer getUserLimit() { return userLimit; }
    public void setUserLimit(Integer userLimit) { this.userLimit = userLimit; }

    public String getFeatures() { return features; }
    public void setFeatures(String features) { this.features = features; }
}