package com.example.products.entity;

import com.example.products.entity.enums.SubscriptionStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String subdomain;

    @Enumerated(EnumType.STRING)
    @Column(name = "subscription_status", nullable = false)
    private SubscriptionStatus subscriptionStatus;

    @CreationTimestamp
    @Column(name = "creation_date", updatable = false)
    private Instant creationDate;

    public Company() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSubdomain() { return subdomain; }
    public void setSubdomain(String subdomain) { this.subdomain = subdomain; }

    public SubscriptionStatus getSubscriptionStatus() { return subscriptionStatus; }
    public void setSubscriptionStatus(SubscriptionStatus subscriptionStatus) { this.subscriptionStatus = subscriptionStatus; }

    public Instant getCreationDate() { return creationDate; }
    public void setCreationDate(Instant creationDate) { this.creationDate = creationDate; }
}