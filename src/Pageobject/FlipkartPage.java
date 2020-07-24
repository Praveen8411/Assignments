package Pageobject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlipkartPage {
	
	WebDriver driver;
	 
	public static By searchBox = By.xpath("//input[@class='LM6RPg']");
	public static By searchIcon = By.xpath("//button[@class='vh79eN']");
	public static By allBookNames = By.xpath("//a[@class='_2cLu-l']");
	public static By allAuthorNames = By.xpath("//div[@class='_1rcHFq']");
	public static By beforePrice = By.xpath("//div[@class='_3auQ3N']");
	public static By afterPrice = By.xpath("//div[@class='_1vC4OE']");
	public static By ratings = By.xpath("//span[@class='_2_KrJI']");
	public static By cancelButton = By.xpath("//button[@class='_2AkmmA _29YdH8']");
	
	public static By unique = By.xpath("//div[@class='_1uv9Cb']");
	
	public FlipkartPage(WebDriver driver){
		
        this.driver = driver;
	}
	
	public void searchBooks(String name) {
		driver.findElement(cancelButton).click();
		driver.findElement(searchBox).sendKeys(name);
		driver.findElement(searchIcon).click();
	}
	
	/*public void storeData() {
		List<WebElement> listOfBooks = driver.findElements(allBookNames);
		List<WebElement> listOfAuthors = driver.findElements(allAuthorNames);
		List<WebElement> listOfRatings = driver.findElements(ratings);
		List<WebElement> listOfBeforePrice = driver.findElements(beforePrice);
		List<WebElement> listOfNewPrice = driver.findElements(afterPrice);
		
		ArrayList<String> Books = new ArrayList<String>();
		ArrayList<String> Authors = new ArrayList<String>();
		ArrayList<String> Ratings = new ArrayList<String>();
		ArrayList<String> oldPrice = new ArrayList<String>();
		ArrayList<String> newPrice = new ArrayList<String>();
		
		
		for(int i=0; i<listOfBooks.size(); i++) 
		{
			Books.add(listOfBooks.get(i).getText());
			Authors.add(listOfAuthors.get(i).getText());
			newPrice.add(listOfNewPrice.get(i).getText());
		}
		
		/*int j = listOfBooks.size();
		List<String> Ratings = Arrays.asList(new String[j]);
		List<String> oldPrice = Arrays.asList(new String[j]);
			
		for(int i=0; i<listOfBooks.size(); i++) 
		{
			System.out.println(listOfRatings.get(i).getText());
			Ratings.add(listOfRatings.get(i).getText());
			oldPrice.add(listOfBeforePrice.get(i).getText());
		}
		
		for(int i=0; i<listOfRatings.size(); i++) 
		{
			Ratings.add(listOfRatings.get(i).getText());
		}
			
		for(int i=0; i<listOfBeforePrice.size(); i++) 
		{
			oldPrice.add(listOfBeforePrice.get(i).getText());
		}
		
		pageDescription(Books, Authors, Ratings, oldPrice, newPrice);
	}*/
	
	public void storeData() {
		List<WebElement> listOfBooks = driver.findElements(allBookNames);
		List<WebElement> listOfAuthors = driver.findElements(allAuthorNames);
		List<WebElement> listOfRatings = driver.findElements(ratings);
		List<WebElement> listOfBeforePrice = driver.findElements(beforePrice);
		List<WebElement> listOfNewPrice = driver.findElements(afterPrice);
		List<WebElement> listOfPrice = driver.findElements(unique);
		
		
		ArrayList<String> BooksName = new ArrayList<String>();
		
		for(int i=0; i<listOfBooks.size(); i++) 
		{
			BooksName.add(listOfBooks.get(i).getText());
			BooksName.add(listOfAuthors.get(i).getText());
			BooksName.add(listOfRatings.get(i).getText());
			BooksName.add(listOfPrice.get(i).getText());
		}
		
	    System.out.println(BooksName);
	   	
	   String testString = listOfPrice.get(0).getText();
	   String[] testString1 = testString.split("\\");
	    System.out.println (testString1);
	
	}
	
	public void pageDescription(List<String>Books, List<String>Authors, List<String>Ratings, List<String>oldPrice, List<String>newPrice)
	{
		System.out.println(oldPrice );
		/*for (int i =0 ; i<Books.size(); i++)
		 {   
			 String b = Books.get(i);
			 String a = Authors.get(i);
			 String n = newPrice.get(i);
		 } 
		for (int i =0 ; i<Ratings.size(); i++)
		 {  
			 String r = Ratings.get(i);
		 }
		for (int i =0 ; i<oldPrice.size(); i++)
		 {  
			 String o = oldPrice.get(i);
		 }
		System.out.println(b+ "\n" +a+ "\n" +r);*/
		
		
		//StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 40; i++) 
		{
			  if (Books.size() > i) 
			  {
				String b = Books.get(i);
				System.out.println(b+ "\n" );
			  }
			
			if (Authors.size() > i) 
			  {
				String a = Authors.get(i);
				System.out.println(a+ "\n" );
			  }
		
			if (Ratings.size() > i)
			{
				String r = Ratings.get(i);
				System.out.println(r+ "\n" );
		 	}	 
			else 
			{
				String r = "NA";
				System.out.println(r+ "\n" );
			}

			if (oldPrice.size() > i)
			{
				String o = oldPrice.get(i);
				System.out.println(o+ "\n" );
		 	}	 
			else 
			{
				String o = "NA";
				System.out.println(o+ "\n" );
			}
			
		  if (newPrice.size() > i) 
		  {
			  String  n = newPrice.get(i);
			  System.out.println(n+ "\n" );
		  }
		  
		}

		//System.out.println(sb.toString());
		
	}
	}


