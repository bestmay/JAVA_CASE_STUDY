/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacasestudy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author syntel
 */
public class Documents {

    public static void printPDF(ArrayList<Employees> emps) throws IOException {
        //Creates new PDF Document
        PDDocument doc = new PDDocument();
        //Creates a black PDF Page
        PDPage blankPage = new PDPage();
        //Add blank page to the PDF Document
        doc.addPage(blankPage);
        //Creating the PDDocumentInformation object 
        PDDocumentInformation pdd = doc.getDocumentInformation();
        PDPageContentStream contentStream = new PDPageContentStream(doc, blankPage);
        //Setting the author of the document
        pdd.setAuthor("Syntel");

        // Setting the title of the document
        pdd.setTitle("Employee Details");

        //Setting the creator of the document 
        pdd.setCreator("Syntel");

        //Setting the subject of the document 
        pdd.setSubject("Employee Details");

        

        //Begin Content Stream
        contentStream.beginText();

        //Setting the font to the Content stream
        contentStream.setFont(PDType1Font.COURIER, 16);

        //Setting the leading
        contentStream.setLeading(14.5f);

        //Setting the position for the line
        contentStream.newLineAtOffset(25, 725);
        
        contentStream.showText("Employee Name        Emp. ID     Band  Grade Vertical             Organization");  
        contentStream.newLine();
        contentStream.newLine();
        
        for(Employees e:emps)
        {
          contentStream.showText(e.display());
          contentStream.newLine();
        }
        contentStream.endText();
        contentStream.close();
        
        //Saving the document 
        doc.save("../employee_details.pdf");
        //Closing the document
        doc.close();

    }

}