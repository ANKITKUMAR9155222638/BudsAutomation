package BudsPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DT_REGISTRATION {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

        WebDriver driver = new ChromeDriver();
    //    driver.manage().window().maximize();
		
		
		
		
		
		 // Navigate to the BUDS portal
        driver.get("http://dev.niyamitnivesh.in/");
        Thread.sleep(4000);   

        // Click on the 'Register' button
        driver.findElement(By.xpath("//div[contains(@class,'leading-normal')][normalize-space()='Register']")).click();
        Thread.sleep(4000);   

        // Click on the 'Submit' button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(4000);   

        // Enter company name and PAN number
        driver.findElement(By.xpath("//input[@id='Company Name (As per PAN)']")).sendKeys("SANJEET KUMAR");
        driver.findElement(By.xpath("//input[@id='PAN Number']")).sendKeys("LOZPK6063B");
        Thread.sleep(5000);   

        // Click on the 'Submit' button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(4000);  

        // Click on the 'Okay' button
        driver.findElement(By.xpath("//button[text()='Okay']")).click();
        Thread.sleep(4000);   

        // Click on the select button to open the dropdown
        WebElement selectButton = driver.findElement(By.xpath("//button[@type='button']"));
        selectButton.click();
        Thread.sleep(4000);   

        // Click on the "Sole Partnership" option from the dropdown
        WebElement solePartnershipOption = driver.findElement(By.xpath("//a[normalize-space()='Sole Partnership']"));
        solePartnershipOption.click();
        Thread.sleep(4000);   

        // Enter GST number and certificate of incorporation
        driver.findElement(By.xpath("//input[@id='GST Number']")).sendKeys("27AAAAA0000A1Z5");
        driver.findElement(By.xpath("//input[@id='Certificate of Incorporation']")).sendKeys("U12345MH2023PTC012345");

        // Enter address details
        driver.findElement(By.xpath("//input[@id='Registered Address Line 1']")).sendKeys("tatanagar jharkhand");
        driver.findElement(By.xpath("//input[@id='State']")).sendKeys("jharkhand");
        driver.findElement(By.xpath("//input[@id='Registered Address Line 2']")).sendKeys("sakchi");
        driver.findElement(By.xpath("//input[@id='Pin Code']")).sendKeys("8332219");
        driver.findElement(By.xpath("//input[@id='District']")).sendKeys("Seraikella");
        Thread.sleep(4000);   

        
        
        
        driver.findElement(By.xpath("//button[normalize-space()='Save & Continue']")).click();
        Thread.sleep(4000);  

        driver.findElement(By.xpath("//input[@id='Regulator Number (Provided by Regulator)']")).sendKeys("23748632");
        
        Thread.sleep(4000);  

        driver.findElement(By.xpath("//button[normalize-space()='Type here']")).click();
        Thread.sleep(4000); 
        
        driver.findElement(By.xpath("//a[normalize-space()='RBI']")).click();
        
       driver.findElement(By.xpath("//button[normalize-space()='Select Date']")).click();
       //driver.findElement(By.xpath("//button[normalize-space()='Select Date']")).sendKeys(Keys.RETURN);
       Thread.sleep(4000);

       // Using JavaScript Executor to enter company name and PAN number
       JavascriptExecutor js = (JavascriptExecutor) driver;

       WebElement companyNameField = driver.findElement(By.xpath("//input[@type='date']"));
       
       
       js.executeScript("arguments[0].value='SANJEET KUMAR';", companyNameField);

       WebElement panNumberField = driver.findElement(By.xpath("//input[@id='PAN Number']"));
       js.executeScript("arguments[0].value='LOZPK6063B';", panNumberField);
       Thread.sleep(5000);
        
        
	}}
        
     /*   // Enter regulator number
        driver.findElement(By.xpath("//input[@id='Regulator Number (Provided by Regulator)']")).sendKeys("123234");
        Thread.sleep(1000);   

        // Click to select Sakchi
        driver.findElesment(By.xpath("(//button[@type='button'])[1]")).sendKeys("Sakchi");
        Thread.sleep(1000);   

        // Click to proceed to the next step
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        Thread.sleep(4000);  

        // Select SEBI as the regulator
        driver.findElement(By.xpath("//a[text()='SEBI']")).click();
        Thread.sleep(2000);   















        // Click on the 'Save & Continue' button
        driver.findElement(By.xpath("//button[text()='Save & Continue']")).click();
        Thread.sleep(1000);  

        // Upload DSC document
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        String projectDirectory = System.getProperty("user.dir");
        String filePath = "/Users/ankitkumar/eclipse-workspace/BudsApplication/DSCDocuments/cert_Protean-GP_Bangalore.crt";
        fileInput.sendKeys(filePath);

        // Enter nodal officer details
        driver.findElement(By.xpath("//input[@id='Nodal Officer Middle Name']")).sendKeys("ankit");
        Thread.sleep(1000);   
        driver.findElement(By.xpath("//input[@id='Nodal Officer Last Name']")).sendKeys("ankit");
        Thread.sleep(1000);   
        driver.findElement(By.xpath("//input[@id='Nodal Officer Mobile Number']")).sendKeys("4578965879");
        Thread.sleep(1000);   
        driver.findElement(By.xpath("//input[@id='Nodal Officer Email']")).sendKeys("indiaankit@gmail.com");
        Thread.sleep(1000);  
        driver.findElement(By.xpath("//input[@id='Nodal Officer First Name']")).sendKeys("indiaankit");
        Thread.sleep(1000);   

        // Click on the 'Submit' button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(4000);   
        
        
    }
}
*/