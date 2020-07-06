package com.TiseniGiri.ProgettoTiseniGiri.Filter.InterfacesAndAbstractClasses;

import java.util.ArrayList;
import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Exceptions.ExtremesException;
import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;

public abstract class NumericalFilter{
	
	public abstract List<Tweet> greater(List<Tweet> list, Object par);
	public abstract List<Tweet> lower(List<Tweet> list,	Object par);
	public abstract List<Tweet> equal(List<Tweet> list,	Object par);
	public List<Tweet> between(List<Tweet> list, Object top, Object bottom){
		if ((int)top <= (int)bottom)
			throw new ExtremesException("The top value must be higher that the bottom value");
		List<Tweet> list1 = new ArrayList<Tweet>(list);
		list1 = greater(list, bottom);
		list1 = lower(list1, top);
		return list1;
	}
}
