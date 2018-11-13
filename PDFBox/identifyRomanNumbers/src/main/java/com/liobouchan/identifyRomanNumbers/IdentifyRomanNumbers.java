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
    	
    	Pattern pattern =  Pattern.compile("([M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})&&[^\\p{Digit}]&&[^\\p{Punct}]]+\\.)");
    	Matcher matcher = pattern.matcher(text);
    	String contenido;
    	String contenidoApartado;
		int apuntador = 0;
		
		String nombreDeApartado;
		String[] auxiliar;

		while (matcher.find(apuntador)) {
			apuntador = matcher.end();
			
			System.out.println("Apartado: "+ matcher.group());
			auxiliar = matcher.group().toString().split("\\.",2);
			nombreDeApartado = auxiliar[0].trim();
			System.out.println("Nombre Apartado: " + nombreDeApartado);

			contenido = text.substring(matcher.end()).trim();
			String[] aux = contenido.split("([M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})&&[^\\p{Digit}]&&[^\\p{Punct}]]+\\.)");
			auxiliar = contenido.split("([M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})&&[^\\p{Digit}]&&[^\\p{Punct}]]+\\.)",2);
			contenidoApartado = auxiliar[0].trim();
						
			System.out.println("Contenido: "+ contenidoApartado);
			System.out.println(" ");
		}
    	
    	document.close();
    }
}
