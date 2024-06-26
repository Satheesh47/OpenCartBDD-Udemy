package org.opencart.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementUtils {
    WebDriver driver;
    public ElementUtils(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnElement(WebElement element,long durationInSeconds) {
        WebElement webElement = waitForElementToBeClickable(element,durationInSeconds);
        webElement.click();
    }
    public void typeTextIntoElement(WebElement element,String text,long durationInSeconds) {
        WebElement webElement = waitForElementToBeClickable(element,durationInSeconds);
        webElement.click();
        webElement.clear();
        webElement.sendKeys(text);
    }
    public WebElement waitForElementToBeClickable(WebElement element, long durationInSeconds) {
        WebElement webElement = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (Throwable e) {
            e.printStackTrace();
        }
        return webElement;
    }
    public void selectOptionInDropdown(WebElement element,String dropDownOption,long durationInSeconds) {
        WebElement webElement = waitForElementToBeClickable(element,durationInSeconds);
        Select select = new Select(webElement);
        select.selectByVisibleText(dropDownOption);
    }
    public void acceptAlert(long durationInSeconds) {
        Alert alert = waitForAlert(durationInSeconds);
        alert.accept();
    }
    public void dismissAlert(long durationInSeconds) {
        Alert alert = waitForAlert(durationInSeconds);
        alert.dismiss();
    }
    public Alert waitForAlert(long durationInSeconds) {
        Alert alert = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(0));
            alert = wait.until(ExpectedConditions.alertIsPresent());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return alert;
    }
    public void mouseHoverAndClick(WebElement element,long durationInSeconds) {
        WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).click().build().perform();
    }
    public WebElement waitForVisibilityOfElement(WebElement element,long durationInSeconds) {
        WebElement webElement = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(0));
            webElement = wait.until(ExpectedConditions.visibilityOf(element));
        }catch (Throwable e){
            e.printStackTrace();
        }
        return webElement;
    }
    public void javaScriptClick(WebElement element,long durationInSeconds) {
        WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",webElement);
    }
    public void javaScriptType(WebElement element,long durationInSeconds,String textToBeTyped) {
        WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='"+textToBeTyped+"'",webElement);
    }
    public String getTextFromElement(WebElement element,long durationInSeconds) {
        WebElement webElement = waitForElementToBeClickable(element,durationInSeconds);
        return webElement.getText();
    }
    public boolean isElementDisplayed(WebElement element,long durationInSeconds) {
        try {
            WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
            return webElement.isDisplayed();
        }catch (Throwable e) {
            e.printStackTrace();
            return false;
        }
    }
}