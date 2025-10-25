package com.example.products.controller;

import com.example.products.entity.SubscriptionPayment;
import com.example.products.repository.SubscriptionPaymentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subscription-payments")
@CrossOrigin(origins = "*")
public class SubscriptionPaymentController {

    private final SubscriptionPaymentRepository subscriptionPaymentRepository;

    public SubscriptionPaymentController(SubscriptionPaymentRepository subscriptionPaymentRepository) {
        this.subscriptionPaymentRepository = subscriptionPaymentRepository;
    }

    @GetMapping
    public List<SubscriptionPayment> findAll() {
        return subscriptionPaymentRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionPayment> findById(@PathVariable Long id) {
        return subscriptionPaymentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SubscriptionPayment> create(@RequestBody SubscriptionPayment subscriptionPayment) {
        SubscriptionPayment saved = subscriptionPaymentRepository.save(subscriptionPayment);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionPayment> update(@PathVariable Long id, @RequestBody SubscriptionPayment subscriptionPayment) {
        return subscriptionPaymentRepository.findById(id)
                .map(existing -> {
                    subscriptionPayment.setId(id);
                    return ResponseEntity.ok(subscriptionPaymentRepository.save(subscriptionPayment));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!subscriptionPaymentRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        subscriptionPaymentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}