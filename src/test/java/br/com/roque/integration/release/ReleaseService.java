package br.com.roque.integration.release;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ReleaseService {

	private ReleaseRequest releaseRequest;
	
	private ReleaseResponse releaseResponse;

	private Response response;

	private RequestSpecification requestSpecification;
	
//	public ReleaseService() {
//		super();
//	}

	public ReleaseResponse getReleaseResponse() {
		return releaseResponse;
	}

	public void setReleaseResponse(ReleaseResponse releaseResponse) {
		this.releaseResponse = releaseResponse;
	}

	public ReleaseRequest getReleaseRequest() {
		return releaseRequest;
	}

	public void setReleaseRequest(ReleaseRequest releaseRequest) {
		this.releaseRequest = releaseRequest;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public RequestSpecification getRequestSpecification() {
		return requestSpecification;
	}

	public void setRequestSpecification(RequestSpecification requestSpecification) {
		this.requestSpecification = requestSpecification;
	}
}
