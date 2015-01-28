import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedList;


public class Test {

	public static void main(String[] args) throws FileNotFoundException 
	{
		Person gordan= new Person("Gordan", "Sajević");
		Person edib = new Person ("Edib", "Imamović");
		Person jesenko = new Person("Jesenko", "Gavrić");
		Person necko = new Person("Nedžad", "Hamzić");
		Person davor = new Person ("Davor", "Stanković");
		LinkedList<Person> predavaci = new LinkedList<Person>();
		Person omer = new Person("Mali Omer", "vanbračno");
		Person imran = new Person("Imran", "Imamović");
		Person iman = new Person("Iman", "Imamović");
		Person george = new Person("George", "Stanković");
		Person junior = new Person("Nedžad Junior", "Hamzić");
		Person proljecko = new Person("Proljećko", "Gavrić");
		gordan.addChild(omer);
		edib.addChild(imran);
		edib.addChild(iman);
		jesenko.addChild(proljecko);
		necko.addChild(junior);
		davor.addChild(george);
		predavaci.add(gordan);
		predavaci.add(edib);
		predavaci.add(jesenko);
		predavaci.add(necko);
		predavaci.add(davor);
		Person.personToXML(predavaci, System.out);
		String path ="/Users/gordansajevic/Documents/workspace/LabWork28-01-2015/xml/people.xml";
		Person.personToXML(predavaci, new FileOutputStream(path));
		
	}

}
