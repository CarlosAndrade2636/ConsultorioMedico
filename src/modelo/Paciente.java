/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p")
    , @NamedQuery(name = "Paciente.findByIdPaciente", query = "SELECT p FROM Paciente p WHERE p.idPaciente = :idPaciente")
    , @NamedQuery(name = "Paciente.findByTipoSangre", query = "SELECT p FROM Paciente p WHERE p.tipoSangre = :tipoSangre")
    , @NamedQuery(name = "Paciente.findByLugarNac", query = "SELECT p FROM Paciente p WHERE p.lugarNac = :lugarNac")
    , @NamedQuery(name = "Paciente.findByEtnia", query = "SELECT p FROM Paciente p WHERE p.etnia = :etnia")})
public class Paciente implements Serializable {

    @JoinColumn(name = "usuarioPaciente", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario usuarioPaciente;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPaciente")
    private Integer idPaciente;
    @Basic(optional = false)
    @Column(name = "tipoSangre")
    private String tipoSangre;
    @Basic(optional = false)
    @Column(name = "lugarNac")
    private String lugarNac;
    @Basic(optional = false)
    @Column(name = "etnia")
    private String etnia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private Collection<Citamedica> citamedicaCollection;
    @JoinColumn(name = "personaPaciente", referencedColumnName = "idPerosona")
    @ManyToOne(optional = false)
    private Persona personaPaciente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private Collection<Turno> turnoCollection;

    public Paciente() {
    }

    public Paciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Paciente(Integer idPaciente, String tipoSangre, String lugarNac, String etnia) {
        this.idPaciente = idPaciente;
        this.tipoSangre = tipoSangre;
        this.lugarNac = lugarNac;
        this.etnia = etnia;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getLugarNac() {
        return lugarNac;
    }

    public void setLugarNac(String lugarNac) {
        this.lugarNac = lugarNac;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    @XmlTransient
    public Collection<Citamedica> getCitamedicaCollection() {
        return citamedicaCollection;
    }

    public void setCitamedicaCollection(Collection<Citamedica> citamedicaCollection) {
        this.citamedicaCollection = citamedicaCollection;
    }

    public Persona getPersonaPaciente() {
        return personaPaciente;
    }

    public void setPersonaPaciente(Persona personaPaciente) {
        this.personaPaciente = personaPaciente;
    }

    @XmlTransient
    public Collection<Turno> getTurnoCollection() {
        return turnoCollection;
    }

    public void setTurnoCollection(Collection<Turno> turnoCollection) {
        this.turnoCollection = turnoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaciente != null ? idPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.idPaciente == null && other.idPaciente != null) || (this.idPaciente != null && !this.idPaciente.equals(other.idPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Paciente[ idPaciente=" + idPaciente + " ]";
    }

    public Usuario getUsuarioPaciente() {
        return usuarioPaciente;
    }

    public void setUsuarioPaciente(Usuario usuarioPaciente) {
        this.usuarioPaciente = usuarioPaciente;
    }
    
}
