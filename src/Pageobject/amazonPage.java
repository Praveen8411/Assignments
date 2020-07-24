package Pageobject;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class amazonPage {
	WebDriver driver;
	
	//public static By link = By.xpath("//a[contains(text(),'Gmail')]");

	public static By searchBox = By.xpath("//input[@id='twotabsearchtextbox']");
	public static By goButton = By.xpath("//input[@value='Go']");
	public static By price = By.xpath("//span[@class='a-price-whole']");
	//public static By horizontalView = By.xpath("//ol[@class='a-carousel']");
	//public static By hv1 = By.xpath("//div[@class='s-include-content-margin s-border-bottom s-border-top-overlap']");
	public static By freedel = By.xpath("//span[@aria-label='FREE Delivery by Amazon']");
	public static By nxtbtn = By.xpath("//a[@class='a-link-normal a-carousel-goto-nextpage s-carousel-button']");
	

    public amazonPage(WebDriver driver){

        this.driver = driver;

    }
    
public void mobileSearch() {
		
		driver.findElement(searchBox).sendKeys("mobile");
		driver.findElement(goButton).click();	
	}

public void getAllPrice() {
	
	List<WebElement> value = driver.findElements(price);
	int sum = 0;
	int totNum = (value.size());
	for(WebElement li:value)
	{
	if(li.getText().equals("")) {
		totNum=totNum-1;
		continue;
		
	}
		//System.out.println(li.getText());
        String s = li.getText().replace(",", "");
        sum = sum + Integer.parseInt(s);
        //value.stream().skip(nxtbtn);
		}
        

	
	
	System.out.println(sum);
	System.out.println(totNum);
	
	int avg = sum/ totNum;
	System.out.println(avg);
	
	 
	
	
	
	/*List<String> main_array = new ArrayList<>();
	
	//List<String> addition = new List<String>();
	
	//String add;
	
    for (int i = 0; i <value.size(); i++)

    {
     main_array.add(value.get(i).getText());
 
     //addition += main_array[i];
    }
    System.out.println(main_array);
    
    //return addition; 
    }

  
  /*+ addition ;
   // int sum = MathUtils.sum(main_array);

    }
    
    */
	
}
}

    

