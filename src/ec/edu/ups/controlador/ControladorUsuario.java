package ec.edu.ups.controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ec.edu.ups.modelo.Usuario;

/**
 *
 * @author jessica
 */
public class ControladorUsuario {

    public static int generarID() {
        String sql = "select max(idUsuario) from usuario";
        return ConexionDB.generarID(sql);
    }

    public static boolean agregar(Usuario usuario) {
       
            String sql = "insert into usuario values("
                    + usuario.getIdUsuario() + ", '"
                    + usuario.getNombreUsuario() + "', '"
                    + usuario.getPassUsuario() + "', '"
                    + usuario.getRolUsuario() + "')";
            
            ConexionDB.ejecutarSentencia(sql);
           
            return true;
            
        
     
    }

    public static boolean modificar(String nombre, Usuario usuario) {
        if (buscar(nombre) != null) {
            String sql = "update usuario set "
                    + "nombre = '" + usuario.getNombreUsuario() + "',"
                    + "clave = '" + usuario.getPassUsuario() + "',"
                    + "rol = '" + usuario.getRolUsuario() + "' "
                    + "where id = " + usuario.getIdUsuario();
            ConexionDB.ejecutarSentencia(sql);
            return true;
        }
        return false;
    }

    public static Usuario buscar(String nombreUsuario) {
        Usuario usuario = null;
        String sql = "select * from usuario where nombreUsuario = '" + nombreUsuario + "'";
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
