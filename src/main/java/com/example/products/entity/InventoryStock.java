package com.example.products.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "inventory_stock",
       uniqueConstraints = @UniqueConstraint(columnNames = {"store_id", "product_variant_id"}))
public class InventoryStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_variant_id", nullable = false)
    private ProductVariant productVariant;

    @Column(nullable = false)
    private Integer quantity = 0;

    @Column(name = "min_stock_alert")
    private Integer minStockAlert;

    @UpdateTimestamp
    @Column(name = "last_update_date")
    private Instant lastUpdateDate;

    public InventoryStock() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Store getStore() { return store; }
    public void setStore(Store store) { this.store = store; }

    public ProductVariant getProductVariant() { return productVariant; }
    public void setProductVariant(ProductVariant productVariant) { this.productVariant = productVariant; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Integer getMinStockAlert() { return minStockAlert; }
    public void setMinStockAlert(Integer minStockAlert) { this.minStockAlert = minStockAlert; }

    public Instant getLastUpdateDate() { return lastUpdateDate; }
    public void setLastUpdateDate(Instant lastUpdateDate) { this.lastUpdateDate = lastUpdateDate; }
}