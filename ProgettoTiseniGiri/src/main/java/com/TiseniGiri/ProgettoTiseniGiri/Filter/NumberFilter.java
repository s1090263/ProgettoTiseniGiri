package com.TiseniGiri.ProgettoTiseniGiri.Filter;

import java.util.ArrayList;
import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Exceptions.NegativeNumberException;
import com.TiseniGiri.ProgettoTiseniGiri.Exceptions.OutOfReachException;
import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;

public class NumberFilter {
	public List<Tweet> getNumberOfTweets(List<Tweet> list, Object num) {
		if ((int)num < 0)
			throw new NegativeNumberException("You can only obtain a positive number of Tweets");
		if (list.size() < (int)num)
			throw new OutOfReachException("The number of tweets you're tring to get exceeds the number of tweets found");
		List<Tweet> list1 = new ArrayList<Tweet>();
		for (int i=0; i < (int)num; i++)
			list1.add(list.get(i));
		return list1;
	}
}
