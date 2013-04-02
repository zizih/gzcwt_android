package com.common.utils.date;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 日期类
 *
 * @author feijinbo
 * @createTime 2011-10-24 下午05:23:01
 * @desc
 */
public class DateUtil {

	/**
	 * 构造函数
	 */
	private DateUtil() {
	}

	/**
	 * 返回当前时间长整型
	 *
	 * @return
	 */
	public static long getLongTime() {
		return System.currentTimeMillis();
	}

	public static void main(String args[]){
		System.out.println( getLongTime());
		System.out.println( getLocalDate());
	}
	/**
	 * 返回当前时间字符型
	 *
	 * @return
	 */
	public static String getLongDate() {
		long d = System.currentTimeMillis();
		return String.valueOf(d);
	}

	/**
	 * 格式化日期,格式化后可直接insert into [DB]
	 *
	 * @return
	 *
	 */
    public static String formatMillis(long mss) {
        long days = mss / (1000 * 60 * 60 * 24);
        long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (mss % (1000 * 60)) / 1000;
        long millis = mss % 1000;
        StringBuilder sb = new StringBuilder();
        if (days != 0) sb.append((0 <= days && days < 10) ? "0" + days + "d" : days + "d");
        if (hours != 0) sb.append((0 <= hours && hours < 10) ? "0" + hours + ":" : hours + ":");
        sb.append((0 <= minutes && minutes < 10) ? "0" + minutes + ":" : minutes + ":");
        sb.append((0 <= seconds && seconds < 10) ? "0" + seconds + ":" : seconds + ":");
        String millisStr = "000'";
        if (millis < 10) millisStr = "00" + millis + "''";
        else if (10 <= millis && millis < 100) millisStr = "0" + millis + "''";
        else if (100 <= millis && millis < 1000) millisStr = millis + "''";
        else millisStr = "000''";
        sb.append(millisStr);
        return sb.toString();
    }

	public static String dateToStr(Date date) {

		if (date == null)
			return "";
		else {
			SimpleDateFormat sdFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm", Locale.getDefault());
			String str_Date = sdFormat.format(date);
			return str_Date;
		}
	}

	public static String dateToStr(Date date, String format) {

		if (date == null)
			return "";
		else {
			SimpleDateFormat sdFormat = new SimpleDateFormat(format,
					Locale.getDefault());
			String str_Date = sdFormat.format(date);
			return str_Date;
		}
	}

	/**
	 * 格式化
	 *
	 * @param dt_in
	 * @param format
	 * @return
	 */
	public static String DoFormatDate(java.util.Date dt_in, String format) {
		return (new SimpleDateFormat(format)).format(dt_in);
	}

	/**
	 * 反向格式化日期
	 *
	 * @return
	 *
	 */
	public static Date strToDate(String str, String format) {
		if (str == null)
			return null;
		// DateFormat defaultDate = DateFormat.getDateInstance();
		// 细化日期的格式
		java.text.SimpleDateFormat defaultDate = new java.text.SimpleDateFormat(
				format);

		Date date = null;
		try {
			date = defaultDate.parse(str);
		} catch (ParseException pe) {
		}
		return date;
	}

	public static Date strToDate(String str) {
		if (str == null)
			return null;
		// 细化日期的格式
		java.text.SimpleDateFormat defaultDate = new java.text.SimpleDateFormat(
				"yyyy-MM-dd HH:mm");
		Date date = null;
		try {
			date = defaultDate.parse(str);
		} catch (ParseException pe) {
		}
		return date;
	}

	/**
	 * 日期计算
	 *
	 * @param date
	 *            起始日期
	 * @param yearNum
	 *            年增减数
	 * @param monthNum
	 *            月增减数
	 * @param dateNum
	 *            日增减数
	 */
	public static String calDate(String date, int yearNum, int monthNum,
			int dateNum) {
		String result = "";
		try {
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(sd.parse(date));
			cal.add(Calendar.MONTH, monthNum);
			cal.add(Calendar.YEAR, yearNum);
			cal.add(Calendar.DATE, dateNum);
			result = sd.format(cal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static Date calDate(Date date, int yearNum, int monthNum, int dateNum) {
		Date result = null;
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.MONTH, monthNum);
			cal.add(Calendar.YEAR, yearNum);
			cal.add(Calendar.DATE, dateNum);
			result = cal.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 返回当前时间，格式'yyyy-mm-dd HH:mm:ss' 可为插入当前时间
	 *
	 * @return
	 */
	public static String getLocalDate() {
		java.util.Date dt = new java.util.Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		df.setTimeZone(TimeZone.getDefault());
		return df.format(dt);
	}

	public static String getLocalDate(String f) {
		java.util.Date dt = new java.util.Date();
		SimpleDateFormat df = new SimpleDateFormat(f);
		df.setTimeZone(TimeZone.getDefault());
		return df.format(dt);
	}

	/**
	 * 将日期格式化为指定格式的字符串
	 *
	 * @return
	 */
	public static String FormatDate(Date dt, String format) {

		SimpleDateFormat df = new SimpleDateFormat(format);
		df.setTimeZone(TimeZone.getDefault());
		return df.format(dt);
	}

	/**
	 * 返回当前时间，格式'yyyyMMddHHmmss' 可为插入当前时间
	 *
	 * @return
	 */
	public static String getSimpleDate() {
		//
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		Date dt = new Date();
		return df.format(dt);
	}

	/**
	 * 返回当前时间，格式'f' 可为插入当前时间
	 *
	 * @return
	 */
	public static String getFormatDate(String f) {
		//
		SimpleDateFormat df = new SimpleDateFormat(f);
		Date dt = new Date();
		return df.format(dt);
	}

	public static String getFormatDate(String f, Date dt) {
		//
		SimpleDateFormat df = new SimpleDateFormat(f);
		return df.format(dt);

	}

	/**
	 * 格式化日期为“2004年9月13日”
	 *
	 * @param orlTime
	 * @return
	 */
	public static String parseCnDate(String orlTime) {
		if (orlTime == null || orlTime.length() <= 0) {
			return "";
		}

		if (orlTime.length() < 10) {
			return "";
		}
		String sYear = orlTime.substring(0, 4);
		String sMonth = delFrontZero(orlTime.substring(5, 7));
		String sDay = delFrontZero(orlTime.substring(8, 10));
		return sYear + "年" + sMonth + "月" + sDay + "日";
	}

	/**
	 * 格式化日期为"9.13"
	 *
	 * @param orlTime
	 * @return
	 */
	public static String parsePointDate(String orlTime) {
		if (orlTime == null || orlTime.length() <= 0) {
			return "";
		}
		String sMonth = delFrontZero(orlTime.substring(5, 7));
		String sDay = delFrontZero(orlTime.substring(8, 10));
		return sMonth + "." + sDay;
	}

	/**
	 * 取整函数
	 *
	 * @param mord
	 * @return
	 */
	public static String delFrontZero(String mord) {
		int im = -1;
		try {
			im = Integer.parseInt(mord);
			return String.valueOf(im);
		} catch (Exception e) {
			return mord;
		}
	}

	/**
	 * 将毫秒时间转化成yyyyMMddhhmmss格式
	 *
	 * @param stamp
	 * @return
	 */
	private static String DateStyle = "yyyy-MM-dd HH:mm:ss";

	public static String stampToDateStr(long stamp) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DateStyle);
			return sdf.format(stamp);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 处理时间
	 *
	 * @param timestamp
	 * @return
	 */
	public static String fixTime(String timestamp) {
		if (timestamp == null || "".equals(timestamp)) {
			return "";
		}
		try {
			long _timestamp = Long.parseLong(timestamp) * 1000;
			if (System.currentTimeMillis() - _timestamp < 1 * 60 * 1000) {
				return "刚刚";
			} else if (System.currentTimeMillis() - _timestamp < 30 * 60 * 1000) {
				return ((System.currentTimeMillis() - _timestamp) / 1000 / 60)
						+ "分钟前";
			} else {
				Calendar now = Calendar.getInstance();
				Calendar c = Calendar.getInstance();
				c.setTimeInMillis(_timestamp);
				if (c.get(Calendar.YEAR) == now.get(Calendar.YEAR)
						&& c.get(Calendar.MONTH) == now.get(Calendar.MONTH)
						&& c.get(Calendar.DATE) == now.get(Calendar.DATE)) {
					SimpleDateFormat sdf = new SimpleDateFormat("今天 HH:mm");
					return sdf.format(c.getTime());
				}
				if (c.get(Calendar.YEAR) == now.get(Calendar.YEAR)
						&& c.get(Calendar.MONTH) == now.get(Calendar.MONTH)
						&& c.get(Calendar.DATE) == now.get(Calendar.DATE) - 1) {
					SimpleDateFormat sdf = new SimpleDateFormat("昨天 HH:mm");
					return sdf.format(c.getTime());
				} else if (c.get(Calendar.YEAR) == now.get(Calendar.YEAR)) {
					SimpleDateFormat sdf = new SimpleDateFormat("M月d日 HH:mm:ss");
					return sdf.format(c.getTime());
				} else {
					SimpleDateFormat sdf = new SimpleDateFormat(
							"yyyy年M月d日 HH:mm:ss");
					return sdf.format(c.getTime());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public static Timestamp getTimestamp() {
		try {
			Timestamp stamp = new Timestamp(new Date().getTime());
			return stamp;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public static Timestamp getTimestamp(Date date) throws Exception {
		Timestamp stamp = new Timestamp(date.getTime());
		return stamp;
	}
}
