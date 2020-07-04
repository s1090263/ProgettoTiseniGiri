package com.TiseniGiri.ProgettoTiseniGiri.Stats;

import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;
import com.TiseniGiri.ProgettoTiseniGiri.Stats.Interfaces.Stat;

public class HashtagStats implements Stat {

	@Override
	public Double average(List<Tweet> list) {
		Double sum = 0.0;
		for(Tweet t: list) {
			sum += t.getEntities().getHashtags().length;
		}
		return (sum/(double)list.size());
	}

	@Override
	public Integer frequency(List<Tweet> list, int num) {
		int count = 0;
		for(Tweet t: list) {
			if (t.getEntities().getHashtags().length == num);
			count++;
		}
		return count;
	}

	@Override
	public Double standardDeviation(List<Tweet> list) {
		Double avg = average(list);
		Double sum = 0.0;
		for(Tweet t: list) {
			sum = Math.pow((t.getEntities().getHashtags().length-avg), 2.0);
		}
		return Math.sqrt(sum/list.size());
	}

}
