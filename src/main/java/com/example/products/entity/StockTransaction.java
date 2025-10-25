package com.example.products.entity;

import com.example.products.entity.enums.TransactionType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "stock_transaction")
public class StockTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_variant_id", nullable = false)
    private ProductVariant productVariant;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type;

    @Column(name = "change_quantity", nullable = false)
    private Integer changeQuantity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @CreationTimestamp
    @Column(name = "transaction_date")
    private Instant transactionDate;

    @Column(name = "external_reference")
    private String externalReference;

    public StockTransaction() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Store getStore() { return store; }
    public void setStore(Store store) { this.store = store; }

    public ProductVariant getProductVariant() { return productVariant; }
    public void setProductVariant(ProductVariant productVariant) { this.productVariant = productVariant; }

    public TransactionType getType() { return type; }
    public void setType(TransactionType type) { this.type = type; }

    public Integer getChangeQuantity() { return changeQuantity; }
    public void setChangeQuantity(Integer changeQuantity) { this.changeQuantity = changeQuantity; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Instant getTransactionDate() { return transactionDate; }
    public void setTransactionDate(Instant transactionDate) { this.transactionDate = transactionDate; }

    public String getExternalReference() { return externalReference; }
    public void setExternalReference(String externalReference) { this.externalReference = externalReference; }
}