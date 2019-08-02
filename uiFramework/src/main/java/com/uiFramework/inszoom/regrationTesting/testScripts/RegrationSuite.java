package com.uiFramework.inszoom.regrationTesting.testScripts;

import org.testng.annotations.Test;

import com.uiFramework.inszoom.regrationTesting.helper.assertion.AssertionHelper;
import com.uiFramework.inszoom.regrationTesting.helper.browserConfiguration.config.ObjectReader;

import com.uiFramework.inszoom.regrationTesting.pageObject.LoginPage.LoginPage;
import com.uiFramework.inszoom.regrationTesting.pageObject.dashboardPage.DashboardPage;
import com.uiFramework.inszoom.regrationTesting.pageObject.formsPage.FormsUtilityPage;
import com.uiFramework.inszoom.regrationTesting.pageObject.formsPage.RecentlyVisitedCaseFormsPage;
import com.uiFramework.inszoom.regrationTesting.testbase.TestBase;

public class RegrationSuite extends TestBase {

	@Test(priority = 1)
	public void testLoginToApplication() throws Exception {

		getApplicationUrl(ObjectReader.reader.getUrl());

		LoginPage login = new LoginPage(driver);

		boolean status = login.verifyLoginPage();
		AssertionHelper.updateTestStatus(status);

		login.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());

	}

	@Test(priority = 2)
	public void setDefaultDashboardPage() {

		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.setDefaultHomePage();
	}
	
	
	@Test(priority = 3)
	public void clickOnRecentlyVisitedCaseForm() {

		RecentlyVisitedCaseFormsPage recent = new RecentlyVisitedCaseFormsPage(driver);
		recent.clickOnRecentlyVisitedForm();
	}

	@Test(priority = 4)
	public void formsUtilityFunctionsCheck() {
		FormsUtilityPage forms = new FormsUtilityPage(driver);
		forms.checkFastForm();
	}
	
}
