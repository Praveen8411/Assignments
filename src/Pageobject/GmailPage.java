package Pageobject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GmailPage {

	 WebDriver driver;
	 
		public static By allImg = By.xpath("//img"); 
		public GmailPage(WebDriver driver){

	        this.driver = driver;

	    }
		
		public void storeImages() throws Exception {
			List<WebElement> logo = driver.findElements(allImg);
			Thread.sleep(2000);
			for(int i=0;i<logo.size();i++)
			{
			 String logoSRC = logo.get(i).getAttribute("src");
			 System.out.println(logoSRC);
			 if(logoSRC.contains("https://lh3.googleusercontent.com/"))
			 {
				 URL imageURL = new URL(logoSRC);
				 System.out.println(imageURL);
				 BufferedImage saveImage = ImageIO.read(imageURL);
				 Thread.sleep(2000);
				 ImageIO.write(saveImage, "png", new File("E:\\allImages", "pic" +i+ ".png"));
			 }
			 
			}
		}

}
