package ec.edu.ups.controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ec.edu.ups.modelo.Medico;
import ec.edu.ups.modelo.Paciente;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Usuario;

/**
 *
 * @author jessica
 */


public class ControladorPersona {
      
    
  
    public static int generarID() {
        String sql = "select max(id) from personas";
        return ConexionDB.generarID(sql);
    }
    
    public static boolean agregar(Persona persona, String tipo) {
        if(buscar(persona.getCedula(), tipo) == null) {
            String sql = "insert into personas values(" + 
                          persona.getIdPerosona() + ",'" +
                          persona.getCedula() + "', '" +
                          persona.getNombre() + "', '" +
                          persona.getApellido() + "')";
            ConexionDB.ejecutarSentencia(sql);
            if (tipo.equals("medico")) {
                Medico medico = (Medico) persona;
                sql = "insert into medicos values(" +
                      medico.getId() + ",'" +
                      medico.getDireccion() + "', '" +
                      medico.getEmail() + "', '" +
                      medico.getEspecialidad() + "'," +
                      medico.getUsuario().getId() + ")";
                ConexionDB.ejecutarSentencia(sql);
            } else if (tipo.equals("paciente")) {
                Paciente paciente = (Paciente) persona;
                SimpleDateFormat formato = new SimpleDateFormat("dd-MM-YYYY");
                String fechaFormateada = formato.format(paciente.getFechaNacimiento());
                sql = "insert into pacientes values(" +
                      paciente.getId() + ", '" + 
                      String.valueOf(paciente.getSexo()) + "', '" +
                      fechaFormateada + "', '" +
                      paciente.getTipoSangre() + "', '" +
                      paciente.getProcedencia() + "', '" + 
                      paciente.getEtnia() + "', '" +
                      paciente.getInstruccion() + "')";
                ConexionDB.ejecutarSentencia(sql);
            }
            return true;
        }
        return false;
    }
    
    public static boolean modificar(Persona persona, String tipo) {
        if(buscar(persona.getCedula(), tipo) != null) {
            String sql = "update personas set " + 
                         "cedula = '" + persona.getCedula() + "'," +
                         "nombre = '" + persona.getNombre() + "'," +
                         "apellido = '" + persona.getApellido() + "' " +
                         "where id = " + persona.getId() ;
            ConexionDB.ejecutarSentencia(sql);
            if (tipo.equals("medico")) {
                Medico medico = (Medico) persona;
                sql = "update medicos set " +
                      "direccion = '" + medico.getDireccion() + "'," +
                      "email = '" + medico.getEmail() + "'," +
                      "especialidad = '" + medico.getEspecialidad() + "'," +
                      "idUsuario = '" + medico.getUsuario().getId() + 
                      "where id = '" + medico.getId();
                ConexionDB.ejecutarSentencia(sql);
            } else if (tipo.equals("paciente")) {
                Paciente paciente = (Paciente) persona;
                SimpleDateFormat formato = new SimpleDateFormat("dd-MM-YYYY");
                String fechaFormateada = formato.format(paciente.getFechaNacimiento());
                sql = "update pacientes set " +
                      "sexo = '" + String.valueOf(paciente.getSexo()) + "'," +
                      "fechaNacimiento = '" + fechaFormateada + "'," +
                      "tipoSangre = '" + paciente.getTipoSangre() + "'," +
                      "procedencia = '" + paciente.getProcedencia() + "'," + 
                      "etnia = '" + paciente.getEtnia() + "'," +
                      "instruccion = '" + paciente.getInstruccion() + "' " +
                      "where id = " + paciente.getId();
                ConexionDB.ejecutarSentencia(sql);
            }
            return true;
        }
        return false;
    }
    
    public static Persona buscar(String cedula, String tipo) {
        Persona persona = null;
        String sql = "select * from personas where cedula = '" + cedula + "'";
        try {
            ResultSet resultadoPersona = ConexionDB.ejecutarConsulta(sql);
            if (resultadoPersona.next()) {
                int id = resultadoPersona.getInt("id");
                String nombre = resultadoPersona.getString("nombre");
                String apellido = resultadoPersona.getString("apellido");
                if (tipo.equals("medico")) {
                    sql = "select * from medicos where id = " + id;
                    ResultSet resultadoMedico = ConexionDB.ejecutarConsulta(sql);
                    if (!resultadoMedico.next()) return null;
                    String direccion = resultadoMedico.getString("direccion");
                    String email = resultadoMedico.getString("email");
                    String especialidad = resultadoMedico.getString("especialidad");
                    Usuario usuario = ControladorUsuario.buscar(cedula);
                    persona = new Medico(id, cedula, nombre, apellido, direccion, email, especialidad, usuario);
                } else if (tipo.equals("paciente")){
                    sql = "select * from pacientes where id = " + id;
                    ResultSet resultadoPaciente = ConexionDB.ejecutarConsulta(sql);
                    if (!resultadoPaciente.next()) return null;
                    char sexo = resultadoPaciente.getString("sexo").charAt(0);
                    Date fecha = resultadoPaciente.getDate("fechanacimiento");
                    String tipoSangre = resultadoPaciente.getString("tiposangre");
                    String etnia = resultadoPaciente.getString("etnia");
                    String procedencia = resultadoPaciente.getString("procedencia");
                    String instruccion = resultadoPaciente.getString("instruccion");
                    persona = new Paciente(id, cedula, nombre, apellido, sexo, fecha,
                                           tipoSangre, procedencia, etnia, instruccion);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error buscar: " + e.getMessage());
            e.printStackTrace();
        } 
        return persona;
    }
    
    public static boolean eliminar(String cedula, String tipo) {
        Persona persona = buscar(cedula, tipo);
        if (persona != null) {
            String sqlA = "delete from personas where cedula = '" + cedula + "'";
            String sqlB = "";
            if (tipo.equals("medico")) {
                sqlB = "delete from medicos where id = " + persona.getId();
                ControladorUsuario.eliminar(cedula);
            } else {
                sqlB = "delete from pacientes where id = " + persona.getId();
            }
            ConexionDB.ejecutarSentencia(sqlA);
            ConexionDB.ejecutarConsulta(sqlB);
            return true;
        }
        return false;
    }
    
    public static List<Medico> listarMedicos() {
        List<Medico> lista = new ArrayList();
        try {
            String sql = "select cedula from personas";;
            ResultSet resultado = ConexionDB.ejecutarConsulta(sql);
            for(int i = 1; resultado.next(); i++) {
                Medico medico = (Medico) buscar(resultado.getString("cedula"), "medico");
                if (medico != null) {
                    lista.add(medico);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }
    
    public static List<Paciente> listarPacientes() {
        List<Paciente> lista = new ArrayList();
        try {
            String sql = "select cedula from personas";;
            ResultSet resultado = ConexionDB.ejecutarConsulta(sql);
            for(int i = 1; resultado.next(); i++) {
                Paciente paciente = (Paciente) buscar(resultado.getString("cedula"), "paciente");
                if (paciente != null) {
                    lista.add(paciente);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }
}