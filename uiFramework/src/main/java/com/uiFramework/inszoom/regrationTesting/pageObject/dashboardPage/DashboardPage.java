package com.uiFramework.inszoom.regrationTesting.pageObject.dashboardPage;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiFramework.inszoom.regrationTesting.helper.assertion.VerificationHelper;
import com.uiFramework.inszoom.regrationTesting.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.inszoom.regrationTesting.helper.dropdown.DropDownHelper;
import com.uiFramework.inszoom.regrationTesting.helper.logger.LoggerHelper;
import com.uiFramework.inszoom.regrationTesting.helper.wait.WaitHelper;
import com.uiFramework.inszoom.regrationTesting.helper.window.WindowHelper;
import com.uiFramework.inszoom.regrationTesting.testbase.TestBase;

public class DashboardPage {

	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(DashboardPage.class);

	WaitHelper waitHelper;

	@FindBy(xpath = ".//span[text()='My ZoomBoard']")
	WebElement returnToDashboard;

	@FindBy(xpath = ".//span[text()='Collapse']")
	WebElement Collapse2;

	@FindBy(xpath = ".//th[text()='MY ZOOMBOARD']")
	WebElement successMsgObject;

	@FindBy(xpath = ".//img[@alt='Reset ZoomBoard items to default sequence']")
	WebElement clickOnDefaultSettings;

	@FindBy(xpath = ".//input[@type='button' and @title='Change my INSZoom home page']")
	WebElement listOfRecentlyVisitedFormsIsHomePage;

	@FindBy(xpath = "//*[@id='cboRecentlyVisited']")
	WebElement element;

	@FindBy(xpath = "//table/tbody/tr[2]/td/div/table/tbody/tr/td[2]/input[1]")
	WebElement saveHomePage;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.pageLoadTime(ObjectReader.reader.getPageLoadTime(), TimeUnit.SECONDS);
		TestBase.logExtentReport("Dashboard Page loading compelete");
	}

	public boolean verifyHomePage() {
		return new VerificationHelper(driver).isDisplayed(successMsgObject);
	}

	public void ClickOnDefaultSettings() {
		log.info("clicking on default dashboard setting");
		clickOnDefaultSettings.click();
	}
	
	public void saveHomePage() {
		saveHomePage.click();
	}

	public void returnToDashboard() {
		returnToDashboard.click();
	}

	public void setDefaultHomePage() {
		if (driver.getPageSource().contains("MY ZOOMBOARD")) {
			log.info("dashboard page is diaplayed");
			Collapse2.click();
			ClickOnDefaultSettings();

		} else {
			log.info("dashboard page is not diaplayed");
			listOfRecentlyVisitedFormsIsHomePage.click();

			WindowHelper window = new WindowHelper(driver);
			window.switchToWindow(1);

			DropDownHelper dropdown = new DropDownHelper(driver);
			dropdown.selectUsingVisibleText(element, "MyZoomboard");
//			saveHomePage();
			returnToDashboard();
			ClickOnDefaultSettings();
		}
	}
}
