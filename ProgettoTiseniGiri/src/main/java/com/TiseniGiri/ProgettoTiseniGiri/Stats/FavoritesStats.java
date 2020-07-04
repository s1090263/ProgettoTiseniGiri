package com.TiseniGiri.ProgettoTiseniGiri.Stats;

import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;
import com.TiseniGiri.ProgettoTiseniGiri.Stats.Interfaces.Stat;
import java.lang.Math;
public class FavoritesStats implements Stat {

	@Override
	public Double average(List<Tweet> list) {
		Double sum = 0.0;
		for(Tweet t: list) {
			sum += t.getFavorite_count();
		}
		return (sum/(double)list.size());
	}

	@Override
	public Double frequency(List<Tweet> list, Object num) {
		int count = 0;
		for(Tweet t: list) {
			if (t.getFavorite_count() == (int)num)
			count++;
		}
		return (double)count;
	}

	@Override
	public Double standardDeviation(List<Tweet> list) {
		Double avg = average(list);
		Double sum = 0.0;
		for(Tweet t: list) {
			sum = Math.pow((t.getFavorite_count()-avg), 2.0);
		}
		return Math.sqrt(sum/list.size());
	}

}
