package com.liobouchan.identifyRomanNumbers;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 * Hello world!
 *
 */
public class IdentifyRomanNumbers 
{	
    public static void main( String[] args ) throws IOException
    {
    	File file = new File("src/main/sources/prueba.pdf");
    	PDDocument document = PDDocument.load(file);
    	PDFTextStripper pdfStripper = new PDFTextStripper();
    	String text = pdfStripper.getText(document);
    	System.out.println(text);
    	
    	Pattern pattern =  Pattern.compile("([M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})&&[^\\p{Digit}]&&[^\\p{Punct}]]+\\.)");
    	Matcher matcher = pattern.matcher(text);
    	String contenido;
		int apuntador = 0;

		while (matcher.find(apuntador)) {
			//System.out.println("Apuntador 1: " + apuntador );
			//System.out.println("Start: "+ matcher.start());
			//System.out.println("End: "+ matcher.end());
			apuntador = matcher.end();
			System.out.println("Apartado: "+ matcher.group());
			contenido = text.substring(matcher.end()).trim();
			System.out.println("Contenido: "+ contenido);
			String[] spliteo = contenido.split("([M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})&&[^\\p{Digit}]&&[^\\p{Punct}]]+\\.)",2);
			System.out.println("SPLIT 0: " + spliteo[0]);
			System.out.println("SPLIT 1: " + spliteo[1]);
			//System.out.println("Apuntador 2: " + apuntador );
		}

    	
    	
    	document.close();
    }
}
