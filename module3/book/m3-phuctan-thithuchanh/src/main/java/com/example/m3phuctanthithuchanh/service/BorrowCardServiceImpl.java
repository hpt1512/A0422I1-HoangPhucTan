package com.example.m3phuctanthithuchanh.service;

import com.example.m3phuctanthithuchanh.model.BorrowCard;
import com.example.m3phuctanthithuchanh.repository.BorrowCardRepositoryImpl;
import com.example.m3phuctanthithuchanh.repository.IBaseRepository;

import java.sql.SQLException;
import java.util.List;

public class BorrowCardServiceImpl implements IBaseService<BorrowCard> {
    IBaseRepository<BorrowCard> borrowCardRepository = new BorrowCardRepositoryImpl();
    @Override
    public List<BorrowCard> findAll() {
        return borrowCardRepository.findAll();
    }

    @Override
    public void insert(BorrowCard borrowCard) throws SQLException {
        borrowCardRepository.insert(borrowCard);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(BorrowCard borrowCard) throws SQLException {
        return false;
    }

    @Override
    public BorrowCard getById(int id) {
        return null;
    }

    @Override
    public List<BorrowCard> findByName(String name) {
        return null;
    }
}
