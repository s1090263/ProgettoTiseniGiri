
package com.TiseniGiri.ProgettoTiseniGiri.Model;

import java.util.TreeMap;

/**
 * Class who models and gives to user metadata
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 */
public class Metadata {

	/**
	 * array containing description and type of parameter id
	 */
	private static final String[] idList = new String[] { "Description: tweet's id", "type:long" };
	/**
	 * array containing description and type of parameter created_at
	 */
	private static final String[] created_atList = new String[] {
			"Description: the date in which the tweet was posted on the page", "type:String" };
	/**
	 * array containing description and type of parameter metadata
	 */
	private static final String[] metadataList = new String[] {
			"Description: map containing the two fields, iso_language_code, and result_type(recent,mixed or popular) ",
			"type:Map<String><String>" };
	/**
	 * array containing description and type of parameter user
	 */
	private static final String[] userList = new String[] {
			"Description: an object containing information about the user who posted a specific tweet", "type:Object" };
	/**
	 * array containing description and type of parameter retweet_count
	 */
	private static final String[] retweetList = new String[] { "Description: count of retweets of the current tweet",
			"type:Integer" };
	/**
	 * array containing description and type of parameter favorite_count
	 */
	private static final String[] favoriteList = new String[] { "Description: count of favorites of the current tweet",
			"type:Integer" };
	/**
	 * array containing description and type of parameter lang
	 */
	private static final String[] langList = new String[] { "Description: language of tweet text", "type:String" };
	/**
	 * array containing description and type of parameter entities
	 */
	private static final String[] entitiesList = new String[] {
			"Description: an object containing some features of tweets such as hashtags", "type:Object" };

	/**
	 * A map which contains all the metadata of the tweets
	 */
	private static TreeMap<String, String[]> metadata = new TreeMap<String, String[]>() {
		/**
		 * serial version ID of map
		 */
		private static final long serialVersionUID = 1L;

		{
			put("id", idList);
			put("created_at", created_atList);
			put("metadata", metadataList);
			put("user", userList);
			put("retweet_count", retweetList);
			put("favorite_count", favoriteList);
			put("lang", langList);
			put("entities", entitiesList);
		}
	};

	/**
	 * method used to get metadata
	 */
	public static TreeMap<String, String[]> getMetadata() {
		return metadata;
	}

}