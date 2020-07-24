package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pageobject.UpworkPage;

public class UpworkTest {
	private UpworkPage up;
	WebDriver driver;
	private String domainName;
	
	@BeforeTest	
	public void setup(){
		    //driver = new FirefoxDriver();
	    	/*System.setProperty("webdriver.gecko.driver", "E:\\geckodriver.exe");
	    	driver.get("https://www.upwork.com/");
	    	up = new UpworkPage(driver);
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 	        driver.manage().window().maximize();
 	        domainName = "qa";*/
		System.setProperty("webdriver.firefox.profile", "E:\\geckodriver.exe");
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability("marionette", true);
				WebDriver driver = new FirefoxDriver(capabilities);
				driver.get("www.google.com");
	    }
	
	@Test(priority=1)
	public void sendDomainName() {
		up.searchFreeLancers(domainName);
		up.getAllTitles();
	}

}
