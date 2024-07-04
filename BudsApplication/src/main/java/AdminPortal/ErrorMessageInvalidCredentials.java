package AdminPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ErrorMessageInvalidCredentials {
    WebDriver driver;

    // Setup method to initialize the WebDriver and maximize the window
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // Test method to validate error message for invalid credentials
    @Test
    public void testErrorMessageInvalidCredentials() throws InterruptedException {
        // Navigate to the URL
        driver.get("http://devadmin.niyamitnivesh.in/");
        Thread.sleep(4000); // Wait for page to load

        // Find and input email and password
        WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        emailInput.sendKeys("moiz.@gmail.com");
        passwordInput.sendKeys("23784t2784");

        // Click on login button
        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginButton.click();
        Thread.sleep(4000); // Wait for login process

        // Find the error message element
        WebElement errorMessage = driver.findElement(By.cssSelector("span[class='text-red-500']"));

        // Assert the error message text
        String expectedErrorMessage = "User not registered with us...";
        Assert.assertEquals(errorMessage.getText(), expectedErrorMessage, "Error message doesn't match");

       
    }

    // Tear down method to close the browser
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
