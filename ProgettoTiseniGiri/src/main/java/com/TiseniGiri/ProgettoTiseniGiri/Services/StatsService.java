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

public class StatsService extends GeneralService {
	
	static ExecuterForServices executer = new ExecuterForServices();
	
	public static Map<String, List<String>> getStats(String url,String stats) throws JsonMappingException, JsonProcessingException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		List<Tweet> tweets = getTweets(url);
		
		Map<String,List<Object>> request = null;
		ObjectMapper mapper = new ObjectMapper();
		request = mapper.readValue(stats,Map.class);
			
		return statCycler(request,tweets);
	}
	
	public static Map<String, List<String>> getFilteredStats(String url,String requests) throws JsonMappingException, JsonProcessingException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		Map<String,List<Object>> filters = null;
		Map<String,List<Object>> stats = null;
		
		ObjectMapper mapper = new ObjectMapper();
		final ObjectNode node = new ObjectMapper().readValue(requests, ObjectNode.class);
		filters = mapper.readValue(node.get("filters").toString(),Map.class);
		stats = mapper.readValue(node.get("stats").toString(),Map.class);
		String filterString = mapper.writeValueAsString(filters);
		List<Tweet> filteredTweets = FilterService.getFilteredTweets(url, filterString);
		
		return statCycler(stats,filteredTweets);
	}
	
	public static Map<String, List<String>> statCycler(Map<String,List<Object>> stats, List<Tweet> filteredTweets) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		
		Map<String, List<String>> completedStats = new HashMap<String, List<String>>();
		
		for (Map.Entry<String, List<Object>> entry : stats.entrySet()) {
		    String parameter = entry.getValue().get(0).toString(); //parametro su cui fare statistica
		    String stat = entry.getValue().get(1).toString();	//tipo di statistica da fare
		    List<String> list = new ArrayList<String>();
		    list.add(parameter);
		    list.add(stat);
		    if(entry.getValue().size() == 2)
		    	list.add(String.valueOf(executer.ExecuteStat(filteredTweets,parameter,stat)));
		    else
		    	list.add(String.valueOf(executer.ExecuteStat(filteredTweets,parameter,stat,  entry.getValue().get(2))));
		    completedStats.put(entry.getKey(), list);
		}
		
		return completedStats;
	}
}
