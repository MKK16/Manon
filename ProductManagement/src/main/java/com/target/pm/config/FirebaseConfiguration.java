package com.target.pm.config;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

@Configuration
public class FirebaseConfiguration {

	@Value("${firebase.database.url}")
	private String dataBaseUrl;
	
	@Value("${firebase.config.path}")
	private String myAccountPath;
	
	public String getDataBaseUrl() {
		return dataBaseUrl;
	}
	public String getMyAccountPath() {
		return myAccountPath;
	}
	
	@Autowired
	private FirebaseConfiguration firebaseConfig;
	
	@Bean
	public Firestore firebaseDatabse() {
		final Firestore firestore = FirestoreClient.getFirestore();
		return firestore;
	}
	
	@PostConstruct
	public void init() throws IOException {
		FirebaseOptions options = null;
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(firebaseConfig.getMyAccountPath());
		options = new FirebaseOptions.Builder()
		.setCredentials(GoogleCredentials.fromStream(inputStream))
		.setDatabaseUrl(firebaseConfig.getDataBaseUrl())
		.build();
		FirebaseApp.initializeApp(options);
		
	}
	
}
