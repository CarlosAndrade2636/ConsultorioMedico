/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import javax.imageio.ImageIO;
import modelo.Consulta;
import modelo.Paciente;

/**
 *
 * @author jessica
 */
public class PanelExportarReceta extends javax.swing.JFrame {

    public PanelExportarReceta(Consulta consulta) {
        initComponents();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MMM-YYY");
        Paciente paciente = consulta.getCita().getPaciente();
        Date fecha = Date.from(Instant.now());
        int edad = paciente.calcularEdad();
        txtFecha.setText(formato.format(fecha));
        txtPaciente.setText(paciente.toString());
        txtEdad.setText(edad + " Años");
        txtSexo.setText(paciente.getSexo() + "");
        txtTalla.setText(consulta.getAltura() + " Cm");
        txtPeso.setText(consulta.getPeso() + " Kg");
        txtReceta.setText(consulta.getReceta());
        txtIndicaciones.setText(consulta.getIndicaciones());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        txtIndicaciones = new javax.swing.JTextArea();
        txtEdad = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSexo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTalla = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JLabel();
        txtFecha = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPaciente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtReceta = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtIndicaciones.setEditable(false);
        txtIndicaciones.setBackground(getBackground());
        txtIndicaciones.setColumns(20);
        txtIndicaciones.setRows(5);
        txtIndicaciones.setBorder(null);
        jScrollPane2.setViewportView(txtIndicaciones);

        txtEdad.setText("--------------------");

        jLabel4.setText("Indicaciones:");

        txtSexo.setText("--------------------");

        jLabel9.setText("Talla:");

        jLabel10.setText("Peso:");

        txtTalla.setText("----------------------");

        jLabel1.setText("Fecha:");

        txtPeso.setText("----------------------");

        txtFecha.setText("-----------------------");

        jLabel2.setText("Receta;");

        jLabel3.setText("Paciente:");

        txtPaciente.setText("-----------------------------");

        txtReceta.setEditable(false);
        txtReceta.setBackground(getBackground());
        txtReceta.setColumns(20);
        txtReceta.setLineWrap(true);
        txtReceta.setRows(5);
        txtReceta.setBorder(null);
        jScrollPane1.setViewportView(txtReceta);

        jLabel5.setText("Edad:");

        jLabel6.setText("Sexo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtSexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtTalla, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane2))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFecha)
                    .addComponent(jLabel5)
                    .addComponent(txtEdad)
                    .addComponent(jLabel9)
                    .addComponent(txtTalla))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPaciente)
                    .addComponent(jLabel6)
                    .addComponent(txtSexo)
                    .addComponent(jLabel10)
                    .addComponent(txtPeso))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void imprimirImagen(String ruta) {
        try {
            BufferedImage bufferImagen = new BufferedImage(this.getWidth(), this.getHeight(),
                                             BufferedImage.TYPE_INT_RGB);
            Graphics2D graficos = bufferImagen.createGraphics();
            this.paint(graficos);
            ImageIO.write(bufferImagen, "png", new File(ruta + ".png"));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel txtEdad;
    private javax.swing.JLabel txtFecha;
    private javax.swing.JTextArea txtIndicaciones;
    private javax.swing.JLabel txtPaciente;
    private javax.swing.JLabel txtPeso;
    private javax.swing.JTextArea txtReceta;
    private javax.swing.JLabel txtSexo;
    private javax.swing.JLabel txtTalla;
    // End of variables declaration//GEN-END:variables
}
