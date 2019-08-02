package com.uiFramework.inszoom.regrationTesting.helper.action;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.uiFramework.inszoom.regrationTesting.helper.logger.LoggerHelper;

public class HoverOver {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(HoverOver.class);
	
	public HoverOver(WebDriver driver){
		this.driver = driver;
		log.info("AlertHelper object is craeted..");
	}
	
	public void performAction(WebElement element){
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
//		driver.findElement(By.xpath(xpath)).click();
	}
}
