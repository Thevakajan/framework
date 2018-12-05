package com.test.framework;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
	private static Logger logger = LogManager.getLogger(Log.class);
	
	public static void startTestCase() {
		logger.log(Level.INFO, "**********************************");
		logger.log(Level.INFO, "----------Start Test Case----------");
		logger.log(Level.INFO, "**********************************");
		
		
	}
	public static void endTestCase() {
		logger.log(Level.INFO, "**********************************");
		logger.log(Level.INFO, "---------- End Test Case----------");
		logger.log(Level.INFO, "**********************************");
	}
}
