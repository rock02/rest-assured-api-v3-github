Feature: Criacao de release

##----------------------------------------------------------------RELEASE----------------------------------------------------------------##

  @realizar_criacao_release
  Scenario: Realizar criacao de release
    Given que estou autenticado no sistema
    And montar o release request "valido" e branch "master"
    When fizer requisicao "POST" para a api release "PATH_RELEASE"

