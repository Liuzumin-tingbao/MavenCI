package com.autoframework.driver;

import com.autoframework.element.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BrowserOperate {
    WebDriver driver;
    @Test
    public void OpenChrome() throws InterruptedException {
        driver = SeleniumDriver.Open("chrome");
        driver.get("http://www.baidu.com");
        WebElement e = WebElementUtils.findElement(By.id("kw"));
        e.sendKeys("selenium");
        WebElementUtils.findElement(By.id("su")).click();
        Thread.sleep(2000);
        //后退；
        driver.navigate().back();
        Thread.sleep(2000);
        //q前进
        driver.navigate().forward();
        Thread.sleep(2000);
        //刷新
        driver.navigate().refresh();
        Thread.sleep(2000);
        //设置大小
        Dimension dimension = new Dimension(500,500);
        driver.manage().window().getSize();
        Thread.sleep(2000);
        //获取当前页面的url，获取title
        driver.manage().window().maximize();
        String url = driver.getCurrentUrl();
        System.out.println(url);
        String title = driver.getTitle();
        System.out.println(title);

        SeleniumDriver.Close();
    }
    @Test
    public void OpenIE() throws InterruptedException {
        driver = SeleniumDriver.Open("ie");
        driver.get("http://www.baidu.com");
        WebElementUtils.findElement(By.id("kw")).sendKeys("JMeter");
        WebElementUtils.findElement(By.id("su")).click();
        Thread.sleep(2000);
        //后退
        driver.navigate().back();
        Thread.sleep(2000);
        //前进
        driver.navigate().forward();
        Thread.sleep(2000);
        //刷新
        driver.navigate().refresh();
        Thread.sleep(2000);

        SeleniumDriver.Close();
    }

}
