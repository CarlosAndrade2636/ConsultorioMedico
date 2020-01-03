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
public class PersonaTest {
    
    public PersonaTest() {
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
     * Test of getIdPerosona method, of class Persona.
     */
    @Test
    public void testGetIdPerosona() {
        System.out.println("getIdPerosona");
        Persona instance = new Persona();
        Integer expResult = null;
        Integer result = instance.getIdPerosona();
        assertEquals(expResult, result);
   
    }

    /**
     * Test of setIdPerosona method, of class Persona.
     */
    @Test
    public void testSetIdPerosona() {
        System.out.println("setIdPerosona");
        Integer idPerosona = null;
        Persona instance = new Persona();
        instance.setIdPerosona(idPerosona);
    
    }

    /**
     * Test of getCedula method, of class Persona.
     */
    @Test
    public void testGetCedula() {
        System.out.println("getCedula");
        Persona instance = new Persona();
        String expResult = "";
        String result = instance.getCedula();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of setCedula method, of class Persona.
     */
    @Test
    public void testSetCedula() {
        System.out.println("setCedula");
        String cedula = "";
        Persona instance = new Persona();
        instance.setCedula(cedula);
   
    }

    /**
     * Test of getNombre method, of class Persona.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Persona instance = new Persona();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
   
    }

    /**
     * Test of setNombre method, of class Persona.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Persona instance = new Persona();
        instance.setNombre(nombre);

    }

    /**
     * Test of getApellido method, of class Persona.
     */
    @Test
    public void testGetApellido() {
        System.out.println("getApellido");
        Persona instance = new Persona();
        String expResult = "";
        String result = instance.getApellido();
        assertEquals(expResult, result);

    }

    /**
     * Test of setApellido method, of class Persona.
     */
    @Test
    public void testSetApellido() {
        System.out.println("setApellido");
        String apellido = "";
        Persona instance = new Persona();
        instance.setApellido(apellido);

    }

    /**
     * Test of getSexo method, of class Persona.
     */
    @Test
    public void testGetSexo() {
        System.out.println("getSexo");
        Persona instance = new Persona();
        String expResult = "";
        String result = instance.getSexo();
        assertEquals(expResult, result);
  
    }

    /**
     * Test of setSexo method, of class Persona.
     */
    @Test
    public void testSetSexo() {
        System.out.println("setSexo");
        String sexo = "";
        Persona instance = new Persona();
        instance.setSexo(sexo);
   
    }

    /**
     * Test of getFecha method, of class Persona.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        Persona instance = new Persona();
        Date expResult = null;
        Date result = instance.getFecha();
        assertEquals(expResult, result);

    }

    /**
     * Test of setFecha method, of class Persona.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        Date fecha = null;
        Persona instance = new Persona();
        instance.setFecha(fecha);

    }

    /**
     * Test of getDireccion method, of class Persona.
     */
    @Test
    public void testGetDireccion() {
        System.out.println("getDireccion");
        Persona instance = new Persona();
        String expResult = "";
        String result = instance.getDireccion();
        assertEquals(expResult, result);

    }

    /**
     * Test of setDireccion method, of class Persona.
     */
    @Test
    public void testSetDireccion() {
        System.out.println("setDireccion");
        String direccion = "";
        Persona instance = new Persona();
        instance.setDireccion(direccion);
 
    }

    /**
     * Test of getTelefono method, of class Persona.
     */
    @Test
    public void testGetTelefono() {
        System.out.println("getTelefono");
        Persona instance = new Persona();
        String expResult = "";
        String result = instance.getTelefono();
        assertEquals(expResult, result);
   
    }

    /**
     * Test of setTelefono method, of class Persona.
     */
    @Test
    public void testSetTelefono() {
        System.out.println("setTelefono");
        String telefono = "";
        Persona instance = new Persona();
        instance.setTelefono(telefono);
   
    }

    /**
     * Test of hashCode method, of class Persona.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Persona instance = new Persona();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
   
    }

    /**
     * Test of equals method, of class Persona.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Persona instance = new Persona();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
  
    }

    /**
     * Test of toString method, of class Persona.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Persona instance = new Persona();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);

    }
    
}
