package browserStackDemo;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;

import com.beust.jcommander.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserStackDemo {
	
		public static final String USERNAME = "naveennyoutube1";	
		public static final String AUTOMATE_KEY = "x4jxqdPfi257ZAxucwbv";	
		public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";	
		WebDriver driver;
		
		@Parameters({"browser", "browser_version", "os", "os_version"})	
		@BeforeMethod	
		public void setUp(String browserName, String browser_version, String os, String os_version,  Method name) {	
			
			System.out.println("browser name is : " + browserName);
			String methodName = name.getName();
			
			DesiredCapabilities caps = new DesiredCapabilities();
			
			caps.setCapability("os", os);
			caps.setCapability("os_version", os_version);
			caps.setCapability("browser_version", browser_version);
			caps.setCapability("name", methodName);
			
			if (browserName.equals("Chrome")) {						
				WebDriverManager.chromedriver().setup();					
				caps.setCapability("browser", "Chrome");					
			} else if (browserName.equals("Firefox")) {						
				WebDriverManager.firefoxdriver().setup();					
				caps.setCapability("browser", "Firefox");					
			}						
			try {						
				driver = new RemoteWebDriver(new URL(URL), caps);					
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);					
			} catch (MalformedURLException e) {						
				e.printStackTrace();					
			}									
		}
}