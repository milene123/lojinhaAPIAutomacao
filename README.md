#  Lojinha Automação

Este é um repositorio que contém automação de alguns testes de API Rest de um softawe que foi denominado na Lojinha. Os sub-topicos  que descrevem  algumas decisões que foram tomadas na estrutura do projeto

## Tecnologia Utilizada

- Java  
  https://www.java.com/pt-BR/download/ie_manual.jsp?locale=pt_BR
- JUnit
  https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine/5.7.1

-  RestAsssured
   https://mvnrepository.com/artifact/io.rest-assured/rest-assured/4.0.0

-  Maven
   https://maven.apache.org/

## Testes Automatizados

Testes para validar as partições de equivalência relacionada ao valor do produto na Lojinha, que estão vinculados diretamente a regra de negócio que fiz que o valor do produto deve estar entre R$ 0,001 e R$ 7.000,00

## Notas Gerais

- Sempre utilizamos a anotação Before Each para capturar o token que será utilizado posteriormente nos métodos de testes
- Armazenamos os dados que são enviados para a API através do uso de classe POJO
- Criamos dados inicias atráveis do uso de classe Data Factory, para facilitar a criação e controle dos mesmo
- Nesse projeto fazemos uso do JUnit 5, o que nos dá a possibilidade de usar a anotação DisplayName para dar descrições em português para nosso testes