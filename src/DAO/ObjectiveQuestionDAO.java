/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Model.Answer;
import Model.ObjectiveQuestion;
import Model.Question;
import Model.Teacher;
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
    
    public ArrayList<ObjectiveQuestion> get(Integer quantidade, Integer dificuldade ) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * question WHERE (difficulty_level < ?) LIMIT ?";
        Teacher teacher = new Teacher();
        
        Connection con = ConnectionDB.getConnection();
        PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, dificuldade);
        stmt.setInt(2, quantidade);
        ResultSet res = stmt.executeQuery();
        ArrayList<ObjectiveQuestion> questions = new ArrayList<>();
        
        while(res.next()) {
            ArrayList<Answer> answers = new ArrayList<>();
            ResultSet res1 = stmt.executeQuery("SELECT * FROM awswe WHERE (question_id = "+res.getInt("id")+")");
            while(res1.next()) {
                Answer a = new Answer();
                a.setDescription(res1.getString("description"));
                a.setCorrect(res1.getInt("correct"));
                answers.add(a);
            }
            
            ObjectiveQuestion qe = new ObjectiveQuestion();
            qe.setTeacher(teacher);
            qe.setDifficultyLevel(res.getInt("difficulty_level"));
            qe.setDescription(res.getString("description"));
            qe.setAnswers(answers);
    
            questions.add(qe);
        }
        
        return questions;
        
    }
}
