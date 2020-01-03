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
public class ConsultamedicaTest {
    
    public ConsultamedicaTest() {
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
     * Test of getIdConsulta method, of class Consultamedica.
     */
    @Test
    public void testGetIdConsulta() {
        System.out.println("getIdConsulta");
        Consultamedica instance = new Consultamedica();
        Integer expResult = null;
        Integer result = instance.getIdConsulta();
        assertEquals(expResult, result);
   
    }

    /**
     * Test of setIdConsulta method, of class Consultamedica.
     */
    @Test
    public void testSetIdConsulta() {
        System.out.println("setIdConsulta");
        Integer idConsulta = null;
        Consultamedica instance = new Consultamedica();
        instance.setIdConsulta(idConsulta);

    }

    /**
     * Test of getSintomas method, of class Consultamedica.
     */
    @Test
    public void testGetSintomas() {
        System.out.println("getSintomas");
        Consultamedica instance = new Consultamedica();
        String expResult = "";
        String result = instance.getSintomas();
        assertEquals(expResult, result);

    }

    /**
     * Test of setSintomas method, of class Consultamedica.
     */
    @Test
    public void testSetSintomas() {
        System.out.println("setSintomas");
        String sintomas = "";
        Consultamedica instance = new Consultamedica();
        instance.setSintomas(sintomas);

    }

    /**
     * Test of getDiagnostico method, of class Consultamedica.
     */
    @Test
    public void testGetDiagnostico() {
        System.out.println("getDiagnostico");
        Consultamedica instance = new Consultamedica();
        String expResult = "";
        String result = instance.getDiagnostico();
        assertEquals(expResult, result);

    }

    /**
     * Test of setDiagnostico method, of class Consultamedica.
     */
    @Test
    public void testSetDiagnostico() {
        System.out.println("setDiagnostico");
        String diagnostico = "";
        Consultamedica instance = new Consultamedica();
        instance.setDiagnostico(diagnostico);

    }

    /**
     * Test of getPresionArterial method, of class Consultamedica.
     */
    @Test
    public void testGetPresionArterial() {
        System.out.println("getPresionArterial");
        Consultamedica instance = new Consultamedica();
        String expResult = "";
        String result = instance.getPresionArterial();
        assertEquals(expResult, result);

    }

    /**
     * Test of setPresionArterial method, of class Consultamedica.
     */
    @Test
    public void testSetPresionArterial() {
        System.out.println("setPresionArterial");
        String presionArterial = "";
        Consultamedica instance = new Consultamedica();
        instance.setPresionArterial(presionArterial);

    }

    /**
     * Test of getFrecuenciaCardiaca method, of class Consultamedica.
     */
    @Test
    public void testGetFrecuenciaCardiaca() {
        System.out.println("getFrecuenciaCardiaca");
        Consultamedica instance = new Consultamedica();
        String expResult = "";
        String result = instance.getFrecuenciaCardiaca();
        assertEquals(expResult, result);

    }

    /**
     * Test of setFrecuenciaCardiaca method, of class Consultamedica.
     */
    @Test
    public void testSetFrecuenciaCardiaca() {
        System.out.println("setFrecuenciaCardiaca");
        String frecuenciaCardiaca = "";
        Consultamedica instance = new Consultamedica();
        instance.setFrecuenciaCardiaca(frecuenciaCardiaca);

    }

    /**
     * Test of getFrecuenciaRespiratoria method, of class Consultamedica.
     */
    @Test
    public void testGetFrecuenciaRespiratoria() {
        System.out.println("getFrecuenciaRespiratoria");
        Consultamedica instance = new Consultamedica();
        String expResult = "";
        String result = instance.getFrecuenciaRespiratoria();
        assertEquals(expResult, result);

    }

    /**
     * Test of setFrecuenciaRespiratoria method, of class Consultamedica.
     */
    @Test
    public void testSetFrecuenciaRespiratoria() {
        System.out.println("setFrecuenciaRespiratoria");
        String frecuenciaRespiratoria = "";
        Consultamedica instance = new Consultamedica();
        instance.setFrecuenciaRespiratoria(frecuenciaRespiratoria);

    }

    /**
     * Test of getTemperaturaCorporal method, of class Consultamedica.
     */
    @Test
    public void testGetTemperaturaCorporal() {
        System.out.println("getTemperaturaCorporal");
        Consultamedica instance = new Consultamedica();
        String expResult = "";
        String result = instance.getTemperaturaCorporal();
        assertEquals(expResult, result);

    }

    /**
     * Test of setTemperaturaCorporal method, of class Consultamedica.
     */
    @Test
    public void testSetTemperaturaCorporal() {
        System.out.println("setTemperaturaCorporal");
        String temperaturaCorporal = "";
        Consultamedica instance = new Consultamedica();
        instance.setTemperaturaCorporal(temperaturaCorporal);

    }

    /**
     * Test of getPeso method, of class Consultamedica.
     */
    @Test
    public void testGetPeso() {
        System.out.println("getPeso");
        Consultamedica instance = new Consultamedica();
        String expResult = "";
        String result = instance.getPeso();
        assertEquals(expResult, result);

    }

    /**
     * Test of setPeso method, of class Consultamedica.
     */
    @Test
    public void testSetPeso() {
        System.out.println("setPeso");
        String peso = "";
        Consultamedica instance = new Consultamedica();
        instance.setPeso(peso);

    }

    /**
     * Test of getTalla method, of class Consultamedica.
     */
    @Test
    public void testGetTalla() {
        System.out.println("getTalla");
        Consultamedica instance = new Consultamedica();
        String expResult = "";
        String result = instance.getTalla();
        assertEquals(expResult, result);

    }

    /**
     * Test of setTalla method, of class Consultamedica.
     */
    @Test
    public void testSetTalla() {
        System.out.println("setTalla");
        String talla = "";
        Consultamedica instance = new Consultamedica();
        instance.setTalla(talla);

    }

    /**
     * Test of getTurno method, of class Consultamedica.
     */
    @Test
    public void testGetTurno() {
        System.out.println("getTurno");
        Consultamedica instance = new Consultamedica();
        int expResult = 0;
        int result = instance.getTurno();
        assertEquals(expResult, result);

    }

    /**
     * Test of setTurno method, of class Consultamedica.
     */
    @Test
    public void testSetTurno() {
        System.out.println("setTurno");
        int turno = 0;
        Consultamedica instance = new Consultamedica();
        instance.setTurno(turno);

    }

    /**
     * Test of getCita method, of class Consultamedica.
     */
    @Test
    public void testGetCita() {
        System.out.println("getCita");
        Consultamedica instance = new Consultamedica();
        int expResult = 0;
        int result = instance.getCita();
        assertEquals(expResult, result);

    }

    /**
     * Test of setCita method, of class Consultamedica.
     */
    @Test
    public void testSetCita() {
        System.out.println("setCita");
        int cita = 0;
        Consultamedica instance = new Consultamedica();
        instance.setCita(cita);

    }

    /**
     * Test of hashCode method, of class Consultamedica.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Consultamedica instance = new Consultamedica();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of equals method, of class Consultamedica.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Consultamedica instance = new Consultamedica();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of toString method, of class Consultamedica.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Consultamedica instance = new Consultamedica();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
      
    }
    
}
