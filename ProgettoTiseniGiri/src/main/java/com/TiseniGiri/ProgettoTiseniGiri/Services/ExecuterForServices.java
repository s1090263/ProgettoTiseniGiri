package com.TiseniGiri.ProgettoTiseniGiri.Services;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;

public class ExecuterForServices {
	public List<Tweet> ExecuteFilter(List<Tweet> tweets, String parameter, String filter, Object par) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> typeClass = Class.forName("com.TiseniGiri.ProgettoTiseniGiri.Filter." + parameter + "Filter");
		Object typeFilter = typeClass.getDeclaredConstructor().newInstance();
		Method method = typeClass.getDeclaredMethod(filter, List.class, int.class);				
		List<Tweet> filteredTweets= (List<Tweet>) method.invoke(typeFilter, tweets, par);
		return filteredTweets;
	}
	
	public List<Tweet> ExecuteFilter(List<Tweet> tweets, String parameter, String filter, Object par1, Object par2) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> typeClass = Class.forName("com.TiseniGiri.ProgettoTiseniGiri.Filter." + parameter + "Filter");
		Object typeFilter = typeClass.getDeclaredConstructor().newInstance();
		Method method = typeClass.getDeclaredMethod(filter, List.class, int.class,int.class);				
		List<Tweet> filteredTweets= (List<Tweet>) method.invoke(typeFilter, tweets, par1,par2);
		return filteredTweets;
	}
	
	int ciao;
}