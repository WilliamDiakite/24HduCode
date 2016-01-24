
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Test {

	

	public static ArrayList<String> getText(ArrayList<String> listeReplique, ArrayList<Personnage> listePerso) {

		
		try {
			final DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			final DocumentBuilder builder = factory.newDocumentBuilder();
			final Document document = builder.parse(new File("sceneI.xml"));
			final Element racine = document.getDocumentElement();
			boolean nomPresent = true; 
			System.out.println(racine.getNodeName());
			final NodeList racineNoeuds = racine.getChildNodes();
			final int nbRacineNoeuds = racineNoeuds.getLength();
			for (int i = 0; i < nbRacineNoeuds; i++) {

				if (racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
					final Element scene = (Element) racineNoeuds.item(i);
					System.out.println(scene.getNodeName());
					NodeList personnage = scene.getChildNodes();
					for (int j=0; j< personnage.getLength(); j++)
					{
						 if (personnage.item(j).hasAttributes()) {
			             Attr attr = (Attr)personnage.item(j).getAttributes().getNamedItem("nom");
			                    if (attr != null) {
			                        String attribute= attr.getTextContent();                      
			                        System.out.println("attribute: " + attribute);  
			                        listeReplique.add(attribute);
			                        for(Personnage p : listePerso)
			                        {
			                        	if (p.nom.equals(attribute))
			                        	{
			                        		nomPresent= false; 
			                        	}
			                        }
			                        if (nomPresent==true)
			                        {
			                        	   listePerso.add(new Personnage(attribute));
			                        }
			                     
			                        
			                    }
						 }
						NodeList replique = personnage.item(j).getChildNodes();
						for (int k=0; k< replique.getLength(); k++)
						{
							listeReplique.add(replique.item(k).getTextContent());
						}
					
					}						
					for (String s : listeReplique)
					{
						System.out.println(s);
					}
				}
			}
		} catch (final ParserConfigurationException | SAXException
				| IOException e) {
			e.printStackTrace();
		}

		return listeReplique;
	}

}
