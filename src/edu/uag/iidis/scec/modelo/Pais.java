package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


/**
 * Esta clase es usada para representar un rol de un
 * usuario. 
 *
 * <p><a href="Pais.java.html"><i>Ver código fuente</i></a></p>
 *
 * @author <a href="mailto:vramos@uag.mx">Victor Ramos</a>
 * @version 1.0
 */
public class Pais extends ClaseBase 
        implements Serializable {

    private Long id;
    
    private String descripcion;
    private List usuarios = new ArrayList();

    public Pais() {
    }

    public Pais(Long id){
        this.id = id;
    }

    public Pais(String descripcion){
        
        this.descripcion=descripcion;
    }

    /**
     * Regresa el id del rol.
     * @return Long
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Establece el id del rol.
     * @return void
     */
    public void setId(Long id) {
        this.id = id;
    }


    /**
     * Regresa el nombre del rol.
     * @return String
     */
    
    
    /**
     * Regresa la descripción del rol.
     * @return String
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Establece la descripción del rol.
     * @return void
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Regresa los usuarios del rol.
     * @return List
     */
   
}
