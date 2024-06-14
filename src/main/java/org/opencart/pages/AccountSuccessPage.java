package org.opencart.pages;

import org.opencart.utils.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class AccountSuccessPage extends ElementUtils{
    public AccountSuccessPage(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@id='content']/h1")
    private WebElement accountSuccessPageHeading;
    public String retrieveAccountSuccessPageHeading() {
        return getTextFromElement(accountSuccessPageHeading,10);
    }
}
