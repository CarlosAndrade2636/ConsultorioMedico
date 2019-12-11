/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "medicamentoreceta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicamentoreceta.findAll", query = "SELECT m FROM Medicamentoreceta m")
    , @NamedQuery(name = "Medicamentoreceta.findByIdMedRes", query = "SELECT m FROM Medicamentoreceta m WHERE m.idMedRes = :idMedRes")})
public class Medicamentoreceta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMedRes")
    private Integer idMedRes;
    @JoinColumn(name = "idMedicamento", referencedColumnName = "idMedicina")
    @ManyToOne(optional = false)
    private Medicamento idMedicamento;
    @JoinColumn(name = "idReceta", referencedColumnName = "idReceta")
    @ManyToOne(optional = false)
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
