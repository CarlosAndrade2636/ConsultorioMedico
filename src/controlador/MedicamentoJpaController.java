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
import modelo.Medicamentoreceta;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Medicamento;

/**
 *
 * @author USER
 */
public class MedicamentoJpaController implements Serializable {

    public MedicamentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Medicamento medicamento) {
        if (medicamento.getMedicamentorecetaCollection() == null) {
            medicamento.setMedicamentorecetaCollection(new ArrayList<Medicamentoreceta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Medicamentoreceta> attachedMedicamentorecetaCollection = new ArrayList<Medicamentoreceta>();
            for (Medicamentoreceta medicamentorecetaCollectionMedicamentorecetaToAttach : medicamento.getMedicamentorecetaCollection()) {
                medicamentorecetaCollectionMedicamentorecetaToAttach = em.getReference(medicamentorecetaCollectionMedicamentorecetaToAttach.getClass(), medicamentorecetaCollectionMedicamentorecetaToAttach.getIdMedRes());
                attachedMedicamentorecetaCollection.add(medicamentorecetaCollectionMedicamentorecetaToAttach);
            }
            medicamento.setMedicamentorecetaCollection(attachedMedicamentorecetaCollection);
            em.persist(medicamento);
            for (Medicamentoreceta medicamentorecetaCollectionMedicamentoreceta : medicamento.getMedicamentorecetaCollection()) {
                Medicamento oldIdMedicamentoOfMedicamentorecetaCollectionMedicamentoreceta = medicamentorecetaCollectionMedicamentoreceta.getIdMedicamento();
                medicamentorecetaCollectionMedicamentoreceta.setIdMedicamento(medicamento);
                medicamentorecetaCollectionMedicamentoreceta = em.merge(medicamentorecetaCollectionMedicamentoreceta);
                if (oldIdMedicamentoOfMedicamentorecetaCollectionMedicamentoreceta != null) {
                    oldIdMedicamentoOfMedicamentorecetaCollectionMedicamentoreceta.getMedicamentorecetaCollection().remove(medicamentorecetaCollectionMedicamentoreceta);
                    oldIdMedicamentoOfMedicamentorecetaCollectionMedicamentoreceta = em.merge(oldIdMedicamentoOfMedicamentorecetaCollectionMedicamentoreceta);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Medicamento medicamento) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Medicamento persistentMedicamento = em.find(Medicamento.class, medicamento.getIdMedicina());
            Collection<Medicamentoreceta> medicamentorecetaCollectionOld = persistentMedicamento.getMedicamentorecetaCollection();
            Collection<Medicamentoreceta> medicamentorecetaCollectionNew = medicamento.getMedicamentorecetaCollection();
            List<String> illegalOrphanMessages = null;
            for (Medicamentoreceta medicamentorecetaCollectionOldMedicamentoreceta : medicamentorecetaCollectionOld) {
                if (!medicamentorecetaCollectionNew.contains(medicamentorecetaCollectionOldMedicamentoreceta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Medicamentoreceta " + medicamentorecetaCollectionOldMedicamentoreceta + " since its idMedicamento field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Medicamentoreceta> attachedMedicamentorecetaCollectionNew = new ArrayList<Medicamentoreceta>();
            for (Medicamentoreceta medicamentorecetaCollectionNewMedicamentorecetaToAttach : medicamentorecetaCollectionNew) {
                medicamentorecetaCollectionNewMedicamentorecetaToAttach = em.getReference(medicamentorecetaCollectionNewMedicamentorecetaToAttach.getClass(), medicamentorecetaCollectionNewMedicamentorecetaToAttach.getIdMedRes());
                attachedMedicamentorecetaCollectionNew.add(medicamentorecetaCollectionNewMedicamentorecetaToAttach);
            }
            medicamentorecetaCollectionNew = attachedMedicamentorecetaCollectionNew;
            medicamento.setMedicamentorecetaCollection(medicamentorecetaCollectionNew);
            medicamento = em.merge(medicamento);
            for (Medicamentoreceta medicamentorecetaCollectionNewMedicamentoreceta : medicamentorecetaCollectionNew) {
                if (!medicamentorecetaCollectionOld.contains(medicamentorecetaCollectionNewMedicamentoreceta)) {
                    Medicamento oldIdMedicamentoOfMedicamentorecetaCollectionNewMedicamentoreceta = medicamentorecetaCollectionNewMedicamentoreceta.getIdMedicamento();
                    medicamentorecetaCollectionNewMedicamentoreceta.setIdMedicamento(medicamento);
                    medicamentorecetaCollectionNewMedicamentoreceta = em.merge(medicamentorecetaCollectionNewMedicamentoreceta);
                    if (oldIdMedicamentoOfMedicamentorecetaCollectionNewMedicamentoreceta != null && !oldIdMedicamentoOfMedicamentorecetaCollectionNewMedicamentoreceta.equals(medicamento)) {
                        oldIdMedicamentoOfMedicamentorecetaCollectionNewMedicamentoreceta.getMedicamentorecetaCollection().remove(medicamentorecetaCollectionNewMedicamentoreceta);
                        oldIdMedicamentoOfMedicamentorecetaCollectionNewMedicamentoreceta = em.merge(oldIdMedicamentoOfMedicamentorecetaCollectionNewMedicamentoreceta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = medicamento.getIdMedicina();
                if (findMedicamento(id) == null) {
                    throw new NonexistentEntityException("The medicamento with id " + id + " no longer exists.");
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
            Medicamento medicamento;
            try {
                medicamento = em.getReference(Medicamento.class, id);
                medicamento.getIdMedicina();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The medicamento with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Medicamentoreceta> medicamentorecetaCollectionOrphanCheck = medicamento.getMedicamentorecetaCollection();
            for (Medicamentoreceta medicamentorecetaCollectionOrphanCheckMedicamentoreceta : medicamentorecetaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Medicamento (" + medicamento + ") cannot be destroyed since the Medicamentoreceta " + medicamentorecetaCollectionOrphanCheckMedicamentoreceta + " in its medicamentorecetaCollection field has a non-nullable idMedicamento field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(medicamento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Medicamento> findMedicamentoEntities() {
        return findMedicamentoEntities(true, -1, -1);
    }

    public List<Medicamento> findMedicamentoEntities(int maxResults, int firstResult) {
        return findMedicamentoEntities(false, maxResults, firstResult);
    }

    private List<Medicamento> findMedicamentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Medicamento.class));
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

    public Medicamento findMedicamento(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Medicamento.class, id);
        } finally {
            em.close();
        }
    }

    public int getMedicamentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Medicamento> rt = cq.from(Medicamento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
