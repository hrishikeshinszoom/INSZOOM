package com.uiFramework.inszoom.regrationTesting.helper.browserConfiguration.config;

import java.io.FileInputStream;
import java.util.Properties;

import com.uiFramework.inszoom.regrationTesting.helper.browserConfiguration.BrowserType;

public class PropertyReader implements ConfigReader {

	private static FileInputStream file;
	public static Properties OR;

	public PropertyReader() {
		try {
			file = new FileInputStream("./src/main/resources/configfile/config.properties");
			OR = new Properties();
			OR.load(file);
			
			file = new FileInputStream("./src/main/resources/configfile/config1.properties");
			OR = new Properties();
			OR.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getImpliciteWait() {
		return Integer.parseInt(OR.getProperty("implicitwait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(OR.getProperty("explicitwait"));
	}

	public int getPageLoadTime() {
		return Integer.parseInt(OR.getProperty("pageloadtime"));
	}

	public BrowserType getBrowserType() {
		return BrowserType.valueOf(OR.getProperty("browserType"));
	}

	public String getUrl() {
		if(System.getProperty("url")!=null){
			return System.getProperty("url");
		}
		return OR.getProperty("applicationUrl");
	}

	public String getUserName() {
		if(System.getProperty("userName")!=null){
			return System.getProperty("userName");
		}
		return OR.getProperty("userName");
	}

	public String getPassword() {
		if(System.getProperty("password")!=null){
			return System.getProperty("password");
		}
		return OR.getProperty("password");
	}
	
	

}
