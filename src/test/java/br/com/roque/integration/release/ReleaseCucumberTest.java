package br.com.roque.integration.release;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
				features = { "src/test/resources/release" },
	            glue = { "br.com.roque.integration.release" }, 
//				tags = { "@teste_release_git"},
				plugin = { "de.monochromata.cucumber.report.PrettyReports:target/cucumber" },
				stepNotifications = true
				)
public class ReleaseCucumberTest {

}
