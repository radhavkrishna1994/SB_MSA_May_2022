package com.training.interfaces;

import java.util.List;

import com.training.model.Book;

public interface BookServiceI {
	
	//retrieve all books
	public List<Book> getBooks();
	
	//retrieve a book based on isbn
	public Book getBook(Long isbn);
	
	//save a book
	public Book saveBook(Book book);
	//delete book based on isbn
	public Book deleteBook(Long isbn);
	//add stock on isbn
	public Book updateBook(Long isbn,Long newStock);
	

}
