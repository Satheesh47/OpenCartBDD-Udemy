package org.opencart.pages;

import org.opencart.utils.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    private ElementUtils elementUtils;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        elementUtils = new ElementUtils(driver);
    }
    @FindBy(xpath = "//a[@title='My Account']")
    private WebElement myAccountDropMenu;

    @FindBy(xpath = "//a[text()='Login']")
    private WebElement loginOption;

    @FindBy(xpath = "//a[text()='Register']")
    private WebElement registerOption;
    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchBoxField;
    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    private WebElement searchBtn;

    public LoginPage navigateToLoginPage() {
        elementUtils.clickOnElement(myAccountDropMenu,10);
        elementUtils.clickOnElement(loginOption,10);
        return new LoginPage(driver);
    }

    public void enterProductIntoSearchBoxField(String text) {
        elementUtils.typeTextIntoElement(searchBoxField,text,10);
    }
    public RegisterPage navigateToRegisterPage() {
        elementUtils.clickOnElement(myAccountDropMenu,10);
        elementUtils.clickOnElement(registerOption,10);
        return new RegisterPage(driver);
    }
    public SearchResultsPage clickOnSearchButton() {
        elementUtils.clickOnElement(searchBtn,10);
        return new SearchResultsPage(driver);
    }
}
