package com.inaworld.process.startup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public enum ApplicationProperties {
	INSTANCE;

	private static final String RESOURCES = "./resources/";
	private static final String CONFIG_PROPERTIES = "config.properties";

	private ApplicationProperties() {
	}

	public String getPropertyValue(String key) throws IOException {
		String value = null;
		FileInputStream inputStream = null;
		try {
			Properties prop = new Properties();
			String propFileName = CONFIG_PROPERTIES;
			inputStream = new FileInputStream(RESOURCES + propFileName);
			prop.load(inputStream);
			// get the property value and print it out
			value = prop.getProperty(key);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return value;
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.println(ApplicationProperties.INSTANCE.getPropertyValue("AttributesCache"));

	}

}
