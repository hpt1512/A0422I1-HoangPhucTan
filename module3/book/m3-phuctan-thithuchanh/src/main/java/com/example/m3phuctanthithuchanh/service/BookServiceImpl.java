package com.example.m3phuctanthithuchanh.service;

import com.example.m3phuctanthithuchanh.model.Book;
import com.example.m3phuctanthithuchanh.repository.BookRepositoryImpl;
import com.example.m3phuctanthithuchanh.repository.IBaseRepository;

import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl implements IBaseService<Book> {
    IBaseRepository<Book> bookRepository = new BookRepositoryImpl();
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void insert(Book book) throws SQLException {

    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Book book) throws SQLException {
        return false;
    }

    @Override
    public Book getById(int id) {
        return bookRepository.getById(id);
    }

    @Override
    public List<Book> findByName(String name) {
        return null;
    }
}
