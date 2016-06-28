package org.yoking.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	private static final String SHORT_DATE_FMT = "yyyy-MM-dd";
	private static final SimpleDateFormat sdf = new SimpleDateFormat();
	
	/**
	 * Convert string to date.
	 *
	 * @param pattern the pattern
	 * @param str the string
	 * @return the date
	 */
	public static Date convert(String pattern, String str) {
		if(pattern == null || pattern.length() == 0) {
			throw new IllegalArgumentException("Date format pattern is illegal.");
		}
		
		if(str == null || str.length() == 0) {
			throw new IllegalArgumentException("To be parsed date string is illegal.");
		}
		
		sdf.applyPattern(pattern);
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			throw new RuntimeException("Parsing date exception.");
		}
	}
	
	/**
	 * Convert string to date.
	 *
	 * @param str the string
	 * @return the date
	 */
	public static Date convert(String str) {
		return convert(SHORT_DATE_FMT, str);
	}
	
	/**
	 * Format date to string.
	 *
	 * @param pattern the pattern
	 * @param date the date
	 * @return the string
	 */
	public static String format(String pattern, Date date) {
		if(pattern == null || pattern.length() == 0) {
			throw new IllegalArgumentException("Date format pattern is illegal.");
		}
		
		if(date == null) {
			throw new IllegalArgumentException("To be formatted date is illegal.");
		}
		
		sdf.applyPattern(pattern);
		return sdf.format(date);
	}
	
	/**
	 * Format date to string.
	 *
	 * @param date the date
	 * @return the string
	 */
	public static String format(Date date) {
		return format(SHORT_DATE_FMT, date);
	}
}