package BudsLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login_Regulator {

	@Test
	public static void loginRegulator() throws Throwable {

		// public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://dev.niyamitnivesh.in/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
	//	Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Deposit Taker']//*[name()='svg']")).click();
	//	Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='Regulator']")).click();
	//	Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Email id / Mobile no.']"))
				.sendKeys("testdarkscenario+1@gmail.com");
	//	Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Qabc@123");
		driver.findElement(By.xpath("//img[@alt='Toggle visibility']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);

		WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
		String projectDirectory = System.getProperty("user.dir");
		String filePath = projectDirectory + "/DSCDocumnets/cert_Protean-GP_Bangalore.crt";
		fileInput.sendKeys(filePath);

		Thread.sleep(1000);
	//	driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		driver.close();
	}

}