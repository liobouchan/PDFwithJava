package com.liobouchan.getTextGeneral;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 * Hello world!
 *
 */
public class ExtractTextSimple 
{	
    public static void main( String[] args ) throws IOException
    {
    	String texto = "Artículo 2 Bis 109 b";
    	System.out.println("-----> Texto: " + texto.length() );
    	File file = new File("src/main/sources/regulacion.pdf");
    	PDDocument document = PDDocument.load(file);
    	PDFTextStripper pdfStripper = new PDFTextStripper();
    	String text = pdfStripper.getText(document);
    	System.out.println(text);
    	
    	document.close();
    }
}
