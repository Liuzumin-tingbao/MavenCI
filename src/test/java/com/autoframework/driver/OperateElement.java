package com.autoframework.driver;

import com.autoframework.element.WebElementUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class OperateElement {
    WebDriver driver;
    @Test
    //1. 打开百度首页
    //2. 点击百度首页的“糯米”链接.
    public void ClickTest(){
        driver = SeleniumDriver.Open("chrome");
        driver.get("http://www.baidu.com");
        WebElementUtils.findElement(By.className("mnav")).click();
        SeleniumDriver.Close();
    }
    @Test
    //1. 打开百度页面
    //2. 在搜索文本框输入selenium
    //3. 点击百度一下按钮
    public void SendKeysTest(){
        driver = SeleniumDriver.Open("chrome");
        driver.get("http://www.baidu.com");
        WebElementUtils.findElement(By.id("kw")).sendKeys("selenium");
        WebElementUtils.findElement(By.id("su")).click();
        SeleniumDriver.Close();
    }
    @Test
    //1. 打开百度首页
    //2. 在搜索文本框输入selenium
    //3. 清空搜索输入框
    public void ClearTest() throws InterruptedException {
        driver = SeleniumDriver.Open("chrome");
        driver.get("http://www.baidu.com");
        WebElementUtils.findElement(By.id("kw")).sendKeys("selenium");
        Thread.sleep(3000);
        WebElementUtils.findElement(By.id("kw")).clear();
        Thread.sleep(3000);
        SeleniumDriver.Close();
    }
    @Test
    //1. 打开百度首页
    //2. 获取右上角所有的文本并输出
    public void  GetTextTest(){
        driver = SeleniumDriver.Open("chrome");
        driver.get("http://www.baidu.com");
        List<WebElement> element = WebElementUtils.findElements(By.xpath("//*[@id=\"u1\"]"));
        for(int i=0;i<element.size();i++){
            String text = element.get(i).getText();
            System.out.println(text);
        }
        SeleniumDriver.Close();
    }
    @Test
    //1. 打开百度首页
    //2. 获取搜索框的TagName
    public void GetTagnameTest(){
        driver = SeleniumDriver.Open("chrome");
        driver.get("http://www.baidu.com");
        String text = WebElementUtils.findElement(By.id("kw")).getTagName();
        System.out.println(text);
        SeleniumDriver.Close();
    }
    @Test
    //1. 打开百度首页
    //2. 搜索框输入“webdriver”
    //3. 获取搜索框的 value 属性值
    public void GetValue(){
        driver = SeleniumDriver.Open("chrome");
        driver.get("http://www.baidu.com");
        WebElement e = WebElementUtils.findElement(By.id("kw"));
        e.sendKeys("webdriver");
        String text = e.getAttribute("value");
        System.out.println(text);
        SeleniumDriver.Close();
    }
    @Test
    //1. 打开百度首页
    //2. 获取当前页面的title
    //3. 校验title 值等于“百度一下，你就知道
    public void GetTitleTest(){
        driver = SeleniumDriver.Open("chrome");
        driver.get("http://www.baidu.com");
        String title = driver.getTitle();
        Assert.assertEquals(title,"百度一下，你就知道");
        SeleniumDriver.Close();
    }
    @Test
    //1. 打开百度首页
    //2. 校验百度一下按钮已经展示
    public void disableTest(){
        driver = SeleniumDriver.Open("chrome");
        driver.get("http://www.baidu.com");
        Boolean a = WebElementUtils.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(a,"校验百度按钮是否展示！");
        SeleniumDriver.Close();
    }
    @Test
    //1. 打开 “UI自动化测试”主页
    //2. 校验 “Volvo”单选框已经选中
    public void SelectTest(){
        driver = SeleniumDriver.Open("chrome");
        driver.get("file:///E:/java%E8%87%AA%E5%8A%A8%E5%8C%96/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        Boolean a = WebElementUtils.findElement(By.xpath("//*[@id=\"radio\"]/label[1]")).isSelected();
        Assert.assertFalse(a,"校验volvo是否选中！");
        SeleniumDriver.Close();
    }
    @Test
    //1. 打开“UI自动化测试”主页
    //2. 校验 submit 文本框为不可输入状态
    public void EnableTest(){
        driver = SeleniumDriver.Open("chrome");
        driver.get("file:///E:/java%E8%87%AA%E5%8A%A8%E5%8C%96/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        Boolean a = WebElementUtils.findElement(By.xpath("//*[@id=\"button\"]/input[1]")).isEnabled();
        Assert.assertFalse(a,"校验submit文本框是否为不可输入状态！");
        SeleniumDriver.Close();
    }
    @Test
    //1. 打开百度主页
    //2. 截图
    public void ShotSceenTest(){
        driver = SeleniumDriver.Open("chrome");
        driver.get("http://www.baidu.com");
        File file =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(file,new File("E:\\Projects\\pictures\\test.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        SeleniumDriver.Close();
    }

}
