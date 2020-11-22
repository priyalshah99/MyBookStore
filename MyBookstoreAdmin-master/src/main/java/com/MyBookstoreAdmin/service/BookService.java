package com.MyBookstoreAdmin.service;

import java.util.List;
import java.util.Optional;

import com.MyBookstoreAdmin.model.Book;

public interface BookService {
	
	Book save(Book book);

	List<Book> findAll();
	
	Optional<Book> findOne(Long id);
	
}
