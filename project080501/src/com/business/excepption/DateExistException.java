package com.business.excepption;

public class DateExistException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DateExistException(){
		
	}
public DateExistException(String message){
		super(message);
	}
}
