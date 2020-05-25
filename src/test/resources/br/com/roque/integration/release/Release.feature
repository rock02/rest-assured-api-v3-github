Feature: Responsavel pelas releases no git
	
##----------------------------------------------------------------CRIAR RELEASE----------------------------------------------------------------##

	@realizar_criacao_release
	Scenario Outline: Realizar criacao de release
		Given Utilizar dados para autorizacao do login
		And Utilizar dados para criar release:
			|	target_commitish	|	body			|	draft	|	prerelease	|
			|	master				|	criar release	|	false	|	false		|
		When Enviar requisicao "POST" para api release "PATH_RELEASE"
		Then Validar <CODIGO> retorno release
		
		Examples:
			| 	CODIGO	|
			|   201		|
			
	@realizar_criacao_release_branch_invalida
	Scenario Outline: Realizar criacao de release em branch invalida
		Given Utilizar dados para autorizacao do login
		And Utilizar dados para criar release:
			|	target_commitish	|	body			|	draft	|	prerelease	|
			|	invalida			|	criar release	|	false	|	false		|
		When Enviar requisicao "POST" para api release "PATH_RELEASE"
		Then Validar <CODIGO> retorno release
		
		Examples:
			| 	CODIGO	|
			|   401		|
			
			
##----------------------------------------------------------------LISTAR RELEASE----------------------------------------------------------------##
			
	@listar_releases_repositorio
	Scenario Outline: Listar as reliases do repositorio
		Given Utilizar dados para autorizacao do login
		And Utilizar dados para criar release:
			|	target_commitish	|	body			|	draft	|	prerelease	|
			|	master				|	criar relase	|	false	|	false		|
		And Possuir release "<RELEASE>"
		When Enviar requisicao "GET" para api release "PATH_RELEASE"
		Then Validar <CODIGO> retorno release
		
		Examples:
			|	RELEASE 	| 	CODIGO	|
			|	CRIADA		|   200		|
			|	INEXISTENTE	|   401		|
			