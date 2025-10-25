package com.example.products.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "store_selling_price",
       uniqueConstraints = @UniqueConstraint(columnNames = {"store_id", "product_variant_id"}))
public class StoreSellingPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_variant_id", nullable = false)
    private ProductVariant productVariant;

    @Column(name = "selling_price", nullable = false)
    private BigDecimal sellingPrice;

    public StoreSellingPrice() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Store getStore() { return store; }
    public void setStore(Store store) { this.store = store; }

    public ProductVariant getProductVariant() { return productVariant; }
    public void setProductVariant(ProductVariant productVariant) { this.productVariant = productVariant; }

    public BigDecimal getSellingPrice() { return sellingPrice; }
    public void setSellingPrice(BigDecimal sellingPrice) { this.sellingPrice = sellingPrice; }
}