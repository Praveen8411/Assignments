package Pageobject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpworkPage {
	WebDriver driver;
	
	public static By searchField=By.xpath("//div[@class='navbar-collapse d-none d-lg-flex sticky-sublocation']//input[@class='form-control']");
	public static By searchIcon = By.xpath("//div[@class='navbar-collapse d-none d-lg-flex sticky-sublocation']//span[@class='glyphicon air-icon-search m-sm-left m-0-right']");
	public static By title = By.xpath("//strong[@data-qa='tile_title']");
	
	public UpworkPage(WebDriver driver){

        this.driver = driver;

    }
	
	public void searchFreeLancers(String name) {
		driver.findElement(searchField).sendKeys(name);
		driver.findElement(searchIcon).click();
		
	}
	
	public void getAllTitles() {
		
		 List<WebElement> ListTitles = driver.findElements(title);

		    List<String> all_elements_text=new ArrayList<>();

		    for(int i=0; i<ListTitles.size(); i++){

		        //loading text of each element in to array all_elements_text
		        all_elements_text.add(ListTitles.get(i).getText());

		        //to print directly
		        System.out.println(ListTitles.get(i).getText());

		    }
			
		}
		
}
