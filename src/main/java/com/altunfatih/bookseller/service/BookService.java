package com.altunfatih.bookseller.service;

import java.util.List;

import com.altunfatih.bookseller.model.Book;

public interface BookService {

	Book saveBook(Book book);

	void deleteBook(Long id);

	List<Book> findAllBooks();

}
