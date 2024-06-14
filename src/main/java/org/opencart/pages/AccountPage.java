package org.opencart.pages;

import org.opencart.utils.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends ElementUtils{
    public AccountPage(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "Edit your account information")
    private WebElement editYourAccountInformationOption;
    public boolean getDisplayedStatusOfEditYourAccountInformationOption() {
        return isElementDisplayed(editYourAccountInformationOption,20);
    }
}
