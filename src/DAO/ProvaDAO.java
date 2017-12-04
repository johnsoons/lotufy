/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Answer;
import Model.ObjectiveQuestion;
import Model.Prova;
import Model.Subject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author shayron
 */
public class ProvaDAO {
    
    public static ArrayList<Prova> getAll() throws ClassNotFoundException, SQLException {
        String sql = "SELECT id, data FROM prova";
                
        Connection con = ConnectionDB.getConnection();
        Statement stmt = con.createStatement();                
        ResultSet rs = stmt.executeQuery(sql);
        
        ArrayList<Prova> provas = new ArrayList<>();        
        
        while (rs.next()) {
            Prova s = new Prova();
            s.setId(rs.getInt("id"));
            s.setDate(rs.getString("data"));
            provas.add(s);
        }
        
        stmt.close();        
        con.close(); 
        
        return provas;
    }
  
    public static void bulkInsert(ArrayList<ObjectiveQuestion> questions, String data) throws ClassNotFoundException, SQLException {
        String sqlInsert = "INSERT INTO prova "
        + " (data) "
        + " VALUES "
        +  "(?)";        
        Connection con = ConnectionDB.getConnection();
        PreparedStatement stmt = con.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, data);
        stmt.execute();
        
        ResultSet rs = stmt.executeQuery("select last_insert_id() as last_id from prova");
        rs.next();
        int provaId = rs.getInt("last_id");
        stmt.close();        
        con.close();  
        
        for(ObjectiveQuestion question: questions) {
            String sql = "INSERT INTO prova_question "
            + " (prova_id, question_id) "
            + " VALUES "
            +  "(?,?)";
            Connection con1 = ConnectionDB.getConnection();
            PreparedStatement stmt1 = con1.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt1.setInt(1, provaId);
            stmt1.setInt(2, question.getId());
            stmt1.execute();
            stmt1.close();
            con1.close();
        }        
        
        
//        Connection con = ConnectionDB.getConnection();
//        PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//        
//        stmt.setInt(1, question.getTeacher().getId());
//        stmt.setInt(2, question.getSubject().getId());
//        stmt.setString(3, question.getDescription());
//        stmt.setInt(4, question.getDifficultyLevel());
//        stmt.setInt(5, 0);
//        stmt.execute();
    }
    
}
