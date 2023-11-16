
package com.atividadem2.catalogodeprodutos.controllers;

import com.atividadem2.catalogodeprodutos.controllers.services.ProdutoServices;
import com.atividadem2.catalogodeprodutos.models.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoServices service;
    
    @PostMapping(value = "cadastrarProduto")
    public String cadastrarProduto(Produto produto, @RequestParam Long usuarioId){
        service.cadastrar(produto);
        return "redirect:/produto/meusProdutos/id=" + usuarioId;
    }
    
    @PutMapping(value = "/{id}")
    public void AtualizarProduto(Produto produto, @PathVariable Long id){
        service.atualizar(produto, id);
    }
    
    @DeleteMapping(value = "/{id}")
    public void deletarProduto(@PathVariable Long id){
        service.deletar(id);
    }
    
    @GetMapping(value = "/buscarProdutoPorIdProduto/{id}")
    public Model buscarProdutoPorIdProduto(@PathVariable Long id, Model model){
        return model.addAttribute(service.buscarPorIdProduto(id));
    }
    
    @GetMapping(value = "/buscarProdutoPorIdUsuario/{id}")
    public Model buscarProdutoPorIdUsuario(@PathVariable Long id, Model model){
        return model.addAttribute("listaProdutos", service.buscarPorIdUsuario(id));
    }
    
    @GetMapping
    public Model listarProdutos(Model model){
        return model.addAttribute( "listaProdutos",service.listarTodos());
    }
    
    
    
    @GetMapping(value = "catalogo/id={id}")
    public String catalogoPage(@PathVariable Long id, Model model){
        listarProdutos(model);
        return "catalogo";
    }
    
    @GetMapping(value = "meusProdutos/id={id}")
    public String meusProdutosPage(@PathVariable Long id, Model model){
        buscarProdutoPorIdUsuario(id, model);
        return "meusProdutos";
    }
    
    @GetMapping(value = "cadastroProduto/id={id}")
    public String cadastroProdutoPage(@PathVariable Long id, Model model){
        return "cadastroProduto";
    }
}
