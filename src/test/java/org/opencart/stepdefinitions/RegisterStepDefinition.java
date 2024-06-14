package org.opencart.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.opencart.factory.DriverFactory;
import org.opencart.pages.AccountSuccessPage;
import org.opencart.pages.HomePage;
import org.opencart.pages.RegisterPage;;
import org.opencart.utils.Utilities;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import static org.opencart.utils.Constants.*;
import java.util.Map;

public class RegisterStepDefinition {
    private HomePage homePage;
    private RegisterPage registerPage;
    private AccountSuccessPage accountSuccessPage;
    private Utilities utilities = new Utilities();
    @Given("User navigates to Register page")
    public void user_navigates_to_register_page() {
        homePage = new HomePage(DriverFactory.getDriver());
        registerPage = homePage.navigateToRegisterPage();
    }
    @Given("User enters the details into below fields")
    public void user_enters_the_details_into_below_fields(io.cucumber.datatable.DataTable dataTable) {
        Map<String ,String> dataMap = dataTable.asMap(String.class,String.class);
        registerPage.registerWithMandatoryFields(dataMap.get("firstName"),dataMap.get("lastName"),utilities.getEmailWithTimeStamp(),
                dataMap.get("telephone"),dataMap.get("password"));
    }
    @Given("User selects Privacy Policy")
    public void user_selects_privacy_policy() {
        registerPage.selectPrivacyPolicyCheckBox();
    }
    @Given("User clicks on Continue button")
    public void user_clicks_on_continue_button() {
        accountSuccessPage= registerPage.clickContinueButton();
    }
    @Then("User account should get created successfully")
    public void user_account_should_get_created_successfully() {
        Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(),ACCOUNT_CREATED_MSG,"Account success page is not displayed");
    }
    @Given("User selects Yes for Newsletter")
    public void user_selects_yes_for_newsletter() {
        registerPage.selectYesNewsLetterOption();
    }
    @Then("User should get a proper warning about duplicate email")
    public void user_should_get_a_proper_warning_about_duplicate_email() {
        Assert.assertEquals(
                registerPage.retrieveDuplicateEmailAddressWarning(),ACCOUNT_ALREADY_REGISTERED_MSG,"Warning Message is not matched");
    }
    @When("User dont enter any details into fields")
    public void user_dont_enter_any_details_into_fields() {

    }
    @Then("User should get a proper warning messages for every mandatory field")
    public void user_should_get_a_proper_warning_messages_for_every_mandatory_field() {
        Assert.assertEquals(registerPage.retrievePrivacyPolicyWarning(),PRIVATE_POLICY_WARNING_MSG);
        Assert.assertEquals(registerPage.retrieveFirstNameWarning(),FIRST_NAME_WARNING_MSG);
        Assert.assertEquals(registerPage.retrieveLastNameWarning(),LAST_NAME_WARNING_MSG);
        Assert.assertEquals(registerPage.retrieveEmailAddressWarning(),EMAIL_WARNING_MSG);
        Assert.assertEquals(registerPage.retrieveTelephoneWarning(),TELEPHONE_WARNING_MSG);
        Assert.assertEquals(registerPage.retrievePasswordWarning(),PASSWORD_WARNING_MSG);
    }

    @And("User enters the details into below fields with duplicate email")
    public void userEntersTheDetailsIntoBelowFieldsWithDuplicateEmail(io.cucumber.datatable.DataTable dataTable) {
        Map<String ,String> dataMap = dataTable.asMap(String.class,String.class);
        registerPage.registerWithMandatoryFields(dataMap.get("firstName"),dataMap.get("lastName"),dataMap.get("email"),
                dataMap.get("telephone"),dataMap.get("password"));
    }
}