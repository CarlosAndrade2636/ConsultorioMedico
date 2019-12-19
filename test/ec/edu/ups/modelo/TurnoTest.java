/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Collection;
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
public class TurnoTest {
    
    public TurnoTest() {
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
     * Test of getIdTurno method, of class Turno.
     */
    @Test
    public void testGetIdTurno() {
        System.out.println("getIdTurno");
        Turno instance = new Turno();
        Integer expResult = null;
        Integer result = instance.getIdTurno();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdTurno method, of class Turno.
     */
    @Test
    public void testSetIdTurno() {
        System.out.println("setIdTurno");
        Integer idTurno = null;
        Turno instance = new Turno();
        instance.setIdTurno(idTurno);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaTurno method, of class Turno.
     */
    @Test
    public void testGetFechaTurno() {
        System.out.println("getFechaTurno");
        Turno instance = new Turno();
        Date expResult = null;
        Date result = instance.getFechaTurno();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaTurno method, of class Turno.
     */
    @Test
    public void testSetFechaTurno() {
        System.out.println("setFechaTurno");
        Date fechaTurno = null;
        Turno instance = new Turno();
        instance.setFechaTurno(fechaTurno);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHoraTurno method, of class Turno.
     */
    @Test
    public void testGetHoraTurno() {
        System.out.println("getHoraTurno");
        Turno instance = new Turno();
        Date expResult = null;
        Date result = instance.getHoraTurno();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHoraTurno method, of class Turno.
     */
    @Test
    public void testSetHoraTurno() {
        System.out.println("setHoraTurno");
        Date horaTurno = null;
        Turno instance = new Turno();
        instance.setHoraTurno(horaTurno);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValor method, of class Turno.
     */
    @Test
    public void testGetValor() {
        System.out.println("getValor");
        Turno instance = new Turno();
        double expResult = 0.0;
        double result = instance.getValor();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValor method, of class Turno.
     */
    @Test
    public void testSetValor() {
        System.out.println("setValor");
        double valor = 0.0;
        Turno instance = new Turno();
        instance.setValor(valor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPaciente method, of class Turno.
     */
    @Test
    public void testGetPaciente() {
        System.out.println("getPaciente");
        Turno instance = new Turno();
        Paciente expResult = null;
        Paciente result = instance.getPaciente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPaciente method, of class Turno.
     */
    @Test
    public void testSetPaciente() {
        System.out.println("setPaciente");
        Paciente paciente = null;
        Turno instance = new Turno();
        instance.setPaciente(paciente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Turno.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Turno instance = new Turno();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Turno.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Turno instance = new Turno();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Turno.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Turno instance = new Turno();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConsultamedicaCollection method, of class Turno.
     */
    @Test
    public void testGetConsultamedicaCollection() {
        System.out.println("getConsultamedicaCollection");
        Turno instance = new Turno();
        Collection<Consultamedica> expResult = null;
        Collection<Consultamedica> result = instance.getConsultamedicaCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setConsultamedicaCollection method, of class Turno.
     */
    @Test
    public void testSetConsultamedicaCollection() {
        System.out.println("setConsultamedicaCollection");
        Collection<Consultamedica> consultamedicaCollection = null;
        Turno instance = new Turno();
        instance.setConsultamedicaCollection(consultamedicaCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
