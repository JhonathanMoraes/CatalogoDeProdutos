
package com.atividadem2.catalogodeprodutos.models.produtoDecorator;


public class PrecoBase implements Preco{
    
    
    @Override
    public double precoProduto(double preco){
        return preco;
    }

    @Override
    public double precoProduto(double preco, double valorDesconto) {
        return preco;
    }
}
