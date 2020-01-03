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

public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
   
    private Integer idPerosona;

    private String cedula;

    private String nombre;

    private String apellido;

    private String sexo;

    private Date fecha;

    private String direccion;

    private String telefono;

   

    public Persona() {
    }

    public Persona(Integer idPerosona) {
        this.idPerosona = idPerosona;
    }
   public Persona(Integer idPerosona, String cedula, String nombre) {
        this.idPerosona = idPerosona;
        this.cedula = cedula;
        this.nombre = nombre;
   }
   
    public Persona(Integer idPerosona, String cedula, String nombre, String apellido, String sexo, Date fecha, String direccion, String telefono) {
        this.idPerosona = idPerosona;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.fecha = fecha;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Integer getIdPerosona() {
        return idPerosona;
    }

    public void setIdPerosona(Integer idPerosona) {
        this.idPerosona = idPerosona;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerosona != null ? idPerosona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPerosona == null && other.idPerosona != null) || (this.idPerosona != null && !this.idPerosona.equals(other.idPerosona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Persona[ idPerosona=" + idPerosona + " ]";
    }
    
}
