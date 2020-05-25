package br.com.roque.integration.conf;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import br.com.roque.integration.Application;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource(properties = "server.port=8080")
@ActiveProfiles(profiles={"test", "qa", "stg"}, resolver=ProfilesResolver.class)
public class CucumberTestContextConfiguration {

}
