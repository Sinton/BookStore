package edu.zjut.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
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
	 * @param specificLevel
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
	
	/** 
     * 日期格式字符串转换成时间戳 
     * @param date
     * @param specificLevel 
     * @return 
     */  
    public String dateToTimeStamp(String date,int specificLevel){  
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
		try {
			return String.valueOf(timeFormat.parse(date).getTime() / 1000);
		} catch (ParseException exception) {
			exception.printStackTrace();
		}
		return null;
    }

	/**
	 * 将字符串进行Hash加密
	 * @param source 需要加密的字符串
	 * @param hashType 加密类型（MD5 和 SHA）
	 * @return
	 */
	public String getHash(String source, String hashType) {
		// 用来将字节转换成 16 进制表示的字符
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest md = MessageDigest.getInstance(hashType);
			// 通过使用 update 方法处理数据,使指定的 byte数组更新摘要
			md.update(source.getBytes());
			// 获得密文完成哈希计算,产生128 位的长整数
			byte[] encryptStr = md.digest();
			// 每个字节用 16 进制表示的话，使用两个字符
			char str[] = new char[16 * 2];
			// 表示转换结果中对应的字符位置
			int k = 0;
			// 从第一个字节开始，对每一个字节,转换成 16 进制字符的转换
			for (int i = 0; i < 16; i++) {
				// 取第 i 个字节
				byte byte0 = encryptStr[i];
				// 取字节中高 4 位的数字转换, >>>
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				// 取字节中低 4 位的数字转换
				str[k++] = hexDigits[byte0 & 0xf];
			}
			// 换后的结果转换为字符串
			return new String(str);
		} catch (NoSuchAlgorithmException exception) {
			exception.printStackTrace();
		}
		return null;
	}
}