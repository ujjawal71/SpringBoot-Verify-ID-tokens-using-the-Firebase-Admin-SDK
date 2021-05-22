package com.firebaseTokenAuth.backendFirebaseTokenAuth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class FireBaseIdTokenFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		String authorization =request.getHeader("Authorization");
		
		String idToken =authorization.replace("Bearer ", "");
		
		SecurityContextHolder.getContext().setAuthentication(new FirebaseAuthenticationToken(idToken));
		chain.doFilter(request,response);
		
		
	}

}
