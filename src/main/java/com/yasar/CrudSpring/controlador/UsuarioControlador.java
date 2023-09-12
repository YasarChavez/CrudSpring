package com.yasar.CrudSpring.controlador;

import com.yasar.CrudSpring.entidad.UsuarioEntidad;
import com.yasar.CrudSpring.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

public class UsuarioControlador {
    private final UsuarioServicio servicioUsuario;
    @Autowired
    public UsuarioControlador(UsuarioServicio UsuarioServicio) {
        this.servicioUsuario = UsuarioServicio;
    }


     @GetMapping("/listausuarios")
     public String mostrarUsuarios(Model model) {
        try {
            List<UsuarioEntidad> usuarios = servicioUsuario.obtenerTodos();
            model.addAttribute("usuariosParaFront", usuarios);
            return "crudusuarios";
        }catch (Exception e) {
            return "Error al mostrar los usuarios: "+e.getMessage();
        }
     }

     @PostMapping("/guardarusuarios")
     public String guardarUsuario(@ModelAttribute UsuarioEntidad usuario) {
         try {
             servicioUsuario.guardarUsuario(usuario);
             return "redirect:/listausuarios";
         }catch (Exception e) {
             return "Error al guardar el usuario: "+e.getMessage();
         }
     }
    @PostMapping("/actualizarusuarios")
    public String actualizarUsuario(@ModelAttribute UsuarioEntidad usuario) {
        try {
            servicioUsuario.actualizarUsuarioPorId(usuario.getId(), usuario);
            return "redirect:/listausuarios";
        }catch (Exception e) {
            return "Error al editar el usuario: "+e.getMessage();
        }
    }

    @PostMapping("/eliminarusuarios")
    public String eliminarUsuarioPorId(@RequestParam long id) {
        try {
            servicioUsuario.eliminarUsuarioPorId(id);
            return "redirect:/listausuarios";
        }catch (Exception e) {
            return "Error al eliminar el usuario: "+e.getMessage();
        }
    }

}
