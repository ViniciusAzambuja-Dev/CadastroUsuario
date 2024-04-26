package com.vinicius.ProjetoCadastro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

import com.vinicius.ProjetoCadastro.models.Usuario;
import com.vinicius.ProjetoCadastro.repository.UsuariosRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class LoginController {
    @Autowired
    private UsuariosRepository ur;

    @RequestMapping(value="/Login", method=RequestMethod.GET)
    public String login() {

        return "usuarios/login";
    }

    @RequestMapping(value="/Login", method=RequestMethod.POST)
    public String logar(Usuario usuarioParam, RedirectAttributes attributes){
        Usuario usuario = this.ur.validacaoLogin(usuarioParam.getEmail(), usuarioParam.getSenha());
        if(usuario != null){
            
            return "/home";
       
        }
        attributes.addFlashAttribute("erroLogin", "Usuario não encontrado!");
        return "redirect:/Login";
    }
}
