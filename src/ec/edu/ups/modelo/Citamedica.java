/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USER
 */

public class Citamedica implements Serializable {


    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private Collection<Consultamedica> consultamedicaCollection;

    private static final long serialVersionUID = 1L;
  
    private Integer idCita;
    
    private Date fechaCita;
 
    private Date horaCita;
 
    private String motivo;
   
    private String estado;
   
    private Medico medico;
   
    private Paciente paciente;

    public Citamedica() {
    }

    public Citamedica(Integer idCita) {
        this.idCita = idCita;
    }

    public Citamedica(Integer idCita, Date fechaCita, Date horaCita, String motivo, String estado) {
        this.idCita = idCita;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.motivo = motivo;
        this.estado = estado;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        Integer oldIdCita = this.idCita;
        this.idCita = idCita;
        changeSupport.firePropertyChange("idCita", oldIdCita, idCita);
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        Date oldFechaCita = this.fechaCita;
        this.fechaCita = fechaCita;
        changeSupport.firePropertyChange("fechaCita", oldFechaCita, fechaCita);
    }

    public Date getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(Date horaCita) {
        Date oldHoraCita = this.horaCita;
        this.horaCita = horaCita;
        changeSupport.firePropertyChange("horaCita", oldHoraCita, horaCita);
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        String oldMotivo = this.motivo;
        this.motivo = motivo;
        changeSupport.firePropertyChange("motivo", oldMotivo, motivo);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        String oldEstado = this.estado;
        this.estado = estado;
        changeSupport.firePropertyChange("estado", oldEstado, estado);
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        Medico oldMedico = this.medico;
        this.medico = medico;
        changeSupport.firePropertyChange("medico", oldMedico, medico);
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        Paciente oldPaciente = this.paciente;
        this.paciente = paciente;
        changeSupport.firePropertyChange("paciente", oldPaciente, paciente);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCita != null ? idCita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citamedica)) {
            return false;
        }
        Citamedica other = (Citamedica) object;
        if ((this.idCita == null && other.idCita != null) || (this.idCita != null && !this.idCita.equals(other.idCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Citamedica[ idCita=" + idCita + " ]";
    }

    @XmlTransient
    public Collection<Consultamedica> getConsultamedicaCollection() {
        return consultamedicaCollection;
    }

    public void setConsultamedicaCollection(Collection<Consultamedica> consultamedicaCollection) {
        this.consultamedicaCollection = consultamedicaCollection;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
