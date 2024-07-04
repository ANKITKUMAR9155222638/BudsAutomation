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

public class MyTaskRegulatorApproveDocument {
    WebDriver driver;

    // Setup method to initialize the WebDriver and maximize the window
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // Test method to perform document approval task
    @Test
    public void testRegulatorDocumentApproval() throws IOException, InterruptedException {
        // Read username and password from Excel file
        FileInputStream fis = new FileInputStream("testData/TestData.xlsx");
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(1);
        String username = row.getCell(0).getStringCellValue();
        String password = row.getCell(1).getStringCellValue();
        workbook.close(); // Close workbook after use

        // Navigate to the URL and login
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

        // Click on elements to navigate through tasks
        WebElement loginButtonAfterUpload = driver.findElement(By.xpath("(//button[normalize-space()='Login'])[1]"));
        loginButtonAfterUpload.click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//div[contains(text(),'My Task')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[normalize-space()='Regulator']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='flex justify-center items-center']")).click();
        Thread.sleep(2000);

        // Perform action to approve document
        driver.findElement(By.xpath("//button[normalize-space()='Approve']")).click();
    }

    // Tear down method to close the browser
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
