package com.poc.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src\\test\\resources"},
		glue = {"com.poc.stepDefinitions"},
		monochrome = true,
		tags = {},
		plugin = {"pretty", "html:target/cucumber", "com.cucumber.listener.ExtentCucumberFormatter:target/report.html"}
		)
public class MainRunner {

	
}
