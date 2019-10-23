package com.autoframework.element;

import com.autoframework.driver.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebElementUtils extends SeleniumDriver {
    public static WebElement findElement(final By by){
        WebElement element = null;
        try{
            WebDriverWait waiter = new WebDriverWait(driver,10);
            waiter.until(ExpectedConditions.presenceOfElementLocated(by));
        }catch (Exception e){
            System.out.println("元素查找超时：：："+by);
            e.printStackTrace();
        }
        element = driver.findElement(by);
        return element;
    }
    public static List<WebElement> findElements(final By by){
        List<WebElement> element = null;
        try{
            WebDriverWait waiter = new WebDriverWait(driver,10);
            waiter.until(ExpectedConditions.presenceOfElementLocated(by));
        }catch (Exception e){
            System.out.println("元素查找超时：：："+by);
            e.printStackTrace();
        }
        element = driver.findElements(by);
        return element;
    }
}
