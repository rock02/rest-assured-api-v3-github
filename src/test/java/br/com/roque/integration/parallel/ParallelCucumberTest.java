package br.com.roque.integration.parallel;

import org.junit.Ignore;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@Ignore
@CucumberOptions(
		features = { "src/test/resources/parallel" },
        glue = { "br.com.roque.integration.parallel" }, 
//		tags = { "@teste_login_git"},
        		plugin = { "pretty", "html:target/cucumber-html-report", "json:target/cucumber.json", "junit:target/cucumber.xml", "rerun:target/rerun.txt" },
        stepNotifications = true
		)
public class ParallelCucumberTest {

}
