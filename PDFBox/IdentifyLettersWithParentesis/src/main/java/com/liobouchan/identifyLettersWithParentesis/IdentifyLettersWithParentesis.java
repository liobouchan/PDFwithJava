package com.liobouchan.identifyLettersWithParentesis;

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
public class IdentifyLettersWithParentesis 
{
    public static void main( String[] args ) throws IOException
    {
    	File file = new File("src/main/sources/prueba.pdf");
    	PDDocument document = PDDocument.load(file);
    	PDFTextStripper pdfStripper = new PDFTextStripper();
    	String text = pdfStripper.getText(document);
    	
    	Pattern pattern =  Pattern.compile("\\p{Lower}\\)");
    	Matcher matcher = pattern.matcher(text);
    	String contenido;
    	String contenidoSubApartado;
		int apuntador = 0;
		
		String nombreDeSubApartado;
		String[] auxiliar;

		while (matcher.find(apuntador)) {
			apuntador = matcher.end();
			
			System.out.println("SubApartado: "+ matcher.group());
			auxiliar = matcher.group().toString().split("\\)",2);
			nombreDeSubApartado = auxiliar[0].trim();
			System.out.println("Nombre SubApartado: " + nombreDeSubApartado);

			contenido = text.substring(matcher.end()).trim();
			String[] aux = contenido.split("\\p{Lower}\\)");
			auxiliar = contenido.split("\\p{Lower}\\)",2);
			contenidoSubApartado = auxiliar[0].trim();
						
			System.out.println("Contenido: "+ contenidoSubApartado);
			System.out.println(" ");
		}
    	
    	document.close();
    }
}
