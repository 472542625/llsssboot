package com.lc.web.util;

import java.util.UUID;

public class ThisUUID {

	/**
	 * uid随机生成
	 * @return
	 * @throws Exception
	 */
	public static String getUUID() throws Exception {

		return UUID.randomUUID().toString();
	}

	public static String getSpiltUUID()  throws Exception{
		String uuid = getUUID();
		char ch =0;
	 char [] c= 	new char [32];
		for (int i= uuid.length(),j=0  ; i-- >0;) {
		 if ((ch=uuid.charAt(i))!='-') {
			c[j++]=ch;
		}	 
			
		}
		return String.valueOf(c);
	}
}
