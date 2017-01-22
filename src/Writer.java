//package addressbook;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Writer {
     public static void writer() throws FileNotFoundException{
         try (PrintWriter pw = new PrintWriter(new File("test.csv").getAbsolutePath())) {
             StringBuilder sb = new StringBuilder();
             
             sb.append("Bruce"); //FirstName 0
             sb.append(',');
             sb.append("Campbell"); //LastName 1
             sb.append(',');
             sb.append("876-202-2222"); //PhoneNumber 2
             sb.append(',');
             sb.append("123 Cabin Woods Way"); //Address 3
             sb.append(',');
             sb.append("Detroit"); //City 4
             sb.append(',');
             sb.append("Michigan"); //State 5
             sb.append(',');
             sb.append("ShopSMart@hotmail.com"); //Email 6
             sb.append(',');
             sb.append("57467"); // zip 7
             sb.append('\n'); // end of contact
             
             sb.append("StoneFace"); //FirstName
             sb.append(',');
             sb.append("Zardoz"); //LastName
             sb.append(',');
             sb.append("541-867-5309"); //PhoneNumber
             sb.append(',');
             sb.append("456 Fake Way"); //Address
             sb.append(',');
             sb.append("FakeCity"); //City
             sb.append(',');
             sb.append("New Mexico"); //State
             sb.append(',');
             sb.append("someEmail@hotmail.com"); //Email
             sb.append(',');
             sb.append("97477"); // zip
             sb.append('\n'); // end of contact
             
             sb.append("Grape"); //FirstName
             sb.append(',');
             sb.append("Ape"); //LastName
             sb.append(',');
             sb.append("541-867-5309"); //PhoneNumber
             sb.append(',');
             sb.append("456 Fake Way"); //Address
             sb.append(',');
             sb.append("FakeCity"); //City
             sb.append(',');
             sb.append("Idaho"); //State
             sb.append(',');
             sb.append("grapeApe@hotmail.com"); //Email
             sb.append(',');
             sb.append("97477"); // zip
             sb.append('\n'); // end of contact
             
             
             pw.write(sb.toString());
         }
        System.out.println("done!");
    }
    
    
}
