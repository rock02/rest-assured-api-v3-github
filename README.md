# TESTES REST API V3 DO GITHUB

## Estrutura do Projeto

**src/test/java**

- config: Pacote com configurações pertinentes aos testes integrados e web 
- integration: Pacote com requisitos referentes aos testes REST API
	- login: Pacote com implementacoes do login e testes
	- release: Pacote com implementacoes da release e testes
	- parallel: Pacote para visualizacao do paralelismo quando os gherkins do cucumber sao compartilhados
		
**src/test/resource**

- login: Pacote com requisitos do login descritos com cucumber
- release: Pacote com requisitos da release descritos com cucumber
- parallel: Pacote com requisitos da parallel descritos com cucumber
	
## Requerimentos

Para executar a aplicação é necessário:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)
- Rodar com JUnit as clases dos pacotes de tests/cucumber ou tests/junit

## Tecnologias

* Java
* Maven
* Rest-assured
* JUnit
* Cucumber
