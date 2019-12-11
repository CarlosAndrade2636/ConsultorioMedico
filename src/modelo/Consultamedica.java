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
@Table(name = "consultamedica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultamedica.findAll", query = "SELECT c FROM Consultamedica c")
    , @NamedQuery(name = "Consultamedica.findByIdConsulta", query = "SELECT c FROM Consultamedica c WHERE c.idConsulta = :idConsulta")
    , @NamedQuery(name = "Consultamedica.findBySintomas", query = "SELECT c FROM Consultamedica c WHERE c.sintomas = :sintomas")
    , @NamedQuery(name = "Consultamedica.findByDiagnostico", query = "SELECT c FROM Consultamedica c WHERE c.diagnostico = :diagnostico")
    , @NamedQuery(name = "Consultamedica.findByPresionArterial", query = "SELECT c FROM Consultamedica c WHERE c.presionArterial = :presionArterial")
    , @NamedQuery(name = "Consultamedica.findByFrecuenciaCardiaca", query = "SELECT c FROM Consultamedica c WHERE c.frecuenciaCardiaca = :frecuenciaCardiaca")
    , @NamedQuery(name = "Consultamedica.findByFrecuenciaRespiratoria", query = "SELECT c FROM Consultamedica c WHERE c.frecuenciaRespiratoria = :frecuenciaRespiratoria")
    , @NamedQuery(name = "Consultamedica.findByTemperaturaCorporal", query = "SELECT c FROM Consultamedica c WHERE c.temperaturaCorporal = :temperaturaCorporal")
    , @NamedQuery(name = "Consultamedica.findByPeso", query = "SELECT c FROM Consultamedica c WHERE c.peso = :peso")
    , @NamedQuery(name = "Consultamedica.findByTalla", query = "SELECT c FROM Consultamedica c WHERE c.talla = :talla")
    , @NamedQuery(name = "Consultamedica.findByTurno", query = "SELECT c FROM Consultamedica c WHERE c.turno = :turno")
    , @NamedQuery(name = "Consultamedica.findByCita", query = "SELECT c FROM Consultamedica c WHERE c.cita = :cita")})
public class Consultamedica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idConsulta")
    private Integer idConsulta;
    @Basic(optional = false)
    @Column(name = "sintomas")
    private String sintomas;
    @Basic(optional = false)
    @Column(name = "diagnostico")
    private String diagnostico;
    @Basic(optional = false)
    @Column(name = "presionArterial")
    private String presionArterial;
    @Basic(optional = false)
    @Column(name = "frecuenciaCardiaca")
    private String frecuenciaCardiaca;
    @Basic(optional = false)
    @Column(name = "frecuenciaRespiratoria")
    private String frecuenciaRespiratoria;
    @Basic(optional = false)
    @Column(name = "temperaturaCorporal")
    private String temperaturaCorporal;
    @Basic(optional = false)
    @Column(name = "peso")
    private String peso;
    @Basic(optional = false)
    @Column(name = "talla")
    private String talla;
    @Basic(optional = false)
    @Column(name = "turno")
    private int turno;
    @Basic(optional = false)
    @Column(name = "cita")
    private int cita;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConsulta")
    private Collection<Consulrece> consulreceCollection;

    public Consultamedica() {
    }

    public Consultamedica(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Consultamedica(Integer idConsulta, String sintomas, String diagnostico, String presionArterial, String frecuenciaCardiaca, String frecuenciaRespiratoria, String temperaturaCorporal, String peso, String talla, int turno, int cita) {
        this.idConsulta = idConsulta;
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
        this.presionArterial = presionArterial;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
        this.temperaturaCorporal = temperaturaCorporal;
        this.peso = peso;
        this.talla = talla;
        this.turno = turno;
        this.cita = cita;
    }

    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getPresionArterial() {
        return presionArterial;
    }

    public void setPresionArterial(String presionArterial) {
        this.presionArterial = presionArterial;
    }

    public String getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(String frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public String getFrecuenciaRespiratoria() {
        return frecuenciaRespiratoria;
    }

    public void setFrecuenciaRespiratoria(String frecuenciaRespiratoria) {
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
    }

    public String getTemperaturaCorporal() {
        return temperaturaCorporal;
    }

    public void setTemperaturaCorporal(String temperaturaCorporal) {
        this.temperaturaCorporal = temperaturaCorporal;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getCita() {
        return cita;
    }

    public void setCita(int cita) {
        this.cita = cita;
    }

    @XmlTransient
    public Collection<Consulrece> getConsulreceCollection() {
        return consulreceCollection;
    }

    public void setConsulreceCollection(Collection<Consulrece> consulreceCollection) {
        this.consulreceCollection = consulreceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConsulta != null ? idConsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultamedica)) {
            return false;
        }
        Consultamedica other = (Consultamedica) object;
        if ((this.idConsulta == null && other.idConsulta != null) || (this.idConsulta != null && !this.idConsulta.equals(other.idConsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Consultamedica[ idConsulta=" + idConsulta + " ]";
    }
    
}
