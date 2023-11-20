
package com.atividadem2.catalogodeprodutos.models.produtoDecorator;


public class PrecoBase implements Preco{
    
    private double preco;

    public PrecoBase(double preco) {
        this.preco = preco;
    }

    @Override
    public double precoProduto(){
        return preco;
    }

}
