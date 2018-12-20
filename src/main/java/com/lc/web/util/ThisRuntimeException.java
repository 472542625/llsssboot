package com.lc.web.util;


/**
 * 自定义异常
 * @author Administrator
 *@date 2018年3月7日
 */
public class ThisRuntimeException  extends RuntimeException{

	public ThisRuntimeException() {
		super();
		 
	}

	public ThisRuntimeException(String message, Throwable cause) {
		super(message, cause);
		 
	}

	public ThisRuntimeException(String message) {
		super(message);
		 
	}
	

	
}
