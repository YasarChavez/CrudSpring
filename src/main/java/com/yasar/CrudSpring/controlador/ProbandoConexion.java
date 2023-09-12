package com.yasar.CrudSpring.controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProbandoConexion {
    private final JdbcTemplate JdbcTemplate;

    @Autowired
    public ProbandoConexion(JdbcTemplate jdbcTemplate) {
        this.JdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/pruebaConexion")
    public String pruebaConexionBaseDeDatos() {
        try {
            JdbcTemplate.execute("SELECT 1 FROM DUAL");
            return "Conexion exitosa";
        } catch (Exception e) {
            return "Error al conectar con la base de datos " + e.getMessage();
        }
    }
}
