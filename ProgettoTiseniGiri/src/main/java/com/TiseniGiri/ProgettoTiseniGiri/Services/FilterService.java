package com.TiseniGiri.ProgettoTiseniGiri.Services;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;
import com.TiseniGiri.ProgettoTiseniGiri.Utility.SingleKeyHashMap;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FilterService extends GeneralService {
	
	static ExecuterForServices executer = new ExecuterForServices();
	
	@SuppressWarnings("unchecked")
	public static List<Tweet> getFilteredTweets(String url,String filters) throws JsonMappingException, JsonProcessingException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		List<Tweet> tweets = getTweets(url);
		
		SingleKeyHashMap<String,List<Object>> request = null;
		ObjectMapper mapper = new ObjectMapper();
		request = mapper.readValue(filters,SingleKeyHashMap.class);

		
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
