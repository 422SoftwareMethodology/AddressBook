import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableColumn;
import javax.swing.JFileChooser;

//Menu Interface
@SuppressWarnings("serial")
public class Menu extends JFrame{
	private JButton newbutton, openbutton, quitbutton, deletebutton, importbutton, exportbutton;
	private JScrollPane sc;
	private JLabel titlelabel;
	private JTextArea text;
	private JTable table;
	public Menu()
	{
		super("Welcome!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLayout(new BorderLayout());
		
		JFileChooser chooser = new JFileChooser();
		
		
		//Container c= getContentPane();
		//c.setLayout(new BorderLayout());
		
		JPanel buttonPanel = new JPanel(new GridLayout(1, 6));  //panel for buttons
		//JPanel titlepanel = new JPanel(new GridLayout(1, 1));   //panel in the center, we may change it to a display field that shows all addressbooks exists.
		//titlepanel.setBackground(Color.yellow);
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
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				chooser.showOpenDialog(null);
				String fileLoc = chooser.getSelectedFile().getAbsolutePath();
				//Open.FOpen();
				Frame1 f1 = new Frame1(fileLoc);
				f1.setLocation(150, 50);
        }   
    });  
		
		deletebutton = new JButton("delete");
		deletebutton.setBackground(Color.green);
		
		importbutton = new JButton("import");
		importbutton.setBackground(Color.green);
		importbutton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e) {    
				
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				chooser.showOpenDialog(null);
		        System.out.println(chooser.getSelectedFile());
				
        }   
    });  
		
		exportbutton = new JButton("export");
		exportbutton.setBackground(Color.green);
		
		quitbutton = new JButton("Quit");
		quitbutton.setBackground(Color.green);
		quitbutton.addActionListener(new ActionListener(){  //end the program.
			public void actionPerformed(ActionEvent e) { 
				System.exit(0);
        }   
    });  
		
		  Object[][] obj = new Object[1][1];  
	        for (int i = 0; i < 1; i++)  
	        {  
	            for (int j = 0; j < 1; j++)  
	            {  
	                switch (j)  
	                {  
	                case 0:  
	                    obj[i][j] = "Jack";  
	                    break;  
	    
	                }  
	            }  
	        }  
		//text = new JTextArea();
	    String[] columnNames =  
	            { "                                                                 Addressbook name" };  
		table = new JTable(obj, columnNames);  
		TableColumn column = null;  
        int colunms = table.getColumnCount();  
        for(int i = 0; i < colunms; ++i) {  
            column = table.getColumnModel().getColumn(i);  
            column.setPreferredWidth(500);  
        }  

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
		sc = new JScrollPane(table);
		
		//bookmenu = new JMenuBar();
		
		
		//titlelabel = new JLabel();
		//titlelabel.setText(Createbookname.getInputaddressbook());
		//titlelabel.setFont(new java.awt.Font("Dialog", 1, 25));   //setfont size and style.
		buttonPanel.add(newbutton);                    // add all buttons to the panel
		buttonPanel.add(openbutton);
		buttonPanel.add(deletebutton);
		buttonPanel.add(importbutton);
		buttonPanel.add(exportbutton);
		buttonPanel.add(quitbutton);
		//titlepanel.add(bookmenu);
		add(buttonPanel, BorderLayout.NORTH);         // set panel location
		//add(titlepanel, BorderLayout.CENTER);
		add(sc, BorderLayout.CENTER);
		sc.setVisible(true);
		setSize(500, 500);  //set frame size
	}
	
}
	