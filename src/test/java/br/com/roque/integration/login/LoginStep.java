package br.com.roque.integration.login;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import br.com.roque.integration.conf.EnumValidationException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;

public class LoginStep {

	private LoginService loginService = new LoginService();

	@Given("Utilizar dados para autorizacao:")
	public RequestSpecification utilizar_dados_para_autorizacao(DataTable dt) {
        
		LoginRequest loginRequest = this.utilizarDadosAutorizacao(dt);
		
		System.out.format("Thread ID - %2d - Utilizar dados para autorizacao: Login: %s\n",
		        Thread.currentThread().getId(), loginRequest.getUsername());
		
		loginService.setLoginRequest(loginRequest);
		
		loginService.setRequestSpecification(given().auth().preemptive()
				.basic(loginService.getLoginRequest().getUsername(), loginService.getLoginRequest().getPassword()));
		
		return loginService.getRequestSpecification();
	}

	private LoginRequest utilizarDadosAutorizacao(DataTable dt) {

		List<Map<String, String>> list = dt.asMaps(String.class, String.class);

		LoginRequest loginRequest = null;

		for (Map<String, String> item : list) {

			loginRequest = new LoginRequest(item.get("username"), item.get("password"));
		}

		return loginRequest;
	}

	@When("Enviar requisicao para api {string}")
	public void enviar_requisicao(String urlPath) throws EnumValidationException {
		
		System.out.format("Thread ID - %2d - Enviar requisicao para api %s\n",
		        Thread.currentThread().getId(), urlPath);
		
		loginService.setResponse(loginService.getRequestSpecification().when().get(LoginPathEnum.getPath(urlPath)));

	}

	@Then("Validar {int} retorno")
	public void validar_retorno(int expectedStatusCode) {
		
		System.out.format("Thread ID - %2d - Validar $s retorno\n",
		        Thread.currentThread().getId(), expectedStatusCode);

		assertEquals(expectedStatusCode, loginService.getResponse().getStatusCode());
		
	}
}
