import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//person info interface
@SuppressWarnings("serial")
public class PersonInfo extends JFrame{
	private JPanel InfoPanel;
	private JLabel FirstName, LastName, phonenumber, ZIP_code, city, state, address1, address2, email;
	private JTextField fname, lname, phonenum, zip, c, s, a1, a2, e;
	private JButton Done, Cancel;
	private Contact tempContact;
	public PersonInfo(ArrayList<Contact> openContactList){
		super("Contact Info!");
		tempContact = new Contact(" ", " ", " ", " ", " ", " ", " ", " ");
		setLayout(new BorderLayout());
		
		InfoPanel = new JPanel(new GridLayout(10, 2));      //one panel in this interface
		
		FirstName = new JLabel("            FirstName");     //all attributes labels
		LastName = new JLabel("            LastName");
		phonenumber = new JLabel("            Phonenumber");
		address1 = new JLabel("            Address1");
		address2 = new JLabel("            Address2");
		city = new JLabel("            City");
		state = new JLabel("            State");
		ZIP_code = new JLabel("            ZIP");
		email = new JLabel("            Email address");
		
		fname = new JTextField();  //all text areas
		lname = new JTextField();
		phonenum = new JTextField();
		zip = new JTextField();
		c = new JTextField();
		s = new JTextField();
		a1 = new JTextField();
		a2 = new JTextField();
		e = new JTextField();
		
		Done = new JButton("Done!");    //click this button to save the info
		Done.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e) { 
				if(fname.getText().isEmpty() && lname.getText().isEmpty()){
					prompt1 p1 = new prompt1();
					p1.setLocation(300, 200);
				}
				else{
					tempContact.set_firstName(fname.getText());
					tempContact.set_lastName(lname.getText());
					tempContact.set_phoneNumber(phonenum.getText());
					tempContact.set_address(a1.getText());
					tempContact.set_address(a2.getText());
					tempContact.set_city(c.getText());
					tempContact.set_state(s.getText());
					tempContact.set_zip(zip.getText());
					openContactList.add(tempContact);
					Frame1.AddContactToTable();
					dispose();                                //after customer click the button, close the current window and save data
				}
				
				
        }   
    });  
		Cancel = new JButton("Cancel");
		Cancel.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e) {  
				dispose();                                //after customer click the button, close the current window and do not save data
        }   
    });  
		
		InfoPanel.add(FirstName);   //add allthings to the panel
		InfoPanel.add(fname);
		InfoPanel.add(LastName);
		InfoPanel.add(lname);
		InfoPanel.add(phonenumber);
		InfoPanel.add(phonenum);
		InfoPanel.add(address1);
		InfoPanel.add(a1);
		InfoPanel.add(address2);
		InfoPanel.add(a2);
		InfoPanel.add(city);
		InfoPanel.add(c);
		InfoPanel.add(state);
		InfoPanel.add(s);
		InfoPanel.add(ZIP_code);
		InfoPanel.add(zip);
		InfoPanel.add(email);
		InfoPanel.add(e);
		InfoPanel.add(Done);
		InfoPanel.add(Cancel);
		
		InfoPanel.setBackground(Color.green); //set background color of panel
		
		add(InfoPanel, BorderLayout.CENTER);  //set panel location
		setSize(500,500);         //set frame size
		setVisible(true);
		

		
	}
	/*public boolean hasblank(String s){
		int i = s.indexOf(" ");
		if(i >= 0)
			return true;
		else
			return false;
		}*/
}
