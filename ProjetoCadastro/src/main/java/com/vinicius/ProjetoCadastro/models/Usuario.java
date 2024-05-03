package com.vinicius.ProjetoCadastro.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    @Pattern(regexp = "^(?=.*@(hotmail\\.com|gmail\\.com))\\S+$", message = "ERRO, o endereço de e-mail deve ser do tipo gmail.com ou hotmail.com")
    @NotBlank
    private String email;
    @NotBlank
    @Pattern(regexp = "^[A-Z]+(.)*", message = "ERRO, o nome deve começar com letra maiúscula!")
    private String nome;
    @NotBlank
    private String senha;
   


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
