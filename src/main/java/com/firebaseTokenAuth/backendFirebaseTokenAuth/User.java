package com.firebaseTokenAuth.backendFirebaseTokenAuth;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.google.firebase.auth.UserRecord;

public class User implements Authentication {

	
	private final UserRecord userRecord;
	private String userId;
	private boolean isEmployee;
	
	public Map<String,Object>getClaims()
	{
		return userRecord.getCustomClaims();
	}
	
	public User() {
		
		this.userRecord = null;
	}

	
	
	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public boolean isEmployee() {
		return isEmployee;
	}



	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}



	public UserRecord getUserRecord() {
		return userRecord;
	}



	public User(UserRecord userRecord) {
		super();
		this.userRecord = userRecord;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAuthenticated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

}
