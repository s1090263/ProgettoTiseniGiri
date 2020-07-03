package com.TiseniGiri.ProgettoTiseniGiri.Utility;

import java.util.Comparator;

import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;

public class ComparatorForRetweets implements Comparator<Tweet> {

	@Override
	public int compare(Tweet tweet1, Tweet tweet2) {
		return (tweet2.getRetweet_count()-tweet1.getRetweet_count());
	}

}
