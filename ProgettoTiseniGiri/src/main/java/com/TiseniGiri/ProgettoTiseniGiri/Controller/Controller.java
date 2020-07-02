package com.TiseniGiri.ProgettoTiseniGiri.Controller;

import java.lang.reflect.InvocationTargetException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TiseniGiri.ProgettoTiseniGiri.Services.FilterService;
import com.TiseniGiri.ProgettoTiseniGiri.Services.GeneralService;
import com.TiseniGiri.ProgettoTiseniGiri.Utility.UrlSetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class Controller {
	
	@GetMapping("/tweets")
	public ResponseEntity<Object> getTweets(@RequestParam(name="topic", defaultValue="@UnivPoliMarche") String topic, @RequestParam(name="num", defaultValue="100") int num) throws JsonMappingException, JsonProcessingException{
		return new ResponseEntity<>(GeneralService.getTweets(UrlSetter.getUrl(topic,num)),HttpStatus.OK);
	}
	
	@PostMapping("/tweets/filter")
	public ResponseEntity<Object> getFilteredTweets(@RequestParam(name="topic", defaultValue="@UnivPoliMarche") String topic, @RequestParam(name="num", defaultValue="100") int num, @RequestBody String filters) throws JsonMappingException, JsonProcessingException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		return new ResponseEntity<>(FilterService.getFilteredTweets(UrlSetter.getUrl(topic,num),filters),HttpStatus.OK);
	}
}
