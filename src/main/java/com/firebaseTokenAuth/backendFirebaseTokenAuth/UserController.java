package com.firebaseTokenAuth.backendFirebaseTokenAuth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

@RestController
public class UserController {

	@PostMapping("/user")
	public Message createUser(@RequestBody User user)
	{
		Map<String,Object>claims = new HashMap<>();
		claims.put("isEmployee", user.isEmployee());
		try {
			FirebaseAuth.getInstance().setCustomClaims(user.getUserId(), claims);
			BackendFirebaseTokenAuthApplication.userMap.put(user.getUserId(), user.isEmployee());
			return new Message("user created");
		} catch (FirebaseAuthException e) {
			// TODO Auto-generated catch block
		 throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"failed to create user !");
		}
		
	}
	
}
