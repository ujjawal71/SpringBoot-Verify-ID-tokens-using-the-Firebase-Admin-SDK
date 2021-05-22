package com.firebaseTokenAuth.backendFirebaseTokenAuth;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class FirebaseAuthenticationToken extends AbstractAuthenticationToken {

	
	private final String idtokn;
	
	
	
	public FirebaseAuthenticationToken(String idToken) {
		super(null);
		this.idtokn=idToken;
		// TODO Auto-generated constructor stub
	}
	
	public String getIdtokn() {
		return idtokn;
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}

}
