//package addressbook;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Writer {
     public static void writer() throws FileNotFoundException{
         try (PrintWriter pw = new PrintWriter(new File("test.csv").getAbsolutePath())) {
             StringBuilder sb = new StringBuilder();
             sb.append("Grape"); //FirstName
             sb.append(',');
             sb.append("Ape"); //LastName
             sb.append(',');
             sb.append("456 Fake Way"); //Address
             sb.append(',');
             sb.append("FakeCity"); //City
             sb.append(',');
             sb.append("Idaho"); //State
             sb.append(',');
             sb.append("grapeApe@hotmail.com"); //Email
             sb.append('\n'); // end of contact
             
             sb.append("Bruce"); //FirstName
             sb.append(',');
             sb.append("Campbell"); //LastName
             sb.append(',');
             sb.append("123 Cabin Woods Way"); //Address
             sb.append(',');
             sb.append("Detroit"); //City
             sb.append(',');
             sb.append("Michigan"); //State
             sb.append(',');
             sb.append("ShopSMart@hotmail.com"); //Email
             sb.append('\n'); // end of contact
             
             
             pw.write(sb.toString());
         }
        System.out.println("done!");
    }
    
    
}
