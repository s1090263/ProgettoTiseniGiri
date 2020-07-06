package com.TiseniGiri.ProgettoTiseniGiri.Services;

import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;
import com.TiseniGiri.ProgettoTiseniGiri.Utility.Downloader;
import com.TiseniGiri.ProgettoTiseniGiri.Utility.Parser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class GeneralService {
	
	public static List<Tweet> getTweets(String url) throws JsonMappingException, JsonProcessingException{
		String data = Downloader.downloadData(url);
		List<Tweet> tweets = Parser.dataParser(data);
		return tweets;
	}
}
