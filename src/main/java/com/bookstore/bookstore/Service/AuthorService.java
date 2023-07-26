package com.bookstore.bookstore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.Entity.Author;
import com.bookstore.bookstore.Repository.AuthorRepository;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository authorRepository;
	
	// Get
	public List<Author> getAllAuthors() {
		return authorRepository.findAll();
	}
	
	// Get by Id
	public Author getAuthorById(Long id) {
		return authorRepository.findById(id).orElse(null);
	}
	
	// Post
	public Author createAuthor(Author author) {
		return authorRepository.save(author);
	}
	
	// Put
	public Author updateAuthor(Author author) {
		return authorRepository.save(author);
	}
	
	// Delete
	public void deleteAuthor(Long id) {
		authorRepository.deleteById(id);
	}
}