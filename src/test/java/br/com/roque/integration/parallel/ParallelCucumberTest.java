package br.com.roque.integration.parallel;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "src/test/resources/parallel" },
        glue = { "br.com.roque.integration.parallel" }, 
//		tags = { "@teste_login_git"},
		plugin = { "pretty", "json:target/report.json", "de.monochromata.cucumber.report.PrettyReports:target/pretty-cucumber" },
        stepNotifications = true,
		monochrome = true
		)
public class ParallelCucumberTest {

}
