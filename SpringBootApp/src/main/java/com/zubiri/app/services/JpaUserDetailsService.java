package com.zubiri.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zubiri.app.Interfaces.DBUserRepository;
import com.zubiri.app.beans.SecurityUser;
import com.zubiri.app.beans.User;



@Service
public class JpaUserDetailsService implements UserDetailsService{

	@Autowired
	private DBUserRepository userRepository;
	
	
	@Override
	public SecurityUser loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> u = userRepository.findByUsername(username);
		if(u.isEmpty()) {
			throw new UsernameNotFoundException("No existe");
		}else {
			return new SecurityUser(u.get());
		}		
		
	}
}
