package BudsLogin;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationRegulator {

	public static void main(String[] args) throws Throwable {

		ChromeDriver driver = new ChromeDriver();
	//	driver.manage().window().maximize();
		
		
		driver.get("http://dev.niyamitnivesh.in/");
        Thread.sleep(2000);   

        // Click on the 'Register' button
        driver.findElement(By.xpath("//div[contains(@class,'leading-normal')][normalize-space()='Register']")).click();
        Thread.sleep(2000);   

        driver.findElement(By.xpath("//label[normalize-space()='Regulator']")).click();
        // Click on the 'Submit' button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000); 
		
		
		
		
        Thread.sleep(2000);   
       driver.findElement(By.xpath("//body//div//div//div//div//div//div//div//div//div//div[1]//div[1]//button[1]")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//a[normalize-space()='SEBI']")).click();
       Thread.sleep(2000);
       
       driver.findElement(By.xpath("//button[normalize-space()='Save & Continue']")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//img[@alt='Upload']")).click();
       Thread.sleep(4000);
       WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
       String filePath = "/Users/ankitkumar/eclipse-workspace/BudsApplication/pdffile/Dummy PDF download - dummy-pdf_2.pdf";
       fileInput.sendKeys(filePath);
       Thread.sleep(3000);
	driver.findElement(By.xpath("//button[normalize-space()='Save & Continue']")).click();
	  
	Thread.sleep(3000);
	  
	driver.findElement(By.xpath("//input[@id='Nodal Officer First Name']")).sendKeys("Abhishek");
	driver.findElement(By.xpath("//input[@id='Nodal Officer Middle Name']")).sendKeys("ku");
	
	driver.findElement(By.xpath("//input[@id='Nodal Officer Last Name']")).sendKeys("m");
	driver.findElement(By.xpath("//input[@id='Nodal Officer Email']")).sendKeys("testdarkscenario@gmail.com");
	driver.findElement(By.xpath("//input[@id='Nodal Officer Mobile Number']")).sendKeys("9155222638");
	Thread.sleep(1000);
	
	
	WebElement fileInput1 = driver.findElement(By.xpath("//input[@type='file']"));
    String projectDirectory = System.getProperty("user.dir");
    String filePath1 = projectDirectory + "/DSCDocumnets/cert_Protean-GP_Bangalore.crt";
    fileInput1.sendKeys(filePath1);
    
    Thread.sleep(2000);
	driver.findElement(By.xpath("//button[normalize-space()='Save & Review']")).click();
	
	Thread.sleep(4000);
	driver.findElement(By.xpath("//div[@class='p-3']//div[2]//input[1]")).sendKeys("0");
	driver.findElement(By.xpath("//div[@class='p-3']//div[2]//input[2]")).sendKeys("0");
	driver.findElement(By.xpath("//div[@class='p-3']//div[2]//input[3]")).sendKeys("0");
	driver.findElement(By.xpath("//div[@class='p-3']//div[2]//input[4]")).sendKeys("0");
	driver.findElement(By.xpath("//div[@class='p-3']//div[2]//input[5]")).sendKeys("0");
	driver.findElement(By.xpath("//div[@class='p-3']//div[2]//input[6]")).sendKeys("0");

	
	}
	
	
	
	

}