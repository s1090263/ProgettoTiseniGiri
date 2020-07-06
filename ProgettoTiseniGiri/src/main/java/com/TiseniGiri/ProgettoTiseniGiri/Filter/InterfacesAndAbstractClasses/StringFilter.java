package com.TiseniGiri.ProgettoTiseniGiri.Filter.InterfacesAndAbstractClasses;

import java.util.List;

import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;

public interface StringFilter {
	
	public List<Tweet> stringSearch(List<Tweet> list, Object word);

}
