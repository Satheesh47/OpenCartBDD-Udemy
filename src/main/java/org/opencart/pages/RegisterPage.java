package org.opencart.pages;

import org.opencart.utils.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class RegisterPage {
    private WebDriver driver;
    private ElementUtils elementUtils;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        elementUtils = new ElementUtils(driver);
    }
    @FindBy(id = "input-firstname")
    private WebElement firstnameTxtField;
    @FindBy(id = "input-lastname")
    private WebElement lastnameTxtField;
    @FindBy(id = "input-email")
    private WebElement emailAddressTxtField;
    @FindBy(id = "input-telephone")
    private WebElement telephoneTxtField;
    @FindBy(id = "input-password")
    private WebElement passwordTxtField;
    @FindBy(id = "input-confirm")
    private WebElement passwordConfirmTxtField;
    @FindBy(xpath = "//*[@name='agree']")
    private WebElement privacyPolicyChkBox;
    @FindBy(xpath = "//*[@type='submit']")
    private WebElement continueBtn;
    @FindBy(xpath = "//input[@name='newsletter' and @value='1']")
    private WebElement yesNewsLetterOption;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement duplicateEmailAddressWarning;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement privacyPolicyWarning;
    @FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
    private WebElement firstNameWarning;
    @FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
    private WebElement lastNameWarning;
    @FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
    private WebElement emailAddressWarning;
    @FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
    private WebElement telephoneWarning;
    @FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
    private WebElement passwordWarning;

    public void registerWithMandatoryFields(String firstNameText, String lastNameText, String emailText, String telephoneText, String passwordText) {
        elementUtils.typeTextIntoElement(firstnameTxtField,firstNameText,5);
        elementUtils.typeTextIntoElement(lastnameTxtField,lastNameText,5);
        elementUtils.typeTextIntoElement(emailAddressTxtField,emailText,5);
        elementUtils.typeTextIntoElement(telephoneTxtField,telephoneText,5);
        elementUtils.typeTextIntoElement(passwordTxtField,passwordText,5);
        elementUtils.typeTextIntoElement(passwordConfirmTxtField,passwordText,5);
        passwordConfirmTxtField.sendKeys(passwordText);
        //privacyPolicyChkBox.click();
        //continueBtn.click();
        //return new AccountSuccessPage(driver);
    }
    public String retrievePasswordWarning() {
        return elementUtils.getTextFromElement(passwordWarning,10);
    }
    public String retrieveTelephoneWarning() {
        return elementUtils.getTextFromElement(telephoneWarning,10);
    }
    public String retrieveEmailAddressWarning() {
        return elementUtils.getTextFromElement(emailAddressWarning,10);
    }
    public String retrieveLastNameWarning() {
        return elementUtils.getTextFromElement(lastNameWarning,10);
    }
    public String retrieveFirstNameWarning() {
        return elementUtils.getTextFromElement(firstNameWarning,10);
    }
    public String retrievePrivacyPolicyWarning() {
        return elementUtils.getTextFromElement(privacyPolicyWarning,10);
    }
    public void selectPrivacyPolicyCheckBox() {
        elementUtils.clickOnElement(privacyPolicyChkBox,10);
    }
    public AccountSuccessPage clickContinueButton() {
        elementUtils.clickOnElement(continueBtn,10);
        return new AccountSuccessPage(driver);
    }
    public String retrieveDuplicateEmailAddressWarning() {
        return elementUtils.getTextFromElement(duplicateEmailAddressWarning,20);
    }
    public void selectYesNewsLetterOption() {
        elementUtils.clickOnElement(yesNewsLetterOption,10);
    }
}
