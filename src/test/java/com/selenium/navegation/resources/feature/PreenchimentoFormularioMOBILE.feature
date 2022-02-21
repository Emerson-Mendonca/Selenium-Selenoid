@all @PG_ADD_TO_CART @MOBILE
Feature: login

  Background: Selecione qual Driver WEB ou MOBILE
    Given que selecione o driver "MOBILE"


  Scenario: Preencher do formulário
    Given que o usuario esteja na pagina inicial
    And preencher o campo qual seu nome completo "Emerson Silva"
    And preencher o campo qual qual seu email "email.teste@teste.com.br"
    And preencher o campo qual qual sua cor favorita "Vermelho"
    And preencher o campo qual qual sua sobremesa favorita "Fruta"
    And preencher o campo qual qual sua comida favorita  "Legumes"
    And preencher o campo qual o quanto voce gosta de animas de um 1 a 10 "6"
    And preencher o campo qual considere os esportes
      | esportes | tipo    |
      | Futebol  | Ótimo   |
      | Rugby    | Bom     |
      | Baseball | Mediano |
      | eSport   | Ruim    |
    And preencher o campo qual quais os ingredientes do sandwich
      | sandwich    | Pao | Carne | Queijo | Ovo | Salada |
      | Hamburguer  | X   | X     | X      |     | X      |
      | Vegetariano | X   |       |        |     | X      |
      | EggXburger  | X   | X     |        | X   | X      |
      | Xburguer    | X   | X     | X      |     |        |
    And preencher o campo que dia e hoje
    Then preencher o campo daqui uma hora que horas serao