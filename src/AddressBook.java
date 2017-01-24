//package addressbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

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
    
	public static ArrayList<Contact> openContactList = new ArrayList<Contact>();
	public Contact myContact = new Contact("Alex", "Costello", "Butt", "Turdd", "Poop", "Nipz", "buttz", 0);
	
        public static void main(String[] args) throws FileNotFoundException {
            
        String fileLoc = new File("test.csv").getAbsolutePath();
        Menu frame = new Menu();
		frame.setVisible(true);
        
        Writer.writer();
        openContactList = Reader.reader(fileLoc);
        
        Display.display(openContactList);
        System.out.println("\n~~~~~~~~Gonna get my Last Name sort on!~~~~~~~\n");
        Sorter.sortByLastname(openContactList);
        Display.display(openContactList);
        ListEdit.finder(openContactList, "Zardoz");
        ListEdit.finder(openContactList, "AintGonnaFindIt");
    }
        
        
}
