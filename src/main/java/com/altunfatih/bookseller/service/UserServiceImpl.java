package com.altunfatih.bookseller.service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.altunfatih.bookseller.model.Role;
import com.altunfatih.bookseller.model.User;
import com.altunfatih.bookseller.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(Role.USER);
		user.setCreateTime(LocalDateTime.now());
		
		return userRepository.save(user);
	}
	
	@Override
	public Optional<User> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	@Transactional
	public void makeAdmin(String username) {
		userRepository.updateUserRole(username, Role.ADMIN);
	}
}
