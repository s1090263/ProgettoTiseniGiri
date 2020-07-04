package com.TiseniGiri.ProgettoTiseniGiri.Stats.Interfaces;

import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;

public interface Stat {
	public Double average(List<Tweet> list);
	public Integer frequency(List<Tweet> list, int num);
	public Double standardDeviation(List<Tweet> list);
	
}
