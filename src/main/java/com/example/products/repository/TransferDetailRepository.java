package com.example.products.repository;

import com.example.products.entity.TransferDetail;
import com.example.products.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransferDetailRepository extends JpaRepository<TransferDetail, Long> {
    List<TransferDetail> findByTransfer(Transfer transfer);
}