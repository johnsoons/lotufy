/*
 * viniciusrosalen@uvv.br
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ObjectiveQuestionDAO;
import DAO.SubjectDAO;
import Model.Answer;
import Model.ObjectiveQuestion;
import Model.Subject;
import Model.Teacher;
import View.FormQuestion;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author johnson
 */
public class QuestionController {    
    
    public static void store(FormQuestion formQuestion) throws SQLException, ClassNotFoundException {                
        Subject subject = SubjectDAO.findByIndex(formQuestion.getSubjectId().getSelectedIndex());                
        
        Teacher teacher = new Teacher();        
        
        ObjectiveQuestion question = new ObjectiveQuestion();        
        question.setTeacher(teacher);
        question.setDescription(formQuestion.getDescription().getText());
        question.setDifficultyLevel(formQuestion.getDifficultyLevel().getSelectedIndex());        
        question.setSubject(subject);                                       
                
        Answer answer1 = new Answer();    
        answer1.setObjectiveQuestion(question);
        answer1.setDescription(formQuestion.getOption1().getText());
        
        if(formQuestion.getCorrectAnswer1().getText().equals("A"))
            answer1.setCorrect(1);        
        
        Answer answer2 = new Answer();        
        answer2.setObjectiveQuestion(question);
        answer2.setDescription(formQuestion.getOption2().getText());
        if(formQuestion.getCorrectAnswer2().toString().charAt(0) == 'B')
            answer2.setCorrect(1);
        
        Answer answer3 = new Answer();        
        answer3.setDescription(formQuestion.getOption3().getText());
        answer3.setObjectiveQuestion(question);
        if(formQuestion.getCorrectAnswer3().toString().charAt(0) == 'C')
            answer3.setCorrect(1);
        
        Answer answer4 = new Answer();        
        answer4.setDescription(formQuestion.getOption4().getText());
        answer4.setObjectiveQuestion(question);
        if(formQuestion.getCorrectAnswer4().toString().charAt(0) == 'D')
            answer4.setCorrect(1);
        
        Answer answer5 = new Answer();        
        answer5.setDescription(formQuestion.getOption5().getText());
        answer5.setObjectiveQuestion(question);
        if(formQuestion.getCorrectAnswer5().toString().charAt(0) == 'E')
            answer5.setCorrect(1);
        
        ArrayList<Answer> answers = new ArrayList<>();
        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);
        answers.add(answer4);
        answers.add(answer5);
        
        question.setAnswers(answers);
        
        ObjectiveQuestionDAO.insert(question);
        
        formQuestion.clearFields();
        JOptionPane.showMessageDialog(formQuestion, "Questão incluida com sucesso!");
    }    
    
    public static void edit(int id) {
        //Question question = new Question();
        //FormQuestion formQuestion = new FormQuestion(question.);        
        //formQuestion.setVisible(true);
    }
   
    public static void create() throws SQLException, ClassNotFoundException {
        ArrayList<Subject> subjects = SubjectDAO.selectAll();
        
        FormQuestion formQuestion = new FormQuestion();
        
        JComboBox subjectId = formQuestion.getSubjectId();
        for(int i = 0; i < subjects.size(); i++) {            
            subjectId.addItem(subjects.get(i).getDescription());
        }
        
        formQuestion.setVisible(true);
        
    }

}
