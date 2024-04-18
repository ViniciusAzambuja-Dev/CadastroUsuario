package com.vinicius.ProjetoCadastro.repository;

import org.springframework.data.repository.CrudRepository;

import com.vinicius.ProjetoCadastro.models.Usuario;
import java.util.List;
import java.util.Optional;


public interface UsuariosRepository extends CrudRepository<Usuario, Long>{
    List<Usuario> findByEmail(String email);
    Optional<Usuario> findById(Long id);
    
} 
