
package com.atividadem2.catalogodeprodutos.models.produtoDecorator;


public class DescontoPersonalizado extends ProdutoDecorator{
    
    public DescontoPersonalizado(Preco preco, double taxaDesconto) {
        super(preco, taxaDesconto);
    }
    
    @Override
    public double precoProduto() {
        return super.precoProduto() - (super.getTaxaDesconto() * (super.precoProduto()/100));
    }
}
