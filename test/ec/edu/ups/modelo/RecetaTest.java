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
public class RecetaTest {
    
    public RecetaTest() {
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
     * Test of getIdReceta method, of class Receta.
     */
    @Test
    public void testGetIdReceta() {
        System.out.println("getIdReceta");
        Receta instance = new Receta();
        Integer expResult = null;
        Integer result = instance.getIdReceta();
        assertEquals(expResult, result);
     
    }

    /**
     * Test of setIdReceta method, of class Receta.
     */
    @Test
    public void testSetIdReceta() {
        System.out.println("setIdReceta");
        Integer idReceta = null;
        Receta instance = new Receta();
        instance.setIdReceta(idReceta);
       
    }

    

    /**
     * Test of setFrecuenciaUso method, of class Receta.
     */
    @Test
    public void testSetFrecuenciaUso() {
        System.out.println("setFrecuenciaUso");
        String frecuenciaUso = "";
        Receta instance = new Receta();
        instance.setFrecuenciaUso(frecuenciaUso);
   
    }

  

    /**
     * Test of setDescripcion method, of class Receta.
     */
    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "";
        Receta instance = new Receta();
        instance.setDescripcion(descripcion);
 
    }

    /**
     * Test of getIdMedREs method, of class Receta.
     */
    @Test
    public void testGetIdMedREs() {
        System.out.println("getIdMedREs");
        Receta instance = new Receta();
        int expResult = 0;
        int result = instance.getIdMedREs();
        assertEquals(expResult, result);
        }

    /**
     * Test of setIdMedREs method, of class Receta.
     */
    @Test
    public void testSetIdMedREs() {
        System.out.println("setIdMedREs");
        int idMedREs = 0;
        Receta instance = new Receta();
        instance.setIdMedREs(idMedREs);

    }

    /**
     * Test of hashCode method, of class Receta.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Receta instance = new Receta();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class Receta.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Receta instance = new Receta();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
     
    }

  
    
}
