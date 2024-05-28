package sauceLabsDemo;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;

import com.beust.jcommander.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SausceLabDemo {

			WebDriver driver;	
				
			@Parameters({"browser", "platform", "version"})	
			@BeforeMethod	
			public void setUp(String browserName, String platformName, String versionName, Method name) {	
				
				System.out.println("Browser name is : " + browserName);
				String methodName = name.getName();
				
				MutableCapabilities sauceOpts = new MutableCapabilities();
				sauceOpts.setCapability("name", methodName);
				sauceOpts.setCapability("build", "Java-W3C-Examples");
				sauceOpts.setCapability("seleniumVersion", "3.141.59");
				sauceOpts.setCapability("username", "naveenanimation20");
				sauceOpts.setCapability("accessKey", "f418309b-b7b4-424d-825c-0d4a78b90bb5");
				sauceOpts.setCapability("tags", "w3c-chrome-tests");
				
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability("sauce:options", sauceOpts);
				cap.setCapability("browserVersion", versionName);
				cap.setCapability("platformName", platformName);
				
				if (browserName.equals("chrome")) {						
					WebDriverManager.chromedriver().setup();					
					cap.setCapability("browserName", "chrome");					
				} else if (browserName.equals("firefox")) {						
					WebDriverManager.firefoxdriver().setup();					
					cap.setCapability("browserName", "firefox");					
				}						
				// https://naveenanimation20:f418309b-b7b4-424d-825c-0d4a78b90bb5@ondemand.us-west-1.saucelabs.com:443/wd/hub						
				try {						
					driver = new RemoteWebDriver(new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub"), cap);					
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);					
				} catch (MalformedURLException e) {						
					e.printStackTrace();					
				}										
			}							
	}