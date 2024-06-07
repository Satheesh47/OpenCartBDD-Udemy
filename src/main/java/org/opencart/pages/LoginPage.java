package org.opencart.pages;

import org.opencart.utils.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    private ElementUtils elementUtils;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        elementUtils = new ElementUtils(driver);
    }
    @FindBy(id = "input-email")
    private WebElement emailAddressTxtField;
    @FindBy(id = "input-password")
    private WebElement passwordTxtField;
    @FindBy(xpath = "//*[@type='submit']")
    private WebElement loginBtn;

    @FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
    private WebElement emailPasswordNotMatchingWarning;

    public void login(String emailText, String passwordText) {
        elementUtils.typeTextIntoElement(emailAddressTxtField,emailText,10);
        elementUtils.typeTextIntoElement(passwordTxtField,passwordText,10);
        elementUtils.clickOnElement(loginBtn,10);
        //return new AccountPage(driver);
    }
    public void enterEmailAddress(String text) {
        elementUtils.typeTextIntoElement(emailAddressTxtField,text,10);
    }
    public void enterPassword(String text) {
        elementUtils.typeTextIntoElement(passwordTxtField,text,10);
    }
    public AccountPage clickLoginButton() {
        elementUtils.clickOnElement(loginBtn,10);
        return new AccountPage(driver);
    }
    public String retrieveEmailPasswordWarningMessageText() {
        return elementUtils.getTextFromElement(emailPasswordNotMatchingWarning,10);
    }
}
