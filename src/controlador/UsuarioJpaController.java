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
import modelo.Medico;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Paciente;
import modelo.Usuario;

/**
 *
 * @author USER
 */
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) {
        if (usuario.getMedicoCollection() == null) {
            usuario.setMedicoCollection(new ArrayList<Medico>());
        }
        if (usuario.getPacienteCollection() == null) {
            usuario.setPacienteCollection(new ArrayList<Paciente>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Medico> attachedMedicoCollection = new ArrayList<Medico>();
            for (Medico medicoCollectionMedicoToAttach : usuario.getMedicoCollection()) {
                medicoCollectionMedicoToAttach = em.getReference(medicoCollectionMedicoToAttach.getClass(), medicoCollectionMedicoToAttach.getIdMedico());
                attachedMedicoCollection.add(medicoCollectionMedicoToAttach);
            }
            usuario.setMedicoCollection(attachedMedicoCollection);
            Collection<Paciente> attachedPacienteCollection = new ArrayList<Paciente>();
            for (Paciente pacienteCollectionPacienteToAttach : usuario.getPacienteCollection()) {
                pacienteCollectionPacienteToAttach = em.getReference(pacienteCollectionPacienteToAttach.getClass(), pacienteCollectionPacienteToAttach.getIdPaciente());
                attachedPacienteCollection.add(pacienteCollectionPacienteToAttach);
            }
            usuario.setPacienteCollection(attachedPacienteCollection);
            em.persist(usuario);
            for (Medico medicoCollectionMedico : usuario.getMedicoCollection()) {
                Usuario oldUsuarioMedicoOfMedicoCollectionMedico = medicoCollectionMedico.getUsuarioMedico();
                medicoCollectionMedico.setUsuarioMedico(usuario);
                medicoCollectionMedico = em.merge(medicoCollectionMedico);
                if (oldUsuarioMedicoOfMedicoCollectionMedico != null) {
                    oldUsuarioMedicoOfMedicoCollectionMedico.getMedicoCollection().remove(medicoCollectionMedico);
                    oldUsuarioMedicoOfMedicoCollectionMedico = em.merge(oldUsuarioMedicoOfMedicoCollectionMedico);
                }
            }
            for (Paciente pacienteCollectionPaciente : usuario.getPacienteCollection()) {
                Usuario oldUsuarioPacienteOfPacienteCollectionPaciente = pacienteCollectionPaciente.getUsuarioPaciente();
                pacienteCollectionPaciente.setUsuarioPaciente(usuario);
                pacienteCollectionPaciente = em.merge(pacienteCollectionPaciente);
                if (oldUsuarioPacienteOfPacienteCollectionPaciente != null) {
                    oldUsuarioPacienteOfPacienteCollectionPaciente.getPacienteCollection().remove(pacienteCollectionPaciente);
                    oldUsuarioPacienteOfPacienteCollectionPaciente = em.merge(oldUsuarioPacienteOfPacienteCollectionPaciente);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getIdUsuario());
            Collection<Medico> medicoCollectionOld = persistentUsuario.getMedicoCollection();
            Collection<Medico> medicoCollectionNew = usuario.getMedicoCollection();
            Collection<Paciente> pacienteCollectionOld = persistentUsuario.getPacienteCollection();
            Collection<Paciente> pacienteCollectionNew = usuario.getPacienteCollection();
            List<String> illegalOrphanMessages = null;
            for (Medico medicoCollectionOldMedico : medicoCollectionOld) {
                if (!medicoCollectionNew.contains(medicoCollectionOldMedico)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Medico " + medicoCollectionOldMedico + " since its usuarioMedico field is not nullable.");
                }
            }
            for (Paciente pacienteCollectionOldPaciente : pacienteCollectionOld) {
                if (!pacienteCollectionNew.contains(pacienteCollectionOldPaciente)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Paciente " + pacienteCollectionOldPaciente + " since its usuarioPaciente field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Medico> attachedMedicoCollectionNew = new ArrayList<Medico>();
            for (Medico medicoCollectionNewMedicoToAttach : medicoCollectionNew) {
                medicoCollectionNewMedicoToAttach = em.getReference(medicoCollectionNewMedicoToAttach.getClass(), medicoCollectionNewMedicoToAttach.getIdMedico());
                attachedMedicoCollectionNew.add(medicoCollectionNewMedicoToAttach);
            }
            medicoCollectionNew = attachedMedicoCollectionNew;
            usuario.setMedicoCollection(medicoCollectionNew);
            Collection<Paciente> attachedPacienteCollectionNew = new ArrayList<Paciente>();
            for (Paciente pacienteCollectionNewPacienteToAttach : pacienteCollectionNew) {
                pacienteCollectionNewPacienteToAttach = em.getReference(pacienteCollectionNewPacienteToAttach.getClass(), pacienteCollectionNewPacienteToAttach.getIdPaciente());
                attachedPacienteCollectionNew.add(pacienteCollectionNewPacienteToAttach);
            }
            pacienteCollectionNew = attachedPacienteCollectionNew;
            usuario.setPacienteCollection(pacienteCollectionNew);
            usuario = em.merge(usuario);
            for (Medico medicoCollectionNewMedico : medicoCollectionNew) {
                if (!medicoCollectionOld.contains(medicoCollectionNewMedico)) {
                    Usuario oldUsuarioMedicoOfMedicoCollectionNewMedico = medicoCollectionNewMedico.getUsuarioMedico();
                    medicoCollectionNewMedico.setUsuarioMedico(usuario);
                    medicoCollectionNewMedico = em.merge(medicoCollectionNewMedico);
                    if (oldUsuarioMedicoOfMedicoCollectionNewMedico != null && !oldUsuarioMedicoOfMedicoCollectionNewMedico.equals(usuario)) {
                        oldUsuarioMedicoOfMedicoCollectionNewMedico.getMedicoCollection().remove(medicoCollectionNewMedico);
                        oldUsuarioMedicoOfMedicoCollectionNewMedico = em.merge(oldUsuarioMedicoOfMedicoCollectionNewMedico);
                    }
                }
            }
            for (Paciente pacienteCollectionNewPaciente : pacienteCollectionNew) {
                if (!pacienteCollectionOld.contains(pacienteCollectionNewPaciente)) {
                    Usuario oldUsuarioPacienteOfPacienteCollectionNewPaciente = pacienteCollectionNewPaciente.getUsuarioPaciente();
                    pacienteCollectionNewPaciente.setUsuarioPaciente(usuario);
                    pacienteCollectionNewPaciente = em.merge(pacienteCollectionNewPaciente);
                    if (oldUsuarioPacienteOfPacienteCollectionNewPaciente != null && !oldUsuarioPacienteOfPacienteCollectionNewPaciente.equals(usuario)) {
                        oldUsuarioPacienteOfPacienteCollectionNewPaciente.getPacienteCollection().remove(pacienteCollectionNewPaciente);
                        oldUsuarioPacienteOfPacienteCollectionNewPaciente = em.merge(oldUsuarioPacienteOfPacienteCollectionNewPaciente);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuario.getIdUsuario();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
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
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getIdUsuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Medico> medicoCollectionOrphanCheck = usuario.getMedicoCollection();
            for (Medico medicoCollectionOrphanCheckMedico : medicoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuario (" + usuario + ") cannot be destroyed since the Medico " + medicoCollectionOrphanCheckMedico + " in its medicoCollection field has a non-nullable usuarioMedico field.");
            }
            Collection<Paciente> pacienteCollectionOrphanCheck = usuario.getPacienteCollection();
            for (Paciente pacienteCollectionOrphanCheckPaciente : pacienteCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuario (" + usuario + ") cannot be destroyed since the Paciente " + pacienteCollectionOrphanCheckPaciente + " in its pacienteCollection field has a non-nullable usuarioPaciente field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
