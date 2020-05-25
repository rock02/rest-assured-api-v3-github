package br.com.roque.integration.contract;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.roque.integration.request.LoginRequest;
import br.com.roque.integration.resource.LoginResource;
import br.com.roque.integration.utils.Conversor;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = LoginResource.class)
public class LoginContratTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testLoginNameNull() throws Exception {
		String body = Conversor.objetoPara(LoginRequest.builder().username(null).password("Lipe@12345").build());
		
		mockMvc.perform(MockMvcRequestBuilders.post("/login")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.content(body))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	public void testLoginNameEmBranco() throws Exception {
		String body = Conversor.objetoPara(LoginRequest.builder().username("").password("Lipe@12345").build());
		
		mockMvc.perform(MockMvcRequestBuilders.post("/login")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.content(body))
		.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	public void testLoginPasswordNull() throws Exception {
		String body = Conversor.objetoPara(LoginRequest.builder().username("rock02").password(null).build());
		
		mockMvc.perform(MockMvcRequestBuilders.post("/login")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.content(body))
		.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	public void testLoginPasswordEmBranco() throws Exception {
		String body = Conversor.objetoPara(LoginRequest.builder().username("Rock02").password("").build());
		
		mockMvc.perform(MockMvcRequestBuilders.post("/login")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.content(body))
		.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	public void testLoginNameMaxInvalido() throws Exception {
		String body = Conversor.objetoPara(LoginRequest.builder().username("rock0333333").password("Lipe@1234").build());
		
		mockMvc.perform(MockMvcRequestBuilders.post("/login")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.content(body))
		.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	public void testLoginPasswordMaxInvalido() throws Exception {
		String body = Conversor.objetoPara(LoginRequest.builder().username("rock02").password("Lipe@1234533").build());
		
		mockMvc.perform(MockMvcRequestBuilders.post("/login")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.content(body))
		.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
}
