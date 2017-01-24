import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Menu Interface
@SuppressWarnings("serial")
public class Menu extends JFrame{
	private JButton newbutton, openbutton, quitbutton;
	private JLabel titlelabel;
	public Menu()
	{
		super("Welcome!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		JPanel buttonPanel = new JPanel(new GridLayout(1, 3));  //panel for buttons
		JPanel titlepanel = new JPanel(new GridLayout(1, 1));   //panel in the center, we may change it to a display field that shows all addressbooks exists.
		titlepanel.setBackground(Color.yellow);
		newbutton = new JButton("New");
		newbutton.setBackground(Color.green);
		newbutton.addActionListener(new ActionListener(){  
	            public void actionPerformed(ActionEvent e) {   //jump to the create addressbook name window.
	            	Createbookname c1 = new Createbookname();
	                c1.setLocation(100, 50);
	            }   
	        });  
		openbutton = new JButton("Open");
		openbutton.setBackground(Color.green);
		openbutton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e) {    //jump to the addressbook interface.
				if (Desktop.isDesktopSupported()) {
				    try {
						Desktop.getDesktop().open(new File("C:\\"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				/*try {
					Process p = new ProcessBuilder("explorer.exe", "/select,C:\\directory\\selectedFile").start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				Frame1 f1 = new Frame1();
				f1.setLocation(150, 50);
        }   
    });  
		quitbutton = new JButton("Quit");
		quitbutton.setBackground(Color.green);
		quitbutton.addActionListener(new ActionListener(){  //end the program.
			public void actionPerformed(ActionEvent e) { 
				System.exit(0);
        }   
    });  
		
		titlelabel = new JLabel("  Welcome to Use Team 5 Address Book!");
		titlelabel.setFont(new java.awt.Font("Dialog", 1, 25));   //setfont size and style.
		buttonPanel.add(newbutton);                    // add all buttons to the panel
		buttonPanel.add(openbutton);
		buttonPanel.add(quitbutton);
		titlepanel.add(titlelabel);
		
		add(buttonPanel, BorderLayout.NORTH);         // set panel location
		add(titlepanel, BorderLayout.CENTER);
		setSize(500, 500);  //set frame size
	}
	
}
	