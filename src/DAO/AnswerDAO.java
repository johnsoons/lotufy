/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Answer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author johnson
 */
public class AnswerDAO {
    
    public static void insert(Answer answer) throws SQLException, ClassNotFoundException {        
        String sql = "INSERT INTO answer "
        + " (question_id, description, correct) "
        + " VALUES "
        + " (?, ?, ?)";
        System.out.println(answer.getObjectiveQuestion().getId());
        Connection con = ConnectionDB.getConnection();
        PreparedStatement stmt = con.prepareStatement(sql);
        
        stmt.setInt(1, answer.getObjectiveQuestion().getId());
        stmt.setString(2, answer.getDescription());
        stmt.setInt(3, answer.getCorrect());        
        
        stmt.execute();
        stmt.close();
        
        con.close();
    }
    
}
