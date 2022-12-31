package com.example.borrowbookapp.repository;

import com.example.borrowbookapp.model.BorrowCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowCardRepository extends JpaRepository<BorrowCard, Integer> {
}
