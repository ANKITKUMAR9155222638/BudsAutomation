package BudsPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateTORegisterThroughLoginPage {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		   driver.manage().window().maximize();

	        driver.get("http://dev.niyamitnivesh.in/");
	        Thread.sleep(3000);   
	        driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
	        Thread.sleep(1000);  
	        driver.findElement(By.cssSelector("span[class='text-[#1C468E] cursor-pointer']")).click();
	        Thread.sleep(2000);
	        driver.close();
	}
	

}
