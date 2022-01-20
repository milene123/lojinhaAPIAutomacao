package dataFactory;

import pojo.ComponentePojo;
import pojo.ProdutoPojo;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDataFactory {

    public static ProdutoPojo criarProdutoComumValorIgualA(double valor) {
        ProdutoPojo produto = new ProdutoPojo();
        produto.setProdutoNome("Play Station 5");
        produto.setProdutoValor(0.00);

        List<String> cores = new ArrayList<>();
        cores.add("branco");
        cores.add("preto");
        cores.add("cinza");
        produto.setProdutoCores(cores);
        produto.setProdutoUrlMock("");

        List<ComponentePojo> componentes = new ArrayList<>();

        ComponentePojo primeiroComponente = new ComponentePojo();
        primeiroComponente.setComponenteNome("Controle");
        primeiroComponente.setComponenteQuantidade(1);

        componentes.add(primeiroComponente);

        ComponentePojo segundoComponente = new ComponentePojo();
        segundoComponente.setComponenteNome("Cartão de Memoria");
        segundoComponente.setComponenteQuantidade(2);

        componentes.add(segundoComponente);
        return produto;
    }

}
