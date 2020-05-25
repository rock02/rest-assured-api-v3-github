package br.com.roque.integration.request;

import java.io.Serializable;

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
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @JsonProperty("username")
    @NotNull(message = "não pode ser null")
    @NotEmpty(message = "não pode ser vazio")
    @Size(max = 10)
	private String username;

    @JsonProperty("password")
    @NotNull(message = "não pode ser null")
    @NotEmpty(message = "não pode ser vazio")
    @Size(max = 10)
	private String password;
    
}
