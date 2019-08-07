package com.uiFramework.inszoom.regrationTesting.FormsLoad;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://global.inszoom.com/");

		driver.findElement(By.xpath("//*[@placeholder='Login ID/User ID']")).sendKeys("hrishikesh.b");

		driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("Canada@2292");
		driver.findElement(By.xpath("//*[@type='button' and @id='login']")).click();

		driver.switchTo().alert().accept();

		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id='dashtbl1']/div/div/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[2]/a")).click();

		driver.findElement(By.xpath("//*[@id='frmCaseFrms']/table/tbody/tr/td[2]/table[2]/tbody/tr[2]/td/div/table/tbody/tr/td[1]/table/tbody/tr/td/a/img")).click();
		
		String parentWindow = driver.getWindowHandle();
		
		Set<String> handles = driver.getWindowHandles();
		
		for(String windows : handles) {
			
			driver.switchTo().window(windows);
		}
			 
		driver.findElement(By.xpath("//*[@id='txtSearchId']")).sendKeys("G-28");

		driver.findElement(By.xpath("//table[contains(@summary,'Attach Case Forms For ')]/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td[3]/table/tbody/tr/td[1]/input")).click();

		List<WebElement> list = driver.findElements(By.xpath("//table[@summary='Search Results']/tbody/tr/td[2]/b"));

		List<String> forms_list = new ArrayList<String>();

		for (int i = 0; i < list.size(); i++) {

			String formName = list.get(i).getText();
			forms_list.add(formName);

		}

		int form_index = forms_list.indexOf("G-28");

		String xpath1 = "//table[@summary='Search Results']/tbody/tr[";

		int xpath2 = form_index + 3;

		String xpath3 = "]/td[2]/input";

		String string4 = xpath1 + xpath2 + xpath3;

		driver.findElement(By.xpath(string4)).click();
		
		driver.findElement(By.xpath("//table[contains(@summary,'Attach Case Forms For ')]/tbody/tr[2]/td/div/table/tbody/tr/td[2]/input")).click();
		
		driver.switchTo().window(parentWindow);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		List<WebElement> listOfRows = driver.findElements(By.xpath("//table[starts-with(@summary,'Case Forms for ')]/tbody/tr[*]/td[2]/table/tbody/tr[1]/td/b"));

		List<String> forms = new ArrayList<String>();

		for (int i = 0; i < listOfRows.size(); i++) {

			String formName = listOfRows.get(i).getText();
			forms.add(formName);

		}

		int form_index1 = forms.lastIndexOf("G-28");

		String path1 = "//table[starts-with(@summary,'Case Forms for ')]/tbody/tr[";

		int path2 = form_index1 + 3;

		String path3 = "]/td[4]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/select/option[4]";

		String path4 = path1 + path2 + path3;

		driver.findElement(By.xpath(path4)).click();

	}
}
