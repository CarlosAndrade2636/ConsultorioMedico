/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USER
 */

public class Receta implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idReceta;

    private String frecuenciaUso;

    private String descripcion;

    private int idMedREs;

    private Collection<Consulrece> consulreceCollection;

    private Collection<Medicamentoreceta> medicamentorecetaCollection;

    public Receta() {
    }

    public Receta(Integer idReceta) {
        this.idReceta = idReceta;
    }

    public Receta(Integer idReceta, String frecuenciaUso, String descripcion, int idMedREs) {
        this.idReceta = idReceta;
        this.frecuenciaUso = frecuenciaUso;
        this.descripcion = descripcion;
        this.idMedREs = idMedREs;
    }

    public Integer getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Integer idReceta) {
        this.idReceta = idReceta;
    }

    public String getFrecuenciaUso() {
        return frecuenciaUso;
    }

    public void setFrecuenciaUso(String frecuenciaUso) {
        this.frecuenciaUso = frecuenciaUso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdMedREs() {
        return idMedREs;
    }

    public void setIdMedREs(int idMedREs) {
        this.idMedREs = idMedREs;
    }

    @XmlTransient
    public Collection<Consulrece> getConsulreceCollection() {
        return consulreceCollection;
    }

    public void setConsulreceCollection(Collection<Consulrece> consulreceCollection) {
        this.consulreceCollection = consulreceCollection;
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
        hash += (idReceta != null ? idReceta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receta)) {
            return false;
        }
        Receta other = (Receta) object;
        if ((this.idReceta == null && other.idReceta != null) || (this.idReceta != null && !this.idReceta.equals(other.idReceta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Receta[ idReceta=" + idReceta + " ]";
    }
    
}
