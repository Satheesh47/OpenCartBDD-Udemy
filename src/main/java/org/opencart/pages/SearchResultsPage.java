package org.opencart.pages;

import org.opencart.utils.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
    private WebDriver driver;
    private ElementUtils elementUtils;
    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        elementUtils = new ElementUtils(driver);
    }
    @FindBy(linkText = "HP LP3065")
    private WebElement validHPProduct;
    @FindBy(xpath = "//h2[contains(text(),'Products meeting the search criteria')]/following-sibling::p")
    private WebElement noProductMessage;
    public boolean displayStatusOfHPValidProduct() {
        return elementUtils.isElementDisplayed(validHPProduct,20);
    }
    public String retrieveNoProductMessageText() {
        return elementUtils.getTextFromElement(noProductMessage,10);
    }
}
