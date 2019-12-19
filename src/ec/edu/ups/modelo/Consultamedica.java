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

public class Consultamedica implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idConsulta;

    private String sintomas;

    private String diagnostico;

    private String presionArterial;

    private String frecuenciaCardiaca;

    private String frecuenciaRespiratoria;

    private String temperaturaCorporal;

    private String peso;

    private String talla;

    private int turno;

    private int cita;
    
    private Citamedica citamedica;


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
