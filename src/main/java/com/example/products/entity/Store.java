package com.example.products.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Column(nullable = false)
    private String name;

    private String country;
    private String timeZone;
    private String localCurrency;
    private Float localTaxes;
    @Column(columnDefinition = "text")
    private String address;

    public Store() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Company getCompany() { return company; }
    public void setCompany(Company company) { this.company = company; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getTimeZone() { return timeZone; }
    public void setTimeZone(String timeZone) { this.timeZone = timeZone; }

    public String getLocalCurrency() { return localCurrency; }
    public void setLocalCurrency(String localCurrency) { this.localCurrency = localCurrency; }

    public Float getLocalTaxes() { return localTaxes; }
    public void setLocalTaxes(Float localTaxes) { this.localTaxes = localTaxes; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}