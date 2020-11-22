package com.MyBookstoreAdmin.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyBookstoreAdmin.model.Book;
import com.MyBookstoreAdmin.repository.BookRepository;
import com.MyBookstoreAdmin.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepository;
	
	public Book save(Book book) {
		return bookRepository.save(book);
	}
	
	public List<Book> findAll() {
		return (List<Book>) bookRepository.findAll();
	}
	
	public Optional<Book> findOne(Long id) {
		return bookRepository.findById(id);
	}
	
}
