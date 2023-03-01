package com.Intuit.socialNewsFeed.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Helper {

	public static Date parseDateTime(String dateString) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
		new Date();
		try {
			return fmt.parse(dateString);
		} catch (ParseException e) {
			// Log.e(Const.TAG, "Could not parse datetime: " + dateString);
			return null;
		}
	}

	public static Date getDateMinusDays() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -7);
		Date newDate = cal.getTime();
		String fromdate = dateFormat.format(newDate);
		return parseDateTime(fromdate);
	}
}
