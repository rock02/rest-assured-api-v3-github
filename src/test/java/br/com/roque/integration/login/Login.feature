Feature: Responsavel pelo login no git
	
##----------------------------------------------------------------LOGIN----------------------------------------------------------------##

	@realizar_login_git_dados_validos
	Scenario Outline: Realizar login no git com dados validos
		Given Utilizar dados para autorizacao:
			|	username	|	 password		|
			|	rock02 		|	 Lipe@1234		|
		When Enviar requisicao para api "PATH_LOGIN"
		Then Validar <CODIGO> retorno login
		
		Examples:
			| 	CODIGO		|
			|   200			|
			
	@realizar_login_git_dados_invalidos
	Scenario Outline: Realizar login no git com dados invalidos
		Given Utilizar dados para autorizacao:
			|	username	|	 password			|
			|	rock02 		|	 Lipe@1234555		|
		When Enviar requisicao para api "PATH_LOGIN"
		Then Validar <CODIGO> retorno login
		
		Examples:
			| 	CODIGO		|
			|   401			|
			
		