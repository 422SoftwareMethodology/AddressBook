//package addressbook;
import java.io.*;


public class Reader {

    public static void reader(String fileLocation) {

        String csvFile = fileLocation;
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] contact = line.split(cvsSplitBy);

                System.out.println("Contact : firstName= " + contact[0] + " , lastName=" + contact[1] + 
                        " , street address=" + contact[2] + " , city=" + contact[3] + " , state=" + contact[4] 
                        + " , email=" + contact[5] );

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
