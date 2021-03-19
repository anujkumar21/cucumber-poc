package com.poc.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (features = "@target/rerun.txt",
                glue = {"com.poc.stepDefinitions"},
                plugin = {
                        "pretty",
                        "html:target/cucumber.html",
                        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class RerunRunnerTest {

}
