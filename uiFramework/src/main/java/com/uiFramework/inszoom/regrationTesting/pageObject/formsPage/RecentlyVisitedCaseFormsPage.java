package com.uiFramework.inszoom.regrationTesting.pageObject.formsPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiFramework.inszoom.regrationTesting.helper.logger.LoggerHelper;
import com.uiFramework.inszoom.regrationTesting.helper.window.WindowHelper;
import com.uiFramework.inszoom.regrationTesting.testbase.TestBase;

public class RecentlyVisitedCaseFormsPage {

	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(RecentlyVisitedCaseFormsPage.class);

	@FindBy(xpath = "//*[@id='dashtbl1']/div/div/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[2]/a")
	WebElement clickOnFirstForm;

	public RecentlyVisitedCaseFormsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		TestBase.logExtentReport("Recently Visited Case/Forms Page loading compelete");
	}

	public void clickOnFirstForm() {
		log.info("Clicking on First linked form where form_disp_id= " + clickOnFirstForm.getText());
		clickOnFirstForm.click();
	}

	public void clickOnRecentlyVisitedForm() {
		clickOnFirstForm();
		/*WindowHelper window = new WindowHelper(driver);
		window.closeAllTabsAndSwitchToMainWindow();*/
	}
}
