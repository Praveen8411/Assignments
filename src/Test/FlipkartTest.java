package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pageobject.FlipkartPage;

public class FlipkartTest {
	
	private FlipkartPage fp;
	private String name; 

	WebDriver driver;

	@BeforeTest	
	public void setup(){
	    	System.setProperty("webdriver.chrome.driver", "E:\\cd\\chromedriver.exe");
	    	driver = new ChromeDriver();
	    	fp = new FlipkartPage(driver);
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.get("https://www.flipkart.com/");
		    driver.manage().window().maximize();
		    name = "Books";
	    }
	
	@Test(priority=1)
	public void searchingBooks() throws Exception{
		fp.searchBooks(name);
		fp.storeData();
	}
}
