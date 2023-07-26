package com.bookstore.bookstore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.Entity.Genre;
import com.bookstore.bookstore.Repository.GenreRepository;

@Service
public class GenreService {
	
	@Autowired
	private GenreRepository genreRepository;

	public List<Genre> getAllGenres() {
		return genreRepository.findAll();
	}
	
	public Genre getGenreById(Long id) {
		return genreRepository.findById(id).orElse(null);
	}

	public Genre createGenre(Genre genre) {
		return genreRepository.save(genre);
	}

	public Genre updateGenre(Genre genre) {
		return genreRepository.save(genre);
	}

	public void deleteGenre(Long id) {
		genreRepository.deleteById(id);
	}
}


