/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import DAO.AnswerDAO;
import DAO.ObjectiveQuestionDAO;
import Model.Answer;
import Model.ObjectiveQuestion;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.test.annotations.WrapToTest;
import com.sun.javafx.font.FontFactory;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author shayron
 */
public class ProvaController {
    public static final String DEST = "pdfs/Prova.pdf";
   
    public static void gerarPdf(String data, Integer dificultie, Integer quantidade) throws IOException, ClassNotFoundException, SQLException {        
        File file = new File(DEST);
        file.getParentFile().mkdirs();
       // Initialize PDF document
        PdfDocument pdf = new PdfDocument(new PdfWriter(DEST));
 
        // Initialize document
        Document document = new Document(pdf);
        
        Text cabec = new Text("Nome:").setFontSize(10).setBorder(new SolidBorder(Color.BLACK, 1));
        Table table = new Table(3);
        Cell cel = new Cell(4, 12);
        cel.add("Nome:");
        table.addHeaderCell(cel);        
        Cell c2 = new Cell(1, 6);
        c2.add("Prova de Programação Orientada a Objeto       Valor: 10,00");
        table.addCell(c2);
        Cell c3 = new Cell(1, 6);
        c3.add("Data: "+data);
        table.addCell(c3);
        
        
        document.add(table);
        
        ArrayList<ObjectiveQuestion> oQuestions = ObjectiveQuestionDAO.get(quantidade, dificultie);        
        String[] options = {"A", "B", "C", "D", "E"};        
        Integer quesNumb = 1;
     
        for(ObjectiveQuestion oQ: oQuestions) {
            String questones = quesNumb+") "+oQ.getDescription();
            Text questoText = new Text(questones).setFontSize(10).setBold();
            Paragraph p1 = new Paragraph().add(questoText); 
            document.add(p1);
            
            int optIndex = 0;
            for(Answer ans: oQ.answers) {
                String anserrr = options[optIndex]+") "+ans.getDescription();                
                Text anserText = new Text(anserrr).setFontSize(10);
                Paragraph p2 = new Paragraph().add(anserText);
                document.add(p2);    
                optIndex++;
            }
            quesNumb++;
        }
 
        //Close document
        document.close();
         
    }
    
    public static Integer questionCount(Integer dificultie) throws ClassNotFoundException, SQLException {
        Integer count = ObjectiveQuestionDAO.questionLength(dificultie);
        if (dificultie == null) {
            return 0;
        }
       
        return count;
    }
    
}
