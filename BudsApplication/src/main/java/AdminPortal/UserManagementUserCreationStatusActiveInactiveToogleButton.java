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

public class UserManagementUserCreationStatusActiveInactiveToogleButton {

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
        Thread.sleep(4000);
        	driver.findElement(By.xpath("//tbody/tr[6]/td[4]/div[1]/div[1]/button[1]")).click();	
	}}