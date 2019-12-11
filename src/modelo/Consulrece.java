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
@Table(name = "consulrece")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consulrece.findAll", query = "SELECT c FROM Consulrece c")
    , @NamedQuery(name = "Consulrece.findByIdConsuRece", query = "SELECT c FROM Consulrece c WHERE c.idConsuRece = :idConsuRece")})
public class Consulrece implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idConsuRece")
    private Integer idConsuRece;
    @JoinColumn(name = "idConsulta", referencedColumnName = "idConsulta")
    @ManyToOne(optional = false)
    private Consultamedica idConsulta;
    @JoinColumn(name = "idReceta", referencedColumnName = "idReceta")
    @ManyToOne(optional = false)
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
