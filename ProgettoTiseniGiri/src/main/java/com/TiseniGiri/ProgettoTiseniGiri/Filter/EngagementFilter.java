package com.TiseniGiri.ProgettoTiseniGiri.Filter;

import java.util.Comparator;
import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;
import com.TiseniGiri.ProgettoTiseniGiri.Utility.ComparatorForFavorites;
import com.TiseniGiri.ProgettoTiseniGiri.Utility.ComparatorForRetweets;

public class EngagementFilter{
	
	ComparatorForRetweets c = new ComparatorForRetweets();
	ComparatorForFavorites f = new ComparatorForFavorites();
	Comparator<Tweet> cmp = c.thenComparing(f);
	NumberFilter n = new NumberFilter();
	
	public List<Tweet> sortForRetweets(List<Tweet> list, int num){
		list.sort(cmp);
		list = n.getNumberOfTweets(list, num);
		return list;
	}
	
	
}