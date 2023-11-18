
package com.atividadem2.catalogodeprodutos.models.produtoDecorator;

import com.atividadem2.catalogodeprodutos.repositories.ProdutoRepository;


public abstract class ProdutoDecorator implements Preco{
    
    private final Preco produtoDecorator;

    public ProdutoDecorator(Preco produto) {
        this.produtoDecorator = produto;
    }
    
    @Override
    public double precoProduto(double preco){
        return produtoDecorator.precoProduto(preco);
    }
    
    public Preco getProduto() {
        return produtoDecorator;
    }
    
}
