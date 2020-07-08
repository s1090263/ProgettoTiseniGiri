package com.TiseniGiri.ProgettoTiseniGiri.Filter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.TiseniGiri.ProgettoTiseniGiri.Exceptions.ExtremesException;
import com.TiseniGiri.ProgettoTiseniGiri.Exceptions.IncorrectDateFormatException;
import com.TiseniGiri.ProgettoTiseniGiri.Filter.InterfacesAndAbstractClasses.NumericalFilter;
import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;

/**
 * This Class filters list of tweets in according to a given date or time
 * 
 * @author Lorenzo Tiseni
 * @author Matteo Giri
 */
public class TimeFilter extends NumericalFilter {

	/**
	 * Date object representing the parsed date given in input by user
	 */
	private Date User_date;

	/**
	 * Date object representing the parsed date of the current tweet
	 */
	private Date Tweet_date;

	/**
	 * SimpleDate object used for parsing the String object representing the date
	 * given in input by user
	 */
	private final SimpleDateFormat Userformatter = new SimpleDateFormat("MMM dd HH:mm:ss yyyy", Locale.ENGLISH);

	/**
	 * SimpleDate object used for parsing the String object representing the current
	 * tweet's date
	 */
	private final SimpleDateFormat Twitterformatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZZZ yyyy",
			Locale.ENGLISH);

	/**
	 * @throws IncorrectDateFormatException {@inheritDoc}
	 */
	@Override
	public List<Tweet> greater(List<Tweet> list, Object stringDate) {
		User_date = new Date();
		Tweet_date = new Date();
		try {
			User_date = Userformatter.parse((String) stringDate);
		} catch (ParseException e) {
			throw new IncorrectDateFormatException("Date's format is incorrect");
		}
		List<Tweet> list1 = new ArrayList<Tweet>();
		for (Tweet t : list) {
			try {
				Tweet_date = Twitterformatter.parse(t.getCreated_at());
			} catch (ParseException e) {
				throw new ExtremesException("ciao");
			}
			if (User_date.before(Tweet_date))
				list1.add(t);
		}
		return list1;
	}

	/**
	 * @throws IncorrectDateFormatException {@inheritDoc}
	 */
	@Override
	public List<Tweet> lower(List<Tweet> list, Object stringDate) {
		User_date = new Date();
		Tweet_date = new Date();
		try {
			User_date = Userformatter.parse((String) stringDate);
		} catch (ParseException e) {
			throw new IncorrectDateFormatException("Date's format is incorrect");
		}
		List<Tweet> list1 = new ArrayList<Tweet>();
		for (Tweet t : list) {
			try {
				Tweet_date = Twitterformatter.parse(t.getCreated_at());
			} catch (ParseException e) {
				throw new ExtremesException("ciao");
			}
			if (User_date.after(Tweet_date))
				list1.add(t);
		}
		return list1;
	}

	/**
	 * @throws IncorrectDateFormatException {@inheritDoc}
	 */
	@Override
	public List<Tweet> equal(List<Tweet> list, Object stringDate) {
		User_date = new Date();
		Tweet_date = new Date();
		try {
			User_date = Userformatter.parse((String) stringDate);
		} catch (ParseException e) {
			throw new IncorrectDateFormatException("Date's format is incorrect");
		}
		List<Tweet> list1 = new ArrayList<Tweet>();
		for (Tweet t : list) {
			try {
				Tweet_date = Twitterformatter.parse(t.getCreated_at());
			} catch (ParseException e) {
				throw new ExtremesException("ciao");
			}
			if (User_date.equals(Tweet_date))
				list1.add(t);
		}
		return list1;
	}

}
