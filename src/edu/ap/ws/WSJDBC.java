package edu.ap.ws;

import org.w3c.dom.*;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.InputSource;

import java.io.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Registratie {
	private static final String FILELOCATION = "C:\\Users/nab/Desktop/registraties.xml";
	
	public String getAllRegistraties(){
		DocumentBuilder docBuilder;
		File file = new File(FileLocation);
        DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
        
        
		try {
			docBuilder = dBF.newDocumentBuilder();
			Document document = docBuilder.parse(file);
			document.getDocumentElement().normalize();
	        
	        NodeList regiter = doc.getElementsByTagName("registratie");
	        
	        for (int i = 0; i < regiter.getLength(); i++) {
	        	 Node Node = regiter.item(i);
	        	 Element element = (Element) Node;
	        	 String regs = "";
	        	 regs += "Datum: " + element.getAttribute("datum");
	        	 regs += "<br/>Dokter : " + element.getAttribute("Dokter");
	        	 regs += "<br/>Naam: " + element.getAttribute("patient");
	        	 regs += "<br/>Geboortedatum: " + element.getAttribute("geboortedatum");
	        	 regs += "<br/>Diagnose : " + element.getAttribute("diagnose");
	        	 regs += "allergieen : " + element.getAttribute("allergieen");

	        }

	        return regs;
		} 
		catch (Exception e) {
			return "ERROR" + e.getMessage();
		}
	}
	

}
