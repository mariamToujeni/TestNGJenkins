package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Test1 {

    WebDriver driver ;


    @BeforeTest
    public void open() {
        driver =new ChromeDriver();
        driver.get("http://www.google.com");
    }

    @Test(testName="test1",priority = 1)
    public void test12() throws Exception {
        WebElement goo =driver.findElement(By.name("q"));
        goo.sendKeys("test1");

    }
    @Test(testName="test2",priority = 2)
    public void test22() throws Exception {
        WebElement goo =driver.findElement(By.name("q"));
        goo.sendKeys("test2");
    }

    @AfterTest
    public void quitbrowser() {
        driver.close();
    }
}

