/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.io.Serializable;


/**
 *
 * @author USER
 */

public class Medicamentoreceta implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idMedRes;
    private Medicamento idMedicamento;
    private Receta idReceta;

    public Medicamentoreceta() {
    }

    public Medicamentoreceta(Integer idMedRes) {
        this.idMedRes = idMedRes;
    }

    public Integer getIdMedRes() {
        return idMedRes;
    }

    public void setIdMedRes(Integer idMedRes) {
        this.idMedRes = idMedRes;
    }

    public Medicamento getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Medicamento idMedicamento) {
        this.idMedicamento = idMedicamento;
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
        hash += (idMedRes != null ? idMedRes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicamentoreceta)) {
            return false;
        }
        Medicamentoreceta other = (Medicamentoreceta) object;
        if ((this.idMedRes == null && other.idMedRes != null) || (this.idMedRes != null && !this.idMedRes.equals(other.idMedRes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Medicamentoreceta[ idMedRes=" + idMedRes + " ]";
    }
    
}
