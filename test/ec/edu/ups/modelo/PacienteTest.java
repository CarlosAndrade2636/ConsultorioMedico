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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipoSangre method, of class Paciente.
     */
    @Test
    public void testGetTipoSangre() {
        System.out.println("getTipoSangre");
        Paciente instance = new Paciente();
        String expResult = "";
        String result = instance.getTipoSangre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLugarNac method, of class Paciente.
     */
    @Test
    public void testGetLugarNac() {
        System.out.println("getLugarNac");
        Paciente instance = new Paciente();
        String expResult = "";
        String result = instance.getLugarNac();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEtnia method, of class Paciente.
     */
    @Test
    public void testGetEtnia() {
        System.out.println("getEtnia");
        Paciente instance = new Paciente();
        String expResult = "";
        String result = instance.getEtnia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Paciente.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Paciente instance = new Paciente();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
