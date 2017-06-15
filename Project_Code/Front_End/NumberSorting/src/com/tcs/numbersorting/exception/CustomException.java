package com.tcs.numbersorting.exception;

/**
 * @author 669517 This file is used to create custom application based exception
 *         and wrapping every exception to the custom one.
 */
public class CustomException extends Exception {

	private static final long serialVersionUID = 101L;

	/**
	 * 
	 */
	public CustomException() {
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param cause
	 */
	public CustomException(Throwable cause) {
		super(cause);
	}

}
