import java.io.*;
import java.util.ArrayList;

//
// This class reads content from a file (currently csv) and returns a ArrayList
//

public class Reader {

	public static ArrayList<Contact> reader(String fileLocation) {

		String tsvFile = fileLocation + ".tsv";
		String line = "";
		String tsvSplitBy = "\t";
		
		ArrayList<Contact> tempContactList = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(tsvFile))) {
			br.readLine();
			while ((line = br.readLine()) != null) {
				// contact array of a single person, use comma to delimit
					String[] infoArr = line.split(tsvSplitBy);
					String[] contactInfo = { "", "", "", "", "", "", "", "", "", "" };
					//System.out.println(Integer.toString(infoArr.length));
					for (int i = 0; i < infoArr.length; i++) {
						contactInfo[i] = infoArr[i];
						//System.out.println(infoArr[i]);
					}
					if(contactInfo[5].isEmpty() && contactInfo[6].isEmpty()){
						continue;
					}else{
						
						
						
						if (infoArr.length <= 8) {
							//System.out.println("DOINGIT");
							
							//public Contact(String city, String state, String zip, String address, String address2, String lastName,
							//String firstName, String phoneNumber, String email, String website)
							
							//   0      1      2    3    4     5      6     7    8      9
							// first, last, phone, add, add2, city, state, zip, email, web normal
							// city, state, zip, add, add2, last, first, phone, email, web
							
							Contact tempContact = new Contact(contactInfo[5], contactInfo[6], contactInfo[7],
								contactInfo[3], contactInfo[4], contactInfo[1], contactInfo[0], contactInfo[2], " ",
								" ");
							tempContactList.add(tempContact);
							
							//System.out.println("Contact: Add2 = " + tempContact.get_address2() + " Arr Add2 = " + contactInfo[4] );
						
						} else {
							System.out.println("Hey, Maybe here?????? #1");
						/*Contact tempContact = new Contact(infoArr[1], infoArr[1], infoArr[2], infoArr[3], infoArr[4],
								infoArr[5], infoArr[6], infoArr[7], infoArr[8], infoArr[9]);*/
							
							Contact tempContact = new Contact(contactInfo[5], contactInfo[6], contactInfo[7],
									contactInfo[3], contactInfo[4], contactInfo[1], contactInfo[0], contactInfo[2], contactInfo[8],
									contactInfo[9]);
						tempContactList.add(tempContact);
						//System.out.println("Contact: firstName = " + tempContact.get_firstName());
						}
						
						
					/*
					 * System.out.println("Contact : firstName= " + contact[0] +
					 * " , lastName=" + contact[1] + " , street address=" +
					 * contact[2] + " , city=" + contact[3] + " , state=" +
					 * contact[4] + " , email=" + contact[5] ); //For Debugging
					 */
					}

				
			}
		} catch (IOException e) {
			// e.printStackTrace();
		}
		return tempContactList;
	}
	/*
	public static boolean isValid(String[] contactInfo){
		boolean firstNameEmpty = contactInfo[5].isEmpty();
		boolean lastNameEmpty = contactInfo[6].isEmpty();
		int otherFields = 0;
		for(int i = 0; i < contactInfo.length; i++){
			if(!contactInfo[i].isEmpty()){
				otherFields += 1;
			}
		}
		if(firstNameEmpty && lastNameEmpty){
			return false;
		}
		else if((firstNameEmpty || lastNameEmpty) && (otherFields < 1)){
			return false;
		}
		else{
			return true;
		}
	}*/
}
