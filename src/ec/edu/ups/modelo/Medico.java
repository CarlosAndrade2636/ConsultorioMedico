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
public class Medico extends Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idMedico;
    private String correoMedico;

    private String especialidadMedico;



    private Persona personaMedico;

    private Usuario usuarioMedico;

    public Medico() {
    }

    public Medico(Integer idMedico) {
        this.idMedico = idMedico;
    }
 public Medico(Integer idPerosona, String cedula, String nombre, String apellido, String sexo, String fecha, String direccion, String telefono, 
              String correoMedico, String especialidadMedico,
                  Usuario usuarioMedico) {
         super (idPerosona,cedula,nombre,apellido,sexo,fecha,direccion,telefono);
      
        this.correoMedico = correoMedico;
        this.especialidadMedico = especialidadMedico;
        this.usuarioMedico = usuarioMedico;
    }
 
    
    public Medico(Integer idMedico, String correoMedico, String especialidadMedico) {
        this.idMedico = idMedico;
        this.correoMedico = correoMedico;
        this.especialidadMedico = especialidadMedico;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public String getCorreoMedico() {
        return correoMedico;
    }

    public void setCorreoMedico(String correoMedico) {
        this.correoMedico = correoMedico;
    }

    public String getEspecialidadMedico() {
        return especialidadMedico;
    }

    public void setEspecialidadMedico(String especialidadMedico) {
        this.especialidadMedico = especialidadMedico;
    }

 
    public Persona getPersonaMedico() {
        return personaMedico;
    }

    public void setPersonaMedico(Persona personaMedico) {
        this.personaMedico = personaMedico;
    }

    public Usuario getUsuarioMedico() {
        return usuarioMedico;
    }

    public void setUsuarioMedico(Usuario usuarioMedico) {
        this.usuarioMedico = usuarioMedico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedico != null ? idMedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.idMedico == null && other.idMedico != null) || (this.idMedico != null && !this.idMedico.equals(other.idMedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Medico[ idMedico=" + idMedico + " ]";
    }
    
}
