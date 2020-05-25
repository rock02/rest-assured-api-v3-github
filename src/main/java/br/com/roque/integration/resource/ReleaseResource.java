package br.com.roque.integration.resource;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.roque.integration.request.ReleaseRequest;

@RestController
@RequestMapping("/release")
public class ReleaseResource {

	@PostMapping
	public ResponseEntity<String> criarRelease(@Valid @RequestBody ReleaseRequest releaseRequest) {
		
		if (releaseRequest.getTarget_commitish().equals("master")) {
			return ResponseEntity.status(HttpStatus.CREATED).body("10");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("branch invalida");
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> criarRelease(@Valid @PathVariable(name = "id") Long id) {
		
		if (id.equals(10L)) {
			return ResponseEntity.status(HttpStatus.OK).body("");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("id invalido");
		}
		
	}
}
