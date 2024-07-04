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
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BudAdminViewPasswordButtonFunctionality {

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
        workbook.close();
        fis.close();
    }

    @Test
    public void viewPasswordFunctionalityTest() throws InterruptedException {
        // Open the specified URL in the browser
        driver.get("http://devadmin.niyamitnivesh.in/");
        // Find the email input field using XPath and enter the username
        WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));
        emailInput.sendKeys(username);
        // Find the password input field using XPath and enter the password
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys(password);

        // Wait for 4 seconds to simulate user delay
        Thread.sleep(4000);
        // Find the password visibility toggle button using XPath and click it
        driver.findElement(By.xpath("//img[@alt='Toggle visibility']")).click();
        // Wait for 6 seconds to simulate user delay and view the password
        Thread.sleep(6000);

        // Validate the password visibility
        WebElement passwordVisibility = driver.findElement(By.xpath("//input[@name='password']"));
        String passwordValue = passwordVisibility.getAttribute("type");
        Assert.assertEquals(passwordValue, "text", "Password is not visible");
    }

    @AfterClass
    public void teardown() {
        // Close the browser
        driver.quit();
        // Optionally, you can use driver.close() to close only the current window
        // driver.close();
    }
}
