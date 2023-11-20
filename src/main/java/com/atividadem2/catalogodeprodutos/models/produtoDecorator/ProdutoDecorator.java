
package com.atividadem2.catalogodeprodutos.models.produtoDecorator;

public abstract class ProdutoDecorator implements Preco{
    
    private final Preco produtoDecorator;
    private final double taxaDesconto;

    public ProdutoDecorator(Preco preco) {
        this.produtoDecorator = preco;
        this.taxaDesconto = 0;
    }
    
    public ProdutoDecorator(Preco preco, double taxaDesconto) {
        this.produtoDecorator = preco;
        this.taxaDesconto = taxaDesconto;
    }
    
    @Override
    public double precoProduto(){
        return produtoDecorator.precoProduto();
    }
    
    public Preco getProduto() {
        return produtoDecorator;
    }

        public double getTaxaDesconto() {
        return taxaDesconto;
    }

}
