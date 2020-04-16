package br.com.roque.integration.login;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginService {

	private LoginRequest loginRequest;

	private Response response;

	private RequestSpecification requestSpecification;

	public RequestSpecification getRequestSpecification() {
		return requestSpecification;
	}

	public void setRequestSpecification(RequestSpecification requestSpecification) {
		this.requestSpecification = requestSpecification;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public LoginRequest getLoginRequest() {
		return loginRequest;
	}

	public void setLoginRequest(LoginRequest loginRequest) {
		this.loginRequest = loginRequest;
	}

	public RequestSpecification realizarLogin() {
		return given().auth().preemptive()
				.basic("rock02", "Lipe@1234");
	}

}
