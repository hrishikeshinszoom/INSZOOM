package com.uiFramework.inszoom.regrationTesting.testScripts.loginPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.uiFramework.inszoom.regrationTesting.helper.alert.AlertHelper;
import com.uiFramework.inszoom.regrationTesting.helper.assertion.AssertionHelper;
import com.uiFramework.inszoom.regrationTesting.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.inszoom.regrationTesting.helper.browserConfiguration.config.PropertyReader;
import com.uiFramework.inszoom.regrationTesting.pageObject.LoginPage.LoginPage;
import com.uiFramework.inszoom.regrationTesting.testbase.TestBase;

public class LoginTest extends TestBase {
	
	@BeforeClass
	public void beforeClass() throws Exception {
		ObjectReader.reader = new PropertyReader();
		setUpDriver(ObjectReader.reader.getBrowserType());
		getApplicationUrl(ObjectReader.reader.getUrl());
	}
	
	@Test
	public void testLoginToApplication() throws Exception {
		
		LoginPage loginPage = new LoginPage(driver);

		boolean status = loginPage.verifyLoginPage();
		AssertionHelper.updateTestStatus(status);

		loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
		
		AlertHelper alertHelper = new AlertHelper(driver);
		alertHelper.acceptAlertIfPresent();
		
	}
}
