/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Medico;
import modelo.Paciente;
import modelo.Consultamedica;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Citamedica;

/**
 *
 * @author USER
 */
public class CitamedicaJpaController implements Serializable {

    public CitamedicaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public CitamedicaJpaController() {
    }
     
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Citamedica citamedica) {
        if (citamedica.getConsultamedicaCollection() == null) {
            citamedica.setConsultamedicaCollection(new ArrayList<Consultamedica>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Medico medico = citamedica.getMedico();
            if (medico != null) {
                medico = em.getReference(medico.getClass(), medico.getIdMedico());
                citamedica.setMedico(medico);
            }
            Paciente paciente = citamedica.getPaciente();
            if (paciente != null) {
                paciente = em.getReference(paciente.getClass(), paciente.getIdPaciente());
                citamedica.setPaciente(paciente);
            }
            Collection<Consultamedica> attachedConsultamedicaCollection = new ArrayList<Consultamedica>();
            for (Consultamedica consultamedicaCollectionConsultamedicaToAttach : citamedica.getConsultamedicaCollection()) {
                consultamedicaCollectionConsultamedicaToAttach = em.getReference(consultamedicaCollectionConsultamedicaToAttach.getClass(), consultamedicaCollectionConsultamedicaToAttach.getIdConsulta());
                attachedConsultamedicaCollection.add(consultamedicaCollectionConsultamedicaToAttach);
            }
            citamedica.setConsultamedicaCollection(attachedConsultamedicaCollection);
            em.persist(citamedica);
            if (medico != null) {
                medico.getCitamedicaCollection().add(citamedica);
                medico = em.merge(medico);
            }
            if (paciente != null) {
                paciente.getCitamedicaCollection().add(citamedica);
                paciente = em.merge(paciente);
            }
            for (Consultamedica consultamedicaCollectionConsultamedica : citamedica.getConsultamedicaCollection()) {
           //     consultamedicaCollectionConsultamedica.getCita().add(citamedica);
                consultamedicaCollectionConsultamedica = em.merge(consultamedicaCollectionConsultamedica);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Citamedica citamedica) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Citamedica persistentCitamedica = em.find(Citamedica.class, citamedica.getIdCita());
            Medico medicoOld = persistentCitamedica.getMedico();
            Medico medicoNew = citamedica.getMedico();
            Paciente pacienteOld = persistentCitamedica.getPaciente();
            Paciente pacienteNew = citamedica.getPaciente();
            Collection<Consultamedica> consultamedicaCollectionOld = persistentCitamedica.getConsultamedicaCollection();
            Collection<Consultamedica> consultamedicaCollectionNew = citamedica.getConsultamedicaCollection();
            if (medicoNew != null) {
                medicoNew = em.getReference(medicoNew.getClass(), medicoNew.getIdMedico());
                citamedica.setMedico(medicoNew);
            }
            if (pacienteNew != null) {
                pacienteNew = em.getReference(pacienteNew.getClass(), pacienteNew.getIdPaciente());
                citamedica.setPaciente(pacienteNew);
            }
            Collection<Consultamedica> attachedConsultamedicaCollectionNew = new ArrayList<Consultamedica>();
            for (Consultamedica consultamedicaCollectionNewConsultamedicaToAttach : consultamedicaCollectionNew) {
                consultamedicaCollectionNewConsultamedicaToAttach = em.getReference(consultamedicaCollectionNewConsultamedicaToAttach.getClass(), consultamedicaCollectionNewConsultamedicaToAttach.getIdConsulta());
                attachedConsultamedicaCollectionNew.add(consultamedicaCollectionNewConsultamedicaToAttach);
            }
            consultamedicaCollectionNew = attachedConsultamedicaCollectionNew;
            citamedica.setConsultamedicaCollection(consultamedicaCollectionNew);
            citamedica = em.merge(citamedica);
            if (medicoOld != null && !medicoOld.equals(medicoNew)) {
                medicoOld.getCitamedicaCollection().remove(citamedica);
                medicoOld = em.merge(medicoOld);
            }
            if (medicoNew != null && !medicoNew.equals(medicoOld)) {
                medicoNew.getCitamedicaCollection().add(citamedica);
                medicoNew = em.merge(medicoNew);
            }
            if (pacienteOld != null && !pacienteOld.equals(pacienteNew)) {
                pacienteOld.getCitamedicaCollection().remove(citamedica);
                pacienteOld = em.merge(pacienteOld);
            }
            if (pacienteNew != null && !pacienteNew.equals(pacienteOld)) {
                pacienteNew.getCitamedicaCollection().add(citamedica);
                pacienteNew = em.merge(pacienteNew);
            }
            for (Consultamedica consultamedicaCollectionNewConsultamedica : consultamedicaCollectionNew) {
                if (!consultamedicaCollectionOld.contains(consultamedicaCollectionNewConsultamedica)) {
//                    consultamedicaCollectionNewConsultamedica.getCita().add(citamedica);
                    consultamedicaCollectionNewConsultamedica = em.merge(consultamedicaCollectionNewConsultamedica);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = citamedica.getIdCita();
                if (findCitamedica(id) == null) {
                    throw new NonexistentEntityException("The citamedica with id " + id + " no longer exists.");
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
            Citamedica citamedica;
            try {
                citamedica = em.getReference(Citamedica.class, id);
                citamedica.getIdCita();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The citamedica with id " + id + " no longer exists.", enfe);
            }
            Medico medico = citamedica.getMedico();
            if (medico != null) {
                medico.getCitamedicaCollection().remove(citamedica);
                medico = em.merge(medico);
            }
            Paciente paciente = citamedica.getPaciente();
            if (paciente != null) {
                paciente.getCitamedicaCollection().remove(citamedica);
                paciente = em.merge(paciente);
            }
            em.remove(citamedica);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Citamedica> findCitamedicaEntities() {
        return findCitamedicaEntities(true, -1, -1);
    }

    public List<Citamedica> findCitamedicaEntities(int maxResults, int firstResult) {
        return findCitamedicaEntities(false, maxResults, firstResult);
    }

    private List<Citamedica> findCitamedicaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Citamedica.class));
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

    public Citamedica findCitamedica(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Citamedica.class, id);
        } finally {
            em.close();
        }
    }

    public int getCitamedicaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Citamedica> rt = cq.from(Citamedica.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
