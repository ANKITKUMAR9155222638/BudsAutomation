package BudsPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForgetPasswordSendOtp {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		   driver.manage().window().maximize();

	        driver.get("http://dev.niyamitnivesh.in/");
	        Thread.sleep(3000);   
	        driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
	        Thread.sleep(1000);  
	        driver.findElement(By.cssSelector("p[class='text-xs font-normal text-gilroy-medium text-end text-[#1C468E] cursor-pointer ']")).click();
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//button[normalize-space()='Select an option']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//a[normalize-space()='Designated Court']")).click();
	        
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//input[@placeholder='Email id / Mobile no.']")).sendKeys("testdarkscenario+12345@gmail.com");
	        
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
	
	        
	        Thread.sleep(2000);
	       // driver.close();
	}}
