/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Usuario;
import java.util.List;
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
public class ControladorUsuarioTest {
    
    public ControladorUsuarioTest() {
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
     * Test of generarID method, of class ControladorUsuario.
     */
    @Test
    public void testGenerarID() {
        System.out.println("generarID");
        int expResult = 0;
        int result = ControladorUsuario.generarID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregar method, of class ControladorUsuario.
     */
    @Test
    public void testAgregar() {
        System.out.println("agregar");
        Usuario usuario = null;
        boolean expResult = false;
        boolean result = ControladorUsuario.agregar(usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificar method, of class ControladorUsuario.
     */
    @Test
    public void testModificar() {
        System.out.println("modificar");
        String nombre = "";
        Usuario usuario = null;
        boolean expResult = false;
        boolean result = ControladorUsuario.modificar(nombre, usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class ControladorUsuario.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        String nombreUsuario = "";
        Usuario expResult = null;
        Usuario result = ControladorUsuario.buscar(nombreUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminar method, of class ControladorUsuario.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        String nombreUsuario = "";
        boolean expResult = false;
        boolean result = ControladorUsuario.eliminar(nombreUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listar method, of class ControladorUsuario.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        List<Usuario> expResult = null;
        List<Usuario> result = ControladorUsuario.listar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
