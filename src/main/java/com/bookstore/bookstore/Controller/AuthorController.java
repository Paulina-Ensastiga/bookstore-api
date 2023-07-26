package com.bookstore.bookstore.Controller;

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
import com.bookstore.bookstore.Service.AuthorService;

@RestController
@RequestMapping(path="/bookstore/authors")
public class AuthorController {


	@Autowired
	private AuthorService authorService;

	
	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}
	
	// Get all
	@GetMapping
	public List<Author> getAllAuthor(){
		return authorService.getAllAuthors();
	}
	
	// Get individual
	@GetMapping("/{id}")
	public Author getAuthorById(@PathVariable Long id) {
		return authorService.getAuthorById(id);
	}
	
	@PostMapping
	public Author createAuthor(@RequestBody Author author) {
		return authorService.createAuthor(author);
	}
	
	// Put
	@PutMapping
	public Author updateAuthor(@RequestBody Author author) {
		return authorService.updateAuthor(author);
	}
	
	// Delete mapping
	@DeleteMapping("/{id}")
	public void deleteAuthor(@PathVariable Long id) {
		authorService.deleteAuthor(id);
	}	
	
}