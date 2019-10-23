package com.autoframework.driver;

import com.autoframework.element.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class FindElements {
    WebDriver driver;
    @Test
    //查找搜索文本框
    public void FindById(){
        driver = SeleniumDriver.Open("chrome");
        driver.get("http://www.baidu.com");
        WebElement element = WebElementUtils.findElement(By.id("kw"));
        SeleniumDriver.Close();
    }
    @Test
    //查找搜索文本框
    public void FindByName(){
        driver = SeleniumDriver.Open("chrome");
        driver.get("http://www.baidu.com");
        WebElement element = WebElementUtils.findElement(By.name("wd"));
        SeleniumDriver.Close();
    }
    @Test
    //查找搜索文本框
    public void FindByClass(){
        driver = SeleniumDriver.Open("chrome");
        driver.get("http://www.baidu.com");
        WebElement element = WebElementUtils.findElement(By.className("s_ipt"));
        SeleniumDriver.Close();
    }
    @Test
    //查找'新闻'，只有a标签才可以
    public void FindByLinkTest(){
        driver = SeleniumDriver.Open("chrome");
        driver.get("http://www.baidu.com");
        WebElement element = WebElementUtils.findElement(By.linkText("新闻"));
        SeleniumDriver.Close();
    }
    @Test
    //c查找新闻
    public void FindByPartLinkTest(){
        driver = SeleniumDriver.Open("chrome");
        driver.get("http://www.baidu.com");
        WebElement element = WebElementUtils.findElement(By.partialLinkText("新"));
        SeleniumDriver.Close();
    }
    @Test
    //搜索文本框
    public void FindByCss(){
        driver = SeleniumDriver.Open("chrome");
        driver.get("http://www.baidu.com");
        WebElement element = WebElementUtils.findElement(By.cssSelector("#kw"));
        SeleniumDriver.Close();
    }
    @Test
    //搜索文本框
    public void FindByXpath(){
        driver = SeleniumDriver.Open("chrome");
        driver.get("http://www.baidu.com");
        WebElement element = WebElementUtils.findElement(By.xpath("//*[@id=\"kw\"]"));
        SeleniumDriver.Close();
    }
    @Test
    //搜索文本框
    public void FindByTagname(){
        driver = SeleniumDriver.Open("chrome");
        driver.get("http://www.baidu.com");
        WebElement element = WebElementUtils.findElement(By.tagName("a"));
        SeleniumDriver.Close();
    }
    @Test
    //findElements
    public void  FindElements(){
        driver = SeleniumDriver.Open("chrome");
        driver.get("http://www.baidu.com");
        List<WebElement> element = WebElementUtils.findElements(By.xpath("//*[@id=\"u1\"]"));
        for(int i=0;i<element.size();i++){
            String text = element.get(i).getText();
            System.out.println(text);
        }
        SeleniumDriver.Close();
    }

}
