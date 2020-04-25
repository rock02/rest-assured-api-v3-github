package br.com.roque.integration.release;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	            glue = { "br.com.roque.integration.release" }, 
	            plugin = { "pretty", "json:target/report.json", "de.monochromata.cucumber.report.PrettyReports:target/pretty-cucumber" },
	            stepNotifications = true
				)
public class ReleaseCucumberTest {

}
