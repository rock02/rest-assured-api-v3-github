package br.com.roque.integration.release;


import br.com.roque.integration.conf.EnumValidationException;
import br.com.roque.integration.login.LoginServiceInformation;
import br.com.roque.integration.request.LoginRequest;
import br.com.roque.integration.request.ReleaseRequest;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import static io.restassured.RestAssured.given;

public class ReleaseStep {

    @Autowired
    private LoginServiceInformation loginServiceInformation;
    @Autowired
    private ReleaseServiceInformation releaseServiceInformation;

    @Given( "que estou autenticado no sistema" )
    public void retornaLogin(){
        LoginRequest loginRequest = loginServiceInformation.realizarLogin();
        this.releaseServiceInformation.setLoginRequest( loginRequest );
    }

    @And( "montar o release request {string} e branch {string}" )
    public void montarRequest( String cenarioRequest, String nameRequest){

        if (cenarioRequest.equalsIgnoreCase( "valido" )){
            Faker faker = new Faker();
            this.releaseServiceInformation.setReleaseRequest(ReleaseRequest.builder().name( faker.name().firstName() ).body( faker.name().fullName() ).tag_name( faker.name().firstName() ).target_commitish( nameRequest ).loginRequest( this.releaseServiceInformation.getLoginRequest() ).build());
        } else {

        }
    }

    @When( "fizer requisicao {string} para a api release {string}" )
    public void realizarRequisicao ( String tipo, String urlPath) throws EnumValidationException {
        ReleaseRequest release = this.releaseServiceInformation.getReleaseRequest();
        if (tipo.equalsIgnoreCase( "POST" )){
            Response reponse = given().body( release ).post(ReleasePathEnum.getPath( urlPath ));
            System.out.println(reponse);
        } else {

        }
    }

}
