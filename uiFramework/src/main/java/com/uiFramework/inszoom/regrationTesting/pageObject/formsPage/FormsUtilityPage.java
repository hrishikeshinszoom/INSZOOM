package com.uiFramework.inszoom.regrationTesting.pageObject.formsPage;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.uiFramework.inszoom.regrationTesting.helper.alert.AlertHelper;
import com.uiFramework.inszoom.regrationTesting.helper.assertion.AssertionHelper;
import com.uiFramework.inszoom.regrationTesting.helper.assertion.VerificationHelper;
import com.uiFramework.inszoom.regrationTesting.helper.dropdown.DropDownHelper;
import com.uiFramework.inszoom.regrationTesting.helper.javaScript.JavaScriptHelper;
import com.uiFramework.inszoom.regrationTesting.helper.logger.LoggerHelper;
import com.uiFramework.inszoom.regrationTesting.helper.window.WindowHelper;
import com.uiFramework.inszoom.regrationTesting.testbase.TestBase;

public class FormsUtilityPage {

	private Logger log = LoggerHelper.getLogger(FormsUtilityPage.class);
	private WebDriver driver;
	TestBase test;

	@FindBy(xpath = "//*[@id='ComboBoxAction' and @name='optFrmUtil']")
	WebElement clickOnFormUtility;

	@FindBy(xpath = ".//table[2]/tbody/tr[3]/td/table/tbody/tr[3]/td[4]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a")
	WebElement clickOnGo;

	@FindBy(xpath = ".//div[2]//div[3]/div/a[1]/i[@class='fa fa-save']")
	WebElement clickOnSaveFF;

	@FindBy(xpath = ".//div[2]//div[3]/div/a[2]/i[@class='fa fa-print']")
	WebElement clickOnPrint;

	@FindBy(xpath = ".//div[2]//div[3]/div/a[3]/i[@class='fa fa-edit']")
	WebElement clickOnEditAddendum;

	@FindBy(xpath = ".//div[2]//div[3]/div/a[4]/i[@class='fa fa-times']")
	WebElement clickOnClose;

	@FindBy(xpath = "//*[@id='ddrChangeFonts']")
	WebElement checkFontType;

	@FindBy(xpath = "//*[@id='ddrChangeFontSize']")
	WebElement checkFontSize;
	
	@FindBy(xpath = "//*[@id='mainContent']")
	WebElement HTMLmain;
	
	@FindBy(xpath = "//*[@id='frmCaseFrms']/table/tbody/tr/td[2]/table[2]/tbody/tr[4]/td/div/table/tbody/tr/td[1]/table/tbody/tr/td/a/img")
	WebElement addFormBtn;
	
	public FormsUtilityPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 *  public void clickOnFormUtility() {
	 *  dropdown = new DropDownHelper(driver);
	 *  System.out.println(dropdown.getAllDropDownData(clickOnFormUtility)); }
	 */

	/**
	 * This method will check Fast Form buttons which includes: Font Type, Font
	 * Size, Save, Print, Edit Addendum and Close,
	 */
	public void checkFastForm() {
		DropDownHelper dropdown = new DropDownHelper(driver);
		JavaScriptHelper java = new JavaScriptHelper(driver);
		AlertHelper alert = new AlertHelper(driver);
		VerificationHelper verify = new VerificationHelper(driver);
		WindowHelper window = new WindowHelper(driver);
		
		dropdown.selectUsingValue(clickOnFormUtility, "Edit Fast Form");
		log.info("clicking on utility function");
		clickOnGo.click();

		for (String secondWindow : driver.getWindowHandles()) {
			log.info("switching to: "+ driver.getTitle() + " window");
			driver.switchTo().window(secondWindow);
		}
		
		log.info("clicking on FontType");
		java.clickElement(checkFontType);
		verify.readValueFromElement(checkFontType);
		Select select = new Select(checkFontType);
		List<WebElement> list = select.getOptions();
		list.size();
		if(list.size() == 12){
			AssertionHelper.markPass();
		}
		
		log.info("clicking on FontSize");
		java.clickElement(checkFontSize);
		Select select1 = new Select(checkFontSize);
		List<WebElement> list1 = select1.getOptions();
		list1.size();
		if(list.size() == 10){
			AssertionHelper.markPass();
		}
		
		/*try {
			Thread.sleep(5000);
			test.getNavigationScreen(driver);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		log.info("clickin on Save button");
		java.clickElement(clickOnSaveFF);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		log.info("clicking on Print");
		java.clickElement(clickOnPrint);
		alert.acceptAlert();
		
		try {
			window.switchToWindow(1);
			Thread.sleep(5000);
			test.getNavigationScreen(driver);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
