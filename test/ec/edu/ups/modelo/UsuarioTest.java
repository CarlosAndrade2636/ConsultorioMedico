/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

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
public class UsuarioTest {
    
    public UsuarioTest() {
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
     * Test of getIdUsuario method, of class Usuario.
     */
    @Test
    public void testGetIdUsuario() {
        System.out.println("getIdUsuario");
        Usuario instance = new Usuario();
        Integer expResult = null;
        Integer result = instance.getIdUsuario();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setIdUsuario method, of class Usuario.
     */
    @Test
    public void testSetIdUsuario() {
        System.out.println("setIdUsuario");
        Integer idUsuario = null;
        Usuario instance = new Usuario();
        instance.setIdUsuario(idUsuario);
        
    }



    /**
     * Test of setNombreUsuario method, of class Usuario.
     */
    @Test
    public void testSetNombreUsuario() {
        System.out.println("setNombreUsuario");
        String nombreUsuario = "";
        Usuario instance = new Usuario();
        instance.setNombreUsuario(nombreUsuario);
      
    }


    /**
     * Test of setPassUsuario method, of class Usuario.
     */
    @Test
    public void testSetPassUsuario() {
        System.out.println("setPassUsuario");
        String passUsuario = "";
        Usuario instance = new Usuario();
        instance.setPassUsuario(passUsuario);
  
    }

    /**
     * Test of getRolUsuario method, of class Usuario.
     */
    @Test
    public void testGetRolUsuario() {
        System.out.println("getRolUsuario");
        Usuario instance = new Usuario();
        String expResult = "";
        String result = instance.getRolUsuario();
    
    }

    /**
     * Test of setRolUsuario method, of class Usuario.
     */
    @Test
    public void testSetRolUsuario() {
        System.out.println("setRolUsuario");
        String rolUsuario = "";
        Usuario instance = new Usuario();
        instance.setRolUsuario(rolUsuario);
       
    }

    /**
     * Test of hashCode method, of class Usuario.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Usuario instance = new Usuario();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
      ;
    }

    /**
     * Test of equals method, of class Usuario.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Usuario instance = new Usuario();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        
    }

  
    
}
