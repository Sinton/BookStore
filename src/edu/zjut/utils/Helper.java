package edu.zjut.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {
	
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
	public String TransDate(long timeStamp) {
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = timeFormat.format(new Date(timeStamp * 1000));
		return time;
	}
}