package com.picSimplificado.picSimplificado.repositories;

import com.picSimplificado.picSimplificado.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
