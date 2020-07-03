package com.TiseniGiri.ProgettoTiseniGiri.Filter;

import java.util.ArrayList;
import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;

public class NumberFilter {
	public List<Tweet> getNumberOfTweets(List<Tweet> list, Object num) {
		List<Tweet> list1 = new ArrayList<Tweet>();
		for (int i=0; i < (int)num; i++)
			list1.add(list.get(i));
		return list1;
	}
}
