package AdminPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ErrorMessageEmptyEmail {
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
        passwordInput.sendKeys("Qabc@123");
        Thread.sleep(4000);

        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginButton.click();
        Thread.sleep(4000);

        WebElement errorMessageEmail = driver.findElement(By.cssSelector("p[class='text-red-500']"));

        String actualEmailErrorMessage = errorMessageEmail.getText();

        Assert.assertTrue(actualEmailErrorMessage.contains("Enter a valid email or phone number"), 
            "Expected error message for email is not displayed.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
