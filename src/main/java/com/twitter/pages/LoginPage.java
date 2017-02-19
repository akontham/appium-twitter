package com.twitter.pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    AppiumDriver driver;

    public LoginPage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.twitter.android:id/login_identifier")
    private MobileElement etUserName;

    @AndroidFindBy(id = "com.twitter.android:id/login_password")
    private MobileElement etPassword;

    @AndroidFindBy(id = "com.twitter.android:id/password_reset")
    private MobileElement tvForgotPassword;

    @AndroidFindBy(id = "com.twitter.android:id/login_login")
    private MobileElement btnLogin;

    private LoginPage setUserName(String userName){
        etUserName.sendKeys(userName);
        return this;
    }

    private LoginPage setPassword(String password){
        etPassword.sendKeys(password);
        return this;
    }

    public HomePage doValidLogin(String userName,String password){
        setUserName(userName);
        setPassword(password);
        btnLogin.click();
        return new HomePage(driver);
    }

    public LoginPage doInValidLogin(String userName, String password){
        setUserName(userName);
        setPassword(password);
        btnLogin.click();
        return this;
    }


}
