package AdminPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class BudsAdminLoginWithValidCredentials {

    WebDriver driver;
    String username;
    String password;

    @BeforeClass
    public void setup() throws IOException {
        // Initialize the ChromeDriver
        driver = new ChromeDriver();
        // Maximize the browser window
        driver.manage().window().maximize();

        // Load the Excel file containing test data
        FileInputStream fis = new FileInputStream("testData/TestData.xlsx");
        Workbook workbook = new XSSFWorkbook(fis);
        // Get the first sheet of the Excel file
        Sheet sheet = workbook.getSheetAt(0);
        // Get the second row (index 1) of the sheet
        Row row = sheet.getRow(1);
        // Read the username and password from the row
        username = row.getCell(0).getStringCellValue();
        password = row.getCell(1).getStringCellValue();
        // Close the workbook and input stream to prevent resource leaks
        workbook.close();
        fis.close();
    }

    @Test
    public void loginWithValidCredentials() throws InterruptedException {
        // Open the specified URL in the browser
        driver.get("http://devadmin.niyamitnivesh.in/");
        // Find the email input field using XPath and enter the username
        WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));
        emailInput.sendKeys(username);
        // Find the password input field using XPath and enter the password
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys(password);
        // Find the login button using XPath and click it
        WebElement loginButton = driver.findElement(By.xpath("(//button[normalize-space()='Login'])[1]"));
        loginButton.click();

        Thread.sleep(2000);

       
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        String projectDirectory = System.getProperty("user.dir");
        String filePath = projectDirectory + "/DSCDocumnets/cert_Protean-GP_Bangalore.crt";
        fileInput.sendKeys(filePath);

        // Find the login button again after file upload and click it
        WebElement loginButtonAfterUpload = driver.findElement(By.xpath("(//button[normalize-space()='Login'])[1]"));
        loginButtonAfterUpload.click();

        // Wait for 2 seconds to simulate user delay
        Thread.sleep(2000);

        // Validate successful login by checking the presence of an element after login
        // For example, check if a Mytask element is displayed
        WebElement dashboardElement = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/aside[1]/div[1]/ul[1]/li[3]/a[1]/div[1]"));
        Assert.assertTrue(dashboardElement.isDisplayed(), "Login was not successful.");

    }

    @AfterClass
    public void teardown() {
        // Close the browser
        driver.quit();
        // Optionally, you can use driver.close() to close only the current window
        // driver.close();
    }
}
