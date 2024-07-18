package page;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class p01_loginPage {
    private final By userName = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");

    private final WebDriver driver;

    public p01_loginPage(WebDriver driver) {
        this.driver = driver;
    }

    public po2_landingPage clickOnLogin() {
        Utility.clickingOnElement(driver, loginButton);
        return new po2_landingPage(driver);
    }

    public p01_loginPage enterUserName(String userNameText) {
        Utility.sendData(driver, userName, userNameText);
        return this;
    }

    public p01_loginPage enterPassword(String passwordText) {
        Utility.sendData(driver, password, passwordText);
        return this;
    }

    public Boolean assertLoginTc(String urlText) {
        return driver.getCurrentUrl().equals(urlText);
    }
}
