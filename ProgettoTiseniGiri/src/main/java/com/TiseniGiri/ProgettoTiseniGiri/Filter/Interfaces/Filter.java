package com.TiseniGiri.ProgettoTiseniGiri.Filter.Interfaces;

import java.util.List;
import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;

public interface Filter<T> {
	
	public List<Tweet> filter_general(List<Tweet> list, Integer x);
}
