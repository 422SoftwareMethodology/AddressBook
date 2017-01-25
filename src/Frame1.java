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
	
	public Frame1(){
		super("Addressbook!");
		setLayout(new BorderLayout());
		
		buttonPanel1 = new JPanel(new GridLayout(1, 5));  //panel for buttons
		TextPanel = new JPanel(new GridLayout(1, 3));     //panel for search function
		displayPanel = new JPanel(new GridLayout(1, 1));  //not sure about the display part, it depends on the backend. It should show a list with name or other info. 
		addbutton = new JButton("Add");
		addbutton.setBackground(Color.green);
		addbutton.addActionListener(new ActionListener(){  //jump to person info interface
            public void actionPerformed(ActionEvent e) {  
                PersonInfo p1 = new PersonInfo();
                p1.setLocation(150, 100);
            }   
        });  
		editbutton = new JButton("Edit");            //these buttons' functions depends on backend, need discuss together.
		editbutton.setBackground(Color.green);       //set buttons' color, it works for windows, but fail on Mac. 
		deletebutton = new JButton("Delete");
		deletebutton.setBackground(Color.green);
		deletebutton.addActionListener(new ActionListener(){  //jump to person info interface
            public void actionPerformed(ActionEvent e) {  
                deleteconfirmation d1 = new deleteconfirmation();
                d1.setLocation(200, 200);
            }   
        });  
		searchbutton = new JButton("Search");
		searchbutton.setBackground(Color.green);
		savebutton = new JButton("Save");
		savebutton.setBackground(Color.green);
		saveasbutton = new JButton("Save as");
		saveasbutton.setBackground(Color.green);;
		
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
            { "firstname", "lastname", "phonenumber", "address", "city", "state", "email" };  
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
		AddContactToTable();
		
		setSize(500,500);          //set frame size
		setVisible(true);
	}
	
	public static void AddContactToTable() {
		if (tableModel.getRowCount() > 0) {
		    for (int i = tableModel.getRowCount() - 1; i > -1; i--) {
		        tableModel.removeRow(i);
		    }
		}
		String firstName = " ", lastName = " ", phoneNumber = " ", address = " ", city = " ", state = " ", email = " ";
		for(int i = 0; i <  AddressBook.openContactList.size(); ++i){
			firstName = AddressBook.openContactList.get(i).get_firstName();
			lastName = AddressBook.openContactList.get(i).get_lastName();
			phoneNumber = AddressBook.openContactList.get(i).get_phoneNumber();
			address = AddressBook.openContactList.get(i).get_address();
			city = AddressBook.openContactList.get(i).get_city();
			state = AddressBook.openContactList.get(i).get_state();
			email = AddressBook.openContactList.get(i).get_email();
			
			Object[] data = { firstName, lastName, phoneNumber, address, city, state, email };
			Frame1.tableModel.addRow(data);
		}
	}	
}
