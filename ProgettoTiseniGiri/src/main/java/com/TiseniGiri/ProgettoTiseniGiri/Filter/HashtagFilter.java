package com.TiseniGiri.ProgettoTiseniGiri.Filter;
import java.util.ArrayList;
import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Filter.Interfaces.*;
import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;

public class HashtagFilter implements Filter {

	@Override
	public List<Tweet> greater(List<Tweet> list, int num) {
		List<Tweet> list1 = new ArrayList<Tweet>(list);
		list1.removeIf(t-> t.getEntities().getHashtags().length <= num);
		return list1;
	}

	@Override
	public List<Tweet> lower(List<Tweet> list, int num) {
		List<Tweet> list1 = new ArrayList<Tweet>(list);
		list1.removeIf(t-> t.getEntities().getHashtags().length >= num);
		return list1;
	}

	@Override
	public List<Tweet> equal(List<Tweet> list, int num) {
		List<Tweet> list1 = new ArrayList<Tweet>(list);
		list1.removeIf(t-> t.getEntities().getHashtags().length != num);
		return list1;
	}

	@Override
	public List<Tweet> between(List<Tweet> list, int top, int bottom) {
		List<Tweet> list1 = new ArrayList<Tweet>(list);
		list1 = greater(list, bottom);
		list1 = lower(list1, top);
		return list1;
		
	}

}
