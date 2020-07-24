package Pageobject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;

public class LombardPage {
	
	 WebDriver driver;
	 final String username = "praveen.mane890@gmail.com";
	 final String password = "Selenium@123";

	 XSSFWorkbook wb = new XSSFWorkbook();
	 XSSFWorkbook wb1 = null;
	 String beforeXpath_hospital = "//*[@id='HospitalList']/tbody/tr[";
	 String afterXpath_hospital = "]/td[2]";
	 
	 String beforeXpath_addrs = "//*[@id='HospitalList']/tbody/tr[";
	 String afterXpath_addrs = "]/td[3]";
	 
	 String beforeXpath_city = "//*[@id='HospitalList']/tbody/tr[";
	 String afterXpath_city = "]/td[4]";
	 
	 String beforeXpath_state = "//*[@id='HospitalList']/tbody/tr[";
	 String afterXpath_state = "]/td[5]";
	 
	 String beforeXpath_contact = "//*[@id='HospitalList']/tbody/tr[";
	 String afterXpath_contact = "]/td[6]";
	 
	 File src = new File ("G:\\Assignment\\Automation\\TestData\\Healthinsurance01.xlsx");
	 
	public static By searchBox = By.xpath("//a[@id='Campaign1_C017_LnkSearch']");
	public static By selectState = By.xpath("//div[@class='state title']");
	public static By selectCity = By.xpath("//div[@class='city title']");
	public static By city = By.xpath("//a[@rel='pune']");
	public static By selectStateFromDropDown = By.xpath("//li//a[contains(text(),'Select State')]");
	public static By hospitalList = By.xpath("//table[@id='HospitalList']//tr");
	
	 public LombardPage(WebDriver driver){

	        this.driver = driver;
	    }
	 
	public void fetchListOfPunehostpitals() throws Exception{ 
		 driver.findElement(searchBox).click();
		 Thread.sleep(3000);
		 
		 List<WebElement> rows = driver.findElements(hospitalList);
		 System.out.println("total number of rows = " + rows.size());
		 int rowCount = rows.size();
		 
		 FileOutputStream out = new FileOutputStream(src);
		 XSSFSheet sh = wb.createSheet("Punelist");
		 Thread.sleep(2000);
	
	     sh.createRow(0).createCell(0).setCellValue("Hospital Name");
		 sh.getRow(0).createCell(1).setCellValue("Address");
		 sh.getRow(0).createCell(2).setCellValue("City");
		 sh.getRow(0).createCell(3).setCellValue("State");
		 sh.getRow(0).createCell(4).setCellValue("Contact");
		 
		
        
				 for(int i=1; i<rowCount; i++){
				 	String actualXpath_hopital = beforeXpath_hospital+i+afterXpath_hospital;
				 	String hospitalName = driver.findElement(By.xpath(actualXpath_hopital)).getText();
				 	System.out.println(hospitalName);
				 	sh.createRow(i).createCell(0).setCellValue(hospitalName);
				 	
					String actualXpath_address = beforeXpath_addrs+i+afterXpath_addrs;
				 	String addressName = driver.findElement(By.xpath(actualXpath_address)).getText();
				 	System.out.println(addressName);
				 	sh.getRow(i).createCell(1).setCellValue(addressName);
				 	
				 	String actualXpath_city = beforeXpath_city+i+afterXpath_city;
				 	String city = driver.findElement(By.xpath(actualXpath_city)).getText();
				 	System.out.println(city);
				 	sh.getRow(i).createCell(2).setCellValue(city);
				 	
				 	String actualXpath_state = beforeXpath_state+i+afterXpath_state;
				 	String state = driver.findElement(By.xpath(actualXpath_state)).getText();
				 	System.out.println(state);
				 	sh.getRow(i).createCell(3).setCellValue(state);
				 	
				 	String actualXpath_contact = beforeXpath_contact+i+afterXpath_contact;
				 	String contact = driver.findElement(By.xpath(actualXpath_contact)).getText();
				 	System.out.println(contact);
				 	sh.getRow(i).createCell(4).setCellValue(contact);
				 }
				 wb.write(out);
	 }
	
	public void mumbaiHospitals() throws Exception {
		 driver.get("https://www.icicilombard.com/cashless-hospitals");
		 selectStateValues();
		 selectCityValues();
		 Thread.sleep(3000);
		 List<WebElement> rows = driver.findElements(hospitalList);
		 System.out.println("total number of rows = " + rows.size());
		 int rowCount1 = rows.size();
		 
		 FileOutputStream out = new FileOutputStream(src);
		 XSSFSheet sh1 = wb.createSheet("MumbaiList");
		 
		 sh1.createRow(0).createCell(0).setCellValue("Hospital Name");
		 sh1.getRow(0).createCell(1).setCellValue("Address");
		 sh1.getRow(0).createCell(2).setCellValue("City");
		 sh1.getRow(0).createCell(3).setCellValue("State");
		 sh1.getRow(0).createCell(4).setCellValue("Contact");
		 
		 for(int j=1; j<rowCount1; j++) {
			 	String actualXpath_hopital = beforeXpath_hospital+j+afterXpath_hospital;
			 	String hospitalName = driver.findElement(By.xpath(actualXpath_hopital)).getText();
			 	System.out.println(hospitalName);
			 	sh1.createRow(j).createCell(0).setCellValue(hospitalName);
			 	
				String actualXpath_address = beforeXpath_addrs+j+afterXpath_addrs;
			 	String addressName = driver.findElement(By.xpath(actualXpath_address)).getText();
			 	System.out.println(addressName);
			 	sh1.getRow(j).createCell(1).setCellValue(addressName);
			 	
			 	String actualXpath_city = beforeXpath_city+j+afterXpath_city;
			 	String city = driver.findElement(By.xpath(actualXpath_city)).getText();
			 	System.out.println(city);
			 	sh1.getRow(j).createCell(2).setCellValue(city);
			 	
			 	String actualXpath_state = beforeXpath_state+j+afterXpath_state;
			 	String state = driver.findElement(By.xpath(actualXpath_state)).getText();
			 	System.out.println(state);
			 	sh1.getRow(j).createCell(3).setCellValue(state);
			 	
			 	String actualXpath_contact = beforeXpath_contact+j+afterXpath_contact;
			 	String contact = driver.findElement(By.xpath(actualXpath_contact)).getText();
			 	System.out.println(contact);
			 	sh1.getRow(j).createCell(4).setCellValue(contact);
		 }
		 wb.write(out);
	}
	 
	 public void selectStateValues() throws Exception {
		 String option = "Maharashtra";
		driver.findElement(selectState).click();
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='sbOptions']/li"));
				for (WebElement opt : options) {
		            if (opt.getText().equals(option)) {
		                opt.click();
		                return;
		            }
		        }
		        throw new NoSuchElementException("Can't find " + option + " in dropdown");
		}
	
	 public void selectCityValues() throws Exception {
		 String option = "Mumbai";
		 Thread.sleep(2000);
		driver.findElement(selectCity).click();
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.xpath("//div[@class='city title']//ul[@class='sbOptions']/li"));
				for (WebElement opt : options) {
		            if (opt.getText().equals(option)) {
		                opt.click();
		                return;
		            }
		        }
		        throw new NoSuchElementException("Can't find " + option + " in dropdown");
		
	 }
	 
	public void compareExcel() throws Exception {
		 Sheet sheet1= wb.getSheet("Punelist");
		 Sheet sheet2= wb.getSheet("MumbaiList");

		 int rowCounts = sheet1.getLastRowNum()-sheet1.getFirstRowNum();
		 int rowCountsh = sheet2.getLastRowNum()-sheet2.getFirstRowNum();
		 String comarr[] = new String[rowCounts+1];
		 
		 FileOutputStream out = new FileOutputStream(src);
		 XSSFSheet sh2 = wb.createSheet("CommonNames");
		 sh2.createRow(0).createCell(0).setCellValue("Same Hospital Names");
		 int k=1;
		 for (int i = 1; i < rowCounts+1; i++)
		 {
		         Row row1 = sheet1.getRow(i);
		         String s1 = row1.getCell(0).getStringCellValue();
		                 for (int j = 1; j < rowCountsh+1; j++)
		                 {
		                	 Row row2 = sheet2.getRow(j);
		                	 String s2 = row2.getCell(0).getStringCellValue();
		                	 Thread.sleep(2000);
		                                 if (s1.equals(s2))
		                                 { 
		                                    sh2.createRow(k).createCell(0).setCellValue(s1);
		                                    comarr[k] = s1;
		                                    
		                                    k++; 
		                                 }           
		                 }  
		 }
		 System.out.println("common started------");
		 String theString = Arrays.toString( comarr );
		 String commonData = theString.replace("null,", "").replaceAll(",", "\n").replace("[", "").replace("null]", "");
		 System.out.println( commonData );
				
		 wb.write(out);
		 Thread.sleep(2000);
		 sendMail(commonData);
	 }
	
	 public void sendMail(String commonData) {
		Properties props = new Properties();
        props.put("mail.smtp.host" , "smtp.gmail.com");
        props.put("mail.stmp.user" , username);

        props.put("mail.smtp.auth", "true"); 
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.password", password);
 
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", 
            "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        
        Session session = Session.getDefaultInstance(props, 
        	    new javax.mail.Authenticator(){
        	        protected PasswordAuthentication getPasswordAuthentication() {
        	            return new PasswordAuthentication(
        	            		username, password);// Specify the Username and the PassWord
        	        }
        	});
        String to = "dhanesh.bhansali@thinkitive.com";
        String from = "praveen.mane890@gmail.com";
        String subject = "List of common hospitals";
        Message msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(from));
            msg.setRecipient(Message.RecipientType.TO, 
                new InternetAddress(to));
            msg.setSubject(subject);
            msg.setText(commonData);
          
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com" , 465 , username, password);
            transport.send(msg);
            System.out.println("fine!!");
        }
        catch(Exception exc) {
            System.out.println(exc);
        }
	}
}
