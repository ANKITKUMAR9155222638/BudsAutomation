package BudsLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationDesignatedCourt {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
        WebDriver driver = new ChromeDriver();
   //     driver.manage().window().maximize();
	
        driver.get("http://dev.niyamitnivesh.in/");
        Thread.sleep(4000);   

       
        driver.findElement(By.xpath("//div[contains(@class,'leading-normal')][normalize-space()='Register']")).click();
        Thread.sleep(4000);   

        driver.findElement(By.xpath("//label[normalize-space()='Designated Court']")).click();
        Thread.sleep(4000);   
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(4000);   
	
	
        driver.findElement(By.xpath("//input[@id='Pin Code']")).sendKeys("111045");
    
     driver.findElement(By.xpath("//button[normalize-space()='Save & Continue']")).click();
	}
	
	
	
	
	

}
