package com.TiseniGiri.ProgettoTiseniGiri.Filter.Interfaces;

import java.util.List;
import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;

public interface Filter<T> {
	
	public List<Tweet> generalFilter(List<Tweet> list, Integer x);
}
