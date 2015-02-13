package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Auto;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class AutoDAO {

    private Log log = LogFactory.getLog(AutoDAO.class);

    public AutoDAO() {
    }


    public Auto buscarPorId(Long idAuto, boolean bloquear)
            throws ExcepcionInfraestructura {

        Auto auto = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idAuto + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                auto = (Auto)HibernateUtil.getSession()
                                                .load(Auto.class, 
                                                      idAuto, 
                                                      LockMode.UPGRADE);
            } else {
                auto = (Auto)HibernateUtil.getSession()
                                                .load(Auto.class,
                                                      idAuto);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return auto;
    }


    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection autos;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            autos = HibernateUtil.getSession()
                                    .createCriteria(Auto.class)
                                    .list();
									
			  log.debug(">buscarTodos() ---- list	");									
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return autos;
    }


    public Collection buscarPorEjemplo(Auto auto)
            throws ExcepcionInfraestructura {


        Collection autos;
 
        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(Auto.class);
            autos = criteria.add(Example.create(auto)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return autos;
    }


    public void hazPersistente(Auto auto)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(auto)");
        }

        try {
            HibernateUtil.getSession().saveOrUpdate(auto);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }


    public void hazTransitorio(Auto auto)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(auto)");
        }

        try {
            HibernateUtil.getSession().delete(auto);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }

    public boolean existeAuto(String nombreAuto)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {
			
			
//            String consultaCuentaRoles =
//            "select count(*) from Gente r where r.nombre=?";
//
 //           int resultado =
 //           ((Integer) HibernateUtil.getSession()
 //                          .find(consultaCuentaRoles, 
 //                                nombreRol,
 //                                StringType.INSTANCE)
 //                          .iterator()
 //                          .next()).intValue();
// de acuerdo al nuevo formato
 
			String hql = "select Marca from Auto where Marca = :Marca";
			
			 if (log.isDebugEnabled()) {
           		 log.debug(hql + nombreAuto);
        	}
		
			Query query = HibernateUtil.getSession()
										.createQuery(hql);
			if (log.isDebugEnabled()) {
           		 log.debug("<<<<<<<<< create query ok " );
        	}

			query.setParameter("Marca", nombreAuto);
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
    public Collection ordenarPor(String tipo, int tipoInt)
            throws ExcepcionInfraestructura {

        Collection ciudades;

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }
        String add="";
        if (tipoInt==0) {
            add="ASC";
        } else if(tipoInt==1) {
            add="DESC";
        }
        try {
            String hql="from Auto";
            if(tipo.equals("marca")) {
                hql = "from Auto order by Marca "+add;
            } else if(tipo.equals("color")) {
                hql = "from Auto order by Color "+add;
            } else if(tipo.equals("placas")) {
                hql = "from Auto order by Placas "+add;
            } else if(tipo.equals("propietario")) {
                hql = "from Auto order by Propiedad "+add;
            } else if(tipo.equals("ciudad")) {
                hql = "from Auto order by idCiudad "+add;
            } 
            
             if (log.isDebugEnabled()) {
                 log.debug(hql);
            }
        
            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< create query ok " );
            }

            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< set Parameter ok antes del query list >>>>>");
            }
            ciudades = query.list();

            return ciudades;

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException *******************");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }

}
