/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USER
 */

public class Medicamento implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idMedicina;

    private String nombreMedicina;

    private String tipoMedicina;

    private Date fechaCaducidad;

    private double dosis;

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
