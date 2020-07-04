package com.TiseniGiri.ProgettoTiseniGiri.Services;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;


public class FilterService extends GeneralService {
	
	static ExecuterForServices executer = new ExecuterForServices();
	
	public static List<Tweet> getFilteredTweets(String url,String filters) throws JsonMappingException, JsonProcessingException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		List<Tweet> tweets = getTweets(url);
		
		Map<String,List<Object>> request = null;
		ObjectMapper mapper = new ObjectMapper();
		
		request = mapper.readValue(filters,Map.class);
		
		for (Map.Entry<String, List<Object>> entry : request.entrySet()) {
		    String parameter = entry.getValue().get(0).toString();
		    String filter = entry.getValue().get(1).toString();
		   		    
			if(entry.getValue().size() == 3)
			    tweets = executer.ExecuteFilter(tweets, parameter, filter, entry.getValue().get(2));
			else 
			    tweets = executer.ExecuteFilter(tweets, parameter, filter, entry.getValue().get(2),entry.getValue().get(3));	
		}
		
		return tweets;		
	}
	
	
}
