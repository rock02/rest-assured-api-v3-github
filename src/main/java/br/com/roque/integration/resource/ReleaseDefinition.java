package br.com.roque.integration.resource;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.roque.integration.request.ReleaseRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags={ "Release" })
public interface ReleaseDefinition {

    @ApiOperation(value = "Criar release", nickname = "criarRelease", notes = "Criar release")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "CREATED"),
            @ApiResponse(code = 401, message = "Requisição não autorizada"),
            @ApiResponse(code = 500, message = "Erro interno no servidor") })
    ResponseEntity<String> criarRelease(@Valid @RequestBody ReleaseRequest releaseRequest);
   
    @ApiOperation(value = "Consultar Release", nickname = "getRelease", notes = "Consultar release")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Requisição não autorizada"),
            @ApiResponse(code = 500, message = "Erro interno no servidor") })
    ResponseEntity<String> getRelease(@Valid @PathVariable(name = "id") Long id);
}
