import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

//addressbook interface
@SuppressWarnings("serial")
public class Frame1 extends JFrame{
	private JButton addbutton, editbutton, deletebutton, searchbutton, savebutton, saveasbutton;
	private JTextField ta;
	private JLabel namelabel;
	private JPanel buttonPanel1, TextPanel, displayPanel;
	private JScrollPane scroll;
	private static JTable table1;
	private static DefaultTableModel tableModel;
	public int rowSelected = -1;
	
	public static ArrayList<Contact> openContactList = new ArrayList<Contact>();
	
	public Frame1(String fileLoc){  // This is the main interface of addressbook
		super("Addressbook!");
		setLayout(new BorderLayout());
		
		buttonPanel1 = new JPanel(new GridLayout(1, 5));  //panel for buttons
		TextPanel = new JPanel(new GridLayout(1, 3));     //panel for search function
		displayPanel = new JPanel(new GridLayout(1, 1));  //not sure about the display part, it depends on the backend. It should show a list with name or other info. 
		addbutton = new JButton("Add");
		addbutton.setBackground(Color.green);
		addbutton.addActionListener(new ActionListener(){  //jump to person info interface
            public void actionPerformed(ActionEvent e) {  
                PersonInfo p1 = new PersonInfo(openContactList);
                p1.setLocation(150, 100);
            }
        });  
		
		
		
		//Setting file location for this instance<~~~~~~~~~~~~~~~~~~ defaults to local path
		//String fileLoc = new File("test.tsv").getAbsolutePath();
		
		
		
		openContactList = Reader.reader(fileLoc); 
		
		
		
		editbutton = new JButton("Edit");            //these buttons' functions depends on backend, need discuss together.
		editbutton.setBackground(Color.green);       //set buttons' color, it works for windows, but fail on Mac.
		editbutton.addActionListener(new ActionListener(){  //jump to person info interface
            public void actionPerformed(ActionEvent e) {
            	// String editFirstName, String editLastName, String editPhoneNumber, String editAddress1, String editAddress2, String editCity, String editState, String editZip
            	String tempFirstName = (String) table1.getValueAt(rowSelected, 0);
            	String tempLastName = (String) table1.getValueAt(rowSelected, 1);
            	String tempPhoneNumber = (String) table1.getValueAt(rowSelected, 2);
            	String tempAddress1 = (String) table1.getValueAt(rowSelected, 3);
            	String tempAddress2 = (String) table1.getValueAt(rowSelected, 4);
            	String tempCity = (String) table1.getValueAt(rowSelected, 5);
            	String tempState = (String) table1.getValueAt(rowSelected, 6);
            	String tempZip = (String) table1.getValueAt(rowSelected, 7);
            	String tempEmail = (String) table1.getValueAt(rowSelected, 8);
            	String tempFacebook = (String) table1.getValueAt(rowSelected, 9);
            	PersonInfoEdit p1 = new PersonInfoEdit(openContactList, rowSelected, tempFirstName, tempLastName, tempPhoneNumber, tempAddress1, tempAddress2, tempCity, tempState, tempZip, tempEmail, tempFacebook);
                p1.setLocation(150, 100);
            }   
        });
		
		deletebutton = new JButton("Delete");
		deletebutton.setBackground(Color.green);
		deletebutton.addActionListener(new ActionListener(){  //jump to person info interface
            public void actionPerformed(ActionEvent e) {  
                deleteconfirmation d1 = new deleteconfirmation(rowSelected);
                d1.setLocation(200, 200);
            }   
        });  
		
		
		searchbutton = new JButton("Search");  //Search for contact
		searchbutton.setBackground(Color.green);
		searchbutton.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				 	String textEntered = ta.getText();
	                ListEdit.finder(openContactList, textEntered);
	            }  
		});
		
		
		
		savebutton = new JButton("Save");  // Saving the contact to listArray and File
		savebutton.setBackground(Color.green);
		savebutton.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				save();
	            }  
		});
		
		
		JFileChooser chooser =new JFileChooser();
		saveasbutton = new JButton("Save as");
		saveasbutton.setBackground(Color.green);
		saveasbutton.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				chooser.showSaveDialog(null);
				
				String path = chooser.getSelectedFile().getAbsolutePath();
				String filename = chooser.getSelectedFile().getName();
				
				//System.out.println("Filename: " + filename + "  Path: " + path);
				saveAs (path);
				
	            }  
		});
		
		namelabel = new JLabel("           Enter the name:");
		ta= new JTextField();                     //the area customer can text
		
		TextPanel.setBackground(Color.green);
		displayPanel.setBackground(Color.yellow);
		
		buttonPanel1.add(addbutton);         //add allthings to panel
		buttonPanel1.add(editbutton);
		buttonPanel1.add(deletebutton);
		buttonPanel1.add(savebutton);
		buttonPanel1.add(saveasbutton);
		
		TextPanel.add(namelabel);
		TextPanel.add(ta);
		TextPanel.add(searchbutton);

        String[] columnNames =  
            { "Firstname", "Lastname", "Phonenumber", "Address", "Address2", "City", "State", "Zipcode", "Email", "Facebook" };  
        tableModel = new DefaultTableModel(columnNames, 0);
		table1 = new JTable(tableModel);
		
		
		TableColumn column = null;  
        int colunms = table1.getColumnCount();  
        for(int i = 0; i < colunms; i++)  
        {  
            column = table1.getColumnModel().getColumn(i);   
            column.setPreferredWidth(100);  
        }  
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
        scroll = new JScrollPane(table1);
		
		add(buttonPanel1, BorderLayout.NORTH);   //set panel location
		add(TextPanel, BorderLayout.SOUTH);
		add(scroll, BorderLayout.CENTER);
		
		//Mouse Interactions~~~~~~~~~~~~~
		 table1.addMouseListener(new MouseAdapter() { //click on cell
		        public void mousePressed(MouseEvent e) {

		            int row = table1.rowAtPoint(e.getPoint());
		            table1.getSelectionModel().setSelectionInterval(row, row);
		            System.out.println(row);
		            rowSelected = row;
		        }
		    });
		 // Click header to sort
		 table1.getTableHeader().addMouseListener(new MouseAdapter(){
			 public void mouseClicked(MouseEvent e){
				 int col = table1.columnAtPoint(e.getPoint());
				 if (col == 1){
					 System.out.println("Sorting by lastName");
					 Sorter.sortByLastname(openContactList);
					 AddContactToTable();
				 }
				 if (col == 7){
					 System.out.println("Sorting by zip");
					 Sorter.sortByZip(openContactList);
					 AddContactToTable();
				 }
			 }
			 
		 });
		 
		 
		
		AddContactToTable(); // This is the display refresh
		
		setSize(1000,500);          //set frame size
		setVisible(true);
	}
	
	public static void AddContactToTable() {
		if (tableModel.getRowCount() > 0) {
		    for (int i = tableModel.getRowCount() - 1; i > -1; i--) {
		        tableModel.removeRow(i);
		    }
		}
		String firstName = " ", lastName = " ", phoneNumber = " ", address = " ", address2 = " ", city = " ", state = " ", zip = " ", email = " ", facebook = " ";
		for(int i = 0; i < openContactList.size(); ++i){
			firstName = openContactList.get(i).get_firstName();
			lastName = openContactList.get(i).get_lastName();
			phoneNumber = openContactList.get(i).get_phoneNumber();
			address = openContactList.get(i).get_address();
			address2 = openContactList.get(i).get_address2();
			city = openContactList.get(i).get_city();
			state = openContactList.get(i).get_state();
			zip = openContactList.get(i).get_zip();
			email = openContactList.get(i).get_email();
			facebook = openContactList.get(i).get_facebook();
			
			Object[] data = { firstName, lastName, phoneNumber, address, address2, city, state, zip, email, facebook };
			Frame1.tableModel.addRow(data);
		}
	}	
	
	public static ArrayList<Contact> AddTableToContact () {
		
		int nRow = tableModel.getRowCount(), nCol = tableModel.getColumnCount();
		ArrayList<Contact> tempContactList = new ArrayList<>();
		
		//String first,last,phone,street,city,state,email;
		String[] contactInfo = new String [nCol+1];
		
	    for (int i = 0 ; i < nRow ; i++){
	    	//Contact tempContact = new Contact();
	    	
	        for (int j = 0 ; j < nCol ; j++){
	            //tableData[i][j] = tableModel.getValueAt(i,j);
	            //System.out.println(tableModel.getValueAt(i,j));
	            contactInfo [j] = (String) tableModel.getValueAt(i,j);
	        }
	        Contact tempContact = new Contact(contactInfo[0],contactInfo[1],contactInfo[2],contactInfo[3],contactInfo[4],contactInfo[5],contactInfo[6],contactInfo[7], contactInfo[8], contactInfo [9]);
	        tempContactList.add(tempContact);
	    }
	    //Display.display(tempContactList);
	    return tempContactList;
	}
	
	public static void deleteSelectedRow (int rowToDelete){
		if(rowToDelete != -1) { // select row returns -1 if nothing selected
		    Frame1.tableModel.removeRow(rowToDelete);
		}
	}
	
	public static void save (){
		 openContactList = AddTableToContact();
		 try {
			Writer.writer(openContactList);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 //Display.display(AddressBook.openContactList);
	}
	
	public static void saveAs (String path){
		 openContactList = AddTableToContact();
		 try {
			Writer.saveAsWriter(openContactList, path);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
}

	