import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XMLReader {
	
	public static void main(String[] args) throws ParserConfigurationException 
	{
		try {
			DocumentBuilder docReader = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			String path ="/Users/gordansajevic/Documents/workspace/LabWork28-01-2015/xml/people.xml";
			Document xmldoc = docReader.parse(new File(path));
			NodeList xmlPeople = xmldoc.getElementsByTagName("Person");
			LinkedList<Person> people = new LinkedList<Person>();
			for (int i=0; i<xmlPeople.getLength(); i++)
			{
				
				Node current = xmlPeople.item(i);
				if (current instanceof Element)
				{
					Element currentElement = (Element) current;
					String name = currentElement.getAttribute("name");
					String surname = currentElement.getAttribute("surname");
					Person person = new Person(name, surname);
					if (currentElement.hasChildNodes())
					{
						NodeList childNodes =  currentElement.getChildNodes();
						for (int j=0; j<childNodes.getLength(); j++)
						{
							Node currentChild = childNodes.item(j);
							if(currentChild instanceof Element){
								Element currentChildElement = (Element) currentChild;
								String childName = currentChildElement.getAttribute("name");
								String childSurname = currentChildElement.getAttribute("surname");
								person.addChild(new Person(childName, childSurname));							
							}
						}
						
						
					}
					people.add(person);
				}
			}
			Iterator<Person>it = people.iterator();
			while(it.hasNext())
			{
				System.out.println(it.next().toString());
			}
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
