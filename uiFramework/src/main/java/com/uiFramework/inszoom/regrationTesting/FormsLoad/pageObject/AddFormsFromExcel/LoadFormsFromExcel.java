package com.uiFramework.inszoom.regrationTesting.FormsLoad.pageObject.AddFormsFromExcel;

import java.util.ArrayList;
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
	String parentWindow;
	
	@FindBy(xpath = "//*[@id='frmCaseFrms']/table/tbody/tr/td[2]/table[2]/tbody/tr[2]/td/div/table/tbody/tr/td[1]/table/tbody/tr/td/a/img")
	WebElement AddFormsBTN;

	@FindBy(xpath = "//*[@id='txtSearchId']")
	WebElement searchForm;

	@FindBy(xpath = "//table[contains(@summary,'Attach Case Forms For ')]/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td[3]/table/tbody/tr/td[1]/input")
	WebElement clickOnFindBTN;

	@FindBy(xpath = "//table[contains(@summary,'Attach Case Forms For ')]/tbody/tr[2]/td/div/table/tbody/tr/td[2]/input")
	WebElement clickOnSaveAndCloseBTN;

	@FindBy(xpath = "//table[starts-with(@summary,'Case Forms for ')]/tbody/tr[*]/td[2]/table/tbody/tr[1]/td/b")
	WebElement listOfRows;

	@FindBy(xpath = "//table[@summary='Search Results']/tbody/tr/td[2]/input")
	WebElement clickOnFormsByName;

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
		window = new WindowHelper(driver);
		parentWindow = driver.getWindowHandle();
		window.switchToWindow(1);
	}

	public void addForms(String formIDs) {
		log.info("Taking forms list from Excel File..");
		searchForm.sendKeys(formIDs);
	}

	public void clickOnFindButton() {
		log.info("Clicking on find button..");
		clickOnFindBTN.click();
	}

	public void linkingFormsBasedOnSearch(String formIDs) {
		log.info("Linking from the search result..");

		List<WebElement> list = driver.findElements(By.xpath("//table[@summary='Search Results']/tbody/tr/td[2]/b"));

		List<String> forms_list = new ArrayList<String>();

		for (int i = 0; i < list.size(); i++) {

			String formName = list.get(i).getText();
			forms_list.add(formName);
		}

		int form_index = forms_list.indexOf(formIDs);

		String xpath1 = "//table[@summary='Search Results']/tbody/tr[";

		int xpath2 = form_index + 3;

		String xpath3 = "]/td[2]/input";

		String string4 = xpath1 + xpath2 + xpath3;

		driver.findElement(By.xpath(string4)).click();
		
	}

	public void clickOnSaveAndClose() {
		log.info("Clicking on save button..");
		clickOnSaveAndCloseBTN.click();
		driver.switchTo().window(parentWindow);
	}

	public void loadFormsListFromExcel(String formIDs) {
		clickOnAddFormsBTN();
		addForms(formIDs);
		clickOnFindButton();
		linkingFormsBasedOnSearch(formIDs);
		clickOnSaveAndClose();
	}
}
