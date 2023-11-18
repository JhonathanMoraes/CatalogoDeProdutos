
package com.atividadem2.catalogodeprodutos.models.produtoDecorator;


public class DescontoNatal extends ProdutoDecorator{
    
    public DescontoNatal(Preco Preco) {
        super(Preco);
    }
    
    @Override
    public double precoProduto(double preco){
        return super.precoProduto(preco) - (0.10 * preco);
    }

    @Override
    public double precoProduto(double preco, double valorDesconto) {
        return super.precoProduto(preco) - (valorDesconto * (preco/100));
    }
}
