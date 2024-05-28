import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirefoxTest {
	
	public void CrickbuzzPageCheck() throws MalformedURLException
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("firefox");
		
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.203:4444"),caps);
		driver.get("http://cricbuzz.com");
		System.out.println(driver.getTitle());
		
		driver.close();		
	}
}