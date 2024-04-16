package com.vinicius.ProjetoCadastro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

import com.vinicius.ProjetoCadastro.models.Usuarios;
import com.vinicius.ProjetoCadastro.repository.UsuariosRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;


@Controller
public class UsuarioController {
    @Autowired
    private UsuariosRepository ur;

    @RequestMapping(value = "/cadastrarUsuario", method=RequestMethod.GET)
    public String form() {

        return "usuarios/formUsuario";
    }
    
    @RequestMapping(value = "/cadastrarUsuario", method=RequestMethod.POST)
    public String form(@Validated Usuarios usuario, BindingResult result, RedirectAttributes attributes ) {
        if(result.hasErrors()){
           // attributes.addFlashAttribute("mensagem", "Verifique os campos...");
            return "redirect:/cadastrarUsuario";
        }

        ur.save(usuario);
        //attributes.addFlashAttribute("mensagem", "Pacote cadastrado com sucesso!");
        return "redirect:/cadastrarUsuario";
    }
    
}
