package com.bookstore.bookstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.bookstore.Entity.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

}