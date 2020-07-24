package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pageobject.amazonPage;

public class Testing  {
	WebDriver driver;
	amazonPage ap;
	
	@BeforeTest	
	public void setup(){
	    	
	    	System.setProperty("webdriver.chrome.driver", "E:\\cd\\chromedriver.exe");
	    	WebDriver driver = new ChromeDriver();
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.get("https://www.amazon.in");
	        ap = new amazonPage(driver);
 	        driver.manage().window().maximize();

	        
	    }
	
	@Test(priority=0)
	public void MP()
	{
		ap.mobileSearch();
		ap.getAllPrice();
		
	}
	
}

     

 

