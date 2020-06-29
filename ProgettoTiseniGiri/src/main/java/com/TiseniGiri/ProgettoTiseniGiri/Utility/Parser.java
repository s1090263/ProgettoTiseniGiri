package com.TiseniGiri.ProgettoTiseniGiri.Utility;

import java.util.Arrays;
import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Parser {
	
	public static List<Tweet> dataParser(String data) throws JsonMappingException, JsonProcessingException{
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES); //ignora parametri non riconosciuti		
		final ObjectNode node = new ObjectMapper().readValue(data, ObjectNode.class);
		
		List<Tweet> tweets = Arrays.asList(mapper.readValue(node.get("statuses").toString(), Tweet[].class));

        return tweets;
	}
}
