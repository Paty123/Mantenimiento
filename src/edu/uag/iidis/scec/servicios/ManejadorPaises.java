package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Pais;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.PaisDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

public class ManejadorPaises {
    private Log log = LogFactory.getLog(ManejadorPaises.class);
    private PaisDAO dao;

    public ManejadorPaises() {
        dao = new PaisDAO();
    }


    public Collection listarPaises() {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarTodos();
            HibernateUtil.commitTransaction();
            return resultado;         
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void eliminarPais(Long id) {
        if (log.isDebugEnabled()) {
            log.debug(">eliminarPais(Pais)");
        }
        try {
            HibernateUtil.beginTransaction();           
            Pais pais = dao.buscarPorId(id, true);
            if (pais != null) {
              dao.hazTransitorio(pais);
            }
            HibernateUtil.commitTransaction();
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
        } finally {
            HibernateUtil.closeSession();
        }

    }

    public int crearPais(Pais pais) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarPais(Pais)");
        }

        try {
            HibernateUtil.beginTransaction();           
            
            if (dao.existePais(pais.getDescripcion())) {
               resultado = 1; // Excepción. El nombre de rol ya existe
            } else {

               dao.hazPersistente(pais);

               resultado = 0; // Exito. El rol se creo satisfactoriamente.
            }

            HibernateUtil.commitTransaction();

        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();

            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
            resultado = 2;    // Excepción. Falla en la infraestructura
        } finally {
            HibernateUtil.closeSession();
        }
        return resultado;
    }    
}
