package com.firebaseTokenAuth.backendFirebaseTokenAuth;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@SpringBootApplication
public class BackendFirebaseTokenAuthApplication {

	private final static Logger logger = LoggerFactory.getLogger(BackendFirebaseTokenAuthApplication.class);
	
	public static Map<String,Boolean>userMap = new HashMap<>();

	public static void main(String[] args) throws IOException {
		SpringApplication.run(BackendFirebaseTokenAuthApplication.class, args);

		FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://textrecognize-ef184.firebaseio.com").build();

		FirebaseApp.initializeApp(options);

		logger.info("Firebase app:{} initialized", FirebaseApp.getInstance().getName());

	}

}
