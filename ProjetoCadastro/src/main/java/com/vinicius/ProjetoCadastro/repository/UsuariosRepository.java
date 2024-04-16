package com.vinicius.ProjetoCadastro.repository;

import org.springframework.data.repository.CrudRepository;

import com.vinicius.ProjetoCadastro.models.Usuarios;
import java.util.List;
import java.util.Optional;


public interface UsuariosRepository extends CrudRepository<Usuarios, Long>{
    List<Usuarios> findByEmail(String email);
    Optional<Usuarios> findById(Long id);
    
} 
