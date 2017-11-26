/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

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
    
}
