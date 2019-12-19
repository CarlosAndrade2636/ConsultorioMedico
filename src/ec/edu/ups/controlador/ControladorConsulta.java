package ec.edu.ups.controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ec.edu.ups.modelo.Citamedica;
import ec.edu.ups.modelo.Consultamedica;
/**
 * Metodo para agregar consulta
 *
 * @author jessica
 */
public class ControladorConsulta {

    public static int generarID() {
        String sql = "select max(id) from consultas";
        return ConexionDB.generarID(sql);
    }
    
    public static boolean agregar(Consultamedica consulta) {
        if (buscar(consulta.getIdConsulta()) == null) {
            String sql = "insert into consultas values("
                + consulta.getIdConsulta() + ", '"
                + consulta.getSintomas() + "', '"
                + consulta.getDiagnostico() + "', "
                + consulta.getPresionArterial() + ", "
                + consulta.getFrecuenciaCardiaca() + ", "
                + consulta.getFrecuenciaRespiratoria() + ", "
                + consulta.getTemperaturaCorporal() + ", "
                + consulta.getPeso() + ", "   
                + consulta.getTalla()+ "', '"
                
                + consulta.getTurno()+ "', '"
                + consulta.getCita()+ ");";
            ConexionDB.ejecutarSentencia(sql);
            return true;
        }
        return false;
    }

    public static boolean modificar(Consultamedica consulta) {
        if (buscar(consulta.getIdConsulta()) != null){
            String sql = "update consultas set "
                 + consulta.getIdConsulta() + ", '"
                + consulta.getSintomas() + "', '"
                + consulta.getDiagnostico() + "', "
                + consulta.getPresionArterial() + ", "
                + consulta.getFrecuenciaCardiaca() + ", "
                + consulta.getFrecuenciaRespiratoria() + ", "
                + consulta.getTemperaturaCorporal() + ", "
                + consulta.getPeso() + ", "   
                + consulta.getTalla()+ "', '"
                
                + consulta.getTurno()+ "', '"
                + consulta.getCita()
                    + "where id = " + consulta.getIdConsulta();
            ConexionDB.ejecutarSentencia(sql);
            return true;
        }
        return false;
    }

    public static Consultamedica buscar(int id) {
        Consultamedica consulta = null;
        String sql = "select * from consultas where id = " + id;
        try {
            ResultSet resultado = ConexionDB.ejecutarConsulta(sql);
            if (resultado.next()) {
                int idconsulta = resultado.getInt("idConsulta");
                String sintomas = resultado.getString("sintomas");
                String diagnostico = resultado.getString("diagnostico");
                String pa = resultado.getString("presionArterial ");
                String fc = resultado.getString("frecuenciaCardiaca ");
                String fr = resultado.getString("frecuenciaRespiratoria ");
                String tc = resultado.getString("temperaturaCorporal ");
                String peso = resultado.getString("peso");
                String talla = resultado.getString("talla ");
               int turno = resultado.getInt("turno");
                int citamedica = resultado.getInt("cita");
                Citamedica cita = ControladorCita.buscar(citamedica);
                consulta = new Consultamedica(idconsulta, sintomas, diagnostico,
                          pa, fc, fr,tc, peso, talla, turno, citamedica);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return consulta;
    }
    
    public static List<Consultamedica> listar() {
        List<Consultamedica> lista = new ArrayList();
        String sql = "select * from consultas";
        try {
            ResultSet resultado = ConexionDB.ejecutarConsulta(sql);
            while (resultado.next()) {
                int idconsulta = resultado.getInt("id");
                
                    String sintomas = resultado.getString("sintomas");
                String diagnostico = resultado.getString("diagnostico");
                String pa = resultado.getString("presionArterial ");
                String fc = resultado.getString("frecuenciaCardiaca ");
                String fr = resultado.getString("frecuenciaRespiratoria ");
                String tc = resultado.getString("temperaturaCorporal ");
                String peso = resultado.getString("peso");
                String talla = resultado.getString("talla ");
                String receta = resultado.getString("receta");
                 int turno = resultado.getInt("turno");
                int idcita = resultado.getInt("cita");
                Citamedica cita = ControladorCita.buscar(idcita);
                lista.add(new Consultamedica(idconsulta, sintomas, diagnostico,
                          pa, fc, fr,tc, peso, talla, turno, idcita));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }

    public static List<Consultamedica> listarConsultasEspecificas(String cedulaPaciente) {
        List<Consultamedica> listaFiltrada = new ArrayList<>();
        List<Consultamedica> listaGeneral = listar();
        for (int i = 0; i < listaGeneral.size(); i++) {
            Consultamedica consulta = listaGeneral.get(i);
             int idcita = consulta.getCita();
                Citamedica cita = ControladorCita.buscar(idcita);
          //  Citamedica cita = consulta.getCita();
            if (cita.getPaciente().getCedula().equals(cedulaPaciente)) {
                listaFiltrada.add(consulta);
            }
        }
        return listaFiltrada;
    }

    public static boolean eliminar(int id) {
        if (buscar(id) != null) {
            String sql = "delete from consultas where id = " + id + "";
            ConexionDB.ejecutarSentencia(sql);
            return true;
        }
        return false;
    }
}