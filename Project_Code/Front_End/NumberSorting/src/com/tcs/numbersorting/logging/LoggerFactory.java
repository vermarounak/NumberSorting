package com.tcs.numbersorting.logging;

import java.util.ResourceBundle;

import org.apache.log4j.xml.DOMConfigurator;

/**
 * @author 669517
 *
 */
public class LoggerFactory {

	private LoggerFactory() {

	}

	/**
	 * @param className
	 * @return
	 */
	public static LoggerInterface getLogger(String className) {
		return new LoggerImpl(className);
	}

	static {
		ResourceBundle rb = ResourceBundle.getBundle("environment");
		String log4jpath = rb.getString("LOG4J_FILE_PATH").trim();
		if (log4jpath != null) {
			DOMConfigurator.configure(log4jpath);
		}
	}
}
