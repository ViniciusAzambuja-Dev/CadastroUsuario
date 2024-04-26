package com.vinicius.ProjetoCadastro.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vinicius.ProjetoCadastro.models.Usuario;
import java.util.Optional;


public interface UsuariosRepository extends CrudRepository<Usuario, Long>{
   Optional<Usuario>findByNome(String nome);
   Optional<Usuario>findByEmail(String email);
   Optional<Usuario>findBySenha(String senha); 
    
   @Query(value = "select * from usuario where email = :email and senha = :senha", nativeQuery = true)
   public Usuario validacaoLogin(String email, String senha);

} 
