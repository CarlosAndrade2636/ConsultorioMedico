/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Medico;
import ec.edu.ups.modelo.Paciente;
import ec.edu.ups.modelo.Persona;
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
public class ControladorPersonaTest {
    
    public ControladorPersonaTest() {
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
     * Test of generarID method, of class ControladorPersona.
     */
    @Test
    public void testGenerarID() {
        System.out.println("generarID");
        int expResult = 4;
        int result = ControladorPersona.generarID();
        assertEquals(expResult, result);
       
    }

 

    /**
     * Test of modificar method, of class ControladorPersona.
     */
    @Test
    public void testModificar() {
        System.out.println("modificar");
        Persona persona = new Persona(1,"juan","lopez");
        String tipo = "";
        boolean expResult = false;
        boolean result = ControladorPersona.modificar(persona, tipo);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of buscar method, of class ControladorPersona.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        String cedula = "0203452215";
        String tipo = "o+";
        Persona expResult = null;
        Persona result = ControladorPersona.buscar(cedula, tipo);
        assertEquals(expResult, result);
    }

    /**
     * Test of eliminar method, of class ControladorPersona.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        String cedula = "0203452215";
        String tipo = "o+";
        boolean expResult = false;
        boolean result = ControladorPersona.eliminar(cedula, tipo);
        assertEquals(expResult, result);
       
    }


    
}
