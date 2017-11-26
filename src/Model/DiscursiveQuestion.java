/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;  

/**
 *
 * @author shayron
 */
public class DiscursiveQuestion extends Question {
    public int characters;
    
    public void Question (Teacher teacher, String description, int difficultyLevel, int characters) {
        this.teacher = teacher;
        this.description = description;
        this.difficultyLevel = difficultyLevel;
        this.characters = characters;
    }
    
}
