package com.firebaseTokenAuth.backendFirebaseTokenAuth;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/hello")
	public Message sayHello()
	{ 
		User user=(User)SecurityContextHolder.getContext().getAuthentication();
		boolean isEmployee = (boolean) user.getClaims().get("isEmployee");
		return new Message("Hello" +(isEmployee? " Employee ": "user" )+"!");
	}
	
	
}
