package com.TiseniGiri.ProgettoTiseniGiri;

public class UrlSetter {
	public String url;

	//getter senza parametri restituisce il link con i parametri richiesti dalla consegna: 100 tweets su univpm
	public String getUrl() {
		url = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q=univpm&count=100";
		return url;
	}
	
	//getter con topic, al posto di restituire tweets su univpm restituisce 100 tweets del topic richiesto
	public String getUrl(String topic) {
		url = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q=" + topic + "&count=100";
		return url;
	}
	
	//getter con topic e numero, restituisce il numero di tweets richiesto
	public String getUrl(String topic, int num) {
		url = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q=" + topic + "&count=" + num;
		return url;
	}
	
}
