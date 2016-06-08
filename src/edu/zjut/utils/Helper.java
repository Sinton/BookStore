package edu.zjut.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {
	
	public static final int TIME_SPECIFIC_HEIGH = 1;
	public static final int TIME_SPECIFIC_MID = 2;
	public static final int TIME_SPECIFIC_LOW = 3;
	
	/**
	 * 获取当前时间戳
	 * @return
	 */
	public long getCurrentTimeStamp() {
		long currentTime = new Date().getTime();
		return currentTime / 1000;
	}
	
	/**
	 * 将时间戳转化成具体时间
	 * @param timeStamp
	 * @return
	 */
	public String timeStampToDate(long timeStamp, int specificLevel) {
		SimpleDateFormat timeFormat = null;
		switch (specificLevel) {
		case 1:
			timeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			break;
		case 2:
			timeFormat = new SimpleDateFormat("yyyy-MM-dd");
			break;
		case 3:
			timeFormat = new SimpleDateFormat("yyyy-MM");
			break;
		default:
			break;
		}
		String time = timeFormat.format(new Date(timeStamp * 1000));
		return time;
	}
}