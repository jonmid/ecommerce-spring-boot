package com.example.products.entity;

import com.example.products.entity.enums.CompanyRole;
import jakarta.persistence.*;

@Entity
@Table(name = "user_store_role",
       uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "store_id"}))
public class UserStoreRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CompanyRole role;

    @Column(name = "is_primary_role")
    private Boolean isPrimaryRole = false;

    public UserStoreRole() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Store getStore() { return store; }
    public void setStore(Store store) { this.store = store; }

    public CompanyRole getRole() { return role; }
    public void setRole(CompanyRole role) { this.role = role; }

    public Boolean getIsPrimaryRole() { return isPrimaryRole; }
    public void setIsPrimaryRole(Boolean isPrimaryRole) { this.isPrimaryRole = isPrimaryRole; }
}