/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Usuario;
import java.sql.ResultSet;
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
        System.out.println("ejecutarSentencia");
        String sql = "";
        boolean expResult = false;
        boolean result = ConexionDB.ejecutarSentencia(sql);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ejecutarConsulta method, of class ConexionDB.
     */
    @Test
    public void testEjecutarConsulta() {
        System.out.println("ejecutarConsulta");
        String sql = "";
        ResultSet expResult = null;
        ResultSet result = ConexionDB.ejecutarConsulta(sql);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuarioSesion method, of class ConexionDB.
     */
    @Test
    public void testGetUsuarioSesion() {
        System.out.println("getUsuarioSesion");
        Usuario expResult = null;
        Usuario result = ConexionDB.getUsuarioSesion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsuarioSesion method, of class ConexionDB.
     */
    @Test
    public void testSetUsuarioSesion() {
        System.out.println("setUsuarioSesion");
        Usuario usuarioSesion = null;
        ConexionDB.setUsuarioSesion(usuarioSesion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarID method, of class ConexionDB.
     */
    @Test
    public void testGenerarID() {
        System.out.println("generarID");
        String sql = "";
        int expResult = 0;
        int result = ConexionDB.generarID(sql);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
