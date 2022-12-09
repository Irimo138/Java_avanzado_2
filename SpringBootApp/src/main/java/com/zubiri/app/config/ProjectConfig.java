package com.zubiri.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;

import com.zubiri.app.filters.CsrfTokenLoggerFilter;
import com.zubiri.app.services.AuthenticationProviderService;


@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationProviderService authenticationProviderService;

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
		//http.formLogin();
		http.formLogin().defaultSuccessUrl("/", true).loginPage("/login").failureUrl("/login?error=true");
		http.addFilterAfter(new CsrfTokenLoggerFilter(), CsrfFilter.class).authorizeRequests()
			.mvcMatchers("/consultarDatos").hasAnyRole("ADMIN", "CURRENT")
			.mvcMatchers("/consultarDatos").hasRole("ADMIN")
			.mvcMatchers("/agregarDatos").hasRole("ADMIN")
			.mvcMatchers("/addUsers").permitAll()
			.mvcMatchers("/register").permitAll()
			.mvcMatchers("/registerUser").permitAll()
			.mvcMatchers("/login").permitAll()
			.mvcMatchers("/").permitAll()
			.anyRequest().authenticated();
	}



	public AuthenticationProviderService getCustomAuthenticationProvider() {
		return authenticationProviderService;
	}

	public void setAuthenticationProviderService(AuthenticationProviderService authenticationProviderService) {
		this.authenticationProviderService = authenticationProviderService;
	}

}
