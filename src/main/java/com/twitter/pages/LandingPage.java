package com.twitter.pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    AppiumDriver driver;

    public LandingPage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.twitter.android:id/sign_up")
    private MobileElement btnSignUp;

    @AndroidFindBy(id = "com.twitter.android:id/log_in")
    private MobileElement btnLogin;

    public SignUpPage clickSignUpBtn(){
        btnSignUp.click();
        return new SignUpPage(driver);
    }

    public LoginPage clickLoginBtn(){
        btnLogin.click();
        return new LoginPage(driver);
    }


}
