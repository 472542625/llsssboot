package com.lc.web.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class ThisPassWordSHA {

	public static final String SHA_KEY="SHA";
	 
	
	/**
	 * 
	 * @param password加密前
	 * @return bigInteger加密后
	 * @throws NoSuchAlgorithmException
	 */
	 
	public static  String getSHA(String password) throws NoSuchAlgorithmException {
		
		 byte[] bytes = password.getBytes();
		 MessageDigest instance = MessageDigest.getInstance(SHA_KEY);
		 instance.update(bytes);
	 
		 BigInteger bigInteger = new BigInteger( instance.digest());
		 
//		 System.out.println("加密前："+password);
//		 System.out.println("加密后："+bigInteger);
		 
		return bigInteger.toString(32);
	}
	/**
	 * 
	 * @param password 加密后的密码
	 * @return 加密后的密码的格式化
	 * @throws NoSuchAlgorithmException
	 */
	public  static String getFormatSHA(String password) throws NoSuchAlgorithmException {
		
		String sha = getSHA(password);
		byte[] bytes = sha.getBytes();
		char [] c= new char[bytes.length];
		for (int i = sha.length(),j=0; i -->0;) {
			c[j++]=sha.charAt(i);
		}
		return "^<"+String.valueOf(c)+">_";
	}
	
}
