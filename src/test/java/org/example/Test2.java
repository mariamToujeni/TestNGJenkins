package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class Test2 {

    WebDriver driver;
    ChromeOptions options;

    @Parameters({"Port"})
    @BeforeClass
    public void initiateDriver(String Port) throws MalformedURLException {
        if(Port.equalsIgnoreCase("9001"))
        {
            driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), DesiredCapabilities.chrome());
            driver.manage().window().maximize();
        }
        else if(Port.equalsIgnoreCase("9002")){
            driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), DesiredCapabilities.firefox());
            driver.manage().window().maximize();
        }
        driver.get("http://www.google.com");
    }
    @Test(testName = "test1", priority = 1)
    public void test12() throws Exception {
        WebElement goo = driver.findElement(By.name("q"));
        goo.sendKeys("test1");
        System.out.println("test1");
    }

    @Test(testName = "test2", priority = 2)
    public void test22() throws Exception {
        WebElement goo = driver.findElement(By.name("q"));
        goo.sendKeys("test2");
        System.out.println("test2");

    }

    @AfterTest
    public void quitbrowser() {
        driver.close();
    }
}
