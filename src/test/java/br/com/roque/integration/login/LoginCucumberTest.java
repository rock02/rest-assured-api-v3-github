package br.com.roque.integration.login;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "src/test/resources/login" },
        glue = { "br.com.roque.integration.login" }, 
//		tags = { "@teste_login_git"},
		plugin = { "pretty", "html:target/cucumber-html-report", "json:target/cucumber.json", "junit:target/cucumber.xml", "rerun:target/rerun.txt" },
        stepNotifications = true
		)
public class LoginCucumberTest {
	
}
