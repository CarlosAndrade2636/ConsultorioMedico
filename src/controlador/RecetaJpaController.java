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
import modelo.Medicamentoreceta;
import modelo.Receta;

/**
 *
 * @author USER
 */
public class RecetaJpaController implements Serializable {

    public RecetaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Receta receta) {
        if (receta.getConsulreceCollection() == null) {
            receta.setConsulreceCollection(new ArrayList<Consulrece>());
        }
        if (receta.getMedicamentorecetaCollection() == null) {
            receta.setMedicamentorecetaCollection(new ArrayList<Medicamentoreceta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Consulrece> attachedConsulreceCollection = new ArrayList<Consulrece>();
            for (Consulrece consulreceCollectionConsulreceToAttach : receta.getConsulreceCollection()) {
                consulreceCollectionConsulreceToAttach = em.getReference(consulreceCollectionConsulreceToAttach.getClass(), consulreceCollectionConsulreceToAttach.getIdConsuRece());
                attachedConsulreceCollection.add(consulreceCollectionConsulreceToAttach);
            }
            receta.setConsulreceCollection(attachedConsulreceCollection);
            Collection<Medicamentoreceta> attachedMedicamentorecetaCollection = new ArrayList<Medicamentoreceta>();
            for (Medicamentoreceta medicamentorecetaCollectionMedicamentorecetaToAttach : receta.getMedicamentorecetaCollection()) {
                medicamentorecetaCollectionMedicamentorecetaToAttach = em.getReference(medicamentorecetaCollectionMedicamentorecetaToAttach.getClass(), medicamentorecetaCollectionMedicamentorecetaToAttach.getIdMedRes());
                attachedMedicamentorecetaCollection.add(medicamentorecetaCollectionMedicamentorecetaToAttach);
            }
            receta.setMedicamentorecetaCollection(attachedMedicamentorecetaCollection);
            em.persist(receta);
            for (Consulrece consulreceCollectionConsulrece : receta.getConsulreceCollection()) {
                Receta oldIdRecetaOfConsulreceCollectionConsulrece = consulreceCollectionConsulrece.getIdReceta();
                consulreceCollectionConsulrece.setIdReceta(receta);
                consulreceCollectionConsulrece = em.merge(consulreceCollectionConsulrece);
                if (oldIdRecetaOfConsulreceCollectionConsulrece != null) {
                    oldIdRecetaOfConsulreceCollectionConsulrece.getConsulreceCollection().remove(consulreceCollectionConsulrece);
                    oldIdRecetaOfConsulreceCollectionConsulrece = em.merge(oldIdRecetaOfConsulreceCollectionConsulrece);
                }
            }
            for (Medicamentoreceta medicamentorecetaCollectionMedicamentoreceta : receta.getMedicamentorecetaCollection()) {
                Receta oldIdRecetaOfMedicamentorecetaCollectionMedicamentoreceta = medicamentorecetaCollectionMedicamentoreceta.getIdReceta();
                medicamentorecetaCollectionMedicamentoreceta.setIdReceta(receta);
                medicamentorecetaCollectionMedicamentoreceta = em.merge(medicamentorecetaCollectionMedicamentoreceta);
                if (oldIdRecetaOfMedicamentorecetaCollectionMedicamentoreceta != null) {
                    oldIdRecetaOfMedicamentorecetaCollectionMedicamentoreceta.getMedicamentorecetaCollection().remove(medicamentorecetaCollectionMedicamentoreceta);
                    oldIdRecetaOfMedicamentorecetaCollectionMedicamentoreceta = em.merge(oldIdRecetaOfMedicamentorecetaCollectionMedicamentoreceta);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Receta receta) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Receta persistentReceta = em.find(Receta.class, receta.getIdReceta());
            Collection<Consulrece> consulreceCollectionOld = persistentReceta.getConsulreceCollection();
            Collection<Consulrece> consulreceCollectionNew = receta.getConsulreceCollection();
            Collection<Medicamentoreceta> medicamentorecetaCollectionOld = persistentReceta.getMedicamentorecetaCollection();
            Collection<Medicamentoreceta> medicamentorecetaCollectionNew = receta.getMedicamentorecetaCollection();
            List<String> illegalOrphanMessages = null;
            for (Consulrece consulreceCollectionOldConsulrece : consulreceCollectionOld) {
                if (!consulreceCollectionNew.contains(consulreceCollectionOldConsulrece)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Consulrece " + consulreceCollectionOldConsulrece + " since its idReceta field is not nullable.");
                }
            }
            for (Medicamentoreceta medicamentorecetaCollectionOldMedicamentoreceta : medicamentorecetaCollectionOld) {
                if (!medicamentorecetaCollectionNew.contains(medicamentorecetaCollectionOldMedicamentoreceta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Medicamentoreceta " + medicamentorecetaCollectionOldMedicamentoreceta + " since its idReceta field is not nullable.");
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
            receta.setConsulreceCollection(consulreceCollectionNew);
            Collection<Medicamentoreceta> attachedMedicamentorecetaCollectionNew = new ArrayList<Medicamentoreceta>();
            for (Medicamentoreceta medicamentorecetaCollectionNewMedicamentorecetaToAttach : medicamentorecetaCollectionNew) {
                medicamentorecetaCollectionNewMedicamentorecetaToAttach = em.getReference(medicamentorecetaCollectionNewMedicamentorecetaToAttach.getClass(), medicamentorecetaCollectionNewMedicamentorecetaToAttach.getIdMedRes());
                attachedMedicamentorecetaCollectionNew.add(medicamentorecetaCollectionNewMedicamentorecetaToAttach);
            }
            medicamentorecetaCollectionNew = attachedMedicamentorecetaCollectionNew;
            receta.setMedicamentorecetaCollection(medicamentorecetaCollectionNew);
            receta = em.merge(receta);
            for (Consulrece consulreceCollectionNewConsulrece : consulreceCollectionNew) {
                if (!consulreceCollectionOld.contains(consulreceCollectionNewConsulrece)) {
                    Receta oldIdRecetaOfConsulreceCollectionNewConsulrece = consulreceCollectionNewConsulrece.getIdReceta();
                    consulreceCollectionNewConsulrece.setIdReceta(receta);
                    consulreceCollectionNewConsulrece = em.merge(consulreceCollectionNewConsulrece);
                    if (oldIdRecetaOfConsulreceCollectionNewConsulrece != null && !oldIdRecetaOfConsulreceCollectionNewConsulrece.equals(receta)) {
                        oldIdRecetaOfConsulreceCollectionNewConsulrece.getConsulreceCollection().remove(consulreceCollectionNewConsulrece);
                        oldIdRecetaOfConsulreceCollectionNewConsulrece = em.merge(oldIdRecetaOfConsulreceCollectionNewConsulrece);
                    }
                }
            }
            for (Medicamentoreceta medicamentorecetaCollectionNewMedicamentoreceta : medicamentorecetaCollectionNew) {
                if (!medicamentorecetaCollectionOld.contains(medicamentorecetaCollectionNewMedicamentoreceta)) {
                    Receta oldIdRecetaOfMedicamentorecetaCollectionNewMedicamentoreceta = medicamentorecetaCollectionNewMedicamentoreceta.getIdReceta();
                    medicamentorecetaCollectionNewMedicamentoreceta.setIdReceta(receta);
                    medicamentorecetaCollectionNewMedicamentoreceta = em.merge(medicamentorecetaCollectionNewMedicamentoreceta);
                    if (oldIdRecetaOfMedicamentorecetaCollectionNewMedicamentoreceta != null && !oldIdRecetaOfMedicamentorecetaCollectionNewMedicamentoreceta.equals(receta)) {
                        oldIdRecetaOfMedicamentorecetaCollectionNewMedicamentoreceta.getMedicamentorecetaCollection().remove(medicamentorecetaCollectionNewMedicamentoreceta);
                        oldIdRecetaOfMedicamentorecetaCollectionNewMedicamentoreceta = em.merge(oldIdRecetaOfMedicamentorecetaCollectionNewMedicamentoreceta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = receta.getIdReceta();
                if (findReceta(id) == null) {
                    throw new NonexistentEntityException("The receta with id " + id + " no longer exists.");
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
            Receta receta;
            try {
                receta = em.getReference(Receta.class, id);
                receta.getIdReceta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The receta with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Consulrece> consulreceCollectionOrphanCheck = receta.getConsulreceCollection();
            for (Consulrece consulreceCollectionOrphanCheckConsulrece : consulreceCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Receta (" + receta + ") cannot be destroyed since the Consulrece " + consulreceCollectionOrphanCheckConsulrece + " in its consulreceCollection field has a non-nullable idReceta field.");
            }
            Collection<Medicamentoreceta> medicamentorecetaCollectionOrphanCheck = receta.getMedicamentorecetaCollection();
            for (Medicamentoreceta medicamentorecetaCollectionOrphanCheckMedicamentoreceta : medicamentorecetaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Receta (" + receta + ") cannot be destroyed since the Medicamentoreceta " + medicamentorecetaCollectionOrphanCheckMedicamentoreceta + " in its medicamentorecetaCollection field has a non-nullable idReceta field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(receta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Receta> findRecetaEntities() {
        return findRecetaEntities(true, -1, -1);
    }

    public List<Receta> findRecetaEntities(int maxResults, int firstResult) {
        return findRecetaEntities(false, maxResults, firstResult);
    }

    private List<Receta> findRecetaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Receta.class));
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

    public Receta findReceta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Receta.class, id);
        } finally {
            em.close();
        }
    }

    public int getRecetaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Receta> rt = cq.from(Receta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
