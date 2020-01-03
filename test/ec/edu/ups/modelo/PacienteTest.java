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
public class PacienteTest {
    
    public PacienteTest() {
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
     * Test of getIdPaciente method, of class Paciente.
     */
    @Test
    public void testGetIdPaciente() {
        System.out.println("getIdPaciente");
        Paciente instance = new Paciente();
        Integer expResult = null;
        Integer result = instance.getIdPaciente();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setIdPaciente method, of class Paciente.
     */
    @Test
    public void testSetIdPaciente() {
        System.out.println("setIdPaciente");
        Integer idPaciente = null;
        Paciente instance = new Paciente();
        instance.setIdPaciente(idPaciente);
        
    }


    /**
     * Test of setTipoSangre method, of class Paciente.
     */
    @Test
    public void testSetTipoSangre() {
        System.out.println("setTipoSangre");
        String tipoSangre = "";
        Paciente instance = new Paciente();
        instance.setTipoSangre(tipoSangre);
      
    }


    /**
     * Test of setLugarNac method, of class Paciente.
     */
    @Test
    public void testSetLugarNac() {
        System.out.println("setLugarNac");
        String lugarNac = "";
        Paciente instance = new Paciente();
        instance.setLugarNac(lugarNac);
 
    }

    

    /**
     * Test of setEtnia method, of class Paciente.
     */
    @Test
    public void testSetEtnia() {
        System.out.println("setEtnia");
        String etnia = "";
        Paciente instance = new Paciente();
        instance.setEtnia(etnia);

    }

    /**
     * Test of getPersonaPaciente method, of class Paciente.
     */
    @Test
    public void testGetPersonaPaciente() {
        System.out.println("getPersonaPaciente");
        Paciente instance = new Paciente();
        Persona expResult = null;
        Persona result = instance.getPersonaPaciente();
        assertEquals(expResult, result);

    }

    /**
     * Test of setPersonaPaciente method, of class Paciente.
     */
    @Test
    public void testSetPersonaPaciente() {
        System.out.println("setPersonaPaciente");
        Persona personaPaciente = null;
        Paciente instance = new Paciente();
        instance.setPersonaPaciente(personaPaciente);

    }

    /**
     * Test of hashCode method, of class Paciente.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Paciente instance = new Paciente();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class Paciente.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Paciente instance = new Paciente();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);

    }

  

    /**
     * Test of getUsuarioPaciente method, of class Paciente.
     */
    @Test
    public void testGetUsuarioPaciente() {
        System.out.println("getUsuarioPaciente");
        Paciente instance = new Paciente();
        Usuario expResult = null;
        Usuario result = instance.getUsuarioPaciente();
        assertEquals(expResult, result);

    }

    /**
     * Test of setUsuarioPaciente method, of class Paciente.
     */
    @Test
    public void testSetUsuarioPaciente() {
        System.out.println("setUsuarioPaciente");
        Usuario usuarioPaciente = null;
        Paciente instance = new Paciente();
        instance.setUsuarioPaciente(usuarioPaciente);

    }
    
}
