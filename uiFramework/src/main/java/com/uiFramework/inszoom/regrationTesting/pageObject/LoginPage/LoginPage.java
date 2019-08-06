package com.uiFramework.inszoom.regrationTesting.pageObject.LoginPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiFramework.inszoom.regrationTesting.helper.assertion.VerificationHelper;
import com.uiFramework.inszoom.regrationTesting.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.inszoom.regrationTesting.helper.logger.LoggerHelper;
import com.uiFramework.inszoom.regrationTesting.helper.wait.WaitHelper;
import com.uiFramework.inszoom.regrationTesting.testbase.TestBase;

public class LoginPage {

	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginPage.class);

	WaitHelper waitHelper;

	@FindBy(xpath = "//*[@placeholder='Login ID/User ID']")
	WebElement emailAddress;

	@FindBy(xpath = "//*[@placeholder='Password']")
	WebElement password;

	@FindBy(xpath = "//*[@type='button' and @id='login']")
	WebElement submitLogin;

	@FindBy(xpath = "//*[@id='inszoom_global']/img")
	WebElement homepageLoadSuccess;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(homepageLoadSuccess, ObjectReader.reader.getExplicitWait());
		log.info("Homepage loaded successfully");
		new TestBase().getNavigationScreen(driver);
		TestBase.logExtentReport("Homepage loaded successfully");
	}

	public boolean verifyLoginPage() {
		return new VerificationHelper(driver).isDisplayed(homepageLoadSuccess);
	}

	public void enterEmailAddress(String userID) {
		log.info("Entering email address: " + userID);
		TestBase.logExtentReport("entering email address: ");
		this.emailAddress.sendKeys(userID);
	}

	public void enterPassword(String password) {
		log.info("Entering password: " + password);
		TestBase.logExtentReport("entering password: ");
		this.password.sendKeys(password);
	}

	public void clickOnSubmitButton() {
		log.info("Clicking on submit button");
		TestBase.logExtentReport("Clicking on submit button");
		submitLogin.click();
	}

	public void loginToApplication(String emailAddress, String password) {
		enterEmailAddress(emailAddress);
		enterPassword(password);
		clickOnSubmitButton();
	}

}
