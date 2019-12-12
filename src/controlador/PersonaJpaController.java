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
import modelo.Paciente;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Medico;
import modelo.Persona;

/**
 *
 * @author USER
 */
public class PersonaJpaController implements Serializable {

    public PersonaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Persona persona) {
        if (persona.getPacienteCollection() == null) {
            persona.setPacienteCollection(new ArrayList<Paciente>());
        }
        if (persona.getMedicoCollection() == null) {
            persona.setMedicoCollection(new ArrayList<Medico>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Paciente> attachedPacienteCollection = new ArrayList<Paciente>();
            for (Paciente pacienteCollectionPacienteToAttach : persona.getPacienteCollection()) {
                pacienteCollectionPacienteToAttach = em.getReference(pacienteCollectionPacienteToAttach.getClass(), pacienteCollectionPacienteToAttach.getIdPaciente());
                attachedPacienteCollection.add(pacienteCollectionPacienteToAttach);
            }
            persona.setPacienteCollection(attachedPacienteCollection);
            Collection<Medico> attachedMedicoCollection = new ArrayList<Medico>();
            for (Medico medicoCollectionMedicoToAttach : persona.getMedicoCollection()) {
                medicoCollectionMedicoToAttach = em.getReference(medicoCollectionMedicoToAttach.getClass(), medicoCollectionMedicoToAttach.getIdMedico());
                attachedMedicoCollection.add(medicoCollectionMedicoToAttach);
            }
            persona.setMedicoCollection(attachedMedicoCollection);
            em.persist(persona);
            for (Paciente pacienteCollectionPaciente : persona.getPacienteCollection()) {
                Persona oldPersonaPacienteOfPacienteCollectionPaciente = pacienteCollectionPaciente.getPersonaPaciente();
                pacienteCollectionPaciente.setPersonaPaciente(persona);
                pacienteCollectionPaciente = em.merge(pacienteCollectionPaciente);
                if (oldPersonaPacienteOfPacienteCollectionPaciente != null) {
                    oldPersonaPacienteOfPacienteCollectionPaciente.getPacienteCollection().remove(pacienteCollectionPaciente);
                    oldPersonaPacienteOfPacienteCollectionPaciente = em.merge(oldPersonaPacienteOfPacienteCollectionPaciente);
                }
            }
            for (Medico medicoCollectionMedico : persona.getMedicoCollection()) {
                Persona oldPersonaMedicoOfMedicoCollectionMedico = medicoCollectionMedico.getPersonaMedico();
                medicoCollectionMedico.setPersonaMedico(persona);
                medicoCollectionMedico = em.merge(medicoCollectionMedico);
                if (oldPersonaMedicoOfMedicoCollectionMedico != null) {
                    oldPersonaMedicoOfMedicoCollectionMedico.getMedicoCollection().remove(medicoCollectionMedico);
                    oldPersonaMedicoOfMedicoCollectionMedico = em.merge(oldPersonaMedicoOfMedicoCollectionMedico);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Persona persona) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Persona persistentPersona = em.find(Persona.class, persona.getIdPerosona());
            Collection<Paciente> pacienteCollectionOld = persistentPersona.getPacienteCollection();
            Collection<Paciente> pacienteCollectionNew = persona.getPacienteCollection();
            Collection<Medico> medicoCollectionOld = persistentPersona.getMedicoCollection();
            Collection<Medico> medicoCollectionNew = persona.getMedicoCollection();
            List<String> illegalOrphanMessages = null;
            for (Paciente pacienteCollectionOldPaciente : pacienteCollectionOld) {
                if (!pacienteCollectionNew.contains(pacienteCollectionOldPaciente)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Paciente " + pacienteCollectionOldPaciente + " since its personaPaciente field is not nullable.");
                }
            }
            for (Medico medicoCollectionOldMedico : medicoCollectionOld) {
                if (!medicoCollectionNew.contains(medicoCollectionOldMedico)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Medico " + medicoCollectionOldMedico + " since its personaMedico field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Paciente> attachedPacienteCollectionNew = new ArrayList<Paciente>();
            for (Paciente pacienteCollectionNewPacienteToAttach : pacienteCollectionNew) {
                pacienteCollectionNewPacienteToAttach = em.getReference(pacienteCollectionNewPacienteToAttach.getClass(), pacienteCollectionNewPacienteToAttach.getIdPaciente());
                attachedPacienteCollectionNew.add(pacienteCollectionNewPacienteToAttach);
            }
            pacienteCollectionNew = attachedPacienteCollectionNew;
            persona.setPacienteCollection(pacienteCollectionNew);
            Collection<Medico> attachedMedicoCollectionNew = new ArrayList<Medico>();
            for (Medico medicoCollectionNewMedicoToAttach : medicoCollectionNew) {
                medicoCollectionNewMedicoToAttach = em.getReference(medicoCollectionNewMedicoToAttach.getClass(), medicoCollectionNewMedicoToAttach.getIdMedico());
                attachedMedicoCollectionNew.add(medicoCollectionNewMedicoToAttach);
            }
            medicoCollectionNew = attachedMedicoCollectionNew;
            persona.setMedicoCollection(medicoCollectionNew);
            persona = em.merge(persona);
            for (Paciente pacienteCollectionNewPaciente : pacienteCollectionNew) {
                if (!pacienteCollectionOld.contains(pacienteCollectionNewPaciente)) {
                    Persona oldPersonaPacienteOfPacienteCollectionNewPaciente = pacienteCollectionNewPaciente.getPersonaPaciente();
                    pacienteCollectionNewPaciente.setPersonaPaciente(persona);
                    pacienteCollectionNewPaciente = em.merge(pacienteCollectionNewPaciente);
                    if (oldPersonaPacienteOfPacienteCollectionNewPaciente != null && !oldPersonaPacienteOfPacienteCollectionNewPaciente.equals(persona)) {
                        oldPersonaPacienteOfPacienteCollectionNewPaciente.getPacienteCollection().remove(pacienteCollectionNewPaciente);
                        oldPersonaPacienteOfPacienteCollectionNewPaciente = em.merge(oldPersonaPacienteOfPacienteCollectionNewPaciente);
                    }
                }
            }
            for (Medico medicoCollectionNewMedico : medicoCollectionNew) {
                if (!medicoCollectionOld.contains(medicoCollectionNewMedico)) {
                    Persona oldPersonaMedicoOfMedicoCollectionNewMedico = medicoCollectionNewMedico.getPersonaMedico();
                    medicoCollectionNewMedico.setPersonaMedico(persona);
                    medicoCollectionNewMedico = em.merge(medicoCollectionNewMedico);
                    if (oldPersonaMedicoOfMedicoCollectionNewMedico != null && !oldPersonaMedicoOfMedicoCollectionNewMedico.equals(persona)) {
                        oldPersonaMedicoOfMedicoCollectionNewMedico.getMedicoCollection().remove(medicoCollectionNewMedico);
                        oldPersonaMedicoOfMedicoCollectionNewMedico = em.merge(oldPersonaMedicoOfMedicoCollectionNewMedico);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = persona.getIdPerosona();
                if (findPersona(id) == null) {
                    throw new NonexistentEntityException("The persona with id " + id + " no longer exists.");
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
            Persona persona;
            try {
                persona = em.getReference(Persona.class, id);
                persona.getIdPerosona();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The persona with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Paciente> pacienteCollectionOrphanCheck = persona.getPacienteCollection();
            for (Paciente pacienteCollectionOrphanCheckPaciente : pacienteCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Persona (" + persona + ") cannot be destroyed since the Paciente " + pacienteCollectionOrphanCheckPaciente + " in its pacienteCollection field has a non-nullable personaPaciente field.");
            }
            Collection<Medico> medicoCollectionOrphanCheck = persona.getMedicoCollection();
            for (Medico medicoCollectionOrphanCheckMedico : medicoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Persona (" + persona + ") cannot be destroyed since the Medico " + medicoCollectionOrphanCheckMedico + " in its medicoCollection field has a non-nullable personaMedico field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(persona);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Persona> findPersonaEntities() {
        return findPersonaEntities(true, -1, -1);
    }

    public List<Persona> findPersonaEntities(int maxResults, int firstResult) {
        return findPersonaEntities(false, maxResults, firstResult);
    }

    private List<Persona> findPersonaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Persona.class));
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

    public Persona findPersona(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Persona.class, id);
        } finally {
            em.close();
        }
    }

    public int getPersonaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Persona> rt = cq.from(Persona.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
