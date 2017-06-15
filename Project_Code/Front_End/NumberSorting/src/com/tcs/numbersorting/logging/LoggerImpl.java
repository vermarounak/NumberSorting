package com.tcs.numbersorting.logging;

import org.apache.log4j.Logger;

/**
 * @author 669517
 *
 */
public class LoggerImpl implements LoggerInterface {
	private Logger logger = null;

	/**
	 * @param className
	 */
	public LoggerImpl(String className) {
		this.logger = Logger.getLogger(className);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tcs.numbersorting.logging.LoggerInterface#error(java.lang.Object)
	 */
	public void error(Object obj) {
		this.logger.error(obj.toString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tcs.numbersorting.logging.LoggerInterface#debug(java.lang.Object)
	 */
	public void debug(Object obj) {
		this.logger.debug(obj.toString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tcs.numbersorting.logging.LoggerInterface#warn(java.lang.Object)
	 */
	public void warn(Object obj) {
		this.logger.warn(obj.toString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tcs.numbersorting.logging.LoggerInterface#info(java.lang.Object)
	 */
	public void info(Object obj) {
		this.logger.info(obj.toString());
	}
}
