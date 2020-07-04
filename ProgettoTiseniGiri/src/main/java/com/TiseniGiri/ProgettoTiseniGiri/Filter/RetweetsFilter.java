package com.TiseniGiri.ProgettoTiseniGiri.Filter;

import java.util.ArrayList;
import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Exceptions.NegativeNumberException;
import com.TiseniGiri.ProgettoTiseniGiri.Filter.Interfaces.NumericalFilter;
import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;

public class RetweetsFilter extends NumericalFilter {

	String id= "retweets";
	
	@Override
	public List<Tweet> greater(List<Tweet> list, Object num) {
		if ((int)num < 0)
			throw new NegativeNumberException("Tweets must have only positive number of retweets");
		List<Tweet> list1 = new ArrayList<Tweet>(list);
		list1.removeIf(t-> t.getRetweet_count() <= (int)num);
		return list1;
	}

	@Override
	public List<Tweet> lower(List<Tweet> list, Object num) {
		if ((int)num < 0)
			throw new NegativeNumberException("Tweets must have only positive number of retweets");
		List<Tweet> list1 = new ArrayList<Tweet>(list);
		list1.removeIf(t-> t.getRetweet_count() >= (int)num);
		return list1;
	}

	@Override
	public List<Tweet> equal(List<Tweet> list, Object num) {
		if ((int)num < 0)
			throw new NegativeNumberException("Tweets must have only positive number of retweets");
		List<Tweet> list1 = new ArrayList<Tweet>(list);
		list1.removeIf(t-> t.getRetweet_count() != (int)num);
		return list1;
	}

}
