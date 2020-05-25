package br.com.roque.integration.login;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.roque.integration.conf.EnumValidationException;
import br.com.roque.integration.request.LoginRequest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {

	@Autowired
	private LoginServiceInformation loginService;
	
	@Given("Utilizar dados para autorizacao:")
	public void utilizar_dados_para_autorizacao(DataTable dt) {

		LoginRequest loginRequest = this.utilizarDadosAutorizacao(dt);

		System.out.format(" Thread ID - %2d - Utilizar dados para autorizacao: Login: %s \n",
				Thread.currentThread().getId(), loginRequest.getUsername());

		this.loginService.setLoginRequest(loginRequest);
		
		this.loginService.setRequestSpecification(given().contentType("application/json"));

	}

	private LoginRequest utilizarDadosAutorizacao(DataTable dt) {

		List<Map<String, String>> list = dt.asMaps(String.class, String.class);

		LoginRequest loginRequest = null;

		for (Map<String, String> item : list) {

			loginRequest = LoginRequest.builder().username(item.get("username")).password(item.get("password")).build();
		}

		return loginRequest;
	}
		
	@When("Enviar requisicao {string} para api login {string}")
	public void enviar_requisicao(String tipo, String urlPath) throws EnumValidationException {

		System.out.format(" Thread ID - %2d - Enviar requisicao para api %s \n", Thread.currentThread().getId(),
				urlPath);
		
		if ("POST".equals(tipo)) {
			
			this.loginService.setResponse(this.loginService.getRequestSpecification().body(this.loginService.getLoginRequest()).when().post(LoginPathEnum.getPath(urlPath)));
		} else 
			assertFalse("cenario nao implementado", false);
	
	}

	@Then("Validar {int} retorno login")
	public void validar_retorno(int expectedStatusCode) {

		System.out.format(" Thread ID - %2d - Validar $s retorno \n", Thread.currentThread().getId(),
				expectedStatusCode);

		assertEquals(expectedStatusCode, this.loginService.getResponse().getStatusCode());

	}
}
