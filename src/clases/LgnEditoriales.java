/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author Rogelio
 */
public class LgnEditoriales implements ActionListener{
    JTextField JtxEditorial;
    Connection con;
    public LgnEditoriales(Connection con,JTextField JtxEditorial){
        this.con=con;
        this.JtxEditorial=JtxEditorial;
    }    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       try{
            String editorial=JtxEditorial.getText();
            CallableStatement cs = con.prepareCall("{call InsertaEditorial(?,?)}");
            cs.setString(1,editorial);
            cs.registerOutParameter(2, Types.VARCHAR);
            cs.execute();
            JOptionPane.showMessageDialog(null, cs.getString(2));
       }catch(Exception ee){
           ee.printStackTrace();
       } 
        
        
    }
    
}
