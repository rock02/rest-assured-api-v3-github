package br.com.roque.integration.request;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReleaseRequest {
	
	@Valid
	private LoginRequest loginRequest;

	@JsonProperty("name")
	@NotNull(message = "não pode ser null")
	@NotEmpty(message = "não pode ser vazio")
	@Size(max = 20)
	private String name;

	@JsonProperty("tag_name")
	@NotNull(message = "não pode ser null")
	@NotEmpty(message = "não pode ser vazio")
	@Size(max = 20)
	private String tag_name;

	@JsonProperty("target_commitish")
	@NotNull(message = "não pode ser null")
	@NotEmpty(message = "não pode ser vazio")
	@Size(max = 20)
	private String target_commitish;

	@JsonProperty("body")
	private String body;

	private Boolean draft;

	private Boolean prerelease;

}
