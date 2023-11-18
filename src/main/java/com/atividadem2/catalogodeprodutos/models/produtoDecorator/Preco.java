
package com.atividadem2.catalogodeprodutos.models.produtoDecorator;


public interface Preco {

    double precoProduto(double preco);
    double precoProduto(double preco, double valorDesconto);
}
