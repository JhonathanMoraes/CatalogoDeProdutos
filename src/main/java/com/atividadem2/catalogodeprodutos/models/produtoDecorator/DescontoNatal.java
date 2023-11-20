
package com.atividadem2.catalogodeprodutos.models.produtoDecorator;


public class DescontoNatal extends ProdutoDecorator{
    
    public DescontoNatal(Preco preco) {
        super(preco);
    }
    
    @Override
    public double precoProduto() {
        return super.precoProduto() - (super.precoProduto() * 0.10);
    }
}
