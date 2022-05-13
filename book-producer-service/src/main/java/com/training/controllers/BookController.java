package com.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.training.interfaces.BookServiceI;
import com.training.model.Book;

@RequestMapping("/bookstore/api")
@RestController
public class BookController {
	@Autowired
	private BookServiceI bookService;

	//http://localhost:8081/bookstore/api/books
	@GetMapping("/books")
	public List<Book> getBooks()
	{
		return bookService.getBooks();
	}

	//http://localhost:8081/bookstore/api/book
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/book")
	public Book saveBook(@RequestBody Book book)
	{
		return bookService.saveBook(book);
	}

	//http://localhost:8081/bookstore/api/book/isbn/1234
	@GetMapping("/book/isbn/{isbn}")
	public ResponseEntity<Book> getBook(@PathVariable("isbn") Long isbn)
	{
		Book bookFound = bookService.getBook(isbn);
		if(bookFound!=null)
			return new ResponseEntity<Book>(bookFound, HttpStatus.OK);
		return new ResponseEntity<Book>(bookFound, HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/book/isbn/{isbn}")
	public ResponseEntity<Book> deleteBook(@PathVariable("isbn") Long isbn)
	{
		Book bookFound = bookService.deleteBook(isbn);
		if(bookFound!=null)
			return new ResponseEntity<Book>(bookFound, HttpStatus.OK);
		return new ResponseEntity<Book>(bookFound, HttpStatus.NOT_FOUND);
	}

	@PutMapping("/book/isbn/{isbn}/stock/{stock}")
	public ResponseEntity<Book> updateStockBook(@PathVariable("isbn") Long isbn,@PathVariable("stock") Long stock)
	{
		Book bookFound = bookService.updateBook(isbn, stock);
		if(bookFound!=null)
			return new ResponseEntity<Book>(bookFound, HttpStatus.OK);
		return new ResponseEntity<Book>(bookFound, HttpStatus.NOT_FOUND);
	}
}
