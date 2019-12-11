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
@Table(name = "medicamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicamento.findAll", query = "SELECT m FROM Medicamento m")
    , @NamedQuery(name = "Medicamento.findByIdMedicina", query = "SELECT m FROM Medicamento m WHERE m.idMedicina = :idMedicina")
    , @NamedQuery(name = "Medicamento.findByNombreMedicina", query = "SELECT m FROM Medicamento m WHERE m.nombreMedicina = :nombreMedicina")
    , @NamedQuery(name = "Medicamento.findByTipoMedicina", query = "SELECT m FROM Medicamento m WHERE m.tipoMedicina = :tipoMedicina")
    , @NamedQuery(name = "Medicamento.findByFechaCaducidad", query = "SELECT m FROM Medicamento m WHERE m.fechaCaducidad = :fechaCaducidad")
    , @NamedQuery(name = "Medicamento.findByDosis", query = "SELECT m FROM Medicamento m WHERE m.dosis = :dosis")})
public class Medicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMedicina")
    private Integer idMedicina;
    @Basic(optional = false)
    @Column(name = "nombreMedicina")
    private String nombreMedicina;
    @Basic(optional = false)
    @Column(name = "tipoMedicina")
    private String tipoMedicina;
    @Basic(optional = false)
    @Column(name = "fechaCaducidad")
    @Temporal(TemporalType.DATE)
    private Date fechaCaducidad;
    @Basic(optional = false)
    @Column(name = "dosis")
    private double dosis;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMedicamento")
    private Collection<Medicamentoreceta> medicamentorecetaCollection;

    public Medicamento() {
    }

    public Medicamento(Integer idMedicina) {
        this.idMedicina = idMedicina;
    }

    public Medicamento(Integer idMedicina, String nombreMedicina, String tipoMedicina, Date fechaCaducidad, double dosis) {
        this.idMedicina = idMedicina;
        this.nombreMedicina = nombreMedicina;
        this.tipoMedicina = tipoMedicina;
        this.fechaCaducidad = fechaCaducidad;
        this.dosis = dosis;
    }

    public Integer getIdMedicina() {
        return idMedicina;
    }

    public void setIdMedicina(Integer idMedicina) {
        this.idMedicina = idMedicina;
    }

    public String getNombreMedicina() {
        return nombreMedicina;
    }

    public void setNombreMedicina(String nombreMedicina) {
        this.nombreMedicina = nombreMedicina;
    }

    public String getTipoMedicina() {
        return tipoMedicina;
    }

    public void setTipoMedicina(String tipoMedicina) {
        this.tipoMedicina = tipoMedicina;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public double getDosis() {
        return dosis;
    }

    public void setDosis(double dosis) {
        this.dosis = dosis;
    }

    @XmlTransient
    public Collection<Medicamentoreceta> getMedicamentorecetaCollection() {
        return medicamentorecetaCollection;
    }

    public void setMedicamentorecetaCollection(Collection<Medicamentoreceta> medicamentorecetaCollection) {
        this.medicamentorecetaCollection = medicamentorecetaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedicina != null ? idMedicina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicamento)) {
            return false;
        }
        Medicamento other = (Medicamento) object;
        if ((this.idMedicina == null && other.idMedicina != null) || (this.idMedicina != null && !this.idMedicina.equals(other.idMedicina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Medicamento[ idMedicina=" + idMedicina + " ]";
    }
    
}
