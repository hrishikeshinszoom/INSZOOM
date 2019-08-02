
package com.uiFramework.inszoom.regrationTesting.helper.browserConfiguration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class ChromeBrowser {

	public ChromeOptions getChromeOptions() {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--test-type");
		option.addArguments("--disable-popup-blocking");
		option.addArguments("disable-infobars");
//		option.setPageLoadStrategy(PageLoadStrategy.NONE);
		option.setAcceptInsecureCerts(true);
		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);
		
		option.setCapability(ChromeOptions.CAPABILITY, chrome);	

		return option;
	}

	public WebDriver getChromeDriver(ChromeOptions cap) {

		if (System.getProperty("os.name").contains("Mac")){
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
			return new ChromeDriver(cap);
		}
		else if(System.getProperty("os.name").contains("Window")){
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
			return new ChromeDriver(cap);
		}
		return null;
	}
}
