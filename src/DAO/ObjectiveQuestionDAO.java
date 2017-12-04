/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Model.Answer;
import Model.ObjectiveQuestion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author johnson
 */
public class ObjectiveQuestionDAO {
    
    public static void insert(ObjectiveQuestion question) throws SQLException, ClassNotFoundException {        
        String sql = "INSERT INTO question "
        + " (person_id, subject_id, description, difficulty_level, discursive) "
        + " VALUES "
        + " (?, ?, ?, ?, ?)";
        
        System.out.println(question.getTeacher().getId());
        
        Connection con = ConnectionDB.getConnection();
        PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        stmt.setInt(1, question.getTeacher().getId());
        stmt.setInt(2, question.getSubject().getId());
        stmt.setString(3, question.getDescription());
        stmt.setInt(4, question.getDifficultyLevel());
        stmt.setInt(5, 0);
        stmt.execute();
        
        ResultSet rs = stmt.executeQuery("select last_insert_id() as last_id from question");
        rs.next();
        int lastId = rs.getInt("last_id");
        question.setId(lastId);
        
        
        stmt.close();        
        con.close();       
        
        ArrayList<Answer> answers = question.getAnswers();
        for(int i = 0; i < answers.size(); i++)
        {             
            AnswerDAO.insert(answers.get(i));
        }        
    }    
}
