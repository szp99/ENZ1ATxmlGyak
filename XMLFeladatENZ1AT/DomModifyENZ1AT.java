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
			
			//L�trehozzuk a beolvas�shoz sz�ks�ges egys�geket
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docbuilder = factory.newDocumentBuilder();
			
			//Beolvassuk az XML f�jlt
			Document document = docbuilder.parse(new File("XMLENZ1AT.xml")); 
			document.getDocumentElement().normalize();
			
			//Kiv�lasztjuk a gy�k�relemet
			Element rootElement = document.getDocumentElement();
			System.out.println("Gyokerelem: " + rootElement.getNodeName());
			
			//Gyerekelemeket elt�roljuk egy list�ban
			NodeList childNodes = rootElement.getChildNodes();
			
			//Ciklusban v�gigj�rjuk a gyerekelemeket
			for(int i=1; i<childNodes.getLength(); i++) {
				Node node = childNodes.item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					System.out.println("-----------------------------------");
					System.out.println(node.getNodeName() + ": ");
					Element element = (Element)node;
					
					//Ki�ratjuk az attrib�tumokat (elemjellemz�ket)
					NamedNodeMap attlist = element.getAttributes();					
					for(int j=0; j<attlist.getLength(); j++) {						
						System.out.println("  " + attlist.item(j).getNodeName() + ": " + attlist.item(j).getNodeValue());
					}
					
					//Ki�ratjuk az elemek nev�t �s �rt�k�t
					Node actualNode = element.getFirstChild();
					while(actualNode != null) {
						
						//Kov�cs Jakab neve rosszul lett regisztr�lva, v�ltoztassuk meg Kov�cs Jen�re
						//Kiv�lasztjuk azt a node-ot, ahol Kov�cs Jakab van
						if(actualNode.getNodeType() == Node.ELEMENT_NODE && actualNode.getTextContent().equals("Kovacs Jakab") == true) {
							
							//Megv�ltoztatjuk a tartalmat
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
		
		//Elv�gezz�k a kiv�telkezel�st
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