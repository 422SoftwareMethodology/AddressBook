import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//create new addressbook name interface
@SuppressWarnings("serial")
public class Createbookname extends JFrame{
	private JLabel prompt;
	private JPanel namepanel;
	public static JTextField bookname;
	private JButton submit;
	private static String inputaddressbook;
	
	public Createbookname(){
		super("Please enter the addressbook name!");
		namepanel = new JPanel(new GridLayout(1, 3));     //only one panel in this interface
		bookname = new JTextField();
		setInputaddressbook(bookname.getText());
		System.out.println(bookname.getText().toString());
		prompt = new JLabel("             New addressbook name:");
		submit = new JButton("submit");
		submit.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e) {  //jump to the addressbook interface
				dispose();                                //after customer click the button, close the current window 
				String fileLoc = new File(bookname.getText().toString()).getAbsolutePath(); // Default Save Path
				Frame1 f1 = new Frame1(fileLoc);
				f1.setLocation(200, 50);
        }   
    });  
		
		namepanel.add(prompt);         //add allthings to the panel
		namepanel.add(bookname);
		namepanel.add(submit);
		
		add(namepanel, BorderLayout.CENTER);   //set panel location
		setSize(700,70);   //set frame size
		setVisible(true);	
	}

	public static String getInputaddressbook() {
		return inputaddressbook;
	}

	public void setInputaddressbook(String inputaddressbook) {
		this.inputaddressbook = inputaddressbook;
	}
}
