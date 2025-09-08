package com.example.salareservas.repository;

import com.example.salareservas.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsuarioMatricula(String matricula);
    boolean existsByUsuarioMatricula(String matricula);
}