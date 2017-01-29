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
				int checknum = 0;
				if(phonenum.getText().isEmpty())
					checknum += 1;
				if(a1.getText().isEmpty())
					checknum += 1;
				if(a2.getText().isEmpty())
					checknum += 1;
				if(c.getText().isEmpty())
					checknum += 1;
				if(s.getText().isEmpty())
					checknum += 1;
				if(zip.getText().isEmpty())
					checknum += 1;
				
				if(fname.getText().isEmpty() && lname.getText().isEmpty()){
					prompt1 p1 = new prompt1();
					p1.setLocation(300, 200);
				}
				
				else if(checknum == 6){
						prompt1 p1 = new prompt1();
						p1.setLocation(300, 200);
					}
				
				else{
					if(zip.getText().isEmpty() && phonenum.getText().isEmpty()){
						tempContact.set_firstName(fname.getText());
						tempContact.set_lastName(lname.getText());
						tempContact.set_phoneNumber(phonenum.getText());
						tempContact.set_address(a1.getText());
						tempContact.set_address2(a2.getText());
						tempContact.set_city(c.getText());
						tempContact.set_state(s.getText());
						tempContact.set_zip(zip.getText());
						openContactList.add(tempContact);
						Frame1.AddContactToTable();
						dispose();                                //after customer click the button, close the current window and save data
					}
					
					else if((zip.getText().isEmpty() == false)&&(checkzip(zip.getText()) == false)){
							prompt3 p3 = new prompt3();
							p3.setLocation(500, 200);
					}
					
					else if((phonenum.getText().isEmpty() == false)&&(checkphonenum(phonenum.getText()) == false)){
							prompt2 p2 = new prompt2();
							p2.setLocation(400, 250);
					}
					
					/*else if((email.getText().isEmpty() == false)&&(checkemail(email.getText()) == false)){
							prompt4 p4 = new prompt4();
							p4.setLocation(450, 300);
					}*/
					else{
						tempContact.set_firstName(fname.getText());
						tempContact.set_lastName(lname.getText());
						tempContact.set_phoneNumber(phonenum.getText());
						tempContact.set_address(a1.getText());
						tempContact.set_address2(a2.getText());
						tempContact.set_city(c.getText());
						tempContact.set_state(s.getText());
						tempContact.set_zip(zip.getText());
						//tempContact.set_email(email.getText());
						openContactList.add(tempContact);
						Frame1.AddContactToTable();
						dispose();                                //after customer click the button, close the current window and save data
					}
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
	public boolean checkzip(String s){
		if(s.length() == 5 || s.length() == 10){
			if(s.length() == 5){
				String digit5 = "\\d{5}";
				boolean b1 = s.matches(digit5);
				return b1;
			}
			else if(s.length() == 10){
				String digit10 = "\\d{5}" + "-" + "\\d{4}";
				boolean b2 = s.matches(digit10);
				return b2;
			}
		}
		return false;
	}
	public boolean checkphonenum(String str){
		if(str.length() == 7 || str.length() == 10){
			if(str.length() == 7){
				String dig7 = "\\d{7}";
				boolean b3 = str.matches(dig7);
				return b3;
			}
			else if(str.length() == 10){
				String dig10 = "\\d{10}";
				boolean b4 = str.matches(dig10);
				return b4;
			}
		}
		return false;
	}
	
	/*public boolean checkemail(String str){
		String e = "\\W@\\W";
		boolean b5 = str.matches(e);
		return b5;
	}*/
	/*public boolean hasblank(String s){
		int i = s.indexOf(" ");
		if(i >= 0)
			return true;
		else
			return false;
		}*/
}
