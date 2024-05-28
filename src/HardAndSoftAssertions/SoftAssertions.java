package HardAndSoftAssertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertions {

	@Test
	public void testFacebook() {
		System.setProperty("WebDriver.chrome.driver", "/15dec22_laptop/Selenium/Setup/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		SoftAssert softassert = new SoftAssert();//soft assert class object create 
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Facebook – log in or sign up";
		System.out.println(actualTitle);		
		softassert.assertEquals(actualTitle, expectedTitle,"This title message is missmatched  ");//soft assert due to this next step should be executed	
		
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.facebook.com/";
		System.out.println(actualUrl);		
		softassert.assertEquals(actualUrl, expectedUrl,"This url is missmatched  ");
		
		String actualText = driver.findElement(By.xpath("//input[@name='email']")).getAttribute("Value");
		String expectedText = "";
		System.out.println(actualText);		
		softassert.assertEquals(actualText, expectedText,"This text is missmatched  ");
		
		driver.quit();
		softassert.assertAll();//to record all assert after full execution of all code till end 
	}
}
