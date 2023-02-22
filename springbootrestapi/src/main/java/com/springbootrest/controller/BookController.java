package com.springbootrest.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrest.model.Book;
import com.springbootrest.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookservice;
	
	@GetMapping("/books")
	public List<Book> getBooks() {
		return this.bookservice.getAllBooks();
	}
	
	
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id) {
		return this.bookservice.getBookById(id);
	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		return this.bookservice.addBook(book);
	}
	
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bId) {
		this.bookservice.deleteBook(bId);
	}
	
	@PutMapping("/books/{bookId}")
	public void updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId) {
		this.bookservice.updateBook(book,bookId);
	}
	
}
