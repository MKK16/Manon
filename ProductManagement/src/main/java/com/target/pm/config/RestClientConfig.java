package com.target.pm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestClientConfig {
   
	@Value("${redskyUrl}")
	private String redskyUrl;
	
	public String getRedskyUrl() {
		return redskyUrl;
	}
}
