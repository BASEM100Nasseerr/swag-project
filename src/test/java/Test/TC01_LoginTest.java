package Test;

import Utilities.DataUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.p01_loginPage;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.getDriver;
import static DriverFactory.DriverFactory.setupDriver;

public class TC01_LoginTest {
    private final String USERNAME = DataUtils.getJsonData("validLogin", "username");
    private final String PASSWORD = DataUtils.getJsonData("validLogin", "password");

    @BeforeMethod

    public void setup() throws IOException {
        setupDriver(DataUtils.getPropertyValue("environment", "Browser"));
        getDriver().get(DataUtils.getPropertyValue("environment", "BASE_URL"));
        getDriver().manage().timeouts().
                implicitlyWait(Duration.ofSeconds(10));
    }

    @Test

    public void validTestCases() {
        new p01_loginPage(getDriver()).enterUserName(USERNAME)
                .enterPassword(PASSWORD).clickOnLogin();
        Assert.assertTrue();

    }

    @AfterMethod
    public void quite() {

    }
}
