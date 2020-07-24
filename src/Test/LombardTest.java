package Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pageobject.LombardPage;
import Pageobject.SendMail;

public class LombardTest {
	
	LombardPage lp;
	WebDriver driver;
	
	@BeforeTest	
	public void setup(){
	    	System.setProperty("webdriver.chrome.driver", "E:\\cd\\chromedriver.exe");
	    	driver = new ChromeDriver();
	    	lp = new LombardPage(driver);
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.get("https://www.icicilombard.com/campaigns/health-insurance/health-insurance-pune");
 	        driver.manage().window().maximize();
	    }
	
	@Test(priority=1)
	public void createExcelFile() throws Exception {
		try {
		XSSFWorkbook wb = new XSSFWorkbook();			
		FileOutputStream out = new FileOutputStream(new File("G:\\Assignment\\Automation\\TestData\\Healthinsurance01.xlsx"));  
		wb.write(out);
		out.close();
		}
		catch(Exception e){

			System.out.println(e);
	}
		System.out.println("Excel file created");

}
	@Test(priority=1)
	public void hopitalNames() throws Exception {
		lp.fetchListOfPunehostpitals();
		lp.mumbaiHospitals();
		lp.compareExcel();
 	}
}