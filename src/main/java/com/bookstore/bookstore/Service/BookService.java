package com.bookstore.bookstore.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.Entity.Book;
import com.bookstore.bookstore.Repository.BookRepository;

@Service
public class BookService {

	// Nuestros metodos van a depender de EntityRepository -> Toda la logica viene de JpaRepository
	@Autowired
	private BookRepository bookRepository;
	
	// Get
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	// Get by Id
	public Book getBookById(Long id) {
		return bookRepository.findById(id).orElse(null);
	}
	
	// Post
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	
	// Put
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
	
	// Delete
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
	
	
}
