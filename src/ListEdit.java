//package addressbook;

import java.util.ArrayList;

public class ListEdit {
    public static void finder (ArrayList<Contact> arrayList,String searchKey)
    {
        
        //store index of Contact objects for multiple last names
        ArrayList<Contact> foundArrayList = new ArrayList<>();
        
        int arrayListSize = arrayList.size();
        
        //Very simple search. Room for improvement..
        for (int i = 0; i < arrayListSize; i++){
            Contact focusContact = arrayList.get(i); //contact were looking at
            String currentLastName = focusContact.get_lastName();
            
            if ((currentLastName.equals(searchKey))){
                foundArrayList.add(focusContact);
            }
        }
        
        //didn't find anything
        if (foundArrayList.isEmpty()){
        System.out.println("\n\nDidn't find LastName");
        }
        //found some names
        else{
            System.out.println("\n\nWe found the contact. Huzzah!");
            Display.display(foundArrayList);
        }
        
        return ;
    }

    public static ArrayList<Contact> adder (ArrayList<Contact> arrayList, Contact toAdd){
        arrayList.add(toAdd);
        return arrayList;
    }
}
