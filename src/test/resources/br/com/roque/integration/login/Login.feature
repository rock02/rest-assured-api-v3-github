Feature: Responsavel pelo login no git
	
##----------------------------------------------------------------LOGIN----------------------------------------------------------------##

	@realizar_login_git_dados_validos
	Scenario Outline: Realizar login no git com dados validos
		Given Utilizar dados para autorizacao:
			|	username	|	 password		|
			|	rock02 		|	 Lipe@1234		|
		When Enviar requisicao "POST" para api login "PATH_LOGIN"
		Then Validar <CODIGO> retorno login
		
		Examples:
			| 	CODIGO		|
			|   201			|
			
	@realizar_login_git_dados_invalidos
	Scenario Outline: Realizar login no git com dados invalidos
		Given Utilizar dados para autorizacao:
			|	username	|	 password			|
			|	rock022 	|	 Lipe@1		|
		When Enviar requisicao "POST" para api login "PATH_LOGIN"
		Then Validar <CODIGO> retorno login
		
		Examples:
			| 	CODIGO		|
			|   401			|
			
		