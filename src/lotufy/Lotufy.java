/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotufy;

import View.FormQuestion;
import java.sql.SQLException;

/**
 *
 * @author johnson
 */
public class Lotufy {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        new FormQuestion().setVisible(true);
    }
    
}
