import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//addressbook interface
@SuppressWarnings("serial")
public class Frame1 extends JFrame{
	private JButton addbutton, editbutton, deletebutton, searchbutton, savebutton, saveasbutton;
	private JTextField ta;
	private JLabel namelabel;
	private JPanel buttonPanel1, TextPanel, displayPanel;
	
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
		
		add(buttonPanel1, BorderLayout.NORTH);   //set panel location
		add(TextPanel, BorderLayout.SOUTH);
		add(displayPanel, BorderLayout.CENTER);
		
		setSize(500,500);          //set frame size
		setVisible(true);
	}

}
