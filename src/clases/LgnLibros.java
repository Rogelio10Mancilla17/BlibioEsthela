/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Rogelio
 */
public class LgnLibros implements ActionListener {

    Connection con;
    JTextField titulo;
    JTextField isbn;
    JTextField ejemplares;
    JComboBox editoriales;
    JComboBox autores;

    public LgnLibros(Connection con, JTextField titulo, JTextField isbn, JTextField ejemplares,JComboBox editoriales,JComboBox autores) {
        this.con = con;
        this.titulo = titulo;
        this.isbn = isbn;
        this.ejemplares = ejemplares;
        this.editoriales=editoriales;
        this.autores=autores;
    }

    public JComboBox Autores(JComboBox Autor) {
        try {
            CallableStatement cs = con.prepareCall("{call RegresaAutores()}");
            ResultSet res = cs.executeQuery();
            while (res.next()) {
                String au = res.getString(1) + " " + res.getString(2) + " " + res.getString(3);
                Autor.addItem(au.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Autor;
    }

    public JComboBox Editoriales(JComboBox Ed) {
        try {
            CallableStatement cs = con.prepareCall("{call RegresaEditoriales()}");
            ResultSet res = cs.executeQuery();
            while (res.next()) {
                String au = res.getString(1);
                Ed.addItem(au.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Ed;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            
            String title = titulo.getText();
            String autor = autores.getSelectedItem().toString();
            String au[]=autor.split(" ");
            
            String edito = editoriales.getSelectedItem().toString();
            String isb = isbn.getText();
            String iteraciones=ejemplares.getText();
            int iter=Integer.parseInt(iteraciones);
            for (int i = 0; i < iter; i++) {
                CallableStatement cs = con.prepareCall("{call insertalibro(?,?,?,?,?,?)}");
                cs.setString(1, title);
                cs.setString(2, au[0]);
                cs.setString(3, au[1]);
                cs.setString(4, au[2]);
                cs.setString(5, edito);
                cs.setString(6, isb);
                cs.execute();
             }
            JOptionPane.showMessageDialog(null, "Libros Insertados");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
