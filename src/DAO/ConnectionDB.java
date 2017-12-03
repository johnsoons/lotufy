/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author johnson
 */
public class ConnectionDB {
    
    private static final String USER = "root";
    private static final String PASSWORD = "via321098via";
    private static final String URL = "jdbc:mysql://172.17.0.1:3306/lotufy";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    // Conectar ao banco
    public static Connection getConnection() throws ClassNotFoundException {             
        try {
            Class.forName(DRIVER);        
            return DriverManager.getConnection(URL, USER, PASSWORD);       
        } catch (Exception e) {
            throw new RuntimeException(e);
        }        
    }    
}
