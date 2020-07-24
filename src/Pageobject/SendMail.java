package Pageobject;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.WebDriver;

public class SendMail {
	WebDriver driver;
	final String username = "praveen.mane890@gmail.com";
	final String password = "Selenium@123";

	
	
	public SendMail(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public void setUP() {
		Properties props = new Properties();
        props.put("mail.smtp.host" , "smtp.gmail.com");
        props.put("mail.stmp.user" , username);

        //To use TLS
        props.put("mail.smtp.auth", "true"); 
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.password", password);
        //To use SSL
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
        String to = "praveen.mane@thinkitive.com";
        String from = "praveen.mane890@gmail.com";
        String subject = "Testing...";
        Message msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(from));
            msg.setRecipient(Message.RecipientType.TO, 
                new InternetAddress(to));
            msg.setSubject(subject);
            // Create another object to add another content
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();
            String filename = "G:\\Assignment\\Automation\\TestData\\Healthinsurance01.xlsx";
            // Create data source and pass the filename
            DataSource source = new FileDataSource(filename);
            // set the handler
            messageBodyPart2.setDataHandler(new DataHandler(source));
            // set the file
            messageBodyPart2.setFileName(filename);
            // Create object of MimeMultipart class
            Multipart multipart = new MimeMultipart();
            // add body part 1
            multipart.addBodyPart(messageBodyPart2);
            msg.setContent(multipart);

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
