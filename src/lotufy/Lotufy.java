/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotufy;

import Controller.QuestionController;
import View.HomeView;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author johnson
 */
public class Lotufy {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        System.getProperties().list(System.out);
        
        HomeView hv = new HomeView();
        
        hv.setVisible(true);
    }    
}
