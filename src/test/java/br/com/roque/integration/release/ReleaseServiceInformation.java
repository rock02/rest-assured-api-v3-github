package br.com.roque.integration.release;

import org.springframework.stereotype.Component;

import br.com.roque.integration.request.ReleaseRequest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class ReleaseServiceInformation {

	private ReleaseRequest releaseRequest;
	
	private ReleaseResponse releaseResponse;

	private Response response;

	private RequestSpecification requestSpecification;
	
}
