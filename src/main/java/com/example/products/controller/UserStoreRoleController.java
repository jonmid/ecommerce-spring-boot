package com.example.products.controller;

import com.example.products.entity.UserStoreRole;
import com.example.products.repository.UserStoreRoleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-store-roles")
@CrossOrigin(origins = "*")
public class UserStoreRoleController {

    private final UserStoreRoleRepository userStoreRoleRepository;

    public UserStoreRoleController(UserStoreRoleRepository userStoreRoleRepository) {
        this.userStoreRoleRepository = userStoreRoleRepository;
    }

    @GetMapping
    public List<UserStoreRole> findAll() {
        return userStoreRoleRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserStoreRole> findById(@PathVariable Long id) {
        return userStoreRoleRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserStoreRole> create(@RequestBody UserStoreRole userStoreRole) {
        UserStoreRole saved = userStoreRoleRepository.save(userStoreRole);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserStoreRole> update(@PathVariable Long id, @RequestBody UserStoreRole userStoreRole) {
        return userStoreRoleRepository.findById(id)
                .map(existing -> {
                    userStoreRole.setId(id);
                    return ResponseEntity.ok(userStoreRoleRepository.save(userStoreRole));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!userStoreRoleRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        userStoreRoleRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}