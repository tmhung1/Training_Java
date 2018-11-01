package com.javasampleapproach.cassandra.utils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class DateTimeUtil {
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String DATE_TIME_WITHOUT_ZONE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";
	public static final DateTimeZone TIME_ZONE = DateTimeZone.forID("UTC");

	public static DateTime getCurrent() {
		return DateTime.now().withZone(TIME_ZONE);
	}

	public static int getMonth(DateTime dateTime) {
		dateTime.withZone(TIME_ZONE);
		return dateTime.getMonthOfYear();
	}

	public static int getQuarter(DateTime dateTime) {
		dateTime.withZone(TIME_ZONE);
		return (dateTime.getMonthOfYear() / 3) + 1;
	}

	public static int getYear(DateTime dateTime) {
		dateTime.withZone(TIME_ZONE);
		return dateTime.getYear();
	}

	/*public static void main(String[] args) {
		DateTime d = DateTime.now();
		System.out.println(d + "with zone is " + d.getZone());
		
		
		DateTime dt2 = d.withZone(DateTimeZone.UTC);
		System.out.println(dt2);
	}*/
	
}
