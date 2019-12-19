/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ec.edu.ups.modelo.Citamedica;
import ec.edu.ups.modelo.Medico;
import ec.edu.ups.modelo.Paciente;

/**
 *
 * @author jessica
 */
public class ControladorCita {

    public static int generarID() {
        String sql = "select max(id) from citas";
        return ConexionDB.generarID(sql);
    }

    public static boolean agregar(Citamedica cita) {
        if (buscar(cita.getIdCita()) == null) {
            Date fecha = cita.getFechaCita();
            long cadenaFecha = fecha.getTime();
            String sql = "insert into citas values("
                + cita.getFechaCita() + ", '"
                + cadenaFecha + "', '"
                + cita.getHoraCita() + "', '"
                    + cita.getMotivo()+ "', '"
                + cita.getEstado() + "', '"
                + cita.getMedico().getCedula()+ "', '"
                + cita.getPaciente().getCedula()+ "')";
            ConexionDB.ejecutarSentencia(sql);
            System.out.println("insertando...");
            return true;
        }
        return false;
    }

    public static boolean modificar(Citamedica cita) {
        if(buscar(cita.getIdCita()) != null) {
            String sql = "update citas set "
                + "fecha = '" + cita.getFechaCita().getTime() + "',"
                + "hora = '" + cita.getHoraCita() + "', "
                + "motivo = '" + cita.getMotivo() + "', "
                + " estado = '" + cita.getEstado()+ "', "
                + " idmedico = '" + cita.getMedico().getCedula()  + "', "
                + "idpaciente = '" + cita.getPaciente().getCedula() + "' "
                + "where id = " + cita.getIdCita();
            ConexionDB.ejecutarSentencia(sql);
            System.out.println("Modificando...");
            return true;
        }
        return false;
    }

    public static boolean eliminar(int id) {
        if (buscar(id) != null) {
            String sql = "delete from citas where id = '" + id + "'";
            ConexionDB.ejecutarSentencia(sql);
            return true;
        }
        return false;
    }

    public static Citamedica buscar(int id) {
        Citamedica cita = null;
        String sql = "select * from citas where id = '" + id + "'";
        try {
            ResultSet resultado = ConexionDB.ejecutarConsulta(sql);
            if (resultado.next()) {
                String fechaNoFormateada = resultado.getString("fecha");
             String hora = resultado.getString("horaCita");
                String motivo = resultado.getString("motivo");
                String estado = resultado.getString("estado");
                String idMedico = resultado.getString("Medico");
                String idPaciente = resultado.getString("Paciente");
                
                Medico medico = (Medico) ControladorPersona.buscar(idMedico, "medico");
                Paciente paciente = (Paciente) ControladorPersona.buscar(idPaciente, "paciente");
                Date fechaFormateada = new Date(Long.valueOf(fechaNoFormateada));
                Date horaFormatedara = new Date(Long.valueOf(hora));
                cita = new Citamedica(id, fechaFormateada, horaFormatedara, motivo, estado, medico, paciente);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } 
        return cita;
    }

    public static List<Citamedica> listar() {
        List<Citamedica> lista = new ArrayList();
        String sql = "select * from citas";
        try {
            ResultSet resultado = ConexionDB.ejecutarConsulta(sql);
            while (resultado.next()) {
                int id = resultado.getInt("idCita");
                String fechaNoFormateada = resultado.getString("fechaCita");
                String hora = resultado.getString("horaCita");
                String motivo = resultado.getString("motivo");
                String estado = resultado.getString("estado");
                String idMedico = resultado.getString("medico");
                String idPaciente = resultado.getString("paciente");
                Medico medico = (Medico) ControladorPersona.buscar(idMedico, "medico");
                Paciente paciente = (Paciente) ControladorPersona.buscar(idPaciente, "paciente");
                Date fechaFormateada = new Date(Long.valueOf(fechaNoFormateada));
                 Date horaFormatedara = new Date(Long.valueOf(hora));
                lista.add(new Citamedica(id, fechaFormateada, horaFormatedara, motivo, estado, medico, paciente));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }
    
    public static List<Citamedica> listarCitasNoAsistidas(String cedulaPaciente) {
        List<Citamedica> listaFiltrada = new ArrayList();
        String sql = "select * from citas where idPaciente = '" + cedulaPaciente + "'"
                   + "and estado = 'No asistido'";
        try {
            ResultSet resultado = ConexionDB.ejecutarConsulta(sql);
            while (resultado.next()) {
                int id = resultado.getInt("idCita");
                String fechaNoFormateada = resultado.getString("fechaCita");
                String hora = resultado.getString("horaCita");
                String motivo = resultado.getString("motivo");
                String estado = resultado.getString("estado");
                String idMedico = resultado.getString("medico");
                String idPaciente = resultado.getString("paciente");
                Medico medico = (Medico) ControladorPersona.buscar(idMedico, "medico");
                Paciente paciente = (Paciente) ControladorPersona.buscar(idPaciente, "paciente");
                Date fechaFormateada = new Date(Long.valueOf(fechaNoFormateada));
                 Date horaFormatedara = new Date(Long.valueOf(hora));
                listaFiltrada.add(new Citamedica(id, fechaFormateada, horaFormatedara, motivo, estado, medico, paciente));
             }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return listaFiltrada;
    }
}