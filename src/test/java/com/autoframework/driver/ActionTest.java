package com.autoframework.driver;

import com.autoframework.element.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;


public class ActionTest {
    WebDriver driver;
    @Test
    //平时我们在做自动化过程中可能需要模拟鼠标、键盘等的一些行为，
    //例如鼠标单击，双击，右键，而且很多web 应用可能存在快捷组合键等等。
    //那么可以用WebDriver中提供了Actions类来处理这类需求，更复杂的键盘鼠标
    //处理我们可以通过Java提供的Robot类解决
//    在元素上鼠标右击和双击
    public void actionTest() throws InterruptedException {
        driver = SeleniumDriver.Open("chrome");
        driver.get("http://www.baidu.com");
        Actions action = new Actions(driver);
        action.click(WebElementUtils.findElement(By.id("su"))).perform();
        Thread.sleep(2000);
        action.contextClick(WebElementUtils.findElement(By.id("su"))).perform();
        Thread.sleep(2000);
        WebElementUtils.Close();
    }
    @Test
    //鼠标移动到某个元素上
    public void MoveToElementTest() throws InterruptedException {
        driver = SeleniumDriver.Open("chrome");
        driver.get("http://www.baidu.com");
        Actions action = new Actions(driver);
        action.moveToElement(WebElementUtils.findElement(By.className("bdbriimgtitle"))).perform();
        Thread.sleep(3000);
        WebElementUtils.Close();
    }
    @Test
    //把元素拖动到（x,y） ）
    public void DragTest(){
        driver = SeleniumDriver.Open("chrome");
        driver.get("E:\\java自动化\\源码\\webdriver_demo\\selenium_html\\dragAndDrop.html");
        Actions action = new Actions(driver);
        action.dragAndDropBy(WebElementUtils.findElement(By.xpath("//*[@id=\"drag\"]")),500,500).perform();
        WebElementUtils.Close();
    }
    @Test
    //把元素拖动到另一个元素上
    public void ClickAndHoldTest(){
        driver = SeleniumDriver.Open("chrome");
        driver.get("E:\\java自动化\\源码\\webdriver_demo\\selenium_html\\dragAndDrop.html");
        WebElement e1 = WebElementUtils.findElement(By.id("drag"));
        WebElement e2 = WebElementUtils.findElement(By.xpath("/html/body/h1"));
        Actions action = new Actions(driver);
        action.clickAndHold(e1).moveToElement(e2).release(e2).perform();
        WebElementUtils.Close();
    }
//    @Test
    //下拉框多选
//    public void SelectTest() throws InterruptedException {
//        driver = SeleniumDriver.Open("chrome");
//        driver.get("E:\\java自动化\\源码\\webdriver_demo\\selenium_html\\index.html");
//        WebElement Select = WebElementUtils.findElement(By.id("selectWithMultipleEqualsMultiple"));
//        List<WebElement> ee = Select.findElements(By.tagName("option"));
//        Actions acs = new Actions(driver);
//        Action a = (Action) acs.keyDown(Keys.SHIFT).click(ee.get(0)).click(ee.get(1)).click(ee.get(2));
//        a.perform();
//    }
    @Test
//    1. 按 按 住某个按键
//    keyPress()
//2. 松 松 开某个按键
//    keyRelease()
    public void robotTest() throws AWTException {
        Robot rob = new Robot();
        //按住ctrl
        rob.keyPress(KeyEvent.VK_CONTROL);
        //按住S
        rob.keyPress(KeyEvent.VK_S);
        //得到S的ASCII码值
        int keyS = (int) new Character('S');
        //松开S
        rob.keyRelease(keyS);
        //松开ctrl
        rob.keyRelease(KeyEvent.VK_CONTROL);
    }
}
