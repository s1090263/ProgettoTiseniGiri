package com.TiseniGiri.ProgettoTiseniGiri.Filter;
import java.util.ArrayList;
import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Filter.Interfaces.*;
import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;

public class HashtagFilter implements NumericalFilter,StringFilter {

	@Override
	public List<Tweet> greater(List<Tweet> list, Object num) {
		List<Tweet> list1 = new ArrayList<Tweet>(list);
		list1.removeIf(t-> t.getEntities().getHashtags().length <= (int)num);
		return list1;
	}

	@Override
	public List<Tweet> lower(List<Tweet> list, Object num) {
		List<Tweet> list1 = new ArrayList<Tweet>(list);
		list1.removeIf(t-> t.getEntities().getHashtags().length >= (int)num);
		return list1;
	}

	@Override
	public List<Tweet> equal(List<Tweet> list, Object num) {
		List<Tweet> list1 = new ArrayList<Tweet>(list);
		list1.removeIf(t-> t.getEntities().getHashtags().length != (int)num);
		return list1;
	}

	@Override
	public List<Tweet> between(List<Tweet> list, Object top, Object bottom) {
		List<Tweet> list1 = new ArrayList<Tweet>(list);
		list1 = greater(list, bottom);
		list1 = lower(list1, top);
		return list1;
		
	}

	@Override
	public List<Tweet> stringSearch(List<Tweet> list, Object word) {
		List<Tweet> list1 = new ArrayList<Tweet>();	
		for(Tweet t: list) {
			boolean flag = false;
			for(int i = 0; i < t.getEntities().getHashtags().length; i++) {
			if(String.valueOf(word).equals(t.getEntities().getHashtags()[i].getText()))	
				flag = true;
			}
			if(flag) list1.add(t);
		}
		return list1;
	}

}
