package com.example.borrowbookapp.repository;

import com.example.borrowbookapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Integer> {
}
