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
        int expResult = 1;
        int result = ControladorConsulta.generarID();
        assertEquals(expResult, result);
     
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

  
    
}
