package com.TiseniGiri.ProgettoTiseniGiri.Stats.Interfaces;

import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;

public interface Stat {
	public Double average(List<Tweet> list);
	public Double frequency(List<Tweet> list, Object num);
	public Double standardDeviation(List<Tweet> list);
	
}
