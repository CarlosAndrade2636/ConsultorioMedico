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
import modelo.Medicamento;
import modelo.Medicamentoreceta;
import modelo.Receta;

/**
 *
 * @author USER
 */
public class MedicamentorecetaJpaController implements Serializable {

    public MedicamentorecetaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Medicamentoreceta medicamentoreceta) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Medicamento idMedicamento = medicamentoreceta.getIdMedicamento();
            if (idMedicamento != null) {
                idMedicamento = em.getReference(idMedicamento.getClass(), idMedicamento.getIdMedicina());
                medicamentoreceta.setIdMedicamento(idMedicamento);
            }
            Receta idReceta = medicamentoreceta.getIdReceta();
            if (idReceta != null) {
                idReceta = em.getReference(idReceta.getClass(), idReceta.getIdReceta());
                medicamentoreceta.setIdReceta(idReceta);
            }
            em.persist(medicamentoreceta);
            if (idMedicamento != null) {
                idMedicamento.getMedicamentorecetaCollection().add(medicamentoreceta);
                idMedicamento = em.merge(idMedicamento);
            }
            if (idReceta != null) {
                idReceta.getMedicamentorecetaCollection().add(medicamentoreceta);
                idReceta = em.merge(idReceta);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Medicamentoreceta medicamentoreceta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Medicamentoreceta persistentMedicamentoreceta = em.find(Medicamentoreceta.class, medicamentoreceta.getIdMedRes());
            Medicamento idMedicamentoOld = persistentMedicamentoreceta.getIdMedicamento();
            Medicamento idMedicamentoNew = medicamentoreceta.getIdMedicamento();
            Receta idRecetaOld = persistentMedicamentoreceta.getIdReceta();
            Receta idRecetaNew = medicamentoreceta.getIdReceta();
            if (idMedicamentoNew != null) {
                idMedicamentoNew = em.getReference(idMedicamentoNew.getClass(), idMedicamentoNew.getIdMedicina());
                medicamentoreceta.setIdMedicamento(idMedicamentoNew);
            }
            if (idRecetaNew != null) {
                idRecetaNew = em.getReference(idRecetaNew.getClass(), idRecetaNew.getIdReceta());
                medicamentoreceta.setIdReceta(idRecetaNew);
            }
            medicamentoreceta = em.merge(medicamentoreceta);
            if (idMedicamentoOld != null && !idMedicamentoOld.equals(idMedicamentoNew)) {
                idMedicamentoOld.getMedicamentorecetaCollection().remove(medicamentoreceta);
                idMedicamentoOld = em.merge(idMedicamentoOld);
            }
            if (idMedicamentoNew != null && !idMedicamentoNew.equals(idMedicamentoOld)) {
                idMedicamentoNew.getMedicamentorecetaCollection().add(medicamentoreceta);
                idMedicamentoNew = em.merge(idMedicamentoNew);
            }
            if (idRecetaOld != null && !idRecetaOld.equals(idRecetaNew)) {
                idRecetaOld.getMedicamentorecetaCollection().remove(medicamentoreceta);
                idRecetaOld = em.merge(idRecetaOld);
            }
            if (idRecetaNew != null && !idRecetaNew.equals(idRecetaOld)) {
                idRecetaNew.getMedicamentorecetaCollection().add(medicamentoreceta);
                idRecetaNew = em.merge(idRecetaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = medicamentoreceta.getIdMedRes();
                if (findMedicamentoreceta(id) == null) {
                    throw new NonexistentEntityException("The medicamentoreceta with id " + id + " no longer exists.");
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
            Medicamentoreceta medicamentoreceta;
            try {
                medicamentoreceta = em.getReference(Medicamentoreceta.class, id);
                medicamentoreceta.getIdMedRes();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The medicamentoreceta with id " + id + " no longer exists.", enfe);
            }
            Medicamento idMedicamento = medicamentoreceta.getIdMedicamento();
            if (idMedicamento != null) {
                idMedicamento.getMedicamentorecetaCollection().remove(medicamentoreceta);
                idMedicamento = em.merge(idMedicamento);
            }
            Receta idReceta = medicamentoreceta.getIdReceta();
            if (idReceta != null) {
                idReceta.getMedicamentorecetaCollection().remove(medicamentoreceta);
                idReceta = em.merge(idReceta);
            }
            em.remove(medicamentoreceta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Medicamentoreceta> findMedicamentorecetaEntities() {
        return findMedicamentorecetaEntities(true, -1, -1);
    }

    public List<Medicamentoreceta> findMedicamentorecetaEntities(int maxResults, int firstResult) {
        return findMedicamentorecetaEntities(false, maxResults, firstResult);
    }

    private List<Medicamentoreceta> findMedicamentorecetaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Medicamentoreceta.class));
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

    public Medicamentoreceta findMedicamentoreceta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Medicamentoreceta.class, id);
        } finally {
            em.close();
        }
    }

    public int getMedicamentorecetaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Medicamentoreceta> rt = cq.from(Medicamentoreceta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
