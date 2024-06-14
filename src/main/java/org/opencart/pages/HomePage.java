package org.opencart.pages;

import org.opencart.utils.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends ElementUtils{
    private WebDriver driver;
    public HomePage(final WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
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
        clickOnElement(myAccountDropMenu,10);
        clickOnElement(loginOption,10);
        return new LoginPage(driver);
    }
    public void enterProductIntoSearchBoxField(String text) {
        typeTextIntoElement(searchBoxField,text,10);
    }
    public RegisterPage navigateToRegisterPage() {
        clickOnElement(myAccountDropMenu,10);
        clickOnElement(registerOption,10);
        return new RegisterPage(driver);
    }
    public SearchResultsPage clickOnSearchButton() {
        clickOnElement(searchBtn,10);
        return new SearchResultsPage(driver);
    }
}