package com.upesh.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

	public static String CONFIG_PATH = "../../../resources/configuration.properties";
	
	private static PropertyReader reader = new PropertyReader();
	
	public  String getPropertyValueFromInstance(String key) throws IOException{
		Properties props = new Properties();
		InputStream in = getClass().getResourceAsStream(CONFIG_PATH);
		props.load(in);
		String value = props.getProperty(key);
		return value;
	}
	
	public static String getPropertyValue(String key){
		try {
			return reader.getPropertyValueFromInstance(key);
		} catch (IOException e) {
			return null;
		}
		
	}
}
