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
	
	public static Map<String, List<String>> getStats(String url,String stats) throws JsonMappingException, JsonProcessingException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		List<Tweet> tweets = getTweets(url);
		
		Map<String,String> request = null;
		ObjectMapper mapper = new ObjectMapper();
		request = mapper.readValue(stats,Map.class);
		
		Map<String, List<String>> completedStats = new HashMap<String, List<String>>(); //mappa delle statistiche eseguite
		for (Map.Entry<String, String> entry : request.entrySet()) {
		    String parameter = entry.getKey(); //parametro su cui fare statistica
		    String stat = entry.getValue();	//tipo di statistica da fare
		    List<String> list = new ArrayList<String>();
		    list.add(stat);
		    list.add(String.valueOf(Execute(tweets,parameter,stat)));
		    completedStats.put(parameter, list);
		}
		
		return completedStats;
	}
	
	public static Map<String, List<String>> getFilteredStats(String url,String requests) throws JsonMappingException, JsonProcessingException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		List<Tweet> tweets = getTweets(url);
		Map<String,List<String>> filters = null;
		Map<String,String> stats = null;
		
		ObjectMapper mapper = new ObjectMapper();
		final ObjectNode node = new ObjectMapper().readValue(requests, ObjectNode.class);
		filters = mapper.readValue(node.get("filters").toString(),Map.class);
		stats = mapper.readValue(node.get("stats").toString(),Map.class);
		String filterString = mapper.writeValueAsString(filters);
		
		List<Tweet> filteredTweets = FilterService.getFilteredTweets(url, filterString);
		Map<String, List<String>> completedStats = new HashMap<String, List<String>>(); //mappa delle statistiche eseguite
		
		for (Map.Entry<String, String> entry : stats.entrySet()) {
		    String parameter = entry.getKey(); //parametro su cui fare statistica
		    String stat = entry.getValue();	//tipo di statistica da fare
		    List<String> list = new ArrayList<String>();
		    list.add(stat);
		    list.add(String.valueOf(Execute(tweets,parameter,stat)));
		    completedStats.put(parameter, list);
		}
		return completedStats;
	}
	
	public static int Execute(List<Tweet> tweets, String parameter, String stat) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
//		Class<?> typeClass = Class.forName("com.TiseniGiri.ProgettoTiseniGiri.Filter." + parameter + "Stat");
//		Object typeStat = typeClass.getDeclaredConstructor().newInstance();
//		Method method = typeClass.getDeclaredMethod(stat, List.class, int.class);				
//		List<Tweet> filteredTweets= (List<Tweet>) method.invoke(typeFilter, tweets, num);
		return 0;
	}
}
