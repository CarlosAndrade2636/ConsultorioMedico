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
public class MedicoTest {
    
    public MedicoTest() {
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
     * Test of getIdMedico method, of class Medico.
     */
    @Test
    public void testGetIdMedico() {
        System.out.println("getIdMedico");
        Medico instance = new Medico();
        Integer expResult = null;
        Integer result = instance.getIdMedico();
        assertEquals(expResult, result);

    }

    /**
     * Test of setIdMedico method, of class Medico.
     */
    @Test
    public void testSetIdMedico() {
        System.out.println("setIdMedico");
        Integer idMedico = null;
        Medico instance = new Medico();
        instance.setIdMedico(idMedico);
       
    }

   
    /**
     * Test of setCorreoMedico method, of class Medico.
     */
    @Test
    public void testSetCorreoMedico() {
        System.out.println("setCorreoMedico");
        String correoMedico = "";
        Medico instance = new Medico();
        instance.setCorreoMedico(correoMedico);
        
    }


    /**
     * Test of setEspecialidadMedico method, of class Medico.
     */
    @Test
    public void testSetEspecialidadMedico() {
        System.out.println("setEspecialidadMedico");
        String especialidadMedico = "";
        Medico instance = new Medico();
        instance.setEspecialidadMedico(especialidadMedico);
       
    }

    /**
     * Test of getPersonaMedico method, of class Medico.
     */
    @Test
    public void testGetPersonaMedico() {
        System.out.println("getPersonaMedico");
        Medico instance = new Medico();
        Persona expResult = null;
        Persona result = instance.getPersonaMedico();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of setPersonaMedico method, of class Medico.
     */
    @Test
    public void testSetPersonaMedico() {
        System.out.println("setPersonaMedico");
        Persona personaMedico = null;
        Medico instance = new Medico();
        instance.setPersonaMedico(personaMedico);
       
    }

    /**
     * Test of getUsuarioMedico method, of class Medico.
     */
    @Test
    public void testGetUsuarioMedico() {
        System.out.println("getUsuarioMedico");
        Medico instance = new Medico();
        Usuario expResult = null;
        Usuario result = instance.getUsuarioMedico();
        assertEquals(expResult, result);
     
    }

    /**
     * Test of setUsuarioMedico method, of class Medico.
     */
    @Test
    public void testSetUsuarioMedico() {
        System.out.println("setUsuarioMedico");
        Usuario usuarioMedico = null;
        Medico instance = new Medico();
        instance.setUsuarioMedico(usuarioMedico);

    }

    /**
     * Test of hashCode method, of class Medico.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Medico instance = new Medico();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of equals method, of class Medico.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Medico instance = new Medico();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        
    }

}
