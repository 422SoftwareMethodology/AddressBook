package addressbook;

import java.io.FileNotFoundException;


public class AddressBook {

    
        public static void main(String[] args) throws FileNotFoundException {
        String fileLoc = "/Users/Boydn/Documents/CIS422/Assignment1/testAddressBook.csv";
        Reader.reader(fileLoc);
        fileLoc = "/Users/Boydn/Documents/CIS422/Assignment1/testNewAddress.csv";
        Writer.writer();
        Reader.reader(fileLoc);
    }
    
}
