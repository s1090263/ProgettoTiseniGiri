package com.TiseniGiri.ProgettoTiseniGiri.Services;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class FilterService extends GeneralService {
	
	public static List<Tweet> getFilteredTweets(String url,String filters) throws JsonMappingException, JsonProcessingException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		List<Tweet> tweets = getTweets(url);
		
		Map<String,List<String>> request = null;
		ObjectMapper mapper = new ObjectMapper();
		
		request = mapper.readValue(filters,Map.class);
		
		for (Map.Entry<String, List<String>> entry : request.entrySet()) {
		    String parameter = entry.getKey();
		    String filter = entry.getValue().get(0);
		    int num = Integer.parseInt(entry.getValue().get(1));
		    tweets = filterExecuter(tweets, parameter, filter, num);
		}
		
		return tweets;		
	}
	
	
	
	public static List<Tweet> filterExecuter(List<Tweet> tweets, String parameter, String filter, int num) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> typeClass = Class.forName("com.TiseniGiri.ProgettoTiseniGiri.Filter." + parameter + "Filter");
		Object typeFilter = typeClass.getDeclaredConstructor().newInstance();
		Method method = typeClass.getDeclaredMethod(filter, List.class, int.class);				
		List<Tweet> filteredTweets= (List<Tweet>) method.invoke(typeFilter, tweets, num);
		return filteredTweets;
	}
	
	
}
