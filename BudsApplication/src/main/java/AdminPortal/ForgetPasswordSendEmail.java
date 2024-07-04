package AdminPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ForgetPasswordSendEmail {
    WebDriver driver;

    // Setup method to initialize the WebDriver and maximize the window
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // Test method to perform the actions of sending a forget password email
    @Test
    public void testForgetPasswordSendEmail() throws InterruptedException {
        // Navigate to the URL
        driver.get("http://devadmin.niyamitnivesh.in/");
        Thread.sleep(4000);

        // Click on the forget password link
        driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(2) > div:nth-child(1) > div:nth-child(2) > p:nth-child(3)")).click();
        Thread.sleep(1000);

        // Find the email input field and enter the email address
        WebElement emailInput = driver.findElement(By.xpath("//input[@placeholder='Enter your email or mobile number']"));
        emailInput.sendKeys("testdarkscenario@gmail.com");

        // Find and click the submit button
        WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
        submitButton.click();

        Thread.sleep(2000); // Wait for demonstration purposes
    }

    // Tear down method to close the browser
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
