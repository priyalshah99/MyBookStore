package com.MyBookstoreAdmin.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.MyBookstoreAdmin.model.Book;
import com.MyBookstoreAdmin.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping(value = "/add")
	public String addBook(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "addBook";
	}

	@PostMapping(value = "/add")
	public String addBookPost(@ModelAttribute("book") Book book, HttpServletRequest request) {
		bookService.save(book);

		MultipartFile bookImage = book.getBookImage();

		try 
		{
			byte[] bytes = bookImage.getBytes();
			String name = book.getId() + ".jpg";
			
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File("src/main/resources/static/image/book/" + name)));
			stream.write(bytes);
			stream.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		return "redirect:bookList";
	}
	
	@GetMapping("/bookInfo")
	public String bookInfo(@RequestParam("id") Long id, Model model) {
//		Optional<Book> book = bookService.findOne(id);
		model.addAttribute("book", bookService.findOne(id).orElse(null));
		
		return "bookInfo";
	}
	
	@GetMapping("/updateBook")
	public String updateBook(@RequestParam("id") Long id, Model model) {
//		Optional<Book> book = bookService.findOne(id);
		model.addAttribute("book", bookService.findOne(id).orElse(null));
		
		return "updateBook";
	}
	
	@PostMapping(value="/updateBook")
	public String updateBookPost(@ModelAttribute("book") Book book, HttpServletRequest request) {
		bookService.save(book);
		
		MultipartFile bookImage = book.getBookImage();
		
		if(!bookImage.isEmpty()) {
			try {
				byte[] bytes = bookImage.getBytes();
				String name = book.getId() + ".jpg";
				
				Files.delete(Paths.get("src/main/resources/static/image/book/"+name));
				
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File("src/main/resources/static/image/book/" + name)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "redirect:/book/bookInfo?id="+book.getId();
	}
	
	@GetMapping("/bookList")
	public String bookList(Model model) 
	{
		List<Book> bookList = bookService.findAll();
		model.addAttribute("bookList", bookList);		
		return "bookList";
		
	}

}
