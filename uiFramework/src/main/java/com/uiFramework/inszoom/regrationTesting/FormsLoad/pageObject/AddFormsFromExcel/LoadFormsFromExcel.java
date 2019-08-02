package com.uiFramework.inszoom.regrationTesting.FormsLoad.pageObject.AddFormsFromExcel;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiFramework.inszoom.regrationTesting.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.inszoom.regrationTesting.helper.logger.LoggerHelper;
import com.uiFramework.inszoom.regrationTesting.helper.wait.WaitHelper;
import com.uiFramework.inszoom.regrationTesting.helper.window.WindowHelper;
import com.uiFramework.inszoom.regrationTesting.testbase.TestBase;

public class LoadFormsFromExcel {

	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoadFormsFromExcel.class);
	WindowHelper window;
	
	@FindBy(xpath = "//*[@id=\"frmCaseFrms\"]/table/tbody/tr/td[2]/table[2]/tbody/tr[2]/td/div/table/tbody/tr/td[1]/table/tbody/tr/td/a/img")
	WebElement AddFormsBTN;

	@FindBy(xpath = "//*[@id=\"txtSearchId\"]")
	WebElement searchForm;

	@FindBy(xpath = "//*[@id=\"btn_SearchCaseForms\"]")
	WebElement clickOnFindBTN;

	@FindBy(xpath = "//*[@id=\"frmLink\"]/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/input")
	WebElement clickOnFirstLinkedForm;

//	@FindBy(xpath = "//*[@id=\"btn_SaveSelectedCaseFormsAndCloseTheWindow\"]")
//	WebElement clickOnSaveAndCloseBTN;
	
	@FindBy(xpath = "//*[@id=\"btn_SaveSelectedCaseForms\"]")
	WebElement clickOnSaveBTN;

	public LoadFormsFromExcel(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WaitHelper waitHelper = new WaitHelper(driver);
		waitHelper.pageLoadTime(ObjectReader.reader.getPageLoadTime(), TimeUnit.SECONDS);
		TestBase.logExtentReport("Case/Forms Page loading compelete");
	}

	public void clickOnAddFormsBTN() {
		log.info("clicking on add forms button..");
		AddFormsBTN.click();
	}

	public void clickOnAddFormsBTN(String formIDs) {
		log.info("Taking forms list from Excel File..");
		searchForm.sendKeys(formIDs);
	}

	public void clickOnFindButton() {
		log.info("Clicking on find button..");
		clickOnFindBTN.click();
	}

	public void clickOnFirstLinkedForm() {
		log.info("Checking first linked form from the search result..");
		clickOnFirstLinkedForm.click();
	}

	public void clickOnSave() {
		log.info("Clicking on save button..");
		clickOnSaveBTN.click();
	}
	
//	public void switchBetweenWindows() {
//		for (String secondWindow : driver.getWindowHandles()) {
//			log.info("switching to: "+ driver.getTitle() + " window");
//			driver.switchTo().window(secondWindow);
//		}
//	}
	
	public void loadFormsListFromExcel(String formIDs) {
		clickOnAddFormsBTN();
		window = new WindowHelper(driver);
		window.switchToWindow(1);
		clickOnAddFormsBTN(formIDs);
		clickOnFindButton();
		clickOnFirstLinkedForm();
		clickOnSave();
		window.maximizeWindow();
		window.closeAllTabsAndSwitchToMainWindow();
		List<WebElement> elements = driver.findElements(By.xpath("//b[text()='I-864']"));
		System.out.println(elements);
	}
}
