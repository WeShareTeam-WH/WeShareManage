package com.weshare.manage.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.logging.log4j.*;
import org.apache.tomcat.util.codec.binary.Base64;

public class EncryptUtils {

	private static Logger logger = LogManager.getLogger(EncryptUtils.class);

	public static String saltHashSHA256(String password, String salt) {
		return Encrypt(password + salt, "SHA-256");
	}

	/**
	 * 哈希加密
	 * 
	 * @param strSrc
	 *            需要加密的字符串
	 * @param encName
	 *            需要采用的加密方式，如：SHA-1,SHA-256,SHA-256等等
	 * @return
	 */
	public static String Encrypt(String strSrc, String encName) {
		MessageDigest md = null;
		String strDes = null;
		byte[] bt = strSrc.getBytes();
		try {
			md = MessageDigest.getInstance(encName);
			md.update(bt);
			strDes = bytes2Hex(md.digest()); // to HexString
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage());
			return null;
		}
		return strDes;
	}

	public static String bytes2Hex(byte[] bts) {
		String des = "";
		String tmp = null;
		for (int i = 0; i < bts.length; i++) {
			tmp = (Integer.toHexString(bts[i] & 0xFF));
			if (tmp.length() == 1) {
				des += "0";
			}
			des += tmp;
		}
		return des;
	}

	/**
	 * 将二进制数据编码为BASE64字符串
	 * 
	 * @param binaryData
	 * @return
	 */
	public static String encode(byte[] binaryData) {
		try {
			return new String(Base64.encodeBase64(binaryData), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	/**
	 * 将BASE64字符串恢复为二进制数据
	 * 
	 * @param base64String
	 * @return
	 */
	public static byte[] decode(String base64String) {
		try {
			return Base64.decodeBase64(base64String.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	/**
	 * MD5加密
	 * 
	 * @param message
	 *            要进行MD5加密的字符串
	 * @return 加密结果为32位字符串
	 */
	public static String getMD5(String message) {
		MessageDigest messageDigest = null;
		StringBuffer md5StrBuff = new StringBuffer();
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(message.getBytes("UTF-8"));

			byte[] byteArray = messageDigest.digest();
			for (int i = 0; i < byteArray.length; i++) {
				if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
					md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
				else
					md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return md5StrBuff.toString().toUpperCase();// 字母大写
	}

	/**
	 * md5加密(ITS)
	 * 
	 * @param str
	 * @param charSet
	 * @return
	 */
	public synchronized static final String getMD5Str(String str, String charSet) { // md5加密
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			if (charSet == null) {
				messageDigest.update(str.getBytes());
			} else {
				messageDigest.update(str.getBytes(charSet));
			}
		} catch (NoSuchAlgorithmException e) {
			logger.error("md5 error:"+e.getMessage(),e);
		} catch (UnsupportedEncodingException e) {
			logger.error("md5 error:"+e.getMessage(),e);
		}

		byte[] byteArray = messageDigest.digest();
		StringBuffer md5StrBuff = new StringBuffer();
		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		return md5StrBuff.toString();
	}
}
