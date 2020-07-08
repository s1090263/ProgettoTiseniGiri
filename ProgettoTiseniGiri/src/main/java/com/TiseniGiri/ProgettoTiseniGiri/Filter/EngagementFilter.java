package com.TiseniGiri.ProgettoTiseniGiri.Filter;

import java.util.Comparator;
import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;
import com.TiseniGiri.ProgettoTiseniGiri.Utility.ComparatorForFavorites;
import com.TiseniGiri.ProgettoTiseniGiri.Utility.ComparatorForRetweets;


/**
 * Class representing filter for engagement parameters(Retweets and Favorites)
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 *
 */
public class EngagementFilter{
	
	/**
	 * A Comparator object used to sort tweets by Retweets in descending order 
	 */
	private ComparatorForRetweets c = new ComparatorForRetweets(); 
	
	/**
	 * A Comparator object used to sort tweets by Favorites in descending order 
	 */
	private ComparatorForFavorites f = new ComparatorForFavorites();
	
	/**
	 * A Comparator object used to sort tweets by Retweets in descending order, and then by Favorites
	 * in descending order, if two tweets have the same number of Retweets 
	 */
	private Comparator<Tweet> cmp = c.thenComparing(f);
	
	
	/**
	 * object of class number filter used to select a fixed number of tweets 
	 */
	private NumberFilter n = new NumberFilter();
	
	/**
	 * This method firstly sort tweets for engagement parameters and then chooses 
	 * a certain number of tweets from the list
	 * 
	 * @param list to be filtered
	 * @param num parameter which is used for filtering operation
	 * @return
	 */
	public List<Tweet> sortForRetweets(List<Tweet> list, Object num){
		list.sort(cmp);
		list = n.getNumberOfTweets(list, num);
		return list;
	}
	
	
}