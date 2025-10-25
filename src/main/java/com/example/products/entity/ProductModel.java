package com.example.products.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product_model")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @Column(nullable = false)
    private String name;

    @Column(name = "footwear_type")
    private String footwearType;

    @Column(name = "main_material")
    private String mainMaterial;

    private String gender;

    public ProductModel() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Brand getBrand() { return brand; }
    public void setBrand(Brand brand) { this.brand = brand; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getFootwearType() { return footwearType; }
    public void setFootwearType(String footwearType) { this.footwearType = footwearType; }

    public String getMainMaterial() { return mainMaterial; }
    public void setMainMaterial(String mainMaterial) { this.mainMaterial = mainMaterial; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
}