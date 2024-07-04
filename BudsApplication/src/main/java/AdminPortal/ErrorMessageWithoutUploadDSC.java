package AdminPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ErrorMessageWithoutUploadDSC {
    WebDriver driver;

    // Setup method to initialize the WebDriver and maximize the window
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // Test method to perform the actions and validate the error message
    @Test
    public void testErrorMessageWithoutUploadDSC() throws InterruptedException {
        // Navigate to the URL
        driver.get("http://devadmin.niyamitnivesh.in/");
        Thread.sleep(4000); // Wait for the page to load

        // Locate and input email and password
        WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        emailInput.sendKeys("moiz.mobilefirst@gmail.com");
        passwordInput.sendKeys("Hellworld@123");

        // Locate and click the login button
        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginButton.click();
        Thread.sleep(4000); // Wait for the login process

        // Attempt to perform the action that triggers the error message
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(5000); // Wait for the error message to appear

        // Locate the error message element and get its text using CSS selector
        WebElement errorMessage = driver.findElement(By.cssSelector(".text-red-500"));
        String errorMessageText = errorMessage.getText();

        // Validate the error message
        Assert.assertTrue(errorMessageText.contains("dscCertificateFile should not be empty"), 
            "Expected error message is not displayed.");
    }

    // Tear down method to close the browser
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
