package AdminPortal;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserManagementUserCreationAddUser {

		public static void main(String[] args) throws IOException, InterruptedException {
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	  
	        FileInputStream fis = new FileInputStream("testData/TestData.xlsx");
	        Workbook workbook = new XSSFWorkbook(fis);
	        Sheet sheet = workbook.getSheetAt(0);
	        Row row = sheet.getRow(1);
	        String username = row.getCell(0).getStringCellValue();
	        String password = row.getCell(1).getStringCellValue();

	        driver.get("http://devadmin.niyamitnivesh.in/");
	        WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));
	        emailInput.sendKeys(username);
	        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
	        passwordInput.sendKeys(password);
	        WebElement loginButton = driver.findElement(By.xpath("(//button[normalize-space()='Login'])[1]"));
	        loginButton.click();

	       Thread.sleep(1000);

	       
	        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
	        String projectDirectory = System.getProperty("user.dir");
	        String filePath = projectDirectory + "/DSCDocumnets/cert_Protean-GP_Bangalore.crt";
	        fileInput.sendKeys(filePath);

	       
	        WebElement loginButtonAfterUpload = driver.findElement(By.xpath("(//button[normalize-space()='Login'])[1]"));
	        loginButtonAfterUpload.click();

	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//div[contains(text(),'User Management')]")).click();
	       Thread.sleep(4000);
	        
	        driver.findElement(By.xpath("//div[normalize-space()='User creation']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > a:nth-child(4) > div:nth-child(1)")).click();
	        Thread.sleep(2000);
	       // driver.findElement(By.xpath("")).click();
	       //  driver.findElement(By.xpath("")).sendKeys("");
	        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("rahul");
	        driver.findElement(By.xpath("//input[@name='MiddleName']")).sendKeys("k");
	        driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("Mahto");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//button[normalize-space()='Type input']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("(//a[normalize-space()='Testing'])[1]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("testdarkscenario+232@gmail.com");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("9155222638");

driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
	        

	       
	        
	}

}
