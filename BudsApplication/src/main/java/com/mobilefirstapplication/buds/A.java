package com.mobilefirstapplication.buds;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import java.util.ArrayList;

public class A {

    public static void main(String[] args) throws InterruptedException {
        // Set the path for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Open the Facebook page in the first tab
        driver.get("https://www.facebook.com");

        // Cast WebDriver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Open a new tab and go to Google
        js.executeScript("window.open('https://www.google.com', '_blank');");

        // Get the list of window handles
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        // Switch to the Google tab (second tab)
        driver.switchTo().window(tabs.get(1));

        // Perform an action on the Google tab
        // Example: Search for "Selenium WebDriver"
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.submit();

        // Add a short delay for the page to load (adjust time as needed)
        Thread.sleep(3000);

        // Close the driver
        driver.quit();
    }
}
