/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Date;
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
public class MedicamentoTest {
    
    public MedicamentoTest() {
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
     * Test of getIdMedicina method, of class Medicamento.
     */
    @Test
    public void testGetIdMedicina() {
        System.out.println("getIdMedicina");
        Medicamento instance = new Medicamento();
        Integer expResult = null;
        Integer result = instance.getIdMedicina();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setIdMedicina method, of class Medicamento.
     */
    @Test
    public void testSetIdMedicina() {
        System.out.println("setIdMedicina");
        Integer idMedicina = null;
        Medicamento instance = new Medicamento();
        instance.setIdMedicina(idMedicina);
     
    }

    

    /**
     * Test of setNombreMedicina method, of class Medicamento.
     */
    @Test
    public void testSetNombreMedicina() {
        System.out.println("setNombreMedicina");
        String nombreMedicina = "";
        Medicamento instance = new Medicamento();
        instance.setNombreMedicina(nombreMedicina);
       
    }


    /**
     * Test of setTipoMedicina method, of class Medicamento.
     */
    @Test
    public void testSetTipoMedicina() {
        System.out.println("setTipoMedicina");
        String tipoMedicina = "";
        Medicamento instance = new Medicamento();
        instance.setTipoMedicina(tipoMedicina);
       
    }

    /**
     * Test of getFechaCaducidad method, of class Medicamento.
     */
    @Test
    public void testGetFechaCaducidad() {
        System.out.println("getFechaCaducidad");
        Medicamento instance = new Medicamento();
        Date expResult = null;
        Date result = instance.getFechaCaducidad();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of setFechaCaducidad method, of class Medicamento.
     */
    @Test
    public void testSetFechaCaducidad() {
        System.out.println("setFechaCaducidad");
        Date fechaCaducidad = null;
        Medicamento instance = new Medicamento();
        instance.setFechaCaducidad(fechaCaducidad);
      
    }

    /**
     * Test of getDosis method, of class Medicamento.
     */
    @Test
    public void testGetDosis() {
        System.out.println("getDosis");
        Medicamento instance = new Medicamento();
        double expResult = 0.0;
        double result = instance.getDosis();
        assertEquals(expResult, result, 0.0);
       
    }

    /**
     * Test of setDosis method, of class Medicamento.
     */
    @Test
    public void testSetDosis() {
        System.out.println("setDosis");
        double dosis = 0.0;
        Medicamento instance = new Medicamento();
        instance.setDosis(dosis);
      
    }

    /**
     * Test of hashCode method, of class Medicamento.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Medicamento instance = new Medicamento();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of equals method, of class Medicamento.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Medicamento instance = new Medicamento();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
       
    }

 
    
}
