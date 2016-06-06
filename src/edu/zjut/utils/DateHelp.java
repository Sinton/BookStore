package edu.zjut.utils;

import java.util.Date;

public class DateHelp {
	
	/**
	 * 获取当前时间戳
	 * @return
	 */
	public long getCurrentTime() {
		long currentTime = new Date().getTime();
		return currentTime / 1000;
	}
}