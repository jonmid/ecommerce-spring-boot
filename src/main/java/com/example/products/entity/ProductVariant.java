package com.example.products.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product_variant")
public class ProductVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_model_id", nullable = false)
    private ProductModel productModel;

    @Column(name = "size_us")
    private String sizeUs;
    @Column(name = "size_eu")
    private String sizeEu;
    @Column(name = "size_uk")
    private String sizeUk;

    @Column(name = "primary_color")
    private String primaryColor;
    @Column(name = "secondary_color")
    private String secondaryColor;

    @Column(unique = true)
    private String sku;

    @Column(unique = true)
    private String barcode;

    @Column(name = "purchase_price")
    private BigDecimal purchasePrice;

    public ProductVariant() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public ProductModel getProductModel() { return productModel; }
    public void setProductModel(ProductModel productModel) { this.productModel = productModel; }

    public String getSizeUs() { return sizeUs; }
    public void setSizeUs(String sizeUs) { this.sizeUs = sizeUs; }

    public String getSizeEu() { return sizeEu; }
    public void setSizeEu(String sizeEu) { this.sizeEu = sizeEu; }

    public String getSizeUk() { return sizeUk; }
    public void setSizeUk(String sizeUk) { this.sizeUk = sizeUk; }

    public String getPrimaryColor() { return primaryColor; }
    public void setPrimaryColor(String primaryColor) { this.primaryColor = primaryColor; }

    public String getSecondaryColor() { return secondaryColor; }
    public void setSecondaryColor(String secondaryColor) { this.secondaryColor = secondaryColor; }

    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }

    public String getBarcode() { return barcode; }
    public void setBarcode(String barcode) { this.barcode = barcode; }

    public BigDecimal getPurchasePrice() { return purchasePrice; }
    public void setPurchasePrice(BigDecimal purchasePrice) { this.purchasePrice = purchasePrice; }
}