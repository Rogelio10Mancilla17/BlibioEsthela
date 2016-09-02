/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Rogelio
 */
public class LgnAlumnos implements ActionListener {
    Connection con;
    JTextField mat;
    JTextField nombre;
    JTextField paterno;
    JTextField materno;
    JComboBox carreras;
    JDateChooser fecha;
    public LgnAlumnos(Connection con,JTextField mat,JTextField nombre,JTextField paterno,JTextField materno, JComboBox carreras,JDateChooser fecha){
        this.con=con;
        this.mat=mat;
        this.nombre=nombre;
        this.paterno=paterno;
        this.materno=materno;
        this.carreras=carreras;
        this.fecha=fecha;
    }
    
    public JComboBox LlenaCarreras(JComboBox carre){
        try{
            carre.removeAllItems();
            CallableStatement cs = con.prepareCall("{call RegresaCarreras()}");
            ResultSet res = cs.executeQuery();
            while (res.next()) {
            carre.addItem(res.getString(1));
            }

            
        }catch(Exception e){
            
        }
        return carre;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        try{
        String matricula=mat.getText();
        String nom=nombre.getText();
        String pater=paterno.getText();
        String mater= materno.getText();
        String carre=carreras.getSelectedItem().toString();
        java.util.Date obj= new java.util.Date();
        obj=fecha.getDate();
        SimpleDateFormat fec= new SimpleDateFormat("MM-dd-yyyy");
        String salidafecha=fec.format(obj);
           
        CallableStatement cs = con.prepareCall("{call InsertaAlumno(?,?,?,?,?,?,?)}");
            cs.setString(1,matricula);
            cs.setString(2, nom);
            cs.setString(3, pater);
            cs.setString(4, mater);
            cs.setString(5, carre);
            cs.setString(6, salidafecha);
            cs.registerOutParameter(7, Types.VARCHAR);
            cs.execute();
            JOptionPane.showMessageDialog(null, cs.getString(7));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
