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

public class UserManagementAddRole {

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
        Thread.sleep(4000);
        WebElement loginButton = driver.findElement(By.xpath("(//button[normalize-space()='Login'])[1]"));
        loginButton.click();

        Thread.sleep(1000);

       
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        String projectDirectory = System.getProperty("user.dir");
        String filePath = projectDirectory + "/DSCDocumnets/cert_Protean-GP_Bangalore.crt";
        fileInput.sendKeys(filePath);
        Thread.sleep(1000);
       
        WebElement loginButtonAfterUpload = driver.findElement(By.xpath("(//button[normalize-space()='Login'])[1]"));
        loginButtonAfterUpload.click();

        Thread.sleep(4000);
        driver.findElement(By.xpath("//div[contains(text(),'User Management')]")).click();
        Thread.sleep(4000);
        
        driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > span:nth-child(2)")).click();
        Thread.sleep(4000);
        
        driver.findElement(By.xpath("//input[@id='documentName']")).sendKeys("Admmin TestAnkitAdmin");
        
        
        driver.findElement(By.xpath("//button[normalize-space()='Select']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[normalize-space()='User Manager Admin Role']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Entity Reviewer Role']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='MIS Report Access']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='MIS Report Access']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Entity & Scheme Master Access Role']")).click(); 
        driver.findElement(By.xpath("//a[normalize-space()='Entity Approver']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Website Notification Manager Role']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Dashboard View Access']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='CMS Manager Role']")).click();
        driver.findElement(By.xpath("//input[@id='documentName']")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();

       Thread.sleep(5000);
        
    // driver.quit();
    }
}
