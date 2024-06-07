package org.opencart.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/org/opencart/features",glue = "org.opencart.stepdefinitions",
        monochrome = true,publish = true,plugin = {"pretty","html:target/CucumberReports/CucumberReport.html"})
public class TestNGRunner extends AbstractTestNGCucumberTests{

}
