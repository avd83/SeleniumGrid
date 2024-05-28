import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class dib {

	public static void main(String[] args) {
		
		System.setProperty("WebDriver.chrome.Driver", "/15dec22_laptop/Selenium/Setup/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//To open Flight Booking Website
				driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
				//System.out.println(driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).isSelected());
				//boolean status = driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).isSelected();
				//Assert.assertTrue(status,"Checkbox is selected");
				driver.findElement(By.cssSelector("input[name='ctl00$mainContent$chk_SeniorCitizenDiscount']")).click();
				boolean status = driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).isSelected();
				Assert.assertFalse(status,"Checkbox is selected");
				driver.quit();
	}

}
