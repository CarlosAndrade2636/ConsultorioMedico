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
public class CitamedicaTest {
    
    public CitamedicaTest() {
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
     * Test of getIdCita method, of class Citamedica.
     */
    @Test
    public void testGetIdCita() {
        System.out.println("getIdCita");
        Citamedica instance = new Citamedica();
        Integer expResult = null;
        Integer result = instance.getIdCita();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setIdCita method, of class Citamedica.
     */
    @Test
    public void testSetIdCita() {
        System.out.println("setIdCita");
        Integer idCita = null;
        Citamedica instance = new Citamedica();
        instance.setIdCita(idCita);
        
    }

    /**
     * Test of getFechaCita method, of class Citamedica.
     */
    @Test
    public void testGetFechaCita() {
        System.out.println("getFechaCita");
        Citamedica instance = new Citamedica();
        Date expResult = null;
        Date result = instance.getFechaCita();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setFechaCita method, of class Citamedica.
     */
    @Test
    public void testSetFechaCita() {
        System.out.println("setFechaCita");
        Date fechaCita = null;
        Citamedica instance = new Citamedica();
        instance.setFechaCita(fechaCita);
      
    }

    /**
     * Test of getHoraCita method, of class Citamedica.
     */
    @Test
    public void testGetHoraCita() {
        System.out.println("getHoraCita");
        Citamedica instance = new Citamedica();
        Date expResult = null;
        Date result = instance.getHoraCita();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setHoraCita method, of class Citamedica.
     */
    @Test
    public void testSetHoraCita() {
        System.out.println("setHoraCita");
        Date horaCita = null;
        Citamedica instance = new Citamedica();
        instance.setHoraCita(horaCita);
     
    }

    

    /**
     * Test of setMotivo method, of class Citamedica.
     */
    @Test
    public void testSetMotivo() {
        System.out.println("setMotivo");
        String motivo = "";
        Citamedica instance = new Citamedica();
        instance.setMotivo(motivo);
       
    }


    /**
     * Test of setEstado method, of class Citamedica.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        String estado = "";
        Citamedica instance = new Citamedica();
        instance.setEstado(estado);
       
    }

    /**
     * Test of getMedico method, of class Citamedica.
     */
    @Test
    public void testGetMedico() {
        System.out.println("getMedico");
        Citamedica instance = new Citamedica();
        Medico expResult = null;
        Medico result = instance.getMedico();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setMedico method, of class Citamedica.
     */
    @Test
    public void testSetMedico() {
        System.out.println("setMedico");
        Medico medico = null;
        Citamedica instance = new Citamedica();
        instance.setMedico(medico);
       
    }

    /**
     * Test of getPaciente method, of class Citamedica.
     */
    @Test
    public void testGetPaciente() {
        System.out.println("getPaciente");
        Citamedica instance = new Citamedica();
        Paciente expResult = null;
        Paciente result = instance.getPaciente();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of setPaciente method, of class Citamedica.
     */
    @Test
    public void testSetPaciente() {
        System.out.println("setPaciente");
        Paciente paciente = null;
        Citamedica instance = new Citamedica();
        instance.setPaciente(paciente);
  
    }

    /**
     * Test of hashCode method, of class Citamedica.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Citamedica instance = new Citamedica();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class Citamedica.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Citamedica instance = new Citamedica();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
 
    }

    
    
}
