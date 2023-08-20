package com.banking.java.repository;

import com.banking.java.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    @Override
    TransactionEntity getReferenceById(Long Long);
    // Additional custom query methods if needed...
}
