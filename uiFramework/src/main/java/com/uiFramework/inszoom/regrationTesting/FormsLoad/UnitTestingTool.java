package com.uiFramework.inszoom.regrationTesting.FormsLoad;

import org.testng.annotations.Test;

import com.uiFramework.inszoom.regrationTesting.FormsLoad.pageObject.AddFormsFromExcel.LoadFormsFromExcel;
import com.uiFramework.inszoom.regrationTesting.helper.alert.AlertHelper;
import com.uiFramework.inszoom.regrationTesting.helper.assertion.AssertionHelper;
import com.uiFramework.inszoom.regrationTesting.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.inszoom.regrationTesting.pageObject.LoginPage.LoginPage;
import com.uiFramework.inszoom.regrationTesting.pageObject.dashboardPage.DashboardPage;
import com.uiFramework.inszoom.regrationTesting.pageObject.formsPage.RecentlyVisitedCaseFormsPage;
import com.uiFramework.inszoom.regrationTesting.testbase.TestBase;

public class UnitTestingTool extends TestBase {

	@Test
	public void testFormsInAllHostedServers() throws Exception {

		getApplicationUrl(ObjectReader.reader.getUrl());

		LoginPage login = new LoginPage(driver);

		boolean status = login.verifyLoginPage();
		AssertionHelper.updateTestStatus(status);

		login.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
		AlertHelper alertHelper = new AlertHelper(driver);
		alertHelper.acceptAlertIfPresent();
		
		/**
		 * com.uiFramework.inszoom.regrationTesting.pageObject.dashboardPage
		 */
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.setDefaultHomePage();
		
		/**
		 * com.uiFramework.inszoom.regrationTesting.pageObject.formsPage
		 */
		RecentlyVisitedCaseFormsPage recent = new RecentlyVisitedCaseFormsPage(driver);
		recent.clickOnRecentlyVisitedForm();
		
		/**
		 * com.uiFramework.inszoom.regrationTesting.FormsLoad.pageObject.AddFormsFromExcel
		 */
		LoadFormsFromExcel load = new LoadFormsFromExcel(driver);
		load.loadFormsListFromExcel("I-131");
	}
	
	
}
