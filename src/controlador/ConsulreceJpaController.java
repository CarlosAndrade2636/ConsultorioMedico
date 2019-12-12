/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Consulrece;
import modelo.Consultamedica;
import modelo.Receta;

/**
 *
 * @author USER
 */
public class ConsulreceJpaController implements Serializable {

    public ConsulreceJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Consulrece consulrece) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Consultamedica idConsulta = consulrece.getIdConsulta();
            if (idConsulta != null) {
                idConsulta = em.getReference(idConsulta.getClass(), idConsulta.getIdConsulta());
                consulrece.setIdConsulta(idConsulta);
            }
            Receta idReceta = consulrece.getIdReceta();
            if (idReceta != null) {
                idReceta = em.getReference(idReceta.getClass(), idReceta.getIdReceta());
                consulrece.setIdReceta(idReceta);
            }
            em.persist(consulrece);
            if (idConsulta != null) {
                idConsulta.getConsulreceCollection().add(consulrece);
                idConsulta = em.merge(idConsulta);
            }
            if (idReceta != null) {
                idReceta.getConsulreceCollection().add(consulrece);
                idReceta = em.merge(idReceta);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Consulrece consulrece) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Consulrece persistentConsulrece = em.find(Consulrece.class, consulrece.getIdConsuRece());
            Consultamedica idConsultaOld = persistentConsulrece.getIdConsulta();
            Consultamedica idConsultaNew = consulrece.getIdConsulta();
            Receta idRecetaOld = persistentConsulrece.getIdReceta();
            Receta idRecetaNew = consulrece.getIdReceta();
            if (idConsultaNew != null) {
                idConsultaNew = em.getReference(idConsultaNew.getClass(), idConsultaNew.getIdConsulta());
                consulrece.setIdConsulta(idConsultaNew);
            }
            if (idRecetaNew != null) {
                idRecetaNew = em.getReference(idRecetaNew.getClass(), idRecetaNew.getIdReceta());
                consulrece.setIdReceta(idRecetaNew);
            }
            consulrece = em.merge(consulrece);
            if (idConsultaOld != null && !idConsultaOld.equals(idConsultaNew)) {
                idConsultaOld.getConsulreceCollection().remove(consulrece);
                idConsultaOld = em.merge(idConsultaOld);
            }
            if (idConsultaNew != null && !idConsultaNew.equals(idConsultaOld)) {
                idConsultaNew.getConsulreceCollection().add(consulrece);
                idConsultaNew = em.merge(idConsultaNew);
            }
            if (idRecetaOld != null && !idRecetaOld.equals(idRecetaNew)) {
                idRecetaOld.getConsulreceCollection().remove(consulrece);
                idRecetaOld = em.merge(idRecetaOld);
            }
            if (idRecetaNew != null && !idRecetaNew.equals(idRecetaOld)) {
                idRecetaNew.getConsulreceCollection().add(consulrece);
                idRecetaNew = em.merge(idRecetaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = consulrece.getIdConsuRece();
                if (findConsulrece(id) == null) {
                    throw new NonexistentEntityException("The consulrece with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Consulrece consulrece;
            try {
                consulrece = em.getReference(Consulrece.class, id);
                consulrece.getIdConsuRece();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The consulrece with id " + id + " no longer exists.", enfe);
            }
            Consultamedica idConsulta = consulrece.getIdConsulta();
            if (idConsulta != null) {
                idConsulta.getConsulreceCollection().remove(consulrece);
                idConsulta = em.merge(idConsulta);
            }
            Receta idReceta = consulrece.getIdReceta();
            if (idReceta != null) {
                idReceta.getConsulreceCollection().remove(consulrece);
                idReceta = em.merge(idReceta);
            }
            em.remove(consulrece);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Consulrece> findConsulreceEntities() {
        return findConsulreceEntities(true, -1, -1);
    }

    public List<Consulrece> findConsulreceEntities(int maxResults, int firstResult) {
        return findConsulreceEntities(false, maxResults, firstResult);
    }

    private List<Consulrece> findConsulreceEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Consulrece.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Consulrece findConsulrece(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Consulrece.class, id);
        } finally {
            em.close();
        }
    }

    public int getConsulreceCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Consulrece> rt = cq.from(Consulrece.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
