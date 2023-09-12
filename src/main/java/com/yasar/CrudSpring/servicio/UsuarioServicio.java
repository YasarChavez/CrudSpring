package com.yasar.CrudSpring.servicio;

import com.yasar.CrudSpring.entidad.UsuarioEntidad;
import com.yasar.CrudSpring.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UsuarioServicio {

     private final UsuarioRepositorio usuarioRepositorio;

     @Autowired
     public UsuarioServicio(UsuarioRepositorio usuarioRepositorio) {
         this.usuarioRepositorio = usuarioRepositorio;
     }

     public List<UsuarioEntidad> obtenerTodos() {
         return usuarioRepositorio.findAll();
     }

     public UsuarioEntidad guardarUsuario(UsuarioEntidad usuario) {
         return usuarioRepositorio.save(usuario);
     }

     public UsuarioEntidad actualizarUsuarioPorId(long id, UsuarioEntidad usuario) {
         UsuarioEntidad usuarioExistentente = usuarioRepositorio.findById(id)
                 .orElseThrow(()-> new NoSuchElementException("No se encontro el usuario con id: " + id));
         usuarioExistentente.setNombres(usuario.getNombres());
         usuarioExistentente.setApellidos(usuario.getApellidos());
         return usuarioRepositorio.save(usuarioExistentente);
     }
    public void eliminarUsuarioPorId(long id) {
        UsuarioEntidad usuarioExistentente = usuarioRepositorio.findById(id)
                .orElseThrow(()-> new NoSuchElementException("No se encontro el usuario con id: " + id));
        usuarioRepositorio.delete(usuarioExistentente);
    }
}
