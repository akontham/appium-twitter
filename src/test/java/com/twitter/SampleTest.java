package com.twitter;

import com.twitter.pages.LandingPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by srikanthvejendla on 2/19/17.
 */
public class SampleTest {

    AppiumServiceBuilder appiumServiceBuilder;
    AppiumDriverLocalService appiumLocal;
    AppiumDriver driver;

    @Before
    public void setUp(){
        appiumServiceBuilder = new AppiumServiceBuilder().usingAnyFreePort();
        appiumLocal = appiumServiceBuilder.build();
        appiumLocal.start();

        //Desired Capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","6.0.1");
        capabilities.setCapability("deviceName","Galaxy S6");
        capabilities.setCapability("browserName","");
        capabilities.setCapability("appPackage","com.twitter.android");
        capabilities.setCapability("appActivity","com.twitter.android.StartActivity");

        driver = new AndroidDriver(appiumLocal.getUrl(),capabilities);
    }

    @After
    public void tearDown(){
        appiumLocal.stop();
    }

    @Test
    public void loginTest(){
        LandingPage landingPage = new LandingPage(driver);

        landingPage.clickLoginBtn().doValidLogin("pntdemo","fifa2017");
    }
}
