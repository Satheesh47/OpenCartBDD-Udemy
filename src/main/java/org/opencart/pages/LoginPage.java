package org.opencart.pages;

import org.opencart.utils.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends ElementUtils {
    private WebDriver driver;
    public LoginPage(final WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
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
        typeTextIntoElement(emailAddressTxtField,emailText,10);
        typeTextIntoElement(passwordTxtField,passwordText,10);
        clickOnElement(loginBtn,10);
    }
    public void enterEmailAddress(String text) {
        typeTextIntoElement(emailAddressTxtField,text,10);
    }
    public void enterPassword(String text) {
        typeTextIntoElement(passwordTxtField,text,10);
    }
    public AccountPage clickLoginButton() {
        clickOnElement(loginBtn,10);
        return new AccountPage(driver);
    }
    public String retrieveEmailPasswordWarningMessageText() {
        return getTextFromElement(emailPasswordNotMatchingWarning,10);
    }
}