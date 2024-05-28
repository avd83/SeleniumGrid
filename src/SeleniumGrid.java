import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGrid {

	public static void main(String[] args) throws MalformedURLException {
				
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("chrome");
		caps.setPlatform(Platform.WIN10);
		//caps.setCapability(CapabilityType.PLATFORM_NAME, "WIN10");
		
		ChromeOptions options = new ChromeOptions();// use for customized chrome driver session
		options.merge(caps);
		
		String url = "http://192.168.1.205:4444";
		WebDriver driver = new RemoteWebDriver(new URL(url),options);
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		
		driver.quit();
	}
}
