/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Consultamedica;
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
public class ControladorConsultaTest {
    
    public ControladorConsultaTest() {
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
     * Test of generarID method, of class ControladorConsulta.
     */
    @Test
    public void testGenerarID() {
        System.out.println("generarID");
        int expResult = 0;
        int result = ControladorConsulta.generarID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregar method, of class ControladorConsulta.
     */
    @Test
    public void testAgregar() {
        System.out.println("agregar");
        Consultamedica consulta = null;
        boolean expResult = false;
        boolean result = ControladorConsulta.agregar(consulta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificar method, of class ControladorConsulta.
     */
    @Test
    public void testModificar() {
        System.out.println("modificar");
        Consultamedica consulta = null;
        boolean expResult = false;
        boolean result = ControladorConsulta.modificar(consulta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class ControladorConsulta.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        int id = 0;
        Consultamedica expResult = null;
        Consultamedica result = ControladorConsulta.buscar(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listar method, of class ControladorConsulta.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        List<Consultamedica> expResult = null;
        List<Consultamedica> result = ControladorConsulta.listar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarConsultasEspecificas method, of class ControladorConsulta.
     */
    @Test
    public void testListarConsultasEspecificas() {
        System.out.println("listarConsultasEspecificas");
        String cedulaPaciente = "";
        List<Consultamedica> expResult = null;
        List<Consultamedica> result = ControladorConsulta.listarConsultasEspecificas(cedulaPaciente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminar method, of class ControladorConsulta.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        int id = 0;
        boolean expResult = false;
        boolean result = ControladorConsulta.eliminar(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
