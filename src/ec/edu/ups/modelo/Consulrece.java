/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER
 */

public class Consulrece implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer idConsuRece;
  
    private Consultamedica idConsulta;
  
    private Receta idReceta;

    public Consulrece() {
    }

    public Consulrece(Integer idConsuRece) {
        this.idConsuRece = idConsuRece;
    }

    public Integer getIdConsuRece() {
        return idConsuRece;
    }

    public void setIdConsuRece(Integer idConsuRece) {
        this.idConsuRece = idConsuRece;
    }

    public Consultamedica getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Consultamedica idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Receta getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Receta idReceta) {
        this.idReceta = idReceta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConsuRece != null ? idConsuRece.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consulrece)) {
            return false;
        }
        Consulrece other = (Consulrece) object;
        if ((this.idConsuRece == null && other.idConsuRece != null) || (this.idConsuRece != null && !this.idConsuRece.equals(other.idConsuRece))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Consulrece[ idConsuRece=" + idConsuRece + " ]";
    }
    
}
