package com.TiseniGiri.ProgettoTiseniGiri.Model;

import java.util.Arrays;

public class Hashtag {
	
	private String text; //testo dell'hashtag
	
	private int[] indices; //An array of integers indicating the offsets within the Tweet text where the hashtag begins and ends. The first integer represents the location of the # character in the Tweet text string. The second integer represents the location of the first character after the hashtag
	
	public Hashtag() {
	}
	
	public Hashtag(String text, int[] indices) {
		super();
		this.text = text;
		this.indices = indices;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int[] getIndices() {
		return indices;
	}

	public void setIndices(int[] indices) {
		this.indices = indices;
	}

	@Override
	public String toString() {
		return "Hashtag [text=" + text + ", indices=" + Arrays.toString(indices) + "]";
	}
	
}
