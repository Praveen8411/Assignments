package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pageobject.Googlepage;

public class Switchwindow {
	
	Googlepage gp;
	
	WebDriver driver;


    @BeforeTest

    public void setup(){
    	
    	System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://google.com");
        gp = new Googlepage(driver);

    }
    
    @Test(priority=0)
    public void clickonLinks() throws InterruptedException {
    	
    	gp.gmailLink();
    	gp.footerLink();
    	gp.Terms();
    	gp.About();
    	
    	
    }
    
    @Test(priority=1)
    public void manageWindows() {
    	
    	gp.handleWin();
    }

}
