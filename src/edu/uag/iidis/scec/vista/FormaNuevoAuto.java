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

    private Collection ciudades;
    private int contador;
    private String marca;
    private String color;
    private String placas;
    private String propietario;
    private String ciudad;


    public void setCiudades(Collection ciudades) {
        this.ciudades = ciudades;
        if (ciudades != null) {
          this.contador = ciudades.size();
        } else
          this.contador = -1;
    }

    public Collection getCiudades() {
        return (this.ciudades);
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return (this.marca);
    }


    public void setColor(String color) {
        this.color= color;
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
        return (this.propietario);
    }

    public void setCiudad(String  ciudad) {
        this.ciudad = ciudad;
    }

    public Long getCiudad() {
        return (this.ciudad);
    }

    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        marca=null;
        color=null;
        ciudad=null;
        placas=null;
        propietario=null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
