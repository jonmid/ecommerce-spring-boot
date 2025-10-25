package com.example.products.controller;

import com.example.products.entity.SubscriptionPlan;
import com.example.products.repository.SubscriptionPlanRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subscription-plans")
@CrossOrigin(origins = "*")
public class SubscriptionPlanController {

    private final SubscriptionPlanRepository subscriptionPlanRepository;

    public SubscriptionPlanController(SubscriptionPlanRepository subscriptionPlanRepository) {
        this.subscriptionPlanRepository = subscriptionPlanRepository;
    }

    @GetMapping
    public List<SubscriptionPlan> findAll() {
        return subscriptionPlanRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionPlan> findById(@PathVariable Long id) {
        return subscriptionPlanRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SubscriptionPlan> create(@RequestBody SubscriptionPlan subscriptionPlan) {
        SubscriptionPlan saved = subscriptionPlanRepository.save(subscriptionPlan);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionPlan> update(@PathVariable Long id, @RequestBody SubscriptionPlan subscriptionPlan) {
        return subscriptionPlanRepository.findById(id)
                .map(existing -> {
                    subscriptionPlan.setId(id);
                    return ResponseEntity.ok(subscriptionPlanRepository.save(subscriptionPlan));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!subscriptionPlanRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        subscriptionPlanRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}