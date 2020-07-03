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
		    String parameter = entry.getKey();
		    String filter = entry.getValue().get(0).toString();
		    
		    ArrayList<Object> num = new ArrayList<Object>();
			for (int i=0; i < entry.getValue().size()-1; i++)
				num.add(i,(int)entry.getValue().get(i+1));
			if(num.size() == 1)
			    tweets = executer.ExecuteFilter(tweets, parameter, filter, num.get(0));
			else 
			    tweets = executer.ExecuteFilter(tweets, parameter, filter, num.get(0),num.get(1));

		    	
			
		}
		
		return tweets;		
	}
	
	
}
