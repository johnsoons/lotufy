/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import DAO.AnswerDAO;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.test.annotations.WrapToTest;
import com.sun.javafx.font.FontFactory;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author shayron
 */
public class ProvaController {
    public static final String DEST = "pdfs/Prova.pdf";
   
    public void gerarPdf(String data, Integer dificultie, Integer quantidade) throws IOException {        
        File file = new File(DEST);
        file.getParentFile().mkdirs();
       // Initialize PDF document
        PdfDocument pdf = new PdfDocument(new PdfWriter(DEST));
 
        // Initialize document
        Document document = new Document(pdf);
        
        Text opa = new Text("The cococooc").setFontSize(10).setBold();
        Text af = new Text("resposta").setFontSize(10);
        
        Paragraph p1 = new Paragraph().add(opa);
        Paragraph p2 = new Paragraph().add(af);
        document.add(p1);
        document.add(p2);
 
        //Close document
        document.close();
         
    }
    
}
