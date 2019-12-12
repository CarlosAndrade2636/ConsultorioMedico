/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "citamedica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Citamedica.findAll", query = "SELECT c FROM Citamedica c")
    , @NamedQuery(name = "Citamedica.findByIdCita", query = "SELECT c FROM Citamedica c WHERE c.idCita = :idCita")
    , @NamedQuery(name = "Citamedica.findByFechaCita", query = "SELECT c FROM Citamedica c WHERE c.fechaCita = :fechaCita")
    , @NamedQuery(name = "Citamedica.findByHoraCita", query = "SELECT c FROM Citamedica c WHERE c.horaCita = :horaCita")
    , @NamedQuery(name = "Citamedica.findByMotivo", query = "SELECT c FROM Citamedica c WHERE c.motivo = :motivo")
    , @NamedQuery(name = "Citamedica.findByEstado", query = "SELECT c FROM Citamedica c WHERE c.estado = :estado")})
public class Citamedica implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cita")
    private Collection<Consultamedica> consultamedicaCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCita")
    private Integer idCita;
    @Basic(optional = false)
    @Column(name = "fechaCita")
    @Temporal(TemporalType.DATE)
    private Date fechaCita;
    @Basic(optional = false)
    @Column(name = "horaCita")
    @Temporal(TemporalType.TIME)
    private Date horaCita;
    @Basic(optional = false)
    @Column(name = "motivo")
    private String motivo;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "medico", referencedColumnName = "idMedico")
    @ManyToOne(optional = false)
    private Medico medico;
    @JoinColumn(name = "paciente", referencedColumnName = "idPaciente")
    @ManyToOne(optional = false)
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
        this.idCita = idCita;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Date getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(Date horaCita) {
        this.horaCita = horaCita;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
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
    
}
