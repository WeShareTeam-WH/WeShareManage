package com.weshare.manage.utils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilsHelper {
	private static final String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static int getRandNum(int min, int max) {
		int randNum = min + (int) (Math.random() * ((max - min) + 1));
		return randNum;
	}
	
	/**
	 * 获取任意位的随机字符串(0-9 a-z A-Z)
	 * 
	 * @param size
	 *            位数
	 * @return
	 */
	public static final String getRandomNum(int size) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			sb.append(ALLCHAR.charAt(random.nextInt(ALLCHAR.length())));
		}
		return sb.toString();
	}

	public static boolean isEmail(String email) {
		Pattern emailPattern = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
		Matcher matcher = emailPattern.matcher(email);
		if (matcher.find()) {
			return true;
		}
		return false;
	}

	public static boolean isUserNameRight(String userName) {
		String reg = "^\\w{2,16}$";
		return userName.matches(reg);
	}

}
