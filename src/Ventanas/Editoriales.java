/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;
import Clases.Conexion;
import clases.LgnEditoriales;
import java.sql.*;
/**
 *
 * @author anuar
 */
public class Editoriales extends javax.swing.JInternalFrame {
    Connection con;
    /**
     * Creates new form Editoriales
     */
    public Editoriales() {
        initComponents();
        con= new Conexion().Conectar();
        GuardarEditorial.addActionListener(new LgnEditoriales(con, JtxEditorial));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JtxEditorial = new javax.swing.JTextField();
        GuardarEditorial = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 0, -1, 493));

        jLabel1.setFont(new java.awt.Font("Lucida Calligraphy", 0, 18)); // NOI18N
        jLabel1.setText("Editoriales");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        jLabel2.setText("Editorial");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, -1, -1));

        JtxEditorial.setBackground(new java.awt.Color(102, 153, 255));
        getContentPane().add(JtxEditorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 131, -1));

        GuardarEditorial.setBackground(new java.awt.Color(51, 153, 255));
        GuardarEditorial.setText("GUARDAR");
        getContentPane().add(GuardarEditorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/libros.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 6, 560, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton GuardarEditorial;
    private javax.swing.JTextField JtxEditorial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}