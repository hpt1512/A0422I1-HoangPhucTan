package com.example.borrowbookapp.service;

import com.example.borrowbookapp.model.BorrowCard;

import java.util.List;

public interface IBorrowCardService {
    List<BorrowCard> findAll();
    void add(BorrowCard borrowCard);
    void delete(BorrowCard borrowCard);
    BorrowCard findById(Integer id);
}
