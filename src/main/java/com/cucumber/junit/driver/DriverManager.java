package com.cucumber.junit.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static final String CHROME_DRIVER_PATH = "src/main/resources/chromedriver.exe";
    private static final String GECKO_DRIVER_PATH = "src/main/resources/geckodriver.exe";

    private static WebDriver driver;


    public static WebDriver setupDriver() {

        String browser = System.getProperty("browser");

        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.firefox.driver", GECKO_DRIVER_PATH);
            driver = new FirefoxDriver();
        } else {
            throw new IllegalStateException("This driver is not supported: " + System.getProperty("browser"));
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().maximize();

        return driver;
    }

    public static WebDriver openPage(WebDriver driver, String url) {
        driver.get(url);
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

}
