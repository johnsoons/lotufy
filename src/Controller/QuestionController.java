/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.QuestionDAO;
import Model.ObjectiveQuestion;
import Model.Question;
import Model.Subject;
import Model.Teacher;
import View.FormQuestion;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

/**
 *
 * @author johnson
 */
public class QuestionController {
    
    public static void store(FormQuestion formQuestion) throws SQLException, ClassNotFoundException {
//        Person person = new Person();
//        person.setId(1);
        
        Subject subject = new Subject();
        subject.setId(1);
        
        Teacher teacher = new Teacher();
        ArrayList<String> answers = new ArrayList();
        
        ObjectiveQuestion question = new ObjectiveQuestion();        
        question.setTeacher(teacher);
        question.setDescription(formQuestion.getDescription().getText());
        question.setDifficultyLevel(formQuestion.getDifficultyLevel().getSelectedIndex());
        question.setCorrectAnswer(formQuestion.getCorrectAnswer().getSelection());
        //question.fill(mapAttributes);
        
        
        QuestionDAO.insert(question);
    }    
    
    public static void edit(int id) {
        Question question = new Question();
        //FormQuestion formQuestion = new FormQuestion(question.);        
        formQuestion.setVisible(true);
    }

}
