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
public class MedicamentorecetaTest {
    
    public MedicamentorecetaTest() {
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
     * Test of getIdMedRes method, of class Medicamentoreceta.
     */
    @Test
    public void testGetIdMedRes() {
        System.out.println("getIdMedRes");
        Medicamentoreceta instance = new Medicamentoreceta();
        Integer expResult = null;
        Integer result = instance.getIdMedRes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdMedRes method, of class Medicamentoreceta.
     */
    @Test
    public void testSetIdMedRes() {
        System.out.println("setIdMedRes");
        Integer idMedRes = null;
        Medicamentoreceta instance = new Medicamentoreceta();
        instance.setIdMedRes(idMedRes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdMedicamento method, of class Medicamentoreceta.
     */
    @Test
    public void testGetIdMedicamento() {
        System.out.println("getIdMedicamento");
        Medicamentoreceta instance = new Medicamentoreceta();
        Medicamento expResult = null;
        Medicamento result = instance.getIdMedicamento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdMedicamento method, of class Medicamentoreceta.
     */
    @Test
    public void testSetIdMedicamento() {
        System.out.println("setIdMedicamento");
        Medicamento idMedicamento = null;
        Medicamentoreceta instance = new Medicamentoreceta();
        instance.setIdMedicamento(idMedicamento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdReceta method, of class Medicamentoreceta.
     */
    @Test
    public void testGetIdReceta() {
        System.out.println("getIdReceta");
        Medicamentoreceta instance = new Medicamentoreceta();
        Receta expResult = null;
        Receta result = instance.getIdReceta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdReceta method, of class Medicamentoreceta.
     */
    @Test
    public void testSetIdReceta() {
        System.out.println("setIdReceta");
        Receta idReceta = null;
        Medicamentoreceta instance = new Medicamentoreceta();
        instance.setIdReceta(idReceta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Medicamentoreceta.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Medicamentoreceta instance = new Medicamentoreceta();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Medicamentoreceta.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Medicamentoreceta instance = new Medicamentoreceta();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Medicamentoreceta.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Medicamentoreceta instance = new Medicamentoreceta();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
