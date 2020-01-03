/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author USER
 */
public class ConexionDBTest {
    
    public ConexionDBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of ejecutarSentencia method, of class ConexionDB.
     */
    @Test
    public void testEjecutarSentencia() {
      System.out.println("testEjecutarSentencia");
        String sql = "UPDATE `paciente` SET `etnia`='Ecuatoriana' WHERE 1;";
        boolean expResult = false;
        boolean result = ConexionDB.ejecutarSentencia(sql);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of ejecutarConsulta method, of class ConexionDB.
     */
    @Test
    public void testEjecutarConsulta() {
         System.out.println("testEjecutarConsulta");
        String sql = "SELECT `tipoSangre` FROM `paciente` WHERE `idPaciente`= 2;";
        String expResult = "orh+";
        ResultSet result = ConexionDB.ejecutarConsulta(sql);
        try {
            if (result.next()) {
                
                String    tiposangre = result.getString("tipoSangre");
                 assertEquals(expResult, tiposangre);
                  System.out.println( "expResult  "+expResult+" result "+ tiposangre);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDBTest.class.getName()).log(Level.SEVERE, null, ex);
        }
     
       
    }



    /**
     * Test of generarID method, of class ConexionDB.
     */
    @Test
    public void testGenerarID() {
        System.out.println("generarID");
        String sql = "select max(idPaciente) from paciente;";
        int expResult = 3;
        int result = ConexionDB.generarID(sql);
        assertEquals(expResult, result);
         System.out.println( "expResult  "+expResult+" result "+ result);
    }
    
}
