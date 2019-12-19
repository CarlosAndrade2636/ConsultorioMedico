/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Citamedica;
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
public class ControladorCitaTest {
    
    public ControladorCitaTest() {
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
     * Test of generarID method, of class ControladorCita.
     */
    @Test
    public void testGenerarID() {
        System.out.println("generarID");
        int expResult = 0;
        int result = ControladorCita.generarID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregar method, of class ControladorCita.
     */
    @Test
    public void testAgregar() {
        System.out.println("agregar");
        Citamedica cita = null;
        boolean expResult = false;
        boolean result = ControladorCita.agregar(cita);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificar method, of class ControladorCita.
     */
    @Test
    public void testModificar() {
        System.out.println("modificar");
        Citamedica cita = null;
        boolean expResult = false;
        boolean result = ControladorCita.modificar(cita);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminar method, of class ControladorCita.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        int id = 0;
        boolean expResult = false;
        boolean result = ControladorCita.eliminar(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class ControladorCita.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        int id = 0;
        Citamedica expResult = null;
        Citamedica result = ControladorCita.buscar(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listar method, of class ControladorCita.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        List<Citamedica> expResult = null;
        List<Citamedica> result = ControladorCita.listar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarCitasNoAsistidas method, of class ControladorCita.
     */
    @Test
    public void testListarCitasNoAsistidas() {
        System.out.println("listarCitasNoAsistidas");
        String cedulaPaciente = "";
        List<Citamedica> expResult = null;
        List<Citamedica> result = ControladorCita.listarCitasNoAsistidas(cedulaPaciente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
