package edu.uag.iidis.scec.vista;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;


/**
 * Form bean para el registro de una nueva persona.
 *
 * @author Victor Ramos
 */
public final class FormaNuevoAuto
        extends ValidatorForm {

    private Collection estados;
    private int contador;
    private String marca;
    private String color;
     private String placas;
    private String propietario;
    private String ciudad;
    private Long idEstado;


    public void setEstados(Collection estados) {
        this.estados = estados;
        if (estados != null) {
          this.contador = estados.size();
        } else
          this.contador = -1;
    }

    public Collection getEstados() {
        return (this.estados);
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return (this.marca);
    }


    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return (this.color);
    }


    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public String getPlacas() {
        return (this.placas);
    }


    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getPropietario() {
        return (this.color);
    }


    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCiudad() {
        return (this.ciudad);
    }

    public void setidEstado(Long id) {
        this.idEstado = id;
    }

    public Long getidEstado() {
        return (this.idEstado);
    }

    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        marca=null;
        color=null;
        placas=null;
        propietario=null;
        ciudad=null;
        idEstado=null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
