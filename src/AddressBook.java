import java.io.FileNotFoundException;

//~~~~~~~~~~~~~~~~~~~Glossary~~~~~~~~~~~~~~
//~~~Classes
//Contact: Contains all contact info
//Reader: reads content from a file (csv) and returns arrayList (AKA Load)
//Writer: takes arrayList and writes it to a file (AKA Save)
//Display: unpackages objects and displays them as an array of strings
//Sorter: sorts arrayList by either lastName or zip
//ListEdit: contains find, add, delete, and edit funcitons
//~~~Main Variables
//openContactList: the current working ArrayList

public class AddressBook {

	// public static ArrayList<Contact> openContactList = new
	// ArrayList<Contact>();
	// public Contact myContact = new Contact("Alex", "Costello", "Butt",
	// "Turdd", "Poop", "Nipz", "buttz", "zero");

	public static void main(String[] args) throws FileNotFoundException {

		Menu frame = new Menu();
		frame.setVisible(true);

	}

}
