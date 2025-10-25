package com.example.products.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "auth_method")
    private String authMethod;

    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    public User() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public String getAuthMethod() { return authMethod; }
    public void setAuthMethod(String authMethod) { this.authMethod = authMethod; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Company getCompany() { return company; }
    public void setCompany(Company company) { this.company = company; }
}