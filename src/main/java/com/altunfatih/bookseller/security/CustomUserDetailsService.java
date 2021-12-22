package com.altunfatih.bookseller.security;

import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.altunfatih.bookseller.model.User;
import com.altunfatih.bookseller.service.UserService;
import com.altunfatih.bookseller.util.SecurityUtils;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	private final UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException(username));
		
		Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));
		
		return UserPrincipal.builder()
				.user(user).id(user.getId())
				.username(username)
				.password(user.getPassword())
				.authorities(authorities)
				.build();
	}
}
