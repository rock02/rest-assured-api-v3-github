package br.com.roque.integration.login;

import org.springframework.stereotype.Component;

import br.com.roque.integration.request.LoginRequest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class LoginServiceInformation {

	private LoginRequest loginRequest;

	private Response response;

	private RequestSpecification requestSpecification;

	public LoginRequest realizarLogin() {
		return this.loginRequest = LoginRequest.builder().username("rock02").password("Lipe@1234").build();
	}

}
