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
    protected Subject subject;
    
    @Override
    public void Question (Teacher teacher, String description, int difficultyLevel) {
        this.teacher = teacher;
        this.description = description;
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", teacher=" + teacher + ", description=" + description + ", difficultyLevel=" + difficultyLevel + ", subject=" + subject + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }    
}
