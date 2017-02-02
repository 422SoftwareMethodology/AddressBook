import java.io.*;
import java.util.ArrayList;

//
// This class reads content from a file (currently csv) and returns a ArrayList
//

public class Reader {

    public static ArrayList<Contact> reader(String fileLocation) {

        String tsvFile = fileLocation;
        String line = "";
        String tsvSplitBy = "\t";
        
        ArrayList<Contact> tempContactList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(tsvFile))) {

            while ((line = br.readLine()) != null) {
                // contact array of a single person, use comma to delimit
                String[] infoArr = line.split(tsvSplitBy);
                String[] contactInfo = {"", "", "", "", "", "", "", "", "", ""};
                System.out.println(Integer.toString(infoArr.length));
                for(int i = 0; i < infoArr.length; i++){
                	contactInfo[i] = infoArr[i];
                }
                if (infoArr.length <= 8){
                	System.out.println("DOINGIT");
                	  Contact tempContact = new Contact(contactInfo[0],contactInfo[1],contactInfo[2],contactInfo[3],
                              contactInfo[4],contactInfo[5],contactInfo[6], contactInfo[7], " ", " ");
                      tempContactList.add(tempContact);
                      System.out.println("Contact: firstName = " + tempContact.get_firstName());
                }
                else{
                Contact tempContact = new Contact(infoArr[0],infoArr[1],infoArr[2],infoArr[3],
                        infoArr[4],infoArr[5],infoArr[6], infoArr[7], infoArr[8], infoArr[9]);
                tempContactList.add(tempContact);
                System.out.println("Contact: firstName = " + tempContact.get_firstName());
                }
                /*System.out.println("Contact : firstName= " + contact[0] + " , lastName=" + contact[1] + 
                        " , street address=" + contact[2] + " , city=" + contact[3] + " , state=" + contact[4] 
                        + " , email=" + contact[5] ); //For Debugging*/
                
            }

        } catch (IOException e) {
            //e.printStackTrace();
        }
        return tempContactList;
    }
}
