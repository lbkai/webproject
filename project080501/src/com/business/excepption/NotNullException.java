package com.business.excepption;

public class NotNullException extends Exception{
	/**
	 * 不能为空
	 */
	private static final long serialVersionUID = 1L;
	public NotNullException(){
		super();
	}
	public NotNullException(String message){
		super("输入的字符不能为空！！！");
	}
}
