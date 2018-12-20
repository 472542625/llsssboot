package com.lc.web.util;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 断言类
 * @author Administrator
 *@date 2018年3月7日
 */
public class ThisAssertion {
/**
 * 自定义异常
 * @param message 提示用户的信息
 */
	public static void getThisRuntimeException(final String message)throws ThisRuntimeException {
		
		throw new ThisRuntimeException(message);
	};
	/**
	 * 断言是否为空
	 * @param message
	 * @param arges
	 * @return
	 * @throws ThisRuntimeException
	 */
	public static String  isNotNull(final String message,String arges)throws ThisRuntimeException {
		
		if(arges==null||(arges=arges.trim()).length()==0)
		{
			getThisRuntimeException(message);
		}
		return arges;
	}
	/**
	 * 断言字符串为空
	 * @param message
	 * @param arges
	 * @return
	 * @throws ThisRuntimeException
	 */
	public static String isNull(final String message,String arges)  throws ThisRuntimeException {
		
		if(arges!=null||(arges=arges.trim()).length()>0)
		{
			getThisRuntimeException(message);
		}
		return arges;
	}
	/**
	 * 断言字符串不含空格
	 * @param message
	 * @param arges
	 * @return
	 * @throws ThisRuntimeException
	 */
	public static String isNotSpace(final String message,String arges)  throws ThisRuntimeException {
		if(arges.indexOf("")!=-1)
		{
			getThisRuntimeException(message);
		}
		return arges;
	}
	/**
	 * 断言两个数据相同
	 * @param message
	 * @param obj 数据库查询出来的值
	 * @param arges 需要断言的参数，客户输入的值
	 * @return
	 * @throws ThisRuntimeException
	 */
	public static String isEques(final String message,String obj,String arges)  throws ThisRuntimeException {
		if(!(arges==obj||(arges!=null&&arges.equals(obj))))
		{
			getThisRuntimeException(message);
		}
		return arges;
		 
	}
	/**
	 * 断言一个对象不为空
	 * @param message
	 * @param obj
	 * @return
	 * @throws ThisRuntimeException
	 */
	public static Object isObjectNotNull(final String message,Object obj)  throws ThisRuntimeException {
		if(obj==null)
		{
			getThisRuntimeException(message);
		}
		return obj;
		 
	}
	/**
	 * 断言一个集合不为空
	 * @param message
	 * @param coll
	 * @throws ThisRuntimeException
	 */
	
	public static void isCollectionNotNull(final String message,Collection<?> coll)  throws ThisRuntimeException {
		if(coll.size()==0 ||coll==null)
		{
			getThisRuntimeException(message);
		}
		 
	}
	/**
	 * 正则表达式断言
	 * @param message
	 * @param pattern
	 * @param objActive
	 * @return
	 * @throws Exception
	 */
	public static String isBooleanChin(final String message,String pattern,String objActive)  throws Exception {
		 Pattern compile = Pattern.compile(pattern);
		 Matcher matcher = compile.matcher(objActive);
		 
		 if(!matcher.matches()){
			 getThisRuntimeException(message);
			 
			 
		 }
		 
		 return objActive;
		 
	}
	
	
	
}
