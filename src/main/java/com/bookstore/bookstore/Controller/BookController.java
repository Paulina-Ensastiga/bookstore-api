package com.bookstore.bookstore.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.bookstore.Entity.Author;
import com.bookstore.bookstore.Entity.Book;
import com.bookstore.bookstore.Entity.Genre;
import com.bookstore.bookstore.Service.AuthorService;
import com.bookstore.bookstore.Service.BookService;
import com.bookstore.bookstore.Service.GenreService;

@RequestMapping(path="/bookstore/books")
@RestController
public class BookController {
	
	
	private BookService bookService;	
	// Many to many relationships require their respective entities to be called
	private GenreService genreService;
	private AuthorService authorService;
	
	@Autowired
	public BookController(BookService bookService, GenreService genreService, AuthorService authorService) {
		super();
		this.bookService = bookService;
		this.genreService = genreService;
		this.authorService = authorService;
	}
	
	
	// Get all
	@GetMapping
	public List<Book> getAllBook(){
		return bookService.getAllBooks();
	}
	

	// Get individual
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable Long id) {
		return bookService.getBookById(id);
	}
	
	@PostMapping
	public Book createBook(@RequestBody Book book) {
		// get genre from the database and make a match
		
		Genre persistentGenre = genreService.getGenreById(book.getGenre().getGenre_id());
		book.setGenre(persistentGenre);
		
		// Authors is the same as genre, but for a list
		List<Author> persistentAuthors = new ArrayList<>();
		// Add to the list each author found by their ID
		for(Author author: book.getAuthors()) {
			Author persistentAuthor = authorService.getAuthorById(author.getAuthor_id());
			persistentAuthors.add(persistentAuthor);
		}
		book.setAuthors(persistentAuthors);
		
		return bookService.createBook(book);
	}
	
	// Put
	@PutMapping
	public Book updateBook(@RequestBody Book book) {
		return bookService.updateBook(book);
	}
	
	// Delete mapping
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Long id) {
		bookService.deleteBook(id);
	}	
	
}