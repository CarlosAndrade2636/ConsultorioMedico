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

public class Paciente implements Serializable {


    private Usuario usuarioPaciente;

    private static final long serialVersionUID = 1L;

    private Integer idPaciente;

    private String tipoSangre;

    private String lugarNac;

    private String etnia;

    private Persona personaPaciente;

  
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

    

    public Persona getPersonaPaciente() {
        return personaPaciente;
    }

    public void setPersonaPaciente(Persona personaPaciente) {
        this.personaPaciente = personaPaciente;
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
