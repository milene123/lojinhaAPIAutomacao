package produtos;


import dataFactory.ProdutoDataFactory;
import dataFactory.UsuarioDataFactory;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;


@DisplayName("Teste de API Rest do modulo de Produto")
public class ProdutoTest {

    private String token;

    @BeforeEach
    public void beforeEach(){// vai chegar antes de cada teste
        //Configurando os dados da API Rest da Lojinha
        baseURI = "http://165.227.93.41";
        basePath = "/lojinha-bugada";

        //Obter o token do usuario logado
        this.token = given()
                .contentType(ContentType.JSON)
                .body(UsuarioDataFactory.criarUsuarioAdministrador())

                .when()
                    .post("/v2/login")
                .then()
                    .extract()
                    .path("data.token");
    }

    @Test
    @DisplayName("validar que o valor do produto igual a 0.00 não e permitido")
    public void testarValidarLimitesZeradoProibidosValorProduto() {

        given()
                .contentType(ContentType.JSON)
                .header("token",this.token)
                .body(ProdutoDataFactory.criarProdutoComumValorIgualA(0.00))//o metodo criado na calsse ProdutoDataFactory foi criado statico porque pode ser chamado o objeto direto com o metodo
                .when()
                    .post("/v2/produtos")
                .then()
                    .assertThat()
                    .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"));

    }

    @Test
    @DisplayName("validar os limites proibidos com valor maior de sete mil do Produto")
    public void testarValidarLimitesMaiorSeteMilProibidosValorProduto() {


        given()
                .contentType(ContentType.JSON)
                .header("token", this.token)
                .body(ProdutoDataFactory.criarProdutoComumValorIgualA(7000.00))//o metodo criado na calsse ProdutoDataFactory foi criado statico porque pode ser chamado o objeto direto com o metodo

        .when()
                .post("/v2/produtos")
        .then()
                .assertThat()
                .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"));

    }
}
