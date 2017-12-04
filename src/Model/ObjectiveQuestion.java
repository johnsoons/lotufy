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
    public ArrayList<Answer> answers;

    @Override
    public String toString() {
        return "ObjectiveQuestion{" + "answers=" + answers + '}';
    }
 
    public void Question (Teacher teacher, String description, int difficultyLevel, ArrayList<Answer> answers) {
        this.teacher = teacher;
        this.description = description;
        this.difficultyLevel = difficultyLevel;        
        this.answers = answers;
    }          

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }
}
