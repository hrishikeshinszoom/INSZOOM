package com.uiFramework.inszoom.regrationTesting.FormsLoad.pageObject.formsAddnewCaseClient;

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
import com.uiFramework.inszoom.regrationTesting.helper.assertion.VerificationHelper;
import com.uiFramework.inszoom.regrationTesting.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.inszoom.regrationTesting.helper.dropdown.DropDownHelper;
import com.uiFramework.inszoom.regrationTesting.helper.logger.LoggerHelper;
import com.uiFramework.inszoom.regrationTesting.helper.wait.WaitHelper;
import com.uiFramework.inszoom.regrationTesting.pageObject.AddNewCaseAndClient.NewCaseAndClient;
import com.uiFramework.inszoom.regrationTesting.testbase.TestBase;

public class AddnewCaseClient {

	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(NewCaseAndClient.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//aside/div[8]/a/span[2]")
	WebElement clickOnClient;

	@FindBy(xpath = "//tr[@class='rgCommandRow']/td/input[1]")
	WebElement clickaddClientButton;

	@FindBy(xpath = "//th[text()='Client Registration']")
	WebElement clientRegistration;

	@FindBy(xpath = "//th[text()='Add New Client']")
	WebElement addNewClient;

	@FindBy(xpath = "//*[@id='LM3']")
	WebElement clickOnAdvanceSettings;

	@FindBy(xpath = "/html/body/table/tbody/tr[2]/td/a[2]")
	WebElement clkOnClientCreationQnaire;

	@FindBy(xpath = "//*[@id='txtSearch']")
	WebElement txtSearch;

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

	@FindBy(xpath = "//*[@id='site-aside-wrap']/aside/div[14]/div/a/span[2]")
	WebElement clickOnSETUP;

	@FindBy(xpath = "//span[text()='Settings']")
	WebElement hoverOverSettings;

	public AddnewCaseClient(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.pageLoadTime(ObjectReader.reader.getPageLoadTime(), TimeUnit.SECONDS);
		TestBase.logExtentReport("Dashboard Page loading compelete");
	}

	public void clickOnClient() {
		log.info("clicking client from dashboard page..");
		clickOnClient.click();
		log.info("clicking on add client button..");
		clickaddClientButton.click();
	}

	public void addNewClient() {

		VerificationHelper verify = new VerificationHelper(driver);
		
		if (verify.isDisplayed(addNewClient)) {
			log.info("creating new client..");
			chooseCorp.click();
			
			for (String secondWindow : driver.getWindowHandles()) {
			    driver.switchTo().window(secondWindow);
			}
			
			log.info("Choosing first linked corporation..");
			chooseCorpFromList.click();
			
			

			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat d = new SimpleDateFormat("MM-dd-yyyy");
			enterFName.sendKeys(d.format(calendar.getTime()));
			enterLName.sendKeys("Radcliffe");

			DropDownHelper drpdwn = new DropDownHelper(driver);
			drpdwn.deSelectUsingIndex(CorporationIs, 1);
			clickOnSave.click();

		} else {
			log.info("Unlinking client creation questionnaire..");
			HoverOver hover = new HoverOver(driver);
			hover.performAction(clickOnSETUP);
			driver.findElement(By.linkText("Settings")).click();
			clickOnAdvanceSettings.click();
			txtSearch.sendKeys("client creation");
			clkOnClientCreationQnaire.click();
			
			
		}

	}

}
