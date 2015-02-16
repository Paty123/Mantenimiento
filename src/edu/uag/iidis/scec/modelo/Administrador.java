package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


/**
 * Esta clase es usada para representar un rol de un
 * usuario. 
 *
 * <p><a href="Administrador.java.html"><i>Ver código fuente</i></a></p>
 *
 * @author <a href="mailto:vramos@uag.mx">Victor Ramos</a>
 * @version 1.0
 */
public class Administrador extends ClaseBase 
        implements Serializable {

    private Long id;
    private Long idadministrador;
    private String  usuario;
    private String password;
    
    public Administrador() {
    }

    public Administrador (Long id){
        this.id = id;
    }

    public Administrador(String usuario, String password){
        this.usuario=usuario;
        this.usuario=usuario;
        
    }

    /**
     * Regresa el id del rol.
     * @return Long
     */
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   
    /**
     * Regresa el nombres del rol.
     * @return String
     */
    public String getUsuario() {
        return this.usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
    /**
     * Regresa la descripción del rol.
     * @return String
     */
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    
}
