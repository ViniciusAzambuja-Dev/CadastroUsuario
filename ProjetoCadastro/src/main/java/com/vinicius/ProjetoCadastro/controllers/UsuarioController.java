package com.vinicius.ProjetoCadastro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

import com.vinicius.ProjetoCadastro.models.Usuario;
import com.vinicius.ProjetoCadastro.repository.UsuariosRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;


@Controller
public class UsuarioController {
    @Autowired
    private UsuariosRepository ur;

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String form() {

        return "usuarios/formUsuario";
    }
    
    @RequestMapping(value = "/", method=RequestMethod.POST)
    public String form(@Validated Usuario usuario, BindingResult result, RedirectAttributes attributes) {
        if(result.hasErrors()){
            attributes.addFlashAttribute("validacaoError", "Verifique os campos...");
            return "redirect:/";
        }
        
        if (ur.findByNome(usuario.getNome()).isPresent()) {
            //mensagem de erro
            attributes.addFlashAttribute("nomeError", "Nome já existente!");
            return "redirect:/";
        }
        if (ur.findByEmail(usuario.getEmail()).isPresent()) {
            //mensagem de erro
            attributes.addFlashAttribute("emailError", "Email já existente!");
            return "redirect:/";
        }
        if (ur.findBySenha(usuario.getSenha()).isPresent()) {
            //mensagem de erro
            attributes.addFlashAttribute("senhaError", "Senha já existente!");
            return "redirect:/";
        }
        ur.save(usuario);
        System.out.print("Usuário cadastrado com sucesso!");
        return "redirect:/";
    }
    
}
