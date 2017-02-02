import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditAddressName extends JFrame{
	private JButton confirmButton, cancelButton;
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JPanel namePanel, buttonPanel;
	
	public EditAddressName(String currentName){
		super("Edit Address Name");
		namePanel = new JPanel(new GridLayout(1,2)); 
	    buttonPanel = new JPanel(new GridLayout(1, 2));
	    
	    confirmButton = new JButton("Confirm");
	    cancelButton = new JButton("Cancel");
	    nameLabel = new JLabel("Name: ");
	    nameTextField = new JTextField(currentName);
	    
	    buttonPanel.add(confirmButton);
	    buttonPanel.add(cancelButton);
	    
	    namePanel.add(nameLabel);
	    namePanel.add(nameTextField);
	    
	    add(namePanel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.CENTER);
		
		setSize(350, 90);
		setVisible(true);
		
	}
}
