package com.poc.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (features = {"src/test/resources"},
                glue = {"com.poc.stepDefinitions"},
                plugin = {
                        "rerun:target/rerun.txt",
                        "pretty",
                        "html:target/cucumber.html",
                        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class MainRunnerTest {

}
