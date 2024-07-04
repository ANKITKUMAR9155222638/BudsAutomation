package AdminPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ErrorMessageEmptyEmailPassword {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testErrorMessages() throws InterruptedException {
        driver.get("http://devadmin.niyamitnivesh.in/");
        Thread.sleep(4000);

        WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        emailInput.sendKeys(" ");
        Thread.sleep(4000);
        passwordInput.sendKeys(" ");
        Thread.sleep(4000);

        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginButton.click();
        Thread.sleep(4000);

        WebElement errorMessageEmail = driver.findElement(By.xpath("//p[normalize-space()='Enter a valid email or phone number'], 'error-message-email')]"));
      //  WebElement errorMessagePassword = driver.findElement(By.xpath("//div[contains(@class, 'error-message-password')]"));

        String actualEmailErrorMessage = errorMessageEmail.getText();
      //  String actualPasswordErrorMessage = errorMessagePassword.getText();

        Assert.assertTrue(actualEmailErrorMessage.contains("Enter a valid email or phone number"), 
            "Expected error message for email is not displayed.");
      //  Assert.assertTrue(actualPasswordErrorMessage.contains("Password must have at least 8 characters"), 
        //    "Expected error message for password is not displayed.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
