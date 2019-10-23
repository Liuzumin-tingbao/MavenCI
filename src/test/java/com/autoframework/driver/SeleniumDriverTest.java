package com.autoframework.driver;

import org.testng.annotations.Test;

public class SeleniumDriverTest {
    @Test
    public void opentest(){
        SeleniumDriver.Open("chrome");
//        SeleniumDriver.Open("firefox");
//        SeleniumDriver.Open("ie");
        SeleniumDriver.Close();
    }
}
