# Seleniun Test Google forms

## Getting Started
Clonar o projeto de automação
https://alelo.visualstudio.com/AleloAuto-2.0/_git/aleloauto-automacao

### Prerequisites

* JDK - 1.8

* Maven  

* Docker

## Running Docker

Executar o comando mvn test para executar os testes automatizados.

comando Docker para baixa o container:

    docker-compose -f docker-compose.yml up -d 

Caminho para acessar o Selenoid:

    http://localhost:8083/


## Running tests

Executar o comando mvn test para executar os testes automatizados.

Parâmetros:

* mvn test: 

comando mvn test para executar os testes automatizados:

    mvn test



Parametros de execução do cucumber:

	//executa os cenários de testes contendo as tags passadas
        @all @MOBILE @MOBILE