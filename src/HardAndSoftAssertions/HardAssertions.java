package HardAndSoftAssertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class HardAssertions {
	
	@Test
	public void testFacebook() {
		System.setProperty("WebDriver.chrome.driver", "/15dec22_laptop/Selenium/Setup/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Facebook – log in or sign up";
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle,"This is title message ");//hard assert due to this next step not executed
		driver.quit();
	}
}
