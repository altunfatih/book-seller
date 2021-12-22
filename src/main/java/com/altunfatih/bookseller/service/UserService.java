package com.altunfatih.bookseller.service;

import java.util.Optional;

import com.altunfatih.bookseller.model.User;

public interface UserService {

	User saveUser(User user);

	Optional<User> findByUsername(String username);

	void makeAdmin(String username);

}
