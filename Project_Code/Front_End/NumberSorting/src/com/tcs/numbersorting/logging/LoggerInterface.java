package com.tcs.numbersorting.logging;


/**
 * @author 669517
 *
 */
public interface LoggerInterface {

	/**
	 * @param paramObject
	 */
	public abstract void error(Object paramObject);

	/**
	 * @param paramObject
	 */
	public abstract void debug(Object paramObject);

	/**
	 * @param paramObject
	 */
	public abstract void warn(Object paramObject);

	/**
	 * @param paramObject
	 */
	public abstract void info(Object paramObject);

}
