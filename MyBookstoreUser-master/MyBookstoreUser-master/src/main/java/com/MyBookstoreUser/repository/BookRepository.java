package com.MyBookstoreUser.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MyBookstoreUser.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	List<Book> findByCategory(String category);
	
	List<Book> findByTitleContaining(String title);
}
