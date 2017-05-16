package com.epam.simpleweb04.utility;

import org.apache.log4j.PropertyConfigurator;

public class Utility {

	private static final String LOG_CONFIG = "resource/ConfigLogger.properties";

	public static void init() {
		PropertyConfigurator.configure(LOG_CONFIG);
	}
}
