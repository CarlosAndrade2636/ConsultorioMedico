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
import modelo.Paciente;
import modelo.Turno;

/**
 *
 * @author USER
 */
public class PacienteJpaController implements Serializable {

    public PacienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paciente paciente) {
        if (paciente.getCitamedicaCollection() == null) {
            paciente.setCitamedicaCollection(new ArrayList<Citamedica>());
        }
        if (paciente.getTurnoCollection() == null) {
            paciente.setTurnoCollection(new ArrayList<Turno>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Persona personaPaciente = paciente.getPersonaPaciente();
            if (personaPaciente != null) {
                personaPaciente = em.getReference(personaPaciente.getClass(), personaPaciente.getIdPerosona());
                paciente.setPersonaPaciente(personaPaciente);
            }
            Usuario usuarioPaciente = paciente.getUsuarioPaciente();
            if (usuarioPaciente != null) {
                usuarioPaciente = em.getReference(usuarioPaciente.getClass(), usuarioPaciente.getIdUsuario());
                paciente.setUsuarioPaciente(usuarioPaciente);
            }
            Collection<Citamedica> attachedCitamedicaCollection = new ArrayList<Citamedica>();
            for (Citamedica citamedicaCollectionCitamedicaToAttach : paciente.getCitamedicaCollection()) {
                citamedicaCollectionCitamedicaToAttach = em.getReference(citamedicaCollectionCitamedicaToAttach.getClass(), citamedicaCollectionCitamedicaToAttach.getIdCita());
                attachedCitamedicaCollection.add(citamedicaCollectionCitamedicaToAttach);
            }
            paciente.setCitamedicaCollection(attachedCitamedicaCollection);
            Collection<Turno> attachedTurnoCollection = new ArrayList<Turno>();
            for (Turno turnoCollectionTurnoToAttach : paciente.getTurnoCollection()) {
                turnoCollectionTurnoToAttach = em.getReference(turnoCollectionTurnoToAttach.getClass(), turnoCollectionTurnoToAttach.getIdTurno());
                attachedTurnoCollection.add(turnoCollectionTurnoToAttach);
            }
            paciente.setTurnoCollection(attachedTurnoCollection);
            em.persist(paciente);
            if (personaPaciente != null) {
                personaPaciente.getPacienteCollection().add(paciente);
                personaPaciente = em.merge(personaPaciente);
            }
            if (usuarioPaciente != null) {
                usuarioPaciente.getPacienteCollection().add(paciente);
                usuarioPaciente = em.merge(usuarioPaciente);
            }
            for (Citamedica citamedicaCollectionCitamedica : paciente.getCitamedicaCollection()) {
                Paciente oldPacienteOfCitamedicaCollectionCitamedica = citamedicaCollectionCitamedica.getPaciente();
                citamedicaCollectionCitamedica.setPaciente(paciente);
                citamedicaCollectionCitamedica = em.merge(citamedicaCollectionCitamedica);
                if (oldPacienteOfCitamedicaCollectionCitamedica != null) {
                    oldPacienteOfCitamedicaCollectionCitamedica.getCitamedicaCollection().remove(citamedicaCollectionCitamedica);
                    oldPacienteOfCitamedicaCollectionCitamedica = em.merge(oldPacienteOfCitamedicaCollectionCitamedica);
                }
            }
            for (Turno turnoCollectionTurno : paciente.getTurnoCollection()) {
                Paciente oldPacienteOfTurnoCollectionTurno = turnoCollectionTurno.getPaciente();
                turnoCollectionTurno.setPaciente(paciente);
                turnoCollectionTurno = em.merge(turnoCollectionTurno);
                if (oldPacienteOfTurnoCollectionTurno != null) {
                    oldPacienteOfTurnoCollectionTurno.getTurnoCollection().remove(turnoCollectionTurno);
                    oldPacienteOfTurnoCollectionTurno = em.merge(oldPacienteOfTurnoCollectionTurno);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paciente paciente) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente persistentPaciente = em.find(Paciente.class, paciente.getIdPaciente());
            Persona personaPacienteOld = persistentPaciente.getPersonaPaciente();
            Persona personaPacienteNew = paciente.getPersonaPaciente();
            Usuario usuarioPacienteOld = persistentPaciente.getUsuarioPaciente();
            Usuario usuarioPacienteNew = paciente.getUsuarioPaciente();
            Collection<Citamedica> citamedicaCollectionOld = persistentPaciente.getCitamedicaCollection();
            Collection<Citamedica> citamedicaCollectionNew = paciente.getCitamedicaCollection();
            Collection<Turno> turnoCollectionOld = persistentPaciente.getTurnoCollection();
            Collection<Turno> turnoCollectionNew = paciente.getTurnoCollection();
            List<String> illegalOrphanMessages = null;
            for (Citamedica citamedicaCollectionOldCitamedica : citamedicaCollectionOld) {
                if (!citamedicaCollectionNew.contains(citamedicaCollectionOldCitamedica)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Citamedica " + citamedicaCollectionOldCitamedica + " since its paciente field is not nullable.");
                }
            }
            for (Turno turnoCollectionOldTurno : turnoCollectionOld) {
                if (!turnoCollectionNew.contains(turnoCollectionOldTurno)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Turno " + turnoCollectionOldTurno + " since its paciente field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (personaPacienteNew != null) {
                personaPacienteNew = em.getReference(personaPacienteNew.getClass(), personaPacienteNew.getIdPerosona());
                paciente.setPersonaPaciente(personaPacienteNew);
            }
            if (usuarioPacienteNew != null) {
                usuarioPacienteNew = em.getReference(usuarioPacienteNew.getClass(), usuarioPacienteNew.getIdUsuario());
                paciente.setUsuarioPaciente(usuarioPacienteNew);
            }
            Collection<Citamedica> attachedCitamedicaCollectionNew = new ArrayList<Citamedica>();
            for (Citamedica citamedicaCollectionNewCitamedicaToAttach : citamedicaCollectionNew) {
                citamedicaCollectionNewCitamedicaToAttach = em.getReference(citamedicaCollectionNewCitamedicaToAttach.getClass(), citamedicaCollectionNewCitamedicaToAttach.getIdCita());
                attachedCitamedicaCollectionNew.add(citamedicaCollectionNewCitamedicaToAttach);
            }
            citamedicaCollectionNew = attachedCitamedicaCollectionNew;
            paciente.setCitamedicaCollection(citamedicaCollectionNew);
            Collection<Turno> attachedTurnoCollectionNew = new ArrayList<Turno>();
            for (Turno turnoCollectionNewTurnoToAttach : turnoCollectionNew) {
                turnoCollectionNewTurnoToAttach = em.getReference(turnoCollectionNewTurnoToAttach.getClass(), turnoCollectionNewTurnoToAttach.getIdTurno());
                attachedTurnoCollectionNew.add(turnoCollectionNewTurnoToAttach);
            }
            turnoCollectionNew = attachedTurnoCollectionNew;
            paciente.setTurnoCollection(turnoCollectionNew);
            paciente = em.merge(paciente);
            if (personaPacienteOld != null && !personaPacienteOld.equals(personaPacienteNew)) {
                personaPacienteOld.getPacienteCollection().remove(paciente);
                personaPacienteOld = em.merge(personaPacienteOld);
            }
            if (personaPacienteNew != null && !personaPacienteNew.equals(personaPacienteOld)) {
                personaPacienteNew.getPacienteCollection().add(paciente);
                personaPacienteNew = em.merge(personaPacienteNew);
            }
            if (usuarioPacienteOld != null && !usuarioPacienteOld.equals(usuarioPacienteNew)) {
                usuarioPacienteOld.getPacienteCollection().remove(paciente);
                usuarioPacienteOld = em.merge(usuarioPacienteOld);
            }
            if (usuarioPacienteNew != null && !usuarioPacienteNew.equals(usuarioPacienteOld)) {
                usuarioPacienteNew.getPacienteCollection().add(paciente);
                usuarioPacienteNew = em.merge(usuarioPacienteNew);
            }
            for (Citamedica citamedicaCollectionNewCitamedica : citamedicaCollectionNew) {
                if (!citamedicaCollectionOld.contains(citamedicaCollectionNewCitamedica)) {
                    Paciente oldPacienteOfCitamedicaCollectionNewCitamedica = citamedicaCollectionNewCitamedica.getPaciente();
                    citamedicaCollectionNewCitamedica.setPaciente(paciente);
                    citamedicaCollectionNewCitamedica = em.merge(citamedicaCollectionNewCitamedica);
                    if (oldPacienteOfCitamedicaCollectionNewCitamedica != null && !oldPacienteOfCitamedicaCollectionNewCitamedica.equals(paciente)) {
                        oldPacienteOfCitamedicaCollectionNewCitamedica.getCitamedicaCollection().remove(citamedicaCollectionNewCitamedica);
                        oldPacienteOfCitamedicaCollectionNewCitamedica = em.merge(oldPacienteOfCitamedicaCollectionNewCitamedica);
                    }
                }
            }
            for (Turno turnoCollectionNewTurno : turnoCollectionNew) {
                if (!turnoCollectionOld.contains(turnoCollectionNewTurno)) {
                    Paciente oldPacienteOfTurnoCollectionNewTurno = turnoCollectionNewTurno.getPaciente();
                    turnoCollectionNewTurno.setPaciente(paciente);
                    turnoCollectionNewTurno = em.merge(turnoCollectionNewTurno);
                    if (oldPacienteOfTurnoCollectionNewTurno != null && !oldPacienteOfTurnoCollectionNewTurno.equals(paciente)) {
                        oldPacienteOfTurnoCollectionNewTurno.getTurnoCollection().remove(turnoCollectionNewTurno);
                        oldPacienteOfTurnoCollectionNewTurno = em.merge(oldPacienteOfTurnoCollectionNewTurno);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = paciente.getIdPaciente();
                if (findPaciente(id) == null) {
                    throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.");
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
            Paciente paciente;
            try {
                paciente = em.getReference(Paciente.class, id);
                paciente.getIdPaciente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Citamedica> citamedicaCollectionOrphanCheck = paciente.getCitamedicaCollection();
            for (Citamedica citamedicaCollectionOrphanCheckCitamedica : citamedicaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Paciente (" + paciente + ") cannot be destroyed since the Citamedica " + citamedicaCollectionOrphanCheckCitamedica + " in its citamedicaCollection field has a non-nullable paciente field.");
            }
            Collection<Turno> turnoCollectionOrphanCheck = paciente.getTurnoCollection();
            for (Turno turnoCollectionOrphanCheckTurno : turnoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Paciente (" + paciente + ") cannot be destroyed since the Turno " + turnoCollectionOrphanCheckTurno + " in its turnoCollection field has a non-nullable paciente field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Persona personaPaciente = paciente.getPersonaPaciente();
            if (personaPaciente != null) {
                personaPaciente.getPacienteCollection().remove(paciente);
                personaPaciente = em.merge(personaPaciente);
            }
            Usuario usuarioPaciente = paciente.getUsuarioPaciente();
            if (usuarioPaciente != null) {
                usuarioPaciente.getPacienteCollection().remove(paciente);
                usuarioPaciente = em.merge(usuarioPaciente);
            }
            em.remove(paciente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Paciente> findPacienteEntities() {
        return findPacienteEntities(true, -1, -1);
    }

    public List<Paciente> findPacienteEntities(int maxResults, int firstResult) {
        return findPacienteEntities(false, maxResults, firstResult);
    }

    private List<Paciente> findPacienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Paciente.class));
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

    public Paciente findPaciente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paciente.class, id);
        } finally {
            em.close();
        }
    }

    public int getPacienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paciente> rt = cq.from(Paciente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
