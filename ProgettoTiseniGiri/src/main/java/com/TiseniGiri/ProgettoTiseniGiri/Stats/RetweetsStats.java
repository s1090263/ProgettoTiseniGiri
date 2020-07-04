package com.TiseniGiri.ProgettoTiseniGiri.Stats;

import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;
import com.TiseniGiri.ProgettoTiseniGiri.Stats.Interfaces.Stat;

public class RetweetsStats implements Stat {

	@Override
	public Double average(List<Tweet> list) {
		Double sum = 0.0;
		for(Tweet t: list) {
			sum += t.getRetweet_count();
		}
		return (sum/(double)list.size());
	}

	@Override
	public Integer frequency(List<Tweet> list, int num) {
		int count = 0;
		for(Tweet t: list) {
			if (t.getRetweet_count() == num);
			count++;
		}
		return count;
	}

	@Override
	public Double standardDeviation(List<Tweet> list) {
		Double avg = average(list);
		Double sum = 0.0;
		for(Tweet t: list) {
			sum = Math.pow((t.getRetweet_count()-avg), 2.0);
		}
		return Math.sqrt(sum/list.size());
	}

}
