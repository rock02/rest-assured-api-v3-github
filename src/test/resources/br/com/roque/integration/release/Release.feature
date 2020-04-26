Feature: Responsavel pelas releases no git
	
##----------------------------------------------------------------CRIAR RELEASE----------------------------------------------------------------##

	@realizar_criacao_release
	Scenario Outline: Realizar criacao de release
		Given Utilizar dados para autorizacao do login
		And Utilizar dados para criar release:
			|	target_commitish	|	body			|	draft	|	prerelease	|
			|	master				|	criar relase	|	false	|	false		|
		When Enviar requisicao "POST" para api "PATH_RELEASE"
		Then Validar <CODIGO> retorno release
		
		Examples:
			| 	CODIGO	|
			|   201		|
			
	@realizar_criacao_release_branch_invalida
	Scenario Outline: Realizar criacao de release em branch invalida
		Given Utilizar dados para autorizacao do login
		And Utilizar dados para criar release:
			|	target_commitish	|	body			|	draft	|	prerelease	|
			|	invalida			|	criar relase	|	false	|	false		|
		When Enviar requisicao "POST" para api "PATH_RELEASE"
		Then Validar <CODIGO> retorno release
		
		Examples:
			| 	CODIGO	|
			|   422		|
			
			
##----------------------------------------------------------------LISTAR RELEASE----------------------------------------------------------------##
			
	@listar_releases_repositorio
	Scenario Outline: Listar as reliases do repositorio
		Given Utilizar dados para autorizacao do login
		And Utilizar dados para criar release:
			|	target_commitish	|	body			|	draft	|	prerelease	|
			|	master				|	criar relase	|	false	|	false		|
		And Enviar requisicao "POST" para api "PATH_RELEASE"
		When Enviar requisicao "GET" para api "PATH_RELEASE"
		Then Validar <CODIGO> retorno release
		
		Examples:
			| 	CODIGO	|
			|   200		|
			
##----------------------------------------------------------------DELETAR RELEASE----------------------------------------------------------------##
			
	@deletar_releases
	Scenario Outline: Detelar uma release do repositorio
		Given Utilizar dados para autorizacao do login
		And Utilizar dados para criar release:
			|	target_commitish	|	body			|	draft	|	prerelease	|
			|	master				|	criar relase	|	false	|	false		|
		And Enviar requisicao "POST" para api "PATH_RELEASE"
		And Possuir release "<CENARIO>"
		When Enviar requisicao "DELETE" para api "PATH_RELEASE"
		Then Validar <CODIGO> retorno release
		
		Examples:
			|	CENARIO			| 	CODIGO	|
			|	VALIDO			|   204		|
			|	INEXISTENTE		|   404		|