/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Stack;
import javax.swing.*;

/**
 *
 * @author Rogelio
 */
public class LgnAutores implements ActionListener {

    Connection con;
    JTextField JtxApellidoMater;
    JTextField JtxApellidoPater;
    JTextField JtxNombre;
    JComboBox combo;

    public LgnAutores(Connection con, JTextField JtxApellidoMater, JTextField JtxApellidoPater, JTextField JtxNombre, JComboBox combo) {
        this.con = con;
        this.JtxNombre = JtxNombre;
        this.JtxApellidoPater = JtxApellidoPater;
        this.JtxApellidoMater = JtxApellidoMater;
        this.combo = combo;
    }

    public Stack Nacionalidades() {
        Stack pila = new Stack();
        try {
            CallableStatement cs = con.prepareCall("{call Nacionalidades()}");
            ResultSet res = cs.executeQuery();
            while (res.next()) {
                pila.push(res.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pila;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {

            String nombre = JtxNombre.getText();
            String apPaterno = JtxApellidoPater.getText();
            String apMaterno = JtxApellidoMater.getText();
            String nacionalidad = combo.getSelectedItem().toString();
            CallableStatement cs = con.prepareCall("{call InsertaAutor(?,?,?,?,?)}");
            cs.setString(1, nacionalidad);
            cs.setString(2, nombre);
            cs.setString(3, apPaterno);
            cs.setString(4, apMaterno);
            cs.registerOutParameter(5, Types.VARCHAR);
            cs.execute();
            JOptionPane.showMessageDialog(null, cs.getString(5));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
