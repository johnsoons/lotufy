/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Model.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author johnson
 */
public class QuestionDAO {
    
    public static void insert(Question question) throws SQLException, ClassNotFoundException {        
        String sql = "INSERT INTO question "
                + " (person_id, subject_id, description, difficulty_level, discursive) "
                + " VALUES "
                + " (?, ?, ?, ?, ?)";
        
        
        Connection con = ConnectionDB.getConnection();
        PreparedStatement stmt = con.prepareStatement(sql);
        
        stmt.setInt(1, 1);
        stmt.setInt(2, 1);
        stmt.setString(3, "O que é orientação a objetos?");
        stmt.setInt(4, 1);
        stmt.setInt(5, 0);
        
        stmt.execute();
        stmt.close();
        
        con.close();
    }
    
}
