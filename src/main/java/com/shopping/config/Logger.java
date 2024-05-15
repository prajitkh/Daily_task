package com.shopping.config;

public final class Logger {

	private static Logger logger;

	private Logger() {

	}

	public static Logger getLogger() {
		synchronized (Logger.class) {
			if (logger == null) {
				logger = new Logger();

			}
		}

		return logger;
	}

	public void log(String message) {
		System.out.println("LOG: " + message);
	}

}
