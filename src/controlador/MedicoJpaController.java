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
import modelo.Persona;
import modelo.Usuario;
import modelo.Citamedica;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Medico;

/**
 *
 * @author USER
 */
public class MedicoJpaController implements Serializable {

    public MedicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Medico medico) {
        if (medico.getCitamedicaCollection() == null) {
            medico.setCitamedicaCollection(new ArrayList<Citamedica>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Persona personaMedico = medico.getPersonaMedico();
            if (personaMedico != null) {
                personaMedico = em.getReference(personaMedico.getClass(), personaMedico.getIdPerosona());
                medico.setPersonaMedico(personaMedico);
            }
            Usuario usuarioMedico = medico.getUsuarioMedico();
            if (usuarioMedico != null) {
                usuarioMedico = em.getReference(usuarioMedico.getClass(), usuarioMedico.getIdUsuario());
                medico.setUsuarioMedico(usuarioMedico);
            }
            Collection<Citamedica> attachedCitamedicaCollection = new ArrayList<Citamedica>();
            for (Citamedica citamedicaCollectionCitamedicaToAttach : medico.getCitamedicaCollection()) {
                citamedicaCollectionCitamedicaToAttach = em.getReference(citamedicaCollectionCitamedicaToAttach.getClass(), citamedicaCollectionCitamedicaToAttach.getIdCita());
                attachedCitamedicaCollection.add(citamedicaCollectionCitamedicaToAttach);
            }
            medico.setCitamedicaCollection(attachedCitamedicaCollection);
            em.persist(medico);
            if (personaMedico != null) {
                personaMedico.getMedicoCollection().add(medico);
                personaMedico = em.merge(personaMedico);
            }
            if (usuarioMedico != null) {
                usuarioMedico.getMedicoCollection().add(medico);
                usuarioMedico = em.merge(usuarioMedico);
            }
            for (Citamedica citamedicaCollectionCitamedica : medico.getCitamedicaCollection()) {
                Medico oldMedicoOfCitamedicaCollectionCitamedica = citamedicaCollectionCitamedica.getMedico();
                citamedicaCollectionCitamedica.setMedico(medico);
                citamedicaCollectionCitamedica = em.merge(citamedicaCollectionCitamedica);
                if (oldMedicoOfCitamedicaCollectionCitamedica != null) {
                    oldMedicoOfCitamedicaCollectionCitamedica.getCitamedicaCollection().remove(citamedicaCollectionCitamedica);
                    oldMedicoOfCitamedicaCollectionCitamedica = em.merge(oldMedicoOfCitamedicaCollectionCitamedica);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Medico medico) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Medico persistentMedico = em.find(Medico.class, medico.getIdMedico());
            Persona personaMedicoOld = persistentMedico.getPersonaMedico();
            Persona personaMedicoNew = medico.getPersonaMedico();
            Usuario usuarioMedicoOld = persistentMedico.getUsuarioMedico();
            Usuario usuarioMedicoNew = medico.getUsuarioMedico();
            Collection<Citamedica> citamedicaCollectionOld = persistentMedico.getCitamedicaCollection();
            Collection<Citamedica> citamedicaCollectionNew = medico.getCitamedicaCollection();
            List<String> illegalOrphanMessages = null;
            for (Citamedica citamedicaCollectionOldCitamedica : citamedicaCollectionOld) {
                if (!citamedicaCollectionNew.contains(citamedicaCollectionOldCitamedica)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Citamedica " + citamedicaCollectionOldCitamedica + " since its medico field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (personaMedicoNew != null) {
                personaMedicoNew = em.getReference(personaMedicoNew.getClass(), personaMedicoNew.getIdPerosona());
                medico.setPersonaMedico(personaMedicoNew);
            }
            if (usuarioMedicoNew != null) {
                usuarioMedicoNew = em.getReference(usuarioMedicoNew.getClass(), usuarioMedicoNew.getIdUsuario());
                medico.setUsuarioMedico(usuarioMedicoNew);
            }
            Collection<Citamedica> attachedCitamedicaCollectionNew = new ArrayList<Citamedica>();
            for (Citamedica citamedicaCollectionNewCitamedicaToAttach : citamedicaCollectionNew) {
                citamedicaCollectionNewCitamedicaToAttach = em.getReference(citamedicaCollectionNewCitamedicaToAttach.getClass(), citamedicaCollectionNewCitamedicaToAttach.getIdCita());
                attachedCitamedicaCollectionNew.add(citamedicaCollectionNewCitamedicaToAttach);
            }
            citamedicaCollectionNew = attachedCitamedicaCollectionNew;
            medico.setCitamedicaCollection(citamedicaCollectionNew);
            medico = em.merge(medico);
            if (personaMedicoOld != null && !personaMedicoOld.equals(personaMedicoNew)) {
                personaMedicoOld.getMedicoCollection().remove(medico);
                personaMedicoOld = em.merge(personaMedicoOld);
            }
            if (personaMedicoNew != null && !personaMedicoNew.equals(personaMedicoOld)) {
                personaMedicoNew.getMedicoCollection().add(medico);
                personaMedicoNew = em.merge(personaMedicoNew);
            }
            if (usuarioMedicoOld != null && !usuarioMedicoOld.equals(usuarioMedicoNew)) {
                usuarioMedicoOld.getMedicoCollection().remove(medico);
                usuarioMedicoOld = em.merge(usuarioMedicoOld);
            }
            if (usuarioMedicoNew != null && !usuarioMedicoNew.equals(usuarioMedicoOld)) {
                usuarioMedicoNew.getMedicoCollection().add(medico);
                usuarioMedicoNew = em.merge(usuarioMedicoNew);
            }
            for (Citamedica citamedicaCollectionNewCitamedica : citamedicaCollectionNew) {
                if (!citamedicaCollectionOld.contains(citamedicaCollectionNewCitamedica)) {
                    Medico oldMedicoOfCitamedicaCollectionNewCitamedica = citamedicaCollectionNewCitamedica.getMedico();
                    citamedicaCollectionNewCitamedica.setMedico(medico);
                    citamedicaCollectionNewCitamedica = em.merge(citamedicaCollectionNewCitamedica);
                    if (oldMedicoOfCitamedicaCollectionNewCitamedica != null && !oldMedicoOfCitamedicaCollectionNewCitamedica.equals(medico)) {
                        oldMedicoOfCitamedicaCollectionNewCitamedica.getCitamedicaCollection().remove(citamedicaCollectionNewCitamedica);
                        oldMedicoOfCitamedicaCollectionNewCitamedica = em.merge(oldMedicoOfCitamedicaCollectionNewCitamedica);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = medico.getIdMedico();
                if (findMedico(id) == null) {
                    throw new NonexistentEntityException("The medico with id " + id + " no longer exists.");
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
            Medico medico;
            try {
                medico = em.getReference(Medico.class, id);
                medico.getIdMedico();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The medico with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Citamedica> citamedicaCollectionOrphanCheck = medico.getCitamedicaCollection();
            for (Citamedica citamedicaCollectionOrphanCheckCitamedica : citamedicaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Medico (" + medico + ") cannot be destroyed since the Citamedica " + citamedicaCollectionOrphanCheckCitamedica + " in its citamedicaCollection field has a non-nullable medico field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Persona personaMedico = medico.getPersonaMedico();
            if (personaMedico != null) {
                personaMedico.getMedicoCollection().remove(medico);
                personaMedico = em.merge(personaMedico);
            }
            Usuario usuarioMedico = medico.getUsuarioMedico();
            if (usuarioMedico != null) {
                usuarioMedico.getMedicoCollection().remove(medico);
                usuarioMedico = em.merge(usuarioMedico);
            }
            em.remove(medico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Medico> findMedicoEntities() {
        return findMedicoEntities(true, -1, -1);
    }

    public List<Medico> findMedicoEntities(int maxResults, int firstResult) {
        return findMedicoEntities(false, maxResults, firstResult);
    }

    private List<Medico> findMedicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Medico.class));
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

    public Medico findMedico(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Medico.class, id);
        } finally {
            em.close();
        }
    }

    public int getMedicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Medico> rt = cq.from(Medico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
