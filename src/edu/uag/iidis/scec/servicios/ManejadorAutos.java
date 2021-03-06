package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Auto;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.AutoDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

public class ManejadorAutos {
    private Log log = LogFactory.getLog(ManejadorRoles.class);
    private AutoDAO dao;

    public ManejadorAutos() {
        dao = new AutoDAO();
    }


    public Collection listarAutos() {
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







/////////////////////Metodo listar ordenados////////////////

public Collection listarAutosOrdenados(String resultadoOrdenados) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarTodosOrdenados(resultadoOrdenados);
            HibernateUtil.commitTransaction();
            return resultado;         
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }






///////////////////////////////////////////////////////////////



    public Collection buscarAuto(String autoBuscar) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarPorMarca(autoBuscar);
            HibernateUtil.commitTransaction();
            return resultado;         
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void eliminarAuto(Long id) {
        if (log.isDebugEnabled()) {
            log.debug(">eliminarAuto(auto)");
        }
        try {
            HibernateUtil.beginTransaction();           
            Auto auto = dao.buscarPorId(id, true);
            if (auto != null) {
              dao.hazTransitorio(auto);
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

    public int crearAuto(Auto auto) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarAuto(auto)");
        }

        try {
            HibernateUtil.beginTransaction();           
            
            if (dao.existeAuto(auto.getMarca())) {
               resultado = 1; // Excepci�n. El nombre de ciudad ya existe
            } else {

               dao.hazPersistente(auto);

               resultado = 0; // Exito. El ciudad se creo satisfactoriamente.
            }

            HibernateUtil.commitTransaction();

        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();

            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
            resultado = 2;    // Excepci�n. Falla en la infraestructura
        } finally {
            HibernateUtil.closeSession();
        }
        return resultado;
    }    
}
