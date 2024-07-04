package BudsLogin;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationDepositTaker {

    public static void main(String[] args) throws Throwable {
        WebDriver driver = new ChromeDriver();
        
        // Maximize the browser window
        // driver.manage().window().maximize();
        
        // Set an implicit wait of 10 seconds
    //    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Navigate to the BUDS portal
        driver.get("http://dev.niyamitnivesh.in/");
        Thread.sleep(2000);   

        // Click on the 'Register' button
        driver.findElement(By.xpath("//div[contains(@class,'leading-normal')][normalize-space()='Register']")).click();
        Thread.sleep(2000);   

        // Click on the 'Submit' button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);   

        // Enter company name and PAN number
        driver.findElement(By.xpath("//input[@id='Company Name (As per PAN)']")).sendKeys("ANKIT KUMAR");
        driver.findElement(By.xpath("//input[@id='PAN Number']")).sendKeys("FLZPK8978L");
        Thread.sleep(4000);   

        // Click on the 'Submit' button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(4000);  

        // Click on the 'Okay' button
        driver.findElement(By.xpath("//button[text()='Okay']")).click();
        Thread.sleep(4000);   

        // Click on the select button to open the dropdown
         driver.findElement(By.xpath("//button[@type='button']"))
       .click();
        Thread.sleep(4000);   

        // Click on the "Sole Partnership" option from the dropdown
        driver.findElement(By.xpath("//a[normalize-space()='Sole Partnership']")).click();
        Thread.sleep(2000);   

        // Enter GST number and certificate of incorporation
        driver.findElement(By.xpath("//input[@id='GST Number']")).sendKeys("27AAAAA0000A1Z5");
        driver.findElement(By.xpath("//input[@id='Certificate of Incorporation']")).sendKeys("U12345MH2023PTC012345");

        // Enter address details
        driver.findElement(By.xpath("//input[@id='Registered Address Line 1']")).sendKeys("tatanagar jharkhand");
        driver.findElement(By.xpath("//input[@id='State']")).sendKeys("jharkhand");
        driver.findElement(By.xpath("//input[@id='Registered Address Line 2']")).sendKeys("sakchi");
        driver.findElement(By.xpath("//input[@id='Pin Code']")).sendKeys("8332219");
        driver.findElement(By.xpath("//input[@id='District']")).sendKeys("Seraikella");
        Thread.sleep(3000);   
    
          
        driver.findElement(By.xpath("//button[normalize-space()='Save & Continue']")).click();
        Thread.sleep(3000);
        Thread.sleep(3000);   
        
        
       
        
        // Enter regulator number
        driver.findElement(By.xpath("//input[@id='Regulator Number']")).sendKeys("123234");
        Thread.sleep(1000);   
        driver.findElement(By.xpath("//button[normalize-space()='Type here']")).click();
           Thread.sleep(1000);

driver.findElement(By.xpath("//a[normalize-space()='RBI']")).click();
driver.findElement(By.xpath("//button[normalize-space()='Save & Continue']")).click();

  
Thread.sleep(4000);

        

        // Enter nodal officer details
driver.findElement(By.xpath("//input[@id='Nodal Officer First Name']")).sendKeys("indiaankit");
Thread.sleep(1000); 
        driver.findElement(By.xpath("//input[@id='Nodal Officer Middle Name']")).sendKeys("ankit");
        Thread.sleep(1000);   
        driver.findElement(By.xpath("//input[@id='Nodal Officer Last Name']")).sendKeys("ankit");
        Thread.sleep(1000);   
        driver.findElement(By.xpath("//input[@id='Nodal Officer Mobile Number']")).sendKeys("4578965879");
        Thread.sleep(1000);   
        driver.findElement(By.xpath("//input[@id='Nodal Officer Email']")).sendKeys("testdarkscenario+21@gmail.com");
        Thread.sleep(1000);  
         
     // Upload DSC document
  
        Thread.sleep(2000);

        
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        String projectDirectory = System.getProperty("user.dir");
        String filePath = projectDirectory + "/DSCDocumnets/cert_Protean-GP_Bangalore.crt";
        fileInput.sendKeys(filePath);

        Thread.sleep(3000);
        // Click on the 'Submit' button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(4000);   
        driver.findElement(By.xpath("//div[@class='p-3']//div[2]//input[1]")).sendKeys("0");
        driver.findElement(By.xpath("//div[@class='p-3']//div[2]//input[2]")).sendKeys("0");
        driver.findElement(By.xpath("//div[@class='p-3']//div[2]//input[3]")).sendKeys("0");
        driver.findElement(By.xpath("//div[@class='p-3']//div[2]//input[4]")).sendKeys("0");
        driver.findElement(By.xpath("//div[@class='p-3']//div[2]//input[5]")).sendKeys("0");
        driver.findElement(By.xpath("//div[@class='p-3']//div[2]//input[6]")).sendKeys("0");

} }