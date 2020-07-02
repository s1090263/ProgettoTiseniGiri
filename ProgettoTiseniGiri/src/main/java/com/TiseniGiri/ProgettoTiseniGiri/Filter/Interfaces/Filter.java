package com.TiseniGiri.ProgettoTiseniGiri.Filter.Interfaces;

import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;

public interface Filter{
	
	public List<Tweet> greater(List<Tweet> list, int num);
	public List<Tweet> lower(List<Tweet> list,	int num);
	public List<Tweet> equal(List<Tweet> list,	int num);
	
}
