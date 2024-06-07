package org.opencart.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.opencart.factory.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import static org.opencart.utils.Constants.*;

public class MyHooks {
    private WebDriver driver;
    private DriverFactory driverFactory = new DriverFactory();
    @Before
    public void setUp() {
        driver = driverFactory.initializeBrowser(BROWSER);
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_TIME));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIME));
    }
    @After
    public void tearDown(Scenario scenario) {
        String  scenarioName = scenario.getName().replaceAll(" ","_");

        if(scenario.isFailed()) {
            byte[] srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(srcScreenshot,"image/png",scenarioName);
        }

        driver.quit();
    }
}
