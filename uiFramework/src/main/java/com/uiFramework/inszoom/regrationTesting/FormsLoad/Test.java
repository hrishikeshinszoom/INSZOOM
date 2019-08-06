package com.uiFramework.inszoom.regrationTesting.FormsLoad;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	WebDriver driver;

	public static <E> void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://global.inszoom.com/");

		driver.findElement(By.xpath("//*[@placeholder='Login ID/User ID']")).sendKeys("hrishikesh.b");

		driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("Canada@2292");
		driver.findElement(By.xpath("//*[@type='button' and @id='login']")).click();

		driver.switchTo().alert().accept();

		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id='dashtbl1']/div/div/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[2]/a"))
				.click();

		List<WebElement> listOfRows = driver.findElements(
				By.xpath("//table[starts-with(@summary,'Case Forms for ')]/tbody/tr[*]/td[2]/table/tbody/tr[1]/td/b"));

		List<String> forms = new ArrayList<String>();

		for (int i = 0; i < listOfRows.size(); i++) {

			String formName = listOfRows.get(i).getText();
			forms.add(formName);

			System.out.println(forms);

		}

		int form_index = forms.lastIndexOf("I-140");

		String xpath1 = "//table[starts-with(@summary,'Case Forms for ')]/tbody/tr[";

		int xpath2 = form_index + 3;

		String xpath3 = "]/td[4]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/select/option[4]";

		String string4 = xpath1 + xpath2 + xpath3;

		driver.findElement(By.xpath(string4)).click();;

//		driver.quit();

	}

}
