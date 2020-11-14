package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Test1 {

    WebDriver driver;
    ChromeOptions options;


    @BeforeTest
    public void open() {
        options = new ChromeOptions();
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        driver = new ChromeDriver(options);

        driver.get("http://www.google.com");
    }

    @Test(testName = "test1", priority = 1)
    public void test12() throws Exception {
        WebElement goo = driver.findElement(By.name("q"));
        goo.sendKeys("test1");

    }

    @Test(testName = "test2", priority = 2)
    public void test22() throws Exception {
        WebElement goo = driver.findElement(By.name("q"));
        goo.sendKeys("test2");
    }

    @AfterTest
    public void quitbrowser() {
        driver.close();
    }
}

