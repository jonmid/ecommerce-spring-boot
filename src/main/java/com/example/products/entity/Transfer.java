package com.example.products.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "transfer")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne(optional = false)
    @JoinColumn(name = "origin_store_id", nullable = false)
    private Store originStore;

    @ManyToOne(optional = false)
    @JoinColumn(name = "destination_store_id", nullable = false)
    private Store destinationStore;

    private String status;

    @CreationTimestamp
    @Column(name = "creation_date", updatable = false)
    private Instant creationDate;

    @Column(name = "completion_date")
    private Instant completionDate;

    public Transfer() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Company getCompany() { return company; }
    public void setCompany(Company company) { this.company = company; }

    public Store getOriginStore() { return originStore; }
    public void setOriginStore(Store originStore) { this.originStore = originStore; }

    public Store getDestinationStore() { return destinationStore; }
    public void setDestinationStore(Store destinationStore) { this.destinationStore = destinationStore; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Instant getCreationDate() { return creationDate; }
    public void setCreationDate(Instant creationDate) { this.creationDate = creationDate; }

    public Instant getCompletionDate() { return completionDate; }
    public void setCompletionDate(Instant completionDate) { this.completionDate = completionDate; }
}