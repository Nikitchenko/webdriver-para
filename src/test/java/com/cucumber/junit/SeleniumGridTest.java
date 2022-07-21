package com.cucumber.junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SeleniumGridTest {

    @Test
    public void testGoogle() throws MalformedURLException, InterruptedException {

        System.setProperty("webdriver.firefox.driver", "src/main/resources/geckodriver.exe");
        DesiredCapabilities caps = DesiredCapabilities.firefox();

        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.56.1:4444"), caps);
        driver.get("https://www.google.com/");

        assertAll("Check the Title",
                () -> assertEquals("Google", driver.getTitle(),
                        "Invalid Title")
        );

        Thread.sleep(3000);
        driver.quit();
    }

}
