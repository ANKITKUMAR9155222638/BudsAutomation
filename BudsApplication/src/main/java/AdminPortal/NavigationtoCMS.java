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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NavigationtoCMS {
    WebDriver driver;

    // Setup method to initialize the WebDriver and maximize the window
    @BeforeClass
    public void setUp() {
        // Initialize WebDriver (ChromeDriver) and maximize the window
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // Test method to perform the CMS navigation scenario
    @Test
    public void testNavigateToCMS() throws IOException, InterruptedException {
        // Read username and password from Excel file
        FileInputStream fis = new FileInputStream("testData/TestData.xlsx");
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(1);
        String username = row.getCell(0).getStringCellValue();
        String password = row.getCell(1).getStringCellValue();
        workbook.close(); // Close workbook after use

        // Navigate to the login page and perform login
        driver.get("http://devadmin.niyamitnivesh.in/");
        WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));
        emailInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys(password);
        WebElement loginButton = driver.findElement(By.xpath("(//button[normalize-space()='Login'])[1]"));
        loginButton.click();

        Thread.sleep(2000); // Wait for the login process

        // Upload a file
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        String projectDirectory = System.getProperty("user.dir");
        String filePath = projectDirectory + "/DSCDocumnets/cert_Protean-GP_Bangalore.crt";
        fileInput.sendKeys(filePath);
        Thread.sleep(2000); // Wait for file upload process

        // Click on elements to navigate through tasks
        WebElement loginButtonAfterUpload = driver.findElement(By.xpath("(//button[normalize-space()='Login'])[1]"));
        loginButtonAfterUpload.click();
        Thread.sleep(4000); // Wait for page to load

        // Click on CMS link
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/aside[1]/div[1]/ul[1]/li[6]/a[1]/div[1]")).click();
        Thread.sleep(2000); // Wait for CMS page to load
    }

    // Tear down method to close the browser
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
