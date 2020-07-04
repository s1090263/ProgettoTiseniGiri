package com.TiseniGiri.ProgettoTiseniGiri.Services;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Exceptions.ExtremesException;
import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;

public class ExecuterForServices {
	
	public List<Tweet> ExecuteFilter(List<Tweet> tweets, String parameter, String filter, Object par) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		List<Tweet> filteredTweets = new ArrayList<Tweet>();
		try {
			Class<?> typeClass = Class.forName("com.TiseniGiri.ProgettoTiseniGiri.Filter." + parameter + "Filter");
			Object typeFilter = typeClass.getDeclaredConstructor().newInstance();
			Method method = typeClass.getDeclaredMethod(filter, List.class, Object.class);				
			filteredTweets= (List<Tweet>) method.invoke(typeFilter, tweets, par);
		}
		catch(ExtremesException e) {
			e.printStackTrace();
		}
		return filteredTweets;
	}
	
	public List<Tweet> ExecuteFilter(List<Tweet> tweets, String parameter, String filter, Object par1, Object par2) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> typeClass = Class.forName("com.TiseniGiri.ProgettoTiseniGiri.Filter." + parameter + "Filter");
		Object typeFilter = typeClass.getDeclaredConstructor().newInstance();
		Method method = typeClass.getDeclaredMethod(filter, List.class, Object.class,Object.class);				
		List<Tweet> filteredTweets= (List<Tweet>) method.invoke(typeFilter, tweets, par1,par2);
		return filteredTweets;
	}
	
	public double ExecuteStat(List<Tweet> tweets, String parameter, String stat) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> typeClass = Class.forName("com.TiseniGiri.ProgettoTiseniGiri.Stats." + parameter + "Stats");
		Object typeStat = typeClass.getDeclaredConstructor().newInstance();
		Method method = typeClass.getDeclaredMethod(stat, List.class);
		double completedStat = (double) method.invoke(typeStat, tweets);
		return completedStat;
	}
	
	public double ExecuteStat(List<Tweet> tweets, String parameter, String stat, Object par) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> typeClass = Class.forName("com.TiseniGiri.ProgettoTiseniGiri.Stats." + parameter + "Stats");
		Object typeStat = typeClass.getDeclaredConstructor().newInstance();
		Method method = typeClass.getDeclaredMethod(stat, List.class, Object.class);
		double completedStat = (double) method.invoke(typeStat, tweets, par);
		return completedStat;
	}
}

	
