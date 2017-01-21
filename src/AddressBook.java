//package addressbook;

import java.io.File;
import java.io.FileNotFoundException;


public class AddressBook {

    
        public static void main(String[] args) throws FileNotFoundException {
        String fileLoc = new File("test.csv").getAbsolutePath();
        //fileLoc = new File("fileLoc.csv").getAbsolutePath();
        Writer.writer();
        Reader.reader(fileLoc);
    }
    
}
