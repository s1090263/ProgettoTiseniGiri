package com.TiseniGiri.ProgettoTiseniGiri.Model;

import java.util.Arrays;

public class Entities {
	private Hashtag[] hashtags;

    public Entities() {}
 
	public Entities(Hashtag[] hashtags) {
		super();
		this.hashtags = hashtags;
	}

	/**
	 * @return the hashtags
	 */
	public Hashtag[] getHashtags() {
		return hashtags;
	}

	/**
	 * @param hashtags the hashtags to set
	 */
	public void setHashtags(Hashtag[] hashtags) {
		this.hashtags = hashtags;
	}

	@Override
	public String toString() {
		return "Entities [hashtags=" + Arrays.toString(hashtags) + "]";
	}
	
}
