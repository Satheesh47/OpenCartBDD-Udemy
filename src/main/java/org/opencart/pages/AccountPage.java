package org.opencart.pages;

import org.opencart.utils.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    private WebDriver driver;
    private ElementUtils elementUtils;
    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        elementUtils = new ElementUtils(driver);
    }
    @FindBy(linkText = "Edit your account information")
    private WebElement editYourAccountInformationOption;
    public boolean getDisplayedStatusOfEditYourAccountInformationOption() {
        return elementUtils.isElementDisplayed(editYourAccountInformationOption,20);
    }
}
