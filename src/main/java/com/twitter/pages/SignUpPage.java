package com.twitter.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by srikanthvejendla on 2/19/17.
 */
public class SignUpPage {

    public SignUpPage(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
}
