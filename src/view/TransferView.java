package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ViewManager;

@SuppressWarnings("serial")
public class TransferView extends JPanel implements ActionListener {
	
	private ViewManager manager;
	private JTextField transferAmountField;
	private JTextField destinationAccountField;
	private JButton transferButton;
	private JButton exitButton;
	
	
	
	public TransferView(ViewManager manager) {
		super();
		
		this.manager = manager;
		initialize();
	}
	
	private void initialize() {
		this.setLayout(null);
	
		this.add(new javax.swing.JLabel("TransferView", javax.swing.SwingConstants.CENTER));
		initTransferAmountField();
		initTransferAccountField();
		initTransferButton();
		initExitButton();
	}
	
	private void initTransferAmountField() {
		JLabel label = new JLabel("Transfer Amount: ", SwingConstants.RIGHT);
		label.setBounds(25, 140, 140, 35);
		label.setLabelFor(transferAmountField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		transferAmountField = new JTextField(20);
		transferAmountField.setBounds(160, 140, 200, 35);
		transferAmountField.addActionListener(this);
		
		this.add(label);
		this.add(transferAmountField);
	}
	
	private void initTransferAccountField() {
		JLabel label = new JLabel("Destination Account Number: ", SwingConstants.RIGHT);
		label.setBounds(25, 220, 140, 35);
		label.setLabelFor(destinationAccountField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		destinationAccountField = new JTextField(20);
		destinationAccountField.setBounds(160, 220, 200, 35);
		destinationAccountField.addActionListener(this);
		
		this.add(label);
		this.add(destinationAccountField);
	}
	
	private void initTransferButton() {
		transferButton = new JButton("Transfer");
		transferButton.setBounds(100, 300, 200, 35);
		transferButton.addActionListener(this);
		
		this.add(transferButton);
	}
	
	private void initExitButton() {
		exitButton = new JButton("Exit");
		exitButton.setBounds(310, 300, 100, 35);
		exitButton.addActionListener(this);
		
		this.add(exitButton);
	}
	
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		throw new IOException("ERROR: The TransferView class is not serializable.");
	}
	
	///////////////////// OVERRIDDEN METHODS //////////////////////////////////////////
	
	/*
	 * Responds to button clicks and other actions performed in the CreateView.
	 * 
	 * @param e
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
		if(source.equals(transferButton)) {
			if(manager.transfer(Long.parseLong(destinationAccountField.getText()), Double.parseDouble(transferAmountField.getText())) == true) {
				System.out.println("Transfer Successful");
				manager.switchTo(ATM.HOME_VIEW);
			}
			else {
				System.out.println("Transfer Unsuccessful");
			}
			
		}
		else if(source.equals(exitButton)) {
			manager.switchTo(ATM.HOME_VIEW);
		}
		else {
			System.err.println("ERROR: Action command not found (" + e.getActionCommand() + ")");
		}
		
		
	}
}