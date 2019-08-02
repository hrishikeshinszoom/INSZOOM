package com.uiFramework.inszoom.regrationTesting.pageObject.AddNewCaseAndClient;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiFramework.inszoom.regrationTesting.helper.action.HoverOver;
import com.uiFramework.inszoom.regrationTesting.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.inszoom.regrationTesting.helper.dropdown.DropDownHelper;
import com.uiFramework.inszoom.regrationTesting.helper.logger.LoggerHelper;
import com.uiFramework.inszoom.regrationTesting.helper.wait.WaitHelper;
import com.uiFramework.inszoom.regrationTesting.helper.window.WindowHelper;
import com.uiFramework.inszoom.regrationTesting.testbase.TestBase;

public class NewCaseAndClient {
	
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(NewCaseAndClient.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath = ".//aside/div[8]/a/span[2]")
	WebElement clickOnClient;
	
	@FindBy(xpath = "//tr[@class='rgCommandRow']/td/input[1]")
	WebElement addNewClient;
	
	@FindBy(xpath = "//*[@id='frmbnf']/table/tbody/tr[3]/td/table/tbody/tr[3]/td/a")
	WebElement chooseCorp;
	
	@FindBy(xpath = "//*[@id='frmEprList']/table[2]/tbody/tr[2]/td/table/tbody/tr[3]/td/a")
	WebElement chooseCorpFromList;
	
	@FindBy(xpath = "//*[@id='cboBnfSponsor']")
	WebElement CorporationIs;
	
	@FindBy(xpath = "//*[@id='txtFname']")
	WebElement enterFName;
	
	@FindBy(xpath = "//*[@id='txtFname']")
	WebElement enterLName;
	
	@FindBy(xpath = "//*[@id='frmbnf']/table/tbody/tr[2]/td/div/table/tbody/tr/td[1]/input")
	WebElement clickOnSave;

	
	public NewCaseAndClient(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.pageLoadTime(ObjectReader.reader.getPageLoadTime(), TimeUnit.SECONDS);
		TestBase.logExtentReport("Dashboard Page loading compelete");
	}

	public void clickOnClient() {
		log.info("clicking client from dashboard page");
		clickOnClient.click();
	}
	
	public void addNewClient() {
		log.info("adding a new client..");
		addNewClient.click();
		chooseCorp.click();
		
		WindowHelper window = new WindowHelper(driver);
		window.switchToWindow(1);
		chooseCorpFromList.click();
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat d = new SimpleDateFormat("MM-dd-yyyy");
		enterFName.sendKeys(d.format(calendar.getTime()));
		enterLName.sendKeys("Radcliffe");
		
		DropDownHelper drpdwn = new DropDownHelper(driver);
		drpdwn.deSelectUsingIndex(CorporationIs, 1);
		clickOnSave.click();
	}
	
	
	
}
