package com.TiseniGiri.ProgettoTiseniGiri;

import java.net.URLConnection;
import java.util.List;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.TiseniGiri.ProgettoTiseniGiri.Utility.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.TiseniGiri.ProgettoTiseniGiri.Model.*;

@SpringBootApplication
public class ProgettoTiseniGiriApplication {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException{
		SpringApplication.run(ProgettoTiseniGiriApplication.class, args);		      		   			
	}
}
