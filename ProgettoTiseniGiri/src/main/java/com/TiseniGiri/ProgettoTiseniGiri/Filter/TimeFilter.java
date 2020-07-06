package com.TiseniGiri.ProgettoTiseniGiri.Filter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.TiseniGiri.ProgettoTiseniGiri.Exceptions.ExtremesException;
import com.TiseniGiri.ProgettoTiseniGiri.Exceptions.IncorrectFormatDateException;
import com.TiseniGiri.ProgettoTiseniGiri.Filter.Interfaces.NumericalFilter;
import com.TiseniGiri.ProgettoTiseniGiri.Model.Tweet;

public class TimeFilter extends NumericalFilter {

	@Override
	public List<Tweet> greater(List<Tweet> list, Object num){
		Date date = new Date();
		Date date1 = new Date();;
		SimpleDateFormat Userformatter = new SimpleDateFormat("MMM dd HH:mm:ss yyyy", Locale.ENGLISH);
		SimpleDateFormat Twitterformatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZZZ yyyy", Locale.ENGLISH);
		try {
			date = Userformatter.parse((String) num);
		} catch (ParseException e) {
			throw new IncorrectFormatDateException("Date's format is incorrect");
		}
		List<Tweet> list1 = new ArrayList<Tweet>();
		for(Tweet t: list) {
			try {
				date1 = Twitterformatter.parse(t.getCreated_at());
			} catch (ParseException e) {
				throw new ExtremesException("ciao");
			}
			if(date.before(date1))
				list1.add(t);
		}
		return list1;
	}

	@Override
	public List<Tweet> lower(List<Tweet> list, Object num){
		Date date = new Date();
		Date date1 = new Date();;
		SimpleDateFormat Userformatter = new SimpleDateFormat("MMM dd HH:mm:ss yyyy", Locale.ENGLISH);
		SimpleDateFormat Twitterformatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZZZ yyyy", Locale.ENGLISH);
		try {
			date = Userformatter.parse((String) num);
		} catch (ParseException e) {
			throw new IncorrectFormatDateException("Date's format is incorrect");
		}
		List<Tweet> list1 = new ArrayList<Tweet>();
		for(Tweet t: list) {
			try {
				date1 = Twitterformatter.parse(t.getCreated_at());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if(date.after(date1))
				list1.add(t);
		}
		return list1;
	}

	@Override
	public List<Tweet> equal(List<Tweet> list, Object num){
		Date date = new Date();
		Date date1 = new Date();;
		SimpleDateFormat Userformatter = new SimpleDateFormat("MMM dd HH:mm:ss yyyy", Locale.ENGLISH);
		SimpleDateFormat Twitterformatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZZZ yyyy", Locale.ENGLISH);
		try {
			date = Userformatter.parse((String) num);
		} catch (ParseException e1) {
			throw new IncorrectFormatDateException("Date's format is incorrect");
		}
		List<Tweet> list1 = new ArrayList<Tweet>();
		for(Tweet t: list) {
			try {
				date1 = Twitterformatter.parse(t.getCreated_at());
			} catch (ParseException e) {
				throw new IncorrectFormatDateException("Date's format is incorrect");
			}
			if(date.equals(date1))
			list1.add(t);
		}
		return list1;
	}

}
