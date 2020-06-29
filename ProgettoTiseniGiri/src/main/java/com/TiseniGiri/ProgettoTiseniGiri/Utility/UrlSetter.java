package com.TiseniGiri.ProgettoTiseniGiri.Utility;

public class UrlSetter {
	private static String url = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q=univpm&count=100" ;

	//getter con topic e numero, restituisce il numero di tweets richiesto
	public String getUrl(String topic, int num) {
		url = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q=" + topic + "&count=" + num;
		return url;
	}
	
}

