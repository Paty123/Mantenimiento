package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Pais;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class PaisDAO {

    private Log log = LogFactory.getLog(PaisDAO.class);

    public PaisDAO() {
    }


    public Pais buscarPorId(Long idPais, boolean bloquear)
            throws ExcepcionInfraestructura {

        Pais pais = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idPais + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                pais = (Pais)HibernateUtil.getSession()
                                                .load(Pais.class, 
                                                      idPais, 
                                                      LockMode.UPGRADE);
            } else {
                pais = (Pais)HibernateUtil.getSession()
                                                .load(Pais.class,
                                                      idPais);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return pais;
    }


    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection paises;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            paises = HibernateUtil.getSession()
                                    .createCriteria(Pais.class)
                                    .list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return paises;
    }


    public Collection buscarPorEjemplo(Pais pais)
            throws ExcepcionInfraestructura {


        Collection paises;
 
        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(Pais.class);
            paises = criteria.add(Example.create(pais)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return paises;
    }


    public void hazPersistente(Pais pais)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(pais)");
        }

        try {
            HibernateUtil.getSession().saveOrUpdate(pais);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }


    public void hazTransitorio(Pais pais)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(pais)");
        }

        try {
            HibernateUtil.getSession().delete(pais);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }

    public boolean existePais(String descripcion)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeEstado(descripcion)");
        }

        try {
            
            
//            String consultaCuentaEstados =
//            "select count(*) from Estado r where r.nombre=?";
//
 //           int resultado =
 //           ((Integer) HibernateUtil.getSession()
 //                          .find(consultaCuentaEstados, 
 //                                nombreEstado,
 //                                StringType.INSTANCE)
 //                          .iterator()
 //                          .next()).intValue();
// de acuerdo al nuevo formato
 
            String hql = "select descripcion from Pais where descripcion = :descripcion";
            
             if (log.isDebugEnabled()) {
                 log.debug(hql + descripcion);
            }
        
            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< create query ok " );
            }

            query.setParameter("descripcion", descripcion);
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< set Parameter ok antes del query list >>>>>");
            }
            List results = query.list();
            int resultado = results.size();
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< Result size " + resultado);
            }
            if (resultado == 0) {
               return false;
            }
            
            return true;

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException *******************");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }


}
