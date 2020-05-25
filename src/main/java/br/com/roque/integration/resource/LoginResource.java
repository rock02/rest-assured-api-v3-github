package br.com.roque.integration.resource;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.roque.integration.request.LoginRequest;

@RestController
@RequestMapping("/login")
public class LoginResource {

	@PostMapping
	public ResponseEntity<String> logar(@Valid @RequestBody LoginRequest loginRequest) {
		
		if (loginRequest.getUsername().equals("rock02") && loginRequest.getPassword().equals("Lipe@1234"))
			return ResponseEntity.status(HttpStatus.CREATED).body("login realizado");
		else
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("login nao autorizado");
	}
}
