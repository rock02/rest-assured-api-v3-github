package br.com.roque.integration.release;

import br.com.roque.integration.request.LoginRequest;
import br.com.roque.integration.request.ReleaseRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class ReleaseServiceInformation {

    private LoginRequest loginRequest;
    private ReleaseRequest releaseRequest;

}
