package com.altunfatih.bookseller.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.altunfatih.bookseller.model.Book;
import com.altunfatih.bookseller.repository.BookRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {
	private BookRepository bookRepository;
	
	@Override
	public Book saveBook(Book book) {
		book.setCreateTime(LocalDateTime.now());
		return bookRepository.save(book);
	}
	
	@Override
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
	
	@Override
	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}
}
