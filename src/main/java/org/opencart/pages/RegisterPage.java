package org.opencart.pages;

import org.opencart.utils.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class RegisterPage extends ElementUtils {
    private WebDriver driver;
    public RegisterPage(final WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
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
        typeTextIntoElement(firstnameTxtField,firstNameText,5);
        typeTextIntoElement(lastnameTxtField,lastNameText,5);
        typeTextIntoElement(emailAddressTxtField,emailText,5);
        typeTextIntoElement(telephoneTxtField,telephoneText,5);
        typeTextIntoElement(passwordTxtField,passwordText,5);
        typeTextIntoElement(passwordConfirmTxtField,passwordText,5);
        passwordConfirmTxtField.sendKeys(passwordText);
    }
    public String retrievePasswordWarning() {
        return getTextFromElement(passwordWarning,10);
    }
    public String retrieveTelephoneWarning() {
        return getTextFromElement(telephoneWarning,10);
    }
    public String retrieveEmailAddressWarning() {
        return getTextFromElement(emailAddressWarning,10);
    }
    public String retrieveLastNameWarning() {
        return getTextFromElement(lastNameWarning,10);
    }
    public String retrieveFirstNameWarning() {
        return getTextFromElement(firstNameWarning,10);
    }
    public String retrievePrivacyPolicyWarning() {
        return getTextFromElement(privacyPolicyWarning,10);
    }
    public void selectPrivacyPolicyCheckBox() {
        clickOnElement(privacyPolicyChkBox,10);
    }
    public AccountSuccessPage clickContinueButton() {
        clickOnElement(continueBtn,10);
        return new AccountSuccessPage(driver);
    }
    public String retrieveDuplicateEmailAddressWarning() {
        return getTextFromElement(duplicateEmailAddressWarning,20);
    }
    public void selectYesNewsLetterOption() {
        clickOnElement(yesNewsLetterOption,10);
    }
}