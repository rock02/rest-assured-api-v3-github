package br.com.roque.integration;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		glue = {  
				 "br.com.roque.integration.login", 
				 "br.com.roque.integration.release", 
				 "br.com.roque.integration.parallel", 
				},
		features = { 
				"src/test/java/br/com/roque/integration/login", 
				"src/test/java/br/com/roque/integration/release", 
				"src/test/java/br/com/roque/integration/parallel", 
				},
		plugin = { "pretty", "json:target/report.json", "de.monochromata.cucumber.report.PrettyReports:target/pretty-cucumber" },
        stepNotifications = true,
        strict = true)
public class RunCucumberIT {

}
