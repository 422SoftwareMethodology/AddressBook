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

	public static void main(String args[]) throws FileNotFoundException {
	final ArrayList<String> AddressBookNames = new ArrayList<String>();
    if(OSDetector.isWindows()){
        String currentDirectory = System.getProperty("user.dir") + "\\" + "AddressBooks";
        System.out.println(currentDirectory);
        File f = new File(currentDirectory);
        if(!f.exists()){
            System.out.print("File Doesn't Exists. Creating Folder");
            new File(currentDirectory).mkdir();
        }
        else{
            System.out.println("File Exits");

            File folder = new File(currentDirectory);
            File[] listOfFiles = folder.listFiles();

            for(int i = 0; i < listOfFiles.length; i++){
                AddressBookNames.add(listOfFiles[i].getName());
                System.out.println(listOfFiles[i].getName());
            }
        }
    }
    else{
        String makeDirectory = System.getProperty("user.dir") + "/" + "AddressBooks";
        System.out.println(makeDirectory);
        File f1 = new File(makeDirectory);
        if(!f1.exists()){
            System.out.println("File Doesn't Exist. Creating Folder");
            new File(makeDirectory);
        }
        else{
            System.out.println("File Exists");
        }
    }


    Menu frame = new Menu(AddressBookNames);
    frame.setVisible(true);
}

}
