package com.uiFramework.inszoom.regrationTesting.helper.alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import com.uiFramework.inszoom.regrationTesting.helper.logger.LoggerHelper;

public class AlertHelper {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(AlertHelper.class);
	
	public AlertHelper(WebDriver driver){
		this.driver = driver;
		log.info("AlertHelper object is craeted..");
	}
	
	public Alert getAlert(){
		log.info("Alert test: "+driver.switchTo().alert().getText());
		return driver.switchTo().alert();
	}
	
	public void acceptAlert(){
		getAlert().accept();
		log.info("Accepting Alert");
	}
	
	public void dismissAlert(){
		getAlert().dismiss();
		log.info("Dismissing Alert");
	}
	
	public String getAlertText(){
		String text = getAlert().getText();
		log.info("Alert text: "+text);
		return text;
	}
	
	public boolean isAlertPresent(){
		try{
			driver.switchTo().alert();
			log.info("Alert is present");
			return true;
		}
		catch(NoAlertPresentException e){
			log.info(e.getCause());
			return false;
		}
	}
	
	public void acceptAlertIfPresent(){
		if(isAlertPresent()){
			acceptAlert();
		}
		else{
			log.info("Alert is not present");
		}
	}
	
	public void dismissAlertIfPresent(){
		if(isAlertPresent()){
			log.info("Alert is present");
			dismissAlert();
		}
		else{
			log.info("Alert is not present");
		}
	}
	
	public void acceptPrompt(String text){
		if(isAlertPresent()){
			Alert alert = getAlert();
			alert.sendKeys(text);
			alert.accept();
			log.info("Alert text: "+text);
		}
	}
}
