package com.example.products.controller;

import com.example.products.entity.Company;
import com.example.products.repository.CompanyRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
@CrossOrigin(origins = "*")
public class CompanyController {

    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> findById(@PathVariable Long id) {
        return companyRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Company> create(@RequestBody Company company) {
        Company saved = companyRepository.save(company);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> update(@PathVariable Long id, @RequestBody Company company) {
        return companyRepository.findById(id)
                .map(existing -> {
                    company.setId(id);
                    return ResponseEntity.ok(companyRepository.save(company));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!companyRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        companyRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}