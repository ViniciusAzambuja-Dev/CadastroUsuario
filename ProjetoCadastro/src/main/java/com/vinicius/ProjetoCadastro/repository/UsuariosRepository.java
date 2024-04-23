package com.vinicius.ProjetoCadastro.repository;

import org.springframework.data.repository.CrudRepository;

import com.vinicius.ProjetoCadastro.models.Usuario;
import java.util.List;
import java.util.Optional;


public interface UsuariosRepository extends CrudRepository<Usuario, Long>{
   Optional<Usuario>findByNome(String nome);
   Optional<Usuario>findByEmail(String email);
   Optional<Usuario>findBySenha(String senha); 
    
} 
