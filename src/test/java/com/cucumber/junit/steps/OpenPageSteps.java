package com.cucumber.junit.steps;

import com.cucumber.junit.driver.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpenPageSteps {


    private WebDriver driver;

    @Given("I am set the Webdriver")
    public WebDriver iAmSetTheWebdriver() {
        driver = DriverManager.setupDriver();
        return driver;

    }

    @When("^I open the 'Google' Webpage$")
    public void iOpenTheGoogleWebpage() throws SQLException, InterruptedException {
        DriverManager.openPage(driver, "https://www.google.com/");
        Thread.sleep(1000);
    }

    @When("^I open the 'EPAM' Webpage")
    public void iOpenTheEPAMWebpage() throws InterruptedException {
        DriverManager.openPage(driver, "https://www.epam.com/");
        Thread.sleep(1000);
    }

    @When("^I open the 'BookDepository' Webpage$")
    public void iOpenTheBookDEpositoryWebpage() throws InterruptedException {
        DriverManager.openPage(driver, "https://www.bookdepository.com/");
        Thread.sleep(1000);
    }

    @Then("I verify the Title, it is {string}")
    public void iVerifyTheGoogleTitleIs(String title) {
        assertAll("Check the Title",
                () -> assertEquals(title, driver.getTitle(),
                        "Invalid Title")
        );
    }

    @And("I close the Browser")
    public void iCloseTheBrowser() {
        DriverManager.quitDriver();
    }


}
