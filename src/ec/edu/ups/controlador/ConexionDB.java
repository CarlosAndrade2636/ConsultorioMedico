package ec.edu.ups.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import ec.edu.ups.modelo.Usuario;

/**
 *
 * @author jessica
 * 
 * 
 */

public class ConexionDB {
    
    private static Usuario usuarioSesion;
     // Librería de MySQL
  
     private static Connection conexion = null;
 
    private static void conectar() {
    
        
         conexion = null;
  
      if (conexion == null) {
         try {
            Class.forName("com.mysql.jdbc.Driver");
           conexion = DriverManager.getConnection("jdbc:mysql://localhost/consultorio", "root", "");
          System.out.println("conectado ");
         } catch (SQLException ex) {
          System.out.println("Error de conexion : " + ex.getMessage());
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
      

   }
   
    }
    
       private static void  desconectar() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException ex) {
                System.out.println("Erro al desconctar " + ex.getMessage());
            }
        }
    }
    
    public static boolean ejecutarSentencia(String sql) {
     
         try {
            conectar();
            Statement sta = (Statement) conexion.createStatement();
            sta.executeUpdate(sql);
            desconectar();
        } catch (SQLException ex) {
            System.out.println("Error de sql : " + ex.getMessage());
        }
        return false;
    }
    
    public static ResultSet ejecutarConsulta(String sql) {
        ResultSet resultado = null;
       conectar();
        try {
            Statement sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
            resultado.setFetchDirection(ResultSet.FETCH_FORWARD);
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error consulta: " + e.getMessage());
        }
        return resultado;
    }

    public static Usuario getUsuarioSesion() {
        return usuarioSesion;
    }

    public static void setUsuarioSesion(Usuario usuarioSesion) {
        ConexionDB.usuarioSesion = usuarioSesion;
    }
    
    public static int generarID(String sql) {
        int id = 0;
        try {
            ResultSet resultado = ConexionDB.ejecutarConsulta(sql);
            if (resultado.next()) {
                id = resultado.getInt("max") + 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return id;
    }
}