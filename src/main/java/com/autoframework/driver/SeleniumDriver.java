package com.autoframework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SeleniumDriver {
    public static WebDriver driver;
    public static WebDriver Open(String browser){
        String path = System.getProperty("user.dir");
        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver",path+"/driver/chromedriver.exe");
            driver = new ChromeDriver();
        }else if(browser.equals("firefox")){
            System.setProperty("webdriver.gecko.driver",path+"/driver/geckodriver.exe");
            driver = new FirefoxDriver();
        }else if(browser.equals("ie")){
            System.setProperty("webdriver.ie.driver",path+"/driver/IEDriverServer.64.exe");
            driver = new InternetExplorerDriver();
        }else{
            System.out.println("输入的游览器有误"+browser);
        }
        return driver;
    }
    public static void Close(){
        driver.quit();
    }
}
