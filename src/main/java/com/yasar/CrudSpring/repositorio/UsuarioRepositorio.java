package com.yasar.CrudSpring.repositorio;

import com.yasar.CrudSpring.entidad.UsuarioEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<UsuarioEntidad, Long> {

}
