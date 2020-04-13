package br.com.roque.integration.release;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
				features = { "src/test/resources/release" },
	            glue = { "br.com.roque.integration.release" }, 
//				tags = { "@teste_release_git"},
				plugin = { "pretty", "json:target/report.json", "de.monochromata.cucumber.report.PrettyReports:target/pretty-cucumber" },
				stepNotifications = true,
				monochrome = true
				)
public class ReleaseCucumberTest {

}
