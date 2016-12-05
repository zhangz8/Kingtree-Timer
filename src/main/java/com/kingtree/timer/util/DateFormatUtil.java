package com.kingtree.timer.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

public class DateFormatUtil extends DateFormatUtils {
	public static Date toDate(String strDate, String pattern) {
		SimpleDateFormat f = new SimpleDateFormat(pattern);
		Date validdate = null;
		try {
			validdate = f.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return validdate;
	}

	public static String toStr(Date date, String pattern) {
		SimpleDateFormat f = new SimpleDateFormat(pattern);
		String valiString = "";
		valiString = f.format(date);
		return valiString;
	}

	public static Date parseDate(Date date, String formatStr) {
		DateFormat df = new SimpleDateFormat(formatStr);
		Date result = null;
		try {
			result = df.parse(df.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String DateDiff(Date date1, Date date2) {
		StringBuffer buf = new StringBuffer();
		long c = date1.getTime();
		long e = date2.getTime();

		long tnum = Math.abs(e - c);
		if (tnum > 86400000L) {
			long d = tnum / 86400000L;
			buf.append(d).append("天");
			tnum -= 86400000L * d;
		}
		if (tnum > 3600000L) {
			long h = tnum / 3600000L;
			buf.append(h).append("小时");
			tnum -= 3600000L * h;
		}
		if (tnum > 60000L) {
			long m = tnum / 60000L;
			buf.append(m).append("分钟");
		}

		return buf.toString();
	}

	public static String[] stripdate(Date date) {
		String datestring = toStr(date, "yyyy-MM-dd");
		return StringUtils.split(datestring, "-", 0);
	}

	public static Timestamp date2timstamp(Date date, String formatStr) {
		String ls = toStr(date, formatStr);

		Timestamp tmp = (Timestamp) toDate(ls, formatStr);

		return tmp;
	}

	public static String getYearMonth() {
		Date dateNow = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
		String dateNowStr = dateFormat.format(dateNow);
		dateNowStr = dateNowStr.substring(2);
		return dateNowStr;
	}

	public static String getYearMonthDate() {
		Date dateNow = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String dateNowStr = dateFormat.format(dateNow);

		return dateNowStr;
	}

	public static Calendar toCalender(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	public static boolean isDiff(String date, int datenum) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Calendar c = Calendar.getInstance();
		c.add(5, -datenum);
		String before = sdf.format(c.getTime());
		Date beforedate = toDate(before, "yyyy-MM-dd hh:mm");
		try {
			Date _date = toDate(date, "yyyy-MM-dd hh:mm");
			if (beforedate.after(_date))
				return true;
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public static int nDaysBetweenTwoDate(Date firstDate, Date secondDate) {
		int nDay = (int) ((secondDate.getTime() - firstDate.getTime()) / 86400000L);
		return nDay;
	}

	public static int nDaysBetweenTwoDate(String firstString, String secondString) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date firstDate = null;
		Date secondDate = null;
		try {
			firstDate = df.parse(firstString);
			secondDate = df.parse(secondString);
		} catch (Exception e) {
		}
		int nDay = 0;
		if ((null != firstDate) && (null != secondDate)) {
			nDay = (int) ((secondDate.getTime() - firstDate.getTime()) / 86400000L);
		}
		return nDay;
	}

	public static String StringPattern(String date, String newPattern) {
		if ((date == null) || (newPattern == null))
			return "";
		SimpleDateFormat sdf2 = new SimpleDateFormat(newPattern);
		Date d = null;
		try {
			d = sdf2.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sdf2.format(d);
	}

	public static void main(String[] args) {
		System.out.println(format(new Date(), "yyyy-MM-dd HH:mm:ss"));

		System.out.println(toDate("2010-03-02 13:32:25", "yyyy-MM-dd"));

		System.out.println(isDiff("2010-12-05 13:32:25", 1));
		System.out.println("===============");
		System.out.println(parseDate(new Date(), "yyyy-MM-dd"));
	}

	public static String getSpecifiedDayBefore(String specifiedDay) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (null != date)
			c.setTime(date);
		int day = c.get(5);
		c.set(5, day - 1);

		String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());

		return dayBefore;
	}

	public static String getSpecifiedDayAfter(String specifiedDay) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (null != date)
			c.setTime(date);
		int day = c.get(5);
		c.set(5, day + 1);

		String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());

		return dayAfter;
	}
}