
package com.atividadem2.catalogodeprodutos.models.produtoDecorator;


public class DescontoPersonalizado extends ProdutoDecorator{
    
    public DescontoPersonalizado(Preco Preco) {
        super(Preco);
    }
    
    @Override
    public double precoProduto(double preco, double valorDesconto){
        return super.precoProduto(preco) - (valorDesconto * (preco/100));
    }
}
