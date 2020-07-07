package com.TiseniGiri.ProgettoTiseniGiri;



import java.lang.reflect.InvocationTargetException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@SpringBootApplication
public class ProgettoTiseniGiriApplication {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, JsonMappingException, JsonProcessingException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		
		SpringApplication.run(ProgettoTiseniGiriApplication.class, args);			
	}
}
