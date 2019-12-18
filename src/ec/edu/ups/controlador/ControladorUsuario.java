package ec.edu.ups.controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;

/**
 *
 * @author jessica
 */
public class ControladorUsuario {
    
    public static int generarID() {
        String sql = "select max(id) from usuarios";
        return ConexionDB.generarID(sql);
    }
    
    public static boolean agregar(Usuario usuario) {
        if (buscar(usuario.getNombre()) == null) {
            String sql = "insert into usuarios values(" +
                      usuario.getId() + ", '" + 
                      usuario.getNombre() + "', '" +
                      usuario.getClave() + "', '" +
                      usuario.getRol() + "')";
            ConexionDB.ejecutarSentencia(sql);
            return true;
        }
        return false;
    }
    
    public static boolean modificar(String nombre, Usuario usuario) {
        if (buscar(nombre) != null) {
            String sql = "update usuarios set " + 
                         "nombre = '" + usuario.getNombre() + "'," +
                         "clave = '" + usuario.getClave() + "'," +
                         "rol = '" + usuario.getRol() +"' " +  
                         "where id = " + usuario.getId();
            ConexionDB.ejecutarSentencia(sql);
            return true;
        }
        return false;
    } 
    
    public static Usuario buscar(String nombreUsuario) {
        Usuario usuario = null;
        String sql = "select * from usuarios where nombre = '" + nombreUsuario + "'";
        try {
            ResultSet resultado = ConexionDB.ejecutarConsulta(sql);
            if (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String clave = resultado.getString("clave");
                String rol = resultado.getString("rol");
                usuario = new Usuario(id, nombre, clave, rol);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return usuario;
    }
    
    public static boolean eliminar(String nombreUsuario) {
        if (buscar(nombreUsuario) != null) {
            String sql = "delete from usuarios where nombre = '" + nombreUsuario + "'";
            ConexionDB.ejecutarSentencia(sql);
            return true;
        }
        return false;
    }
    
    public static List<Usuario> listar() {
        List<Usuario> lista = new ArrayList();
        String sql = "select * from usuarios";
        try {
            ResultSet resultado = ConexionDB.ejecutarConsulta(sql);
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String clave = resultado.getString("clave");
                String rol = resultado.getString("rol");
                lista.add(new Usuario(id, nombre, clave, rol));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }
}