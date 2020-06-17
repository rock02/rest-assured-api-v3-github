package br.com.roque.integration.resource;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.roque.integration.request.LoginRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags={ "Login" })
public interface LoginDefinition {

    @ApiOperation(value = "Realizar login", nickname = "logar", notes = "Realizar login")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "CREATED"),
            @ApiResponse(code = 401, message = "Requisição não autorizada"),
            @ApiResponse(code = 500, message = "Erro interno no servidor") })
    ResponseEntity<String> logar(@Valid @RequestBody LoginRequest loginRequest);
}
