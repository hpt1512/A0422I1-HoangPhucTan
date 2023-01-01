package com.example.borrowbookapp.service.impl;

import com.example.borrowbookapp.model.BorrowCard;
import com.example.borrowbookapp.repository.IBorrowCardRepository;
import com.example.borrowbookapp.service.IBorrowCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowCardServiceImpl implements IBorrowCardService  {
    @Autowired
    IBorrowCardRepository borrowCardRepository;
    @Override
    public List<BorrowCard> findAll() {
        return borrowCardRepository.findAll();
    }

    @Override
    public void add(BorrowCard borrowCard) {
        borrowCardRepository.save(borrowCard);
    }

    @Override
    public void delete(BorrowCard borrowCard) {
        borrowCardRepository.delete(borrowCard);
    }

    @Override
    public BorrowCard findById(Integer id) {
        return borrowCardRepository.findById(id).orElse(null);
    }
}
