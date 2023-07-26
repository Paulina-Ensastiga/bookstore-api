package com.bookstore.bookstore.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name = "Book")
public class Book {
	// Id's tipo de dato -> Long
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="book_id", unique=true, nullable=false)
	private Long book_id;
	
	@Column(name="title", nullable=false)
	private String title;
	
	@Column(name="isbn", nullable=false)
	private String isbn;
	
	@Column(name="publish_date", nullable=false)
	private String publish_date;
	
	@Column(name="stock", nullable=false)
	private int stock;
	
	
	// Constructor vacio para JPA
	public Book() {
	}

	// Definimos relaciones
	@ManyToOne
	@JoinColumn(name="Genre_genre_id", nullable=false)
	private Genre genre;
	
	// Relaciones M:N
	@ManyToMany
	@JoinTable(
			name="Book_has_Author",
			joinColumns = @JoinColumn(name="Book_book_id"),
			inverseJoinColumns = @JoinColumn(name="Author_author_id")
	)
	
	private List<Author> authors;
	
	public List<Author> getAuthors() {
		return authors;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public Long getBook_id() {
		return book_id;
	}

	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	
}