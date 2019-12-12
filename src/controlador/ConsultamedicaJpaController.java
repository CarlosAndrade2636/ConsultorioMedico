/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.exceptions.IllegalOrphanException;
import controlador.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Consulrece;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Consultamedica;

/**
 *
 * @author USER
 */
public class ConsultamedicaJpaController implements Serializable {

    public ConsultamedicaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Consultamedica consultamedica) {
        if (consultamedica.getConsulreceCollection() == null) {
            consultamedica.setConsulreceCollection(new ArrayList<Consulrece>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Consulrece> attachedConsulreceCollection = new ArrayList<Consulrece>();
            for (Consulrece consulreceCollectionConsulreceToAttach : consultamedica.getConsulreceCollection()) {
                consulreceCollectionConsulreceToAttach = em.getReference(consulreceCollectionConsulreceToAttach.getClass(), consulreceCollectionConsulreceToAttach.getIdConsuRece());
                attachedConsulreceCollection.add(consulreceCollectionConsulreceToAttach);
            }
            consultamedica.setConsulreceCollection(attachedConsulreceCollection);
            em.persist(consultamedica);
            for (Consulrece consulreceCollectionConsulrece : consultamedica.getConsulreceCollection()) {
                Consultamedica oldIdConsultaOfConsulreceCollectionConsulrece = consulreceCollectionConsulrece.getIdConsulta();
                consulreceCollectionConsulrece.setIdConsulta(consultamedica);
                consulreceCollectionConsulrece = em.merge(consulreceCollectionConsulrece);
                if (oldIdConsultaOfConsulreceCollectionConsulrece != null) {
                    oldIdConsultaOfConsulreceCollectionConsulrece.getConsulreceCollection().remove(consulreceCollectionConsulrece);
                    oldIdConsultaOfConsulreceCollectionConsulrece = em.merge(oldIdConsultaOfConsulreceCollectionConsulrece);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Consultamedica consultamedica) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Consultamedica persistentConsultamedica = em.find(Consultamedica.class, consultamedica.getIdConsulta());
            Collection<Consulrece> consulreceCollectionOld = persistentConsultamedica.getConsulreceCollection();
            Collection<Consulrece> consulreceCollectionNew = consultamedica.getConsulreceCollection();
            List<String> illegalOrphanMessages = null;
            for (Consulrece consulreceCollectionOldConsulrece : consulreceCollectionOld) {
                if (!consulreceCollectionNew.contains(consulreceCollectionOldConsulrece)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Consulrece " + consulreceCollectionOldConsulrece + " since its idConsulta field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Consulrece> attachedConsulreceCollectionNew = new ArrayList<Consulrece>();
            for (Consulrece consulreceCollectionNewConsulreceToAttach : consulreceCollectionNew) {
                consulreceCollectionNewConsulreceToAttach = em.getReference(consulreceCollectionNewConsulreceToAttach.getClass(), consulreceCollectionNewConsulreceToAttach.getIdConsuRece());
                attachedConsulreceCollectionNew.add(consulreceCollectionNewConsulreceToAttach);
            }
            consulreceCollectionNew = attachedConsulreceCollectionNew;
            consultamedica.setConsulreceCollection(consulreceCollectionNew);
            consultamedica = em.merge(consultamedica);
            for (Consulrece consulreceCollectionNewConsulrece : consulreceCollectionNew) {
                if (!consulreceCollectionOld.contains(consulreceCollectionNewConsulrece)) {
                    Consultamedica oldIdConsultaOfConsulreceCollectionNewConsulrece = consulreceCollectionNewConsulrece.getIdConsulta();
                    consulreceCollectionNewConsulrece.setIdConsulta(consultamedica);
                    consulreceCollectionNewConsulrece = em.merge(consulreceCollectionNewConsulrece);
                    if (oldIdConsultaOfConsulreceCollectionNewConsulrece != null && !oldIdConsultaOfConsulreceCollectionNewConsulrece.equals(consultamedica)) {
                        oldIdConsultaOfConsulreceCollectionNewConsulrece.getConsulreceCollection().remove(consulreceCollectionNewConsulrece);
                        oldIdConsultaOfConsulreceCollectionNewConsulrece = em.merge(oldIdConsultaOfConsulreceCollectionNewConsulrece);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = consultamedica.getIdConsulta();
                if (findConsultamedica(id) == null) {
                    throw new NonexistentEntityException("The consultamedica with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Consultamedica consultamedica;
            try {
                consultamedica = em.getReference(Consultamedica.class, id);
                consultamedica.getIdConsulta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The consultamedica with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Consulrece> consulreceCollectionOrphanCheck = consultamedica.getConsulreceCollection();
            for (Consulrece consulreceCollectionOrphanCheckConsulrece : consulreceCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Consultamedica (" + consultamedica + ") cannot be destroyed since the Consulrece " + consulreceCollectionOrphanCheckConsulrece + " in its consulreceCollection field has a non-nullable idConsulta field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(consultamedica);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Consultamedica> findConsultamedicaEntities() {
        return findConsultamedicaEntities(true, -1, -1);
    }

    public List<Consultamedica> findConsultamedicaEntities(int maxResults, int firstResult) {
        return findConsultamedicaEntities(false, maxResults, firstResult);
    }

    private List<Consultamedica> findConsultamedicaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Consultamedica.class));
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

    public Consultamedica findConsultamedica(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Consultamedica.class, id);
        } finally {
            em.close();
        }
    }

    public int getConsultamedicaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Consultamedica> rt = cq.from(Consultamedica.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
