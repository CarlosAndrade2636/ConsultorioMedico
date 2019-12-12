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
import modelo.Paciente;
import modelo.Consultamedica;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Turno;

/**
 *
 * @author USER
 */
public class TurnoJpaController implements Serializable {

    public TurnoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Turno turno) {
        if (turno.getConsultamedicaCollection() == null) {
            turno.setConsultamedicaCollection(new ArrayList<Consultamedica>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente paciente = turno.getPaciente();
            if (paciente != null) {
                paciente = em.getReference(paciente.getClass(), paciente.getIdPaciente());
                turno.setPaciente(paciente);
            }
            Collection<Consultamedica> attachedConsultamedicaCollection = new ArrayList<Consultamedica>();
            for (Consultamedica consultamedicaCollectionConsultamedicaToAttach : turno.getConsultamedicaCollection()) {
                consultamedicaCollectionConsultamedicaToAttach = em.getReference(consultamedicaCollectionConsultamedicaToAttach.getClass(), consultamedicaCollectionConsultamedicaToAttach.getIdConsulta());
                attachedConsultamedicaCollection.add(consultamedicaCollectionConsultamedicaToAttach);
            }
            turno.setConsultamedicaCollection(attachedConsultamedicaCollection);
            em.persist(turno);
            if (paciente != null) {
                paciente.getTurnoCollection().add(turno);
                paciente = em.merge(paciente);
            }
            for (Consultamedica consultamedicaCollectionConsultamedica : turno.getConsultamedicaCollection()) {
                //consultamedicaCollectionConsultamedica.getTurno().add(turno);
                consultamedicaCollectionConsultamedica = em.merge(consultamedicaCollectionConsultamedica);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Turno turno) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Turno persistentTurno = em.find(Turno.class, turno.getIdTurno());
            Paciente pacienteOld = persistentTurno.getPaciente();
            Paciente pacienteNew = turno.getPaciente();
            Collection<Consultamedica> consultamedicaCollectionOld = persistentTurno.getConsultamedicaCollection();
            Collection<Consultamedica> consultamedicaCollectionNew = turno.getConsultamedicaCollection();
            if (pacienteNew != null) {
                pacienteNew = em.getReference(pacienteNew.getClass(), pacienteNew.getIdPaciente());
                turno.setPaciente(pacienteNew);
            }
            Collection<Consultamedica> attachedConsultamedicaCollectionNew = new ArrayList<Consultamedica>();
            for (Consultamedica consultamedicaCollectionNewConsultamedicaToAttach : consultamedicaCollectionNew) {
                consultamedicaCollectionNewConsultamedicaToAttach = em.getReference(consultamedicaCollectionNewConsultamedicaToAttach.getClass(), consultamedicaCollectionNewConsultamedicaToAttach.getIdConsulta());
                attachedConsultamedicaCollectionNew.add(consultamedicaCollectionNewConsultamedicaToAttach);
            }
            consultamedicaCollectionNew = attachedConsultamedicaCollectionNew;
            turno.setConsultamedicaCollection(consultamedicaCollectionNew);
            turno = em.merge(turno);
            if (pacienteOld != null && !pacienteOld.equals(pacienteNew)) {
                pacienteOld.getTurnoCollection().remove(turno);
                pacienteOld = em.merge(pacienteOld);
            }
            if (pacienteNew != null && !pacienteNew.equals(pacienteOld)) {
                pacienteNew.getTurnoCollection().add(turno);
                pacienteNew = em.merge(pacienteNew);
            }
            for (Consultamedica consultamedicaCollectionNewConsultamedica : consultamedicaCollectionNew) {
                if (!consultamedicaCollectionOld.contains(consultamedicaCollectionNewConsultamedica)) {
                
                    //consultamedicaCollectionNewConsultamedica.getTurno().add(turno);
                    consultamedicaCollectionNewConsultamedica = em.merge(consultamedicaCollectionNewConsultamedica);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = turno.getIdTurno();
                if (findTurno(id) == null) {
                    throw new NonexistentEntityException("The turno with id " + id + " no longer exists.");
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
            Turno turno;
            try {
                turno = em.getReference(Turno.class, id);
                turno.getIdTurno();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The turno with id " + id + " no longer exists.", enfe);
            }
            Paciente paciente = turno.getPaciente();
            if (paciente != null) {
                paciente.getTurnoCollection().remove(turno);
                paciente = em.merge(paciente);
            }
            em.remove(turno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Turno> findTurnoEntities() {
        return findTurnoEntities(true, -1, -1);
    }

    public List<Turno> findTurnoEntities(int maxResults, int firstResult) {
        return findTurnoEntities(false, maxResults, firstResult);
    }

    private List<Turno> findTurnoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Turno.class));
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

    public Turno findTurno(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Turno.class, id);
        } finally {
            em.close();
        }
    }

    public int getTurnoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Turno> rt = cq.from(Turno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
