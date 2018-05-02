/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Sparrow
 */
public class DbConnection {
    

public static Connection cn;

    public static void FillConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/pharmacy", "root", "");

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "DBconnection\n" + ex);
        }
    }



}
