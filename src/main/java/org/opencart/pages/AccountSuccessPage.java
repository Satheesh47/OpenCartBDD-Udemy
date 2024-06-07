package org.opencart.pages;

import org.opencart.utils.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class AccountSuccessPage {
    private WebDriver driver;
    private ElementUtils elementUtils;
    public AccountSuccessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        elementUtils = new ElementUtils(driver);
    }
    @FindBy(xpath = "//div[@id='content']/h1")
    private WebElement accountSuccessPageHeading;
    public String retrieveAccountSuccessPageHeading() {
        return elementUtils.getTextFromElement(accountSuccessPageHeading,10);
    }
}
