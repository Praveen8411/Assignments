package Pageobject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Googlepage {
	
	WebDriver driver;

    //By homePageUserName = By.xpath("//table//tr[@class='heading3']");
	public static By link = By.xpath("//a[contains(text(),'Gmail')]");
	public static By privacy = By.xpath("//a[@aria-label='Privacy']");
	public static By terms = By.xpath("//a[@aria-label='Terms']");
	public static By aboutGoogle = By.xpath("//a[@aria-label='About Google']");

    

    public Googlepage(WebDriver driver){

        this.driver = driver;

    }
    
    public void gmailLink() throws InterruptedException {
    	
    	driver.findElement(link).click();
    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
    	driver.manage().window().maximize();
    }
    
    public void footerLink() throws InterruptedException {
    	
    	driver.findElement(privacy).click();
    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
    	windowHandle();
    	
    }
    
    public void Terms() throws InterruptedException {
    	
    	driver.findElement(terms).click();
    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
    	windowHandle();
    }
    
    public void About() throws InterruptedException {
    	
    	driver.findElement(aboutGoogle).click();
    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
    	windowHandle();
    }
    
    public void handleWin() {
    	
    	windowHandles();
    }
    
    public void windowHandle() {
        Set<String> handlesSet = driver.getWindowHandles();
        List<String> handlesList = new ArrayList<String>(handlesSet);
        driver.switchTo().window(handlesList.get(0));
        //driver.close();
        //driver.switchTo().window(handlesList.get(1));
	}
    
    public void windowHandles() {
        Set<String> handlesSet = driver.getWindowHandles();
        ArrayList<String> handlesList = new ArrayList<String>(handlesSet);
        driver.switchTo().window(handlesList.get(1));
        driver.close();
        driver.switchTo().window(handlesList.get(2));
        driver.close();
        driver.switchTo().window(handlesList.get(3));
        driver.close();
        driver.switchTo().window(handlesList.get(0));
        driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS) ;
        driver.close();
        
    }
	

}
