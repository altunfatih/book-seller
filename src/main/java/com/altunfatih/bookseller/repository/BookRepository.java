package com.altunfatih.bookseller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.altunfatih.bookseller.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
