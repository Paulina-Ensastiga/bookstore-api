package com.bookstore.bookstore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.Entity.User;
import com.bookstore.bookstore.Repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	// Get
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	// Get by Id
	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	// Post
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	// Put
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	
	// Delete
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}