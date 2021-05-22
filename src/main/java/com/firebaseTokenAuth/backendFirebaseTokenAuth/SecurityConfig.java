package com.firebaseTokenAuth.backendFirebaseTokenAuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

@EnableWebSecurity
@Component
@EnableGlobalMethodSecurity(securedEnabled =true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final FirebaseIdTokenAuthenticationProvider authenticationProvider;

	@Autowired
	public SecurityConfig(FirebaseIdTokenAuthenticationProvider authenticationProvider) {
		super();
		this.authenticationProvider = authenticationProvider;
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.cors().and().csrf().disable();
		http.addFilterBefore(new FireBaseIdTokenFilter(), BasicAuthenticationFilter.class)
		.authorizeRequests()
		.anyRequest()
		.authenticated();
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.authenticationProvider(authenticationProvider);
	}
}
