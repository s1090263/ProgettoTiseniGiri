package com.TiseniGiri.ProgettoTiseniGiri.Filter.Interfaces;

import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;

public interface NumericalFilter{
	
	public List<Tweet> greater(List<Tweet> list, Object num);
	public List<Tweet> lower(List<Tweet> list,	Object num);
	public List<Tweet> equal(List<Tweet> list,	Object num);
	public List<Tweet> between(List<Tweet> list, Object top, Object bottom);	
}
