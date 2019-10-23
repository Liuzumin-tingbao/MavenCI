package com.autoframework.driver;

import com.autoframework.element.WebElementUtils;
//import org.apache.bcel.generic.Select;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AlertOperate {
    WebDriver driver;
    @Test
//        Alert的处理
//        测试用例：
//        1. 打开“UI 自动化测试”主页
//        2. 点击Alert 按钮
//        3. 在alert
    public void AlertTest(){
            driver = SeleniumDriver.Open("chrome");
            driver.get("E:\\java自动化\\源码\\webdriver_demo\\selenium_html\\index.html");
            WebElementUtils.findElement(By.xpath("//*[@id=\"alert\"]/input")).click();
            Alert alert =driver.switchTo().alert();
            alert.accept();
            SeleniumDriver.Close();
    }
    @Test
    //Confirm的处理
    //测试用例：
    //1. 打开“UI 自动化测试”主页
    //2. 点击Confirm 按钮
    //3. 在Confirm 警告 框点击 确定\ 取消按钮
    public void confirmTest(){
        driver = SeleniumDriver.Open("chrome");
        driver.get("E:\\java自动化\\源码\\webdriver_demo\\selenium_html\\index.html");
        WebElementUtils.findElement(By.className("confirm")).click();
        Alert alert =driver.switchTo().alert();
        alert.accept();
        SeleniumDriver.Close();
    }
    @Test
    //Prompt的处理
    //测试用例：
    //1. 打开“UI 自动化测试”主页
    //2. 点击Prompt 按钮
    //3. 在Prompt 弹窗中，输入“这个是Prompt” ”
    //4. 点击确定\
    public void PromptTest() throws InterruptedException {
        driver = SeleniumDriver.Open("ie");
        driver.get("E:\\java自动化\\源码\\webdriver_demo\\selenium_html\\index.html");
        WebElementUtils.findElement(By.className("prompt")).click();
        Alert alert =driver.switchTo().alert();
        alert.sendKeys("确定");
        Thread.sleep(2000);
        alert.accept();
        SeleniumDriver.Close();
    }
    @Test
    //1. 定位iFrame
    //2. driver 控制权交给iFrame
    //3. 操作iFrame 里面的元素
    //4. driver
    public void iFrameTest() throws InterruptedException {
        driver = SeleniumDriver.Open("chrome");
        driver.get("E:\\java自动化\\源码\\webdriver_demo\\selenium_html\\index.html");
        driver.switchTo().frame("aa");
        WebElementUtils.findElement(By.id("user")).sendKeys("我输入了1234");
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        SeleniumDriver.Close();
    }
    @Test
    //下拉框的处理
    //三种处理方式：
    //1. selectByIndex() 根据索引来选取，从0开始
    //2. selectByValue() 根据属性value的属性值来选取
    //3. selectByVisibleText()根据标签之间的Text值，也就是页面显示的
    public void selectByTest() throws InterruptedException {
        driver = SeleniumDriver.Open("chrome");
        driver.get("E:\\java自动化\\源码\\webdriver_demo\\selenium_html\\index.html");
        WebElement element = WebElementUtils.findElement(By.id("moreSelect"));
        Select select = new Select(element);
        select.selectByIndex(0);
        Thread.sleep(3000);
        select.selectByValue("oppe");
        Thread.sleep(3000);
        select.selectByVisibleText("huawei");
        Thread.sleep(3000);
        WebElementUtils.Close();
    }
    @Test
    //多窗口的处理
    public void windowsTest() throws InterruptedException {
        driver = SeleniumDriver.Open("chrome");
        driver.get("E:\\java自动化\\源码\\webdriver_demo\\selenium_html\\index.html");
        driver.switchTo().frame("aa");
        WebElementUtils.findElement(By.className("open")).click();
        String handle = driver.getWindowHandle();
        for(String str:driver.getWindowHandles()){
            if (str.equals(handle)){
                continue;
            }
            driver.switchTo().window(str);
        }
        Thread.sleep(3000);
        WebElementUtils.findElement(By.id("kw")).sendKeys("wolaile");
        WebElementUtils.findElement(By.id("su")).click();
        Thread.sleep(3000);
        driver.close();
        driver.switchTo().window(handle);
        driver.switchTo().defaultContent();
        WebElementUtils.findElement(By.id("user")).sendKeys("wolaile");
        Thread.sleep(3000);
        WebElementUtils.Close();
    }
}
