package org.opencart.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.opencart.factory.DriverFactory;
import org.opencart.pages.HomePage;
import org.opencart.pages.SearchResultsPage;
import static org.opencart.utils.Constants.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchStepDefinition {
    private WebDriver driver;
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    @Given("User opens the application")
    public void user_opens_the_application() {
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
    }
    @When("User enters valid product {string} into Search box field")
    public void user_enters_valid_product_into_search_box_field(String validProduct) {
        homePage.enterProductIntoSearchBoxField(validProduct);
    }
    @When("User clicks on Search button")
    public void user_clicks_on_search_button() {
        searchResultsPage = homePage.clickOnSearchButton();
    }
    @Then("User should get valid product displayed in Search results")
    public void user_should_get_valid_product_displayed_in_search_results() {
        Assert.assertTrue(searchResultsPage.displayStatusOfHPValidProduct(),"HP product is not displayed");
    }
    @When("User enters invalid product {string} into Search box field")
    public void user_enters_invalid_product_into_search_box_field(String invalidProduct) {
        homePage.enterProductIntoSearchBoxField(invalidProduct);
    }
    @Then("User should get a message about no product matching")
    public void user_should_get_a_message_about_no_product_matching() {
        Assert.assertEquals(searchResultsPage.retrieveNoProductMessageText(),NO_PRODUCT_SEARCH_RESULTS_MSG,"No product message in search results is not displayed");
    }
    @When("User dont enter any product name into Search box field")
    public void user_dont_enter_any_product_name_into_search_box_field() {

    }
}