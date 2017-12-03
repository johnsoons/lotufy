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
public abstract class Question implements IQuestion {    
    protected int id;
    protected Teacher teacher;
    protected String description;
    protected int difficultyLevel;
    
    @Override
    public void Question (Teacher teacher, String description, int difficultyLevel) {
        this.teacher = teacher;
        this.description = description;
        this.difficultyLevel = difficultyLevel;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
}
