package com.example.products.controller;

import com.example.products.entity.InventoryStock;
import com.example.products.repository.InventoryStockRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory-stocks")
@CrossOrigin(origins = "*")
public class InventoryStockController {

    private final InventoryStockRepository inventoryStockRepository;

    public InventoryStockController(InventoryStockRepository inventoryStockRepository) {
        this.inventoryStockRepository = inventoryStockRepository;
    }

    @GetMapping
    public List<InventoryStock> findAll() {
        return inventoryStockRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryStock> findById(@PathVariable Long id) {
        return inventoryStockRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<InventoryStock> create(@RequestBody InventoryStock inventoryStock) {
        InventoryStock saved = inventoryStockRepository.save(inventoryStock);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryStock> update(@PathVariable Long id, @RequestBody InventoryStock inventoryStock) {
        return inventoryStockRepository.findById(id)
                .map(existing -> {
                    inventoryStock.setId(id);
                    return ResponseEntity.ok(inventoryStockRepository.save(inventoryStock));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!inventoryStockRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        inventoryStockRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}