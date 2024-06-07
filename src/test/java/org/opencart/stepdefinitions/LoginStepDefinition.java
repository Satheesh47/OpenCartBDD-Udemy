package org.opencart.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.opencart.factory.DriverFactory;
import org.opencart.pages.AccountPage;
import org.opencart.pages.HomePage;
import org.opencart.pages.LoginPage;
import org.opencart.utils.Utilities;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static org.opencart.utils.Constants.EMAIL_PASSWORD_BLANK_WARNING_MSG;
import static org.opencart.utils.Constants.EMAIL_PASSWORD_NOT_MATCHING_WARNING_MSG;

public class LoginStepDefinition {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private Utilities utilities = new Utilities();
    @Given("User navigates to Login page")
    public void user_navigates_to_login_page() {
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
        loginPage = homePage.navigateToLoginPage();
    }
    @When("^User enters valid email address (.+) into email field$")
    public void user_enters_valid_email_address_into_email_field(String email) {
        loginPage.enterEmailAddress(email);
    }
    @When("^User enters valid password (.+) into password field$")
    public void user_enters_valid_password_into_password_field(String password) {
        loginPage.enterPassword(password);
    }
    @When("User clicks on Login button")
    public void user_clicks_on_login_button() {
        accountPage = loginPage.clickLoginButton();
    }
    @Then("User should get successfully logged in")
    public void user_should_get_successfully_logged_in() {
        Assert.assertTrue(accountPage.getDisplayedStatusOfEditYourAccountInformationOption(),"Edit your account information is not displayed");
    }
    @When("User enters invalid email address into email field")
    public void user_enters_invalid_email_address_into_email_field() {
        loginPage.enterEmailAddress(utilities.getEmailWithTimeStamp());
    }
    @When("User enters invalid password address {string} into password field")
    public void user_enters_invalid_password_address_into_password_field(String invalidPassword) {
        loginPage.enterPassword(invalidPassword);
    }
    @Then("User should get a proper warning message about credentials mismatch")
    public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
        Assert.assertEquals(loginPage.retrieveEmailPasswordWarningMessageText(),EMAIL_PASSWORD_NOT_MATCHING_WARNING_MSG,"Warning message is not displayed");
    }
    @When("User dont enter email address into email field")
    public void user_dont_enter_email_address_into_email_field() {
        loginPage.enterEmailAddress("");
    }
    @When("User dont enter password into password field")
    public void user_dont_enter_password_into_password_field() {
        loginPage.enterPassword("");
    }
    @Then("User should get a proper warning message about blank credentials")
    public void userShouldGetAProperWarningMessageAboutBlankCredentials() {
        Assert.assertEquals(loginPage.retrieveEmailPasswordWarningMessageText(),EMAIL_PASSWORD_BLANK_WARNING_MSG,"Warning message is not displayed");
    }
}