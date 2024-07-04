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

public class NavigatingtoMISReports {
    WebDriver driver;

    // Method to initialize WebDriver and maximize window before tests
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // Test method to navigate to MIS Reports and perform file upload
    @Test
    public void navigateToMISReports() throws IOException, InterruptedException {
        // Read username and password from Excel
        FileInputStream fis = new FileInputStream("testData/TestData.xlsx");
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(1);
        String username = row.getCell(0).getStringCellValue();
        String password = row.getCell(1).getStringCellValue();
        workbook.close(); // Close workbook after usage

        // Navigate to the login page
        driver.get("http://devadmin.niyamitnivesh.in/");

        // Fill in login credentials
        WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));
        emailInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys(password);

        // Click on the login button
        WebElement loginButton = driver.findElement(By.xpath("(//button[normalize-space()='Login'])[1]"));
        loginButton.click();
        Thread.sleep(2000); // Wait for page to load

        // Upload a file
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        String projectDirectory = System.getProperty("user.dir");
        String filePath = projectDirectory + "/DSCDocumnets/cert_Protean-GP_Bangalore.crt";
        fileInput.sendKeys(filePath);

        // Click on the login button after file upload
        WebElement loginButtonAfterUpload = driver.findElement(By.xpath("(//button[normalize-space()='Login'])[1]"));
        loginButtonAfterUpload.click();
        Thread.sleep(4000); // Wait for page to load

        // Click on MIS Reports
        driver.findElement(By.xpath("//div[contains(text(),'MIS Reports')]")).click();
        Thread.sleep(2000); // Wait for page to load
    }

    // Method to close the browser after all tests are completed
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
