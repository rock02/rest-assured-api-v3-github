package br.com.roque.integration.release;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.github.javafaker.Faker;

import br.com.roque.integration.conf.EnumValidationException;
import br.com.roque.integration.login.LoginStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ReleaseStep {

	private ReleaseService releaseService = new ReleaseService();

	@Given("Utilizar dados para autorizacao do login:")
	public void criar_autorizacao_login(DataTable dt) {

		LoginStep loginStep = new LoginStep();

		RequestSpecification requestSpecification = loginStep.utilizar_dados_para_autorizacao(dt);
		releaseService.setRequestSpecification(requestSpecification);
	}

	@And("Utilizar dados para criar release:")
	public void montar_relase(DataTable dt) {

		ReleaseRequest releaseRequest = this.montarRelease(dt);

		System.out.format(" Thread ID - %2d - Utilizar dados para criar release: %s, %s, %s \n",
				Thread.currentThread().getId(), releaseRequest.getName(), releaseRequest.getTag_name(),
				releaseRequest.getTarget_commitish());

		releaseService.setReleaseRequest(releaseRequest);

	}

	@And("Possuir release {string}")
	public void possuir_release(String cenario) throws EnumValidationException, JSONException {

		System.out.format(" Thread ID - %2d - Possuir release %s \n", Thread.currentThread().getId(), cenario);

		this.enviar_requisicao("GET", "PATH_RELEASE");

		if ("INEXISTENTE".equals(cenario)) {

			ReleaseResponse releaseResponse = new ReleaseResponse(-1L);
			releaseService.setReleaseResponse(releaseResponse);
		} else
			this.montarRequestDetetarRelease();

	}

	@When("Enviar requisicao {string} para api {string}")
	public void enviar_requisicao(String tipo, String urlPath) throws EnumValidationException {

		System.out.format(" Thread ID - %2d - Enviar requisicao %s para api %s \n", Thread.currentThread().getId(),
				tipo, urlPath);

		String url = null;

		Response response = null;

		switch (urlPath) {

		case "PATH_RELEASE":

			if ("POST".equals(tipo.toUpperCase())) {

				releaseService.getRequestSpecification().accept("application/json")
						.body(releaseService.getReleaseRequest());

				url = new StringBuilder(ReleasePathEnum.getPath(urlPath).replaceAll("%owner", "rock02")
						.replaceAll("%repo", "TesteApiGit")).toString();

				response = releaseService.getRequestSpecification().when().post(url).andReturn();
			} else if ("GET".equals(tipo.toUpperCase())) {

				url = new StringBuilder(ReleasePathEnum.getPath(urlPath).replaceAll("%owner", "rock02")
						.replaceAll("%repo", "TesteApiGit")).toString();
				response = releaseService.getRequestSpecification().accept("application/json").when().get(url)
						.andReturn();
			}

			else {

				url = new StringBuilder(ReleasePathEnum.getPath(urlPath).replaceAll("%owner", "rock02")
						.replaceAll("%repo", "TesteApiGit")).append("/")
								.append(releaseService.getReleaseResponse().getId()).toString();
				response = releaseService.getRequestSpecification().when().delete(url).andReturn();
			}
			break;
		}

		releaseService.setResponse(response);
	}

	@Then("Validar {int} retorno")
	public void validar_retorno(int expectedStatusCode) {

		System.out.format(" Thread ID - %2d - Validar %s retorno \n", Thread.currentThread().getId(),
				expectedStatusCode);

		assertEquals(expectedStatusCode, releaseService.getResponse().getStatusCode());
	}

	private void montarRequestDetetarRelease() throws JSONException {

		JSONArray contents = new JSONArray(releaseService.getResponse().body().asString());

		Random random = new Random();

		if (Objects.nonNull(contents) && contents.length() > 0) {

			JSONObject release = contents.getJSONObject(random.nextInt(contents.length() - 1));

			ReleaseResponse releaseResponse = new ReleaseResponse(Long.parseLong(release.get("id").toString()));
			releaseService.setReleaseResponse(releaseResponse);
		}

	}

	private ReleaseRequest montarRelease(final DataTable dt) {

		List<Map<String, String>> list = dt.asMaps(String.class, String.class);

		ReleaseRequest releaseRequest = null;

		Faker faker = new Faker();

		for (Map<String, String> item : list) {

			String name = new StringBuilder(faker.name().firstName()).append(".").append(faker.number().randomDigit())
					.toString();

			releaseRequest = new ReleaseRequest(name, name, item.get("target_commitish"), item.get("body"),
					Boolean.valueOf(item.get("draft")), Boolean.valueOf(item.get("prerelease")));
		}

		return releaseRequest;
	}
}
