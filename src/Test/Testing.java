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

     /*  public String extractDataWithSelenium(String url) throws IOException {

 

              System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");

 

              WebDriver driver = new ChromeDriver();

              driver.get("http://www.amazon.in");

              WebElement w1 = driver.findElement(By.id("searchDropdownBox"));

              WebElement w2 = driver.findElement(By.id("twotabsearchtextbox"));

              w2.sendKeys("one plus 7");

              WebElement w3 = driver.findElement(By.className("nav-input"));

              w3.click();

             

              /*

              * List<WebElement> anchors = driver.findElements(By.tagName("a"));

              * Iterator<WebElement> i = anchors.iterator();

              *

               * while(i.hasNext()) { WebElement anchor = i.next();

              * if(anchor.getAttribute("href").contains(href)) { anchor.click(); break; } }

              */

                                 

              //@SuppressWarnings("unchecked")

 

             

      

      /* File file = new File("C:\\Users\\yewalpri\\Desktop\\test.txt"); // Your file

       FileOutputStream fos = new FileOutputStream(file);

       PrintStream ps = new PrintStream(fos);

       System.setOut(ps);

 

       String specifiers = "%-120s %-30s %-30s %n";

       System.out.format(specifiers,"Phone name", "Phone Price", "Ratings" );

       System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------" );

      

       List<WebElement> main_span =driver.findElements(By.xpath("//div[contains(@class,'sg-col-inner')]"));

       List<WebElement> class_span = driver.findElements(By.xpath("//span[contains(@class,'a-size-medium a-color-base a-text-normal')]"));

       List<WebElement> price_span = driver.findElements(By.xpath("//span[contains(@class,'a-price-whole')]"));

       List<WebElement> rating_span =driver.findElements(By.xpath("//span[contains(@class,'a-icon-alt')]"));

      

       List<String> main_array = new ArrayList<>();

       for (int i = 0; i <main_span.size(); i++)

       {

       main_array.add(class_span.get(i).getText());

       main_array.add(price_span.get(i).getText());

       main_array.add(rating_span.get(i).getText());

        System.out.format(specifiers,class_span.get(i).getText(),price_span.get(i).getText(),rating_span.get(i).getText());

       }

      

       return url;

 

}

      

       private char[] toString(String text) {

              // TODO Auto-generated method stub

              return null;

       }

 

       private float getText() {

              // TODO Auto-generated method stub

              return 0;

       }

 

       public static void main(String[] args) throws IOException {

              // TODO Auto-generated method stub

              Testing test = new Testing();

              String webData = test.extractDataWithSelenium("http://www.amazon.in");

 

       }

 

}*/

 

