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
public class ConsulreceTest {
    
    public ConsulreceTest() {
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
     * Test of getIdConsuRece method, of class Consulrece.
     */
    @Test
    public void testGetIdConsuRece() {
        System.out.println("getIdConsuRece");
        Consulrece instance = new Consulrece();
        Integer expResult = null;
        Integer result = instance.getIdConsuRece();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setIdConsuRece method, of class Consulrece.
     */
    @Test
    public void testSetIdConsuRece() {
        System.out.println("setIdConsuRece");
        Integer idConsuRece = null;
        Consulrece instance = new Consulrece();
        instance.setIdConsuRece(idConsuRece);
      
    }

    /**
     * Test of getIdConsulta method, of class Consulrece.
     */
    @Test
    public void testGetIdConsulta() {
        System.out.println("getIdConsulta");
        Consulrece instance = new Consulrece();
        Consultamedica expResult = null;
        Consultamedica result = instance.getIdConsulta();
        assertEquals(expResult, result);
     
    }

    /**
     * Test of setIdConsulta method, of class Consulrece.
     */
    @Test
    public void testSetIdConsulta() {
        System.out.println("setIdConsulta");
        Consultamedica idConsulta = null;
        Consulrece instance = new Consulrece();
        instance.setIdConsulta(idConsulta);

    }

    /**
     * Test of getIdReceta method, of class Consulrece.
     */
    @Test
    public void testGetIdReceta() {
        System.out.println("getIdReceta");
        Consulrece instance = new Consulrece();
        Receta expResult = null;
        Receta result = instance.getIdReceta();
        assertEquals(expResult, result);
     
    }

    /**
     * Test of setIdReceta method, of class Consulrece.
     */
    @Test
    public void testSetIdReceta() {
        System.out.println("setIdReceta");
        Receta idReceta = null;
        Consulrece instance = new Consulrece();
        instance.setIdReceta(idReceta);

    }

    /**
     * Test of hashCode method, of class Consulrece.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Consulrece instance = new Consulrece();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
     
    }

    /**
     * Test of equals method, of class Consulrece.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Consulrece instance = new Consulrece();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
   
    }

}
