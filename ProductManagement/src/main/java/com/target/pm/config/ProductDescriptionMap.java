package com.target.pm.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.target.pm.model.ProductDescriptionResponse;

@Configuration
public class ProductDescriptionMap {
	
	@Bean("productionDescriptionMap")
	 public HashMap<String,ProductDescriptionResponse> productionDescriptionMapping() {
		 HashMap<String,ProductDescriptionResponse> map = new HashMap<String,ProductDescriptionResponse>();
		 map.put("13860428",new ProductDescriptionResponse("The Big Lebowski (Blu-ray)",new ArrayList<>(Arrays.asList(
				 "<B>Movie Studio:</B> Universal Studios", 
				 "<B>Movie Genre:</B> Comedy", 
				 "<B>Software Format:</B> Blu-ray"))));
		 map.put("15117729",new ProductDescriptionResponse("Aladdin Signature Collection (4K/UHD/Blu-ray/digital combo)",new ArrayList<>(Arrays.asList(
				 "<B>Movie Studio:</B> Disney", 
				 "<B>Movie Genre:</B> Cartoons & Animation", 
				 "<B>Software Format:</B> 4K/UHD/Blu-ray/digital combo"))));
		 map.put("16483589",new ProductDescriptionResponse("X-Men:Dark Phoenix (4K/UHD)",new ArrayList<>(Arrays.asList(
				 "<B>Movie Studio:</B> 20th Century Fox", 
				 "<B>Movie Genre:</B> Action/Adventure", 
				 "<B>Software Format:</B> 4K/UHD"))));
		 map.put("16696652",new ProductDescriptionResponse("Men In Black: International (Blu-Ray + DVD + Digital)",new ArrayList<>(Arrays.asList(
				 "<B>Movie Studio:</B> Sony Pictures", 
				 "<B>Movie Genre:</B> Action/Adventure", 
				 "<B>Software Format:</B> Blu-ray/DVD/digital combo"))));
		 map.put("16752456",new ProductDescriptionResponse("Split (Blu-ray)",new ArrayList<>(Arrays.asList(
				 "<B>Movie Studio:</B> Universal Studios", 
				 "<B>Movie Genre:</B> Film + TV + Radio, Horror", 
				 "<B>Software Format:</B> Blu-ray"))));
		 map.put("15643793",new ProductDescriptionResponse("The Lion King (4K/UHD)",new ArrayList<>(Arrays.asList(
				 "<B>Movie Studio:</B> Disney", 
				 "<B>Movie Genre:</B> Action/Adventure", 
				 "<B>Software Format:</B> 4K/UHD/Blu-ray/digital combo"))));
		return map;  
	 }
}
