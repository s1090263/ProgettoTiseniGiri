package com.TiseniGiri.ProgettoTiseniGiri.filter.Interfaces;

import java.util.List;
import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;

public interface Filter {
	
	public List<Tweet> filter_general(List<Tweet> list);

}
