/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.vista;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import javax.swing.JOptionPane;
import controlador.ControladorCita;
import controlador.ControladorConsulta;
import modelo.Cita;
import modelo.Consulta;

/**
 *
 * @author jessica
 */
public class PanelConsultasPaciente extends javax.swing.JPanel {
    
    private Consulta consultaTemporal;
    
    public PanelConsultasPaciente() {
        initComponents();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-YYYY");
        txtFecha.setText(formato.format(Date.from(Instant.now())));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFecha = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPA = new javax.swing.JFormattedTextField();
        txtFC = new javax.swing.JFormattedTextField();
        txtFR = new javax.swing.JFormattedTextField();
        txtTemperatura = new javax.swing.JFormattedTextField();
        txtPeso = new javax.swing.JFormattedTextField();
        txtTalla = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSintomas = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtIMC = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDiagnostico = new javax.swing.JTextArea();

        setEnabled(false);

        txtFecha.setEnabled(false);

        jLabel1.setText("Fecha:");

        jLabel2.setText("PA:");

        txtPA.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        txtPA.setEnabled(false);

        txtFC.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        txtFC.setEnabled(false);

        txtFR.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        txtFR.setEnabled(false);

        txtTemperatura.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        txtTemperatura.setEnabled(false);

        txtPeso.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        txtPeso.setEnabled(false);

        txtTalla.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        txtTalla.setEnabled(false);

        jLabel3.setText("FC:");

        jLabel4.setText("FR:");

        jLabel5.setText("Tmp:");

        jLabel6.setText("Talla:");

        jLabel7.setText("Peso:");

        txtSintomas.setColumns(20);
        txtSintomas.setLineWrap(true);
        txtSintomas.setRows(5);
        txtSintomas.setEnabled(false);
        jScrollPane1.setViewportView(txtSintomas);

        jLabel8.setText("Sintomas:");

        jLabel9.setText("I.M.C:");

        txtIMC.setEnabled(false);

        jLabel10.setText("Diagnostico:");

        txtDiagnostico.setColumns(20);
        txtDiagnostico.setLineWrap(true);
        txtDiagnostico.setRows(5);
        txtDiagnostico.setEnabled(false);
        jScrollPane2.setViewportView(txtDiagnostico);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIMC, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(218, 218, 218))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtPA, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTalla, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFR, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9)
                    .addComponent(txtIMC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setDatos(Consulta consulta) {
        this.consultaTemporal = consulta;
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-YYYY");
        Date fecha = consulta.getCita().getFecha();
        txtFecha.setText(formato.format(fecha));
        txtPA.setText(consulta.getPresionArterial() + "");
        txtFC.setText(consulta.getFrecuenciaCardiaca() + "");
        txtFR.setText(consulta.getFrecuenciaRespiratoria() + "");
        txtTemperatura.setText(consulta.getTemperaturaCorporal() + "");
        txtPeso.setText(consulta.getPeso() + "");
        txtTalla.setText(consulta.getAltura() + "");
        txtIMC.setText(consulta.getIndiceMasa() + "");
        txtSintomas.setText(consulta.getSintomas());
        txtDiagnostico.setText(consulta.getDiagnostico());
    }

    public void guardarCambiosConsulta(String accion, PanelRecetasPaciente panelRecetas) {
        float pa = Float.valueOf(txtPA.getText().replace(",", "."));
        float fc = Float.valueOf(txtFC.getText().replace(",", "."));
        float fr = Float.valueOf(txtFR.getText().replace(",", "."));
        float tc = Float.valueOf(txtTemperatura.getText().replace(",", "."));
        float talla = Float.valueOf(txtTalla.getText().replace(",", "."));
        float peso = Float.valueOf(txtPeso.getText().replace(",", "."));
        String sintomas = txtSintomas.getText();
        String diagnostico = txtDiagnostico.getText();
        Cita cita = ControladorCita.buscar(ControladorCita.generarID() - 1);
        cita.setEstado("Asistido");
        ControladorCita.modificar(cita);
        if (accion.equals("insertar") && consultaTemporal == null) {
            Consulta consulta = new Consulta(ControladorConsulta.generarID(),
                                             cita, sintomas, diagnostico,
                                             pa, fc, fr, tc, peso, talla, "", "");
            if (ControladorConsulta.agregar(consulta)) {
                panelRecetas.generarReceta(consulta.getId());
                panelRecetas.limpiarCampos();
                JOptionPane.showMessageDialog(null, "Operacion exitosa:\n" + 
                                                "La consulta ha sido agregada con exito!");
            } else {
                JOptionPane.showMessageDialog(null, "Operacion fallida:\n" + 
                                                  "La consulta no ha sido agregada!");
            }
        } else if (accion.equals("modificar")) {
            Consulta consulta = new Consulta(consultaTemporal.getId(),
                                             cita,
                                             sintomas, diagnostico,
                                             pa, fc, fr, tc, peso, talla, 
                                             consultaTemporal.getReceta(),
                                             consultaTemporal.getIndicaciones());
            if (ControladorConsulta.modificar(consulta)) {
                panelRecetas.generarReceta(consulta.getId());
                panelRecetas.limpiarCampos();
                JOptionPane.showMessageDialog(null, "Operacion exitosa:\n" + 
                                              "La consulta ha sido modificada con exito!");
            }
        } else if (accion.equals("eliminar")) {
            if (ControladorConsulta.eliminar(consultaTemporal.getId())) {
                JOptionPane.showMessageDialog(null, "Operacion exitosa:\n" + 
                                              "La consulta ha sido eliminada con exito!");
            }
        }
        limpiarCampos();
        desactivarCampos();
        panelRecetas.desactivarCampos();
    }
    
    public void limpiarCampos() {
        txtPA.setText("");
        txtFC.setText("");
        txtFR.setText("");
        txtTemperatura.setText("");
        txtPeso.setText("");
        txtTalla.setText("");
        txtIMC.setText("");
        txtSintomas.setText("");
        txtDiagnostico.setText("");
    }
    
    public void activarCampos() {
        txtPA.setEnabled(true);
        txtFC.setEnabled(true);
        txtFR.setEnabled(true);
        txtTemperatura.setEnabled(true);
        txtPeso.setEnabled(true);
        txtTalla.setEnabled(true);
        txtSintomas.setEnabled(true);
        txtDiagnostico.setEnabled(true);
    }
    
    public void desactivarCampos() {
        txtPA.setEnabled(false);
        txtFC.setEnabled(false);
        txtFR.setEnabled(false);
        txtTemperatura.setEnabled(false);
        txtPeso.setEnabled(false);
        txtTalla.setEnabled(false);
        txtSintomas.setEnabled(false);
        txtDiagnostico.setEnabled(false);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtDiagnostico;
    private javax.swing.JFormattedTextField txtFC;
    private javax.swing.JFormattedTextField txtFR;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIMC;
    private javax.swing.JFormattedTextField txtPA;
    private javax.swing.JFormattedTextField txtPeso;
    private javax.swing.JTextArea txtSintomas;
    private javax.swing.JFormattedTextField txtTalla;
    private javax.swing.JFormattedTextField txtTemperatura;
    // End of variables declaration//GEN-END:variables
}
