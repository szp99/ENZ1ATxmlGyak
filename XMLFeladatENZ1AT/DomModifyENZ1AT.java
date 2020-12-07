package enz1atdom2;

import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NamedNodeMap;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class DomModifyENZ1AT {

	public static void main(String argv[]) {
		
		try {
			
			//Létrehozzuk a beolvasáshoz szükséges egységeket
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docbuilder = factory.newDocumentBuilder();
			
			//Beolvassuk az XML fájlt
			Document document = docbuilder.parse(new File("XMLENZ1AT.xml")); 
			document.getDocumentElement().normalize();
			
			//Kiválasztjuk a gyökérelemet
			Element rootElement = document.getDocumentElement();
			System.out.println("Gyokerelem: " + rootElement.getNodeName());
			
			//Gyerekelemeket eltároljuk egy listában
			NodeList childNodes = rootElement.getChildNodes();
			
			//Ciklusban végigjárjuk a gyerekelemeket
			for(int i=1; i<childNodes.getLength(); i++) {
				Node node = childNodes.item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					System.out.println("-----------------------------------");
					System.out.println(node.getNodeName() + ": ");
					Element element = (Element)node;
					
					//Kiíratjuk az attribútumokat (elemjellemzõket)
					NamedNodeMap attlist = element.getAttributes();					
					for(int j=0; j<attlist.getLength(); j++) {						
						System.out.println("  " + attlist.item(j).getNodeName() + ": " + attlist.item(j).getNodeValue());
					}
					
					//Kiíratjuk az elemek nevét és értékét
					Node actualNode = element.getFirstChild();
					while(actualNode != null) {
						
						//Kovács Jakab neve rosszul lett regisztrálva, változtassuk meg Kovács Jenõre
						//Kiválasztjuk azt a node-ot, ahol Kovács Jakab van
						if(actualNode.getNodeType() == Node.ELEMENT_NODE && actualNode.getTextContent().equals("Kovacs Jakab") == true) {
							
							//Megváltoztatjuk a tartalmat
							actualNode.setTextContent("Kovacs Jeno");
							Element actualElement = (Element)actualNode;													
							System.out.println("  " + actualElement.getNodeName() + ": " + actualElement.getTextContent());
						}
						else if(actualNode.getNodeType() == Node.ELEMENT_NODE) {
							Element actualElement = (Element)actualNode;													
							System.out.println("  " + actualElement.getNodeName() + ": " + actualElement.getTextContent());
						}
						actualNode=actualNode.getNextSibling();
					}
				}
			}	
		}
		
		//Elvégezzük a kivételkezelést
		catch(ParserConfigurationException exception) {
			exception.printStackTrace();
		}
		catch(IOException exception) {
			exception.printStackTrace();
		}
		catch(SAXException exception) {
			exception.printStackTrace();
		} 
	}
}