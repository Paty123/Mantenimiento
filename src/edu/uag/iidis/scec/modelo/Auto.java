package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


/**
 * Esta clase es usada para representar un rol de un
 * usuario. 
 *
 * <p><a href="Auto.java.html"><i>Ver código fuente</i></a></p>
 *
 * @author <a href="mailto:vramos@uag.mx">Victor Ramos</a>
 * @version 1.0
 */
public class Auto extends ClaseBase 
        implements Serializable {

    private Long id;
   
    private String marca;
    private String color;
    private String placas;
    private String propietario;
    private String ciudad;
    //private String claveAcceso;

    public Auto() {
    }

    public Auto(Long id){
        this.id = id;
    }

    public Auto(String marca, String color, String placas, String propietario, String ciudad){
        this.marca=marca;
        this.color=color;
       
        this.placas=placas;
        this.propietario=propietario;
         this.ciudad=ciudad;
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

    // ID Ciudad
    public Long getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    /**
     * Regresa el nombres del rol.
     * @return String
     */
    public String getMarca() {
        return this.marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    
    /**
     * Regresa la descripción del rol.
     * @return String
     */
    public String getColor() {
        return this.color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Regresa la descripción del rol.
     * @return String
     */
    public String getPlacas() {
        return this.placas;
    }
    public void setPlacas(String placas) {
        this.placas = placas;
    }

    /**
     * Regresa la descripción del rol.
     * @return String
     */
    public String getPropietario() {
        return this.propietario;
    }
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
   /* public String getclaveAcceso() {
        return this.claveAcceso;
    }
    public void setclaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }*/
}
