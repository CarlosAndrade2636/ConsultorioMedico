/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Citamedica;
import ec.edu.ups.modelo.Medico;
import ec.edu.ups.modelo.Paciente;
import ec.edu.ups.modelo.Usuario;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
public class ControladorCitaTest {
    
    public ControladorCitaTest() {
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
     * Test of generarID method, of class ControladorCita.
     */
    Date date = new Date();
  
    Medico medico = new Medico (2 ,"03020405683","Pedro" );
    Paciente paciente = new Paciente(2);
    

 public static Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
 
  public static Date ParseHora(String hora)
    {
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
        Date horaDate = null;
        try {
            horaDate = formato.parse(hora);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return horaDate;
    }
    @Test
    public void testGenerarID() {
      
        int expResult = 9;
        int result = ControladorCita.generarID();
        assertEquals(expResult, result);
        System.out.println( "expResult  "+expResult+" result "+ result);
       
    }

    /**
     * Test of agregar method, of class ControladorCita.
     */
    @Test
    public void testAgregar() {
       
        Citamedica cita = new Citamedica (8,ParseFecha("2019-12-11"),ParseHora("15:10:00"), "gripe", "espera", medico, paciente);
        boolean expResult = true;
        boolean result = ControladorCita.agregar(cita);
        assertEquals(expResult, result);
        System.out.println( "expResult  "+expResult+" result "+ result);
    }

    

    /**
     * Test of eliminar method, of class ControladorCita.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        int id = 0;
        boolean expResult = false;
        boolean result = ControladorCita.eliminar(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class ControladorCita.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        int id = 9;
        Citamedica expResult = null;
        
        Citamedica result = ControladorCita.buscar(id);
        assertEquals(expResult, result);
        System.out.println(" result "+ result);
       
    }

    /**
     * Test of listar method, of class ControladorCita.
     */
//    @Test
//    public void testListar() {
//        System.out.println("listar");
//        List<Citamedica> expResult = null;
//        List<Citamedica> result = ControladorCita.listar();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of listarCitasNoAsistidas method, of class ControladorCita.
     */
//    @Test
//    public void testListarCitasNoAsistidas() {
//        System.out.println("listarCitasNoAsistidas");
//        String cedulaPaciente = "";
//        List<Citamedica> expResult = null;
//        List<Citamedica> result = ControladorCita.listarCitasNoAsistidas(cedulaPaciente);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
