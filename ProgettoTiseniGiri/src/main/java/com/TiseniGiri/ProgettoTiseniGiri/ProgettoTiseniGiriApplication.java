package com.TiseniGiri.ProgettoTiseniGiri;



import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;
import com.TiseniGiri.ProgettoTiseniGiri.Utility.Downloader;
import com.TiseniGiri.ProgettoTiseniGiri.Utility.Parser;
import com.TiseniGiri.ProgettoTiseniGiri.Filter.FavoritesFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@SpringBootApplication
public class ProgettoTiseniGiriApplication {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, JsonMappingException, JsonProcessingException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		
		SpringApplication.run(ProgettoTiseniGiriApplication.class, args);			
	}
}
