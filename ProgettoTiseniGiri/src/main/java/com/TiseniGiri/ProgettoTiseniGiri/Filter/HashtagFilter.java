package com.TiseniGiri.ProgettoTiseniGiri.Filter;

import java.util.ArrayList;
import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Filter.Interfaces.Filter;
import com.TiseniGiri.ProgettoTiseniGiri.Model.Hashtag;
import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;

public class HashtagFilter implements Filter<Hashtag> {
	private String identifier;
	
	@Override
	public List<Tweet> generalFilter(List<Tweet> list, Integer num_of) {
		// TODO Auto-generated method stub
		List<Tweet> list1 = new ArrayList<Tweet>(list);
		list1.removeIf(t-> t.getEntities().getHashtags().length < num_of);
		return list1;
	}

}
