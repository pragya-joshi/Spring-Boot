package com.springbootrest.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.springbootrest.model.Book;

public class BookService {
	private static List<Book>list=new ArrayList<Book>();
	
	static {
		list.add(new Book(101,"book1","abc"));
		list.add(new Book(102,"book2","def"));
		list.add(new Book(103,"book3","ghi"));
	}
	
//	get all books
	public List<Book>getAllBooks(){
		return list;
	}
	
	public Book getBookById(int id) {
		Book book=null;
		try {
			book=list.stream().filter(b->b.getId()==id).findFirst().get();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	//add book
	
	public Book addBook(Book b) {
		list.add(b);
		return b;
	}
	
	//delete book
	public void deleteBook(int id) {
		list=list.stream().filter(b->b.getId()!=id).collect(Collectors.toList());
	}
	
	//update Book
	public void updateBook(Book book,int bId) {
		list=list.stream().map(b->{
			if(b.getId()==bId) {
				b.setName(book.getName());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}
		).collect(Collectors.toList());
	}
}
