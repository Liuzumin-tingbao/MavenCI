package com.autoframework.element;

import com.autoframework.driver.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class WebElementUtilsTest {
    WebDriver driver;
    @Test
    public void findTest() throws InterruptedException {
        driver= SeleniumDriver.Open("chrome");
        driver.get("E:\\java自动化\\源码\\webdriver_demo\\selenium_html\\index.html");
        WebElementUtils.findElement(By.className("wait")).click();
        String text = WebElementUtils.findElement(By.className("red")).getText();
        System.out.println(text);
        Thread.sleep(3000);
        SeleniumDriver.Close();
    }
}
