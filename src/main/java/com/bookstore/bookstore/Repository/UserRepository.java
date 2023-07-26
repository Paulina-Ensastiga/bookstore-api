package com.bookstore.bookstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.bookstore.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}