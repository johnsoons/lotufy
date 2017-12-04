/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author johnson
 */
public class Answer {
    private int id;
    private String description;
    private int correct;    
    private ObjectiveQuestion objectiveQuestion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public ObjectiveQuestion getObjectiveQuestion() {
        return objectiveQuestion;
    }

    public void setObjectiveQuestion(ObjectiveQuestion objectiveQuestion) {
        this.objectiveQuestion = objectiveQuestion;
    }

    @Override
    public String toString() {
        return "Answer{" + "id=" + id + ", description=" + description + ", correct=" + correct + ", objectiveQuestion=" + objectiveQuestion + '}';
    }
    
}
