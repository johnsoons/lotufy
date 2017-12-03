/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author shayron
 */
public class ObjectiveQuestion extends Question implements IQuestion {
    public char correctAnswer;
    public ArrayList<String> answers;
 
    public void Question (Teacher teacher, String description, int difficultyLevel, char correctAnswer, ArrayList<String> answers) {
        this.teacher = teacher;
        this.description = description;
        this.difficultyLevel = difficultyLevel;
        this.correctAnswer = correctAnswer;
        this.answers = answers;
    }          

    public char getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(char correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }
}
