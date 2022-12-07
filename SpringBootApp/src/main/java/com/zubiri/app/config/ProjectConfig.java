package com.zubiri.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.zubiri.app.Interfaces.DBUserRepository;
import com.zubiri.app.services.AuthenticationProviderService;
import com.zubiri.app.services.JpaUserDetailsService;



@Order(2)
@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationProviderService authenticationProviderService;

	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private DBUserRepository userRepository;


	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authenticationProviderService);
	}
	
	@Bean
	protected PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.httpBasic();
		http.csrf().disable();
		http.formLogin().defaultSuccessUrl("/", true).loginPage("/login").failureUrl("/login?error=true");
		http.authorizeRequests()
			.mvcMatchers("/hello").permitAll()
			.mvcMatchers("/ciao").hasRole("MANAGER")
			.mvcMatchers("/addUsers").permitAll()
			.mvcMatchers("/register").permitAll()
			.mvcMatchers("/").permitAll()
			.mvcMatchers("/login").permitAll()
			.anyRequest().authenticated();
	}



	public AuthenticationProviderService getCustomAuthenticationProvider() {
		return authenticationProviderService;
	}

	public void setAuthenticationProviderService(AuthenticationProviderService authenticationProviderService) {
		this.authenticationProviderService = authenticationProviderService;
	}

}
