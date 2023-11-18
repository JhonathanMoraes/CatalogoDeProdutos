
package com.atividadem2.catalogodeprodutos.controllers;

import com.atividadem2.catalogodeprodutos.controllers.services.UsuarioServices;
import com.atividadem2.catalogodeprodutos.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    UsuarioServices service;
    
    @PostMapping(value = "/cadastrarUsuario")
    public String cadastrarUsuario(Usuario usuario){
        service.cadastrar(usuario);
        return "redirect:login.html";
    }
    
    @PutMapping(value = "/{id}")
    public void AtualizarUsuario(Usuario usuario, @PathVariable Long id){
        service.atualizar(usuario, id);
    }
    
    @DeleteMapping(value = "/{id}")
    public void deletarUsuario(@PathVariable Long id){
        service.deletar(id);
    }
    
    @GetMapping(value = "/{id}")
    public Model buscarUsuario(@PathVariable Long id, Model model){
        return model.addAttribute(service.buscarPorId(id));
    }
    
    @GetMapping
    public Model listarUsuarios(Model model){
        return model.addAttribute( "listaUsuarios",service.listarTodos());
    }
    
    
    
    @GetMapping(value = "index.html")
    public String indexPage(){
        return "index";
    }
    
    @GetMapping(value = "login.html")
    public String loginPage(Model model){
        listarUsuarios(model);
        return "login";
    }
    
    @GetMapping(value = "cadastroUsuario.html")
    public String cadastroUsuarioPage(Model model){
        return "cadastroUsuario";
    }
}
