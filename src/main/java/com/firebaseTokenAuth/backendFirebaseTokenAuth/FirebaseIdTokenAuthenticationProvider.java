package com.firebaseTokenAuth.backendFirebaseTokenAuth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;

@Component
public class FirebaseIdTokenAuthenticationProvider implements AuthenticationProvider {

	public static final Logger logger = LoggerFactory.getLogger(BackendFirebaseTokenAuthApplication.class);
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		FirebaseAuthenticationToken token =(FirebaseAuthenticationToken) authentication;
		// TODO Auto-generated method stub
		 try {
			 FirebaseToken decodedToken=FirebaseAuth.getInstance().verifyIdToken(token.getIdtokn(),true);
			 String uid = decodedToken.getUid();
			 UserRecord userRecord=FirebaseAuth.getInstance().getUser(uid);
			 logger.info("User fetch ,uid: {}",userRecord.getUid());
			 return new User(userRecord);
		} catch (FirebaseAuthException e) {
			// TODO Auto-generated catch block
			if(e.getErrorCode().equals("id-token-revoked"))
			{
				throw new SecurityException("User token has been revoked , please sign in again");
			}
			else
			{
				throw new SecurityException("Authentication failed!");
			}
			
		}
	
	}

	@Override
	public boolean supports(Class<?> aClass) {
		// TODO Auto-generated method stub
		return aClass.isAssignableFrom(FirebaseAuthenticationToken.class);
	}

}
