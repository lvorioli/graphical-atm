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
public class DepositView extends JPanel implements ActionListener {
	
	private ViewManager manager;
	private JTextField depositAmountField;
	private JButton depositButton;
	private JButton exitButton;
	
	
	
	public DepositView(ViewManager manager) {
		super();
		
		this.manager = manager;
		initialize();
	}
	
	private void initialize() {
		this.setLayout(null);
	
		this.add(new javax.swing.JLabel("DepositView", javax.swing.SwingConstants.CENTER));
		initDepositAmountField();
		initDepositButton();
		initExitButton();
	}
	
	private void initDepositAmountField() {
		JLabel label = new JLabel("Deposit Amount: ", SwingConstants.RIGHT);
		label.setBounds(25, 140, 140, 35);
		label.setLabelFor(depositAmountField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		depositAmountField = new JTextField(20);
		depositAmountField.setBounds(160, 140, 200, 35);
		depositAmountField.addActionListener(this);
		
		this.add(label);
		this.add(depositAmountField);
	}
	
	private void initDepositButton() {
		depositButton = new JButton("Deposit");
		depositButton.setBounds(100, 300, 200, 35);
		depositButton.addActionListener(this);
		
		this.add(depositButton);
	}
	
	private void initExitButton() {
		exitButton = new JButton("Exit");
		exitButton.setBounds(310, 300, 100, 35);
		exitButton.addActionListener(this);
		
		this.add(exitButton);
	}
	
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		throw new IOException("ERROR: The DepositView class is not serializable.");
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
		
		if(source.equals(depositButton)) {
			if(manager.deposit(Double.parseDouble(depositAmountField.getText())) == true) {
				System.out.println("Deposit Successful");
				manager.switchTo(ATM.HOME_VIEW);
			}
			else {
				System.out.println("Deposit Unsuccessful");
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