package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pageobject.GmailPage;

public class GmailTest {
	
private GmailPage gp;
WebDriver driver;

@BeforeTest	
public void setup(){
    	System.setProperty("webdriver.chrome.driver", "E:\\cd\\chromedriver.exe");
    	driver = new ChromeDriver();
    	gp = new GmailPage(driver);
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/gmail/about/#");
	    driver.manage().window().maximize();
    }

@Test(priority=1)
public void saveImage() throws Exception{
	gp.storeImages();
}

}

