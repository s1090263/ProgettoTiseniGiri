package com.TiseniGiri.ProgettoTiseniGiri.Utility;

import java.util.Comparator;

import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;

public class ComparatorForFavorites implements Comparator<Tweet> {

	@Override
	public int compare(Tweet tweet1, Tweet tweet2) {
		return (tweet2.getFavorite_count()-tweet1.getFavorite_count());
	}

}
