package com.TiseniGiri.ProgettoTiseniGiri.Filter.Interfaces;

import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;

public interface ParticularFilter<Type1,Type2> extends Filter {
	
	public List<Tweet> stringFilter(List<Tweet> list, Type1 variable);
	
	public List<Tweet> stringFilter(List<Tweet> list, Type1 variable1, Type2 variable2);

}
