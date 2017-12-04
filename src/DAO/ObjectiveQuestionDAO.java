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
    
    public static ArrayList<Answer> getQuestionAnswers(Integer questionId) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM answer WHERE (question_id = ?)";
        Connection con = ConnectionDB.getConnection();
        PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        stmt.setInt(1, questionId);
        ResultSet res = stmt.executeQuery();
        
        
        ArrayList<Answer> answers = new ArrayList<>();
        while(res.next()) {
            Answer a = new Answer();
            a.setDescription(res.getString("description"));
            a.setCorrect(res.getInt("correct"));
            answers.add(a);
        }
        
        stmt.close();
        con.close();
        
        return answers;
        
    }
    
    public static ArrayList<ObjectiveQuestion> get(Integer quantidade, Integer dificuldade ) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM question WHERE (difficulty_level <= ?) ORDER BY RAND() LIMIT ?";
        Teacher teacher = new Teacher();
        
        Connection con = ConnectionDB.getConnection();
        PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, dificuldade);
        stmt.setInt(2, quantidade);
        ResultSet res = stmt.executeQuery();
        ArrayList<ObjectiveQuestion> questions = new ArrayList<>();
        
        while(res.next()) {
            ObjectiveQuestion qe = new ObjectiveQuestion();
            qe.setTeacher(teacher);
            qe.setDifficultyLevel(res.getInt("difficulty_level"));
            qe.setDescription(res.getString("description"));  
            ArrayList<Answer> answers = ObjectiveQuestionDAO.getQuestionAnswers(res.getInt("id"));
            
            qe.setAnswers(answers);    
            questions.add(qe);
        }                
        
        stmt.close();
        con.close();
        
        return questions;
        
    }
    
    public static Integer questionLength (Integer dificuldade) throws ClassNotFoundException, SQLException {
        if (dificuldade == null) {
            return 0;
        }
        String sql = "SELECT COUNT(*) FROM question WHERE (difficulty_level <= ?)";        
        Connection con = ConnectionDB.getConnection();
        PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        stmt.setInt(1, dificuldade);
        ResultSet res = stmt.executeQuery();
        res.next();
        int count = res.getInt(1);        
        
        stmt.close();
        con.close();
        
        return count;
    }
    
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        ArrayList<ObjectiveQuestion> quesitons = ObjectiveQuestionDAO.get(5, 3);
//        
//        System.out.println(quesitons);
//    }
}
