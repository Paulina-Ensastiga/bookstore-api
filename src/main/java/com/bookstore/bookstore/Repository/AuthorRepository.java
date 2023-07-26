package com.bookstore.bookstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.bookstore.Entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}