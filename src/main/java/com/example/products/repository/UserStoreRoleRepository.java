package com.example.products.repository;

import com.example.products.entity.UserStoreRole;
import com.example.products.entity.User;
import com.example.products.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserStoreRoleRepository extends JpaRepository<UserStoreRole, Long> {
    List<UserStoreRole> findByUser(User user);
    List<UserStoreRole> findByStore(Store store);
    Optional<UserStoreRole> findByUserAndStore(User user, Store store);
}