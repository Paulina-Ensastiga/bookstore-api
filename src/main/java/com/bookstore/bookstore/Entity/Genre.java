package com.bookstore.bookstore.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Genre")
public class Genre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="genre_id", unique=true, nullable=false)
	private Long genre_id;
	
	@Column(nullable=false)
	private String name;
	

	// Constructor vacio para JPA
	public Genre() {
	}

	public Long getGenre_id() {
		return genre_id;
	}

	public void setGenre_id(Long genre_id) {
		this.genre_id = genre_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
