/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author shayron
 */
public class Prova {
    public Teacher teacher;
    public int number;
    public Date date; // date and hour
    public int duration; // in minutes
    public int vacancies;
    public ArrayList<Question> questions;
    public ArrayList<Student> students;
    
    public void Proof (Teacher teacher, int number, Date date, int duration, int vacancies) {
        this.teacher = teacher;
        this.number = number;
        this.date = date;
        this.duration = duration;
        this.vacancies = vacancies;        
    }
}
