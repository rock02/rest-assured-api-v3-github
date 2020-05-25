package br.com.roque.integration.release;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.javafaker.Faker;

import br.com.roque.integration.conf.EnumValidationException;
import br.com.roque.integration.login.LoginServiceInformation;
import br.com.roque.integration.request.ReleaseRequest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReleaseStep {

	@Autowired
	private ReleaseServiceInformation releaseService;

	@Autowired
	private LoginServiceInformation loginService;

	@Given("Utilizar dados para autorizacao do login")
	public void criar_autorizacao_login() {

		this.loginService.realizarLogin();

		this.loginService.setRequestSpecification(given().contentType("application/json"));

	}

	@And("Utilizar dados para criar release:")
	public void montar_relase(DataTable dt) {

		ReleaseRequest releaseRequest = this.montarRelease(dt);

		System.out.format(" Thread ID - %2d - Utilizar dados para criar release: %s, %s, %s \n",
				Thread.currentThread().getId(), releaseRequest.getName(), releaseRequest.getTag_name(),
				releaseRequest.getTarget_commitish());

		this.releaseService.setReleaseRequest(releaseRequest);

	}

	@And("Possuir release {string}")
	public void possuir_release(String cenario) throws EnumValidationException, JSONException {

		System.out.format(" Thread ID - %2d - Possuir release %s \n", Thread.currentThread().getId(), cenario);

		if ("INEXISTENTE".equals(cenario)) {

			ReleaseResponse releaseResponse = new ReleaseResponse(-1L);
			this.releaseService.setReleaseResponse(releaseResponse);
		} else
			if ("CRIADA".equals(cenario)) {
				
				this.enviar_requisicao("POST", "PATH_RELEASE");
				this.montarRequestListarRelease();
			} else
		
				assertFalse(false, "cenario nao existe");
	}

	@When("Enviar requisicao {string} para api release {string}")
	public void enviar_requisicao(String tipo, String urlPath) throws EnumValidationException, JSONException {

		System.out.format(" Thread ID - %2d - Enviar requisicao %s para api %s \n", Thread.currentThread().getId(),
				tipo, urlPath);

		if ("POST".equals(tipo.toUpperCase())) {
			
			this.releaseService.setResponse(this.loginService.getRequestSpecification().body(this.releaseService.getReleaseRequest()).when().post(ReleasePathEnum.getPath(urlPath)));

		} else {
			
			if ("GET".equals(tipo.toUpperCase())) {
				
				this.releaseService.setResponse(this.loginService.getRequestSpecification().when()
						.get(new StringBuilder(ReleasePathEnum.getPath(urlPath)).append("/").append(this.releaseService.getReleaseResponse().getId()).toString()));
			} else 
				
				assertFalse(false, "tipo nao existe");
		}
		
	}

	@Then("Validar {int} retorno release")
	public void validar_retorno(int expectedStatusCode) {

		System.out.format(" Thread ID - %2d - Validar %s retorno \n", Thread.currentThread().getId(),
				expectedStatusCode);

		assertEquals(expectedStatusCode, this.releaseService.getResponse().getStatusCode());
	}

	private void montarRequestListarRelease() throws JSONException {

		String id = this.releaseService.getResponse().body().asString();

		ReleaseResponse releaseResponse = ReleaseResponse.builder().id(Long.parseLong(id))
					.build();
			this.releaseService.setReleaseResponse(releaseResponse);

	}

	private ReleaseRequest montarRelease(final DataTable dt) {

		List<Map<String, String>> list = dt.asMaps(String.class, String.class);

		ReleaseRequest releaseRequest = null;

		Faker faker = new Faker();

		for (Map<String, String> item : list) {

			String name = new StringBuilder(faker.name().firstName()).append(".").append(faker.number().randomDigit())
					.toString();

			releaseRequest = ReleaseRequest.builder().loginRequest(this.loginService.getLoginRequest()).name(name)
					.tag_name(name).target_commitish(item.get("target_commitish")).body(item.get("body"))
					.draft(Boolean.valueOf(item.get("draft"))).prerelease(Boolean.valueOf(item.get("prerelease")))
					.build();

		}

		return releaseRequest;
	}
}
