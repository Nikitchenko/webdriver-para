package com.cucumber.junit.steps;

import com.cucumber.junit.driver.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpenPageSteps {


    private WebDriver driver;

    @Given("I am set the Webdriver")
    public WebDriver iAmSetTheWebdriver() {
        driver = DriverManager.setupDriver();
        return driver;
    }

    @When("I open the {string} Webpage")
    public void iOpenTheWebpage(String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(3000);
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
