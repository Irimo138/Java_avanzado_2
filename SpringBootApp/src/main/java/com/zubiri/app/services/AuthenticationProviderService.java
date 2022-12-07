package com.zubiri.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.zubiri.app.beans.SecurityUser;



@Component
public class AuthenticationProviderService implements AuthenticationProvider{


	
	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String name = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		SecurityUser SUser = userDetailsService.loadUserByUsername(name);
		return checkpassword(SUser, password);
	}

	private Authentication checkpassword(SecurityUser sUser, String password) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(password, sUser.getPassword())) {
			return new UsernamePasswordAuthenticationToken(
			sUser.getUsername(),
			sUser.getPassword(),
			sUser.getAuthorities()
			);
		}else {			
			throw new BadCredentialsException("Credenciales erroneas");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);

	}
	
}
