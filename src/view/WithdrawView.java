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
public class WithdrawView extends JPanel implements ActionListener {
	
	private ViewManager manager;
	private JTextField withdrawAmountField;
	private JButton withdrawButton;
	private JButton exitButton;
	
	
	
	public WithdrawView(ViewManager manager) {
		super();
		
		this.manager = manager;
		initialize();
	}
	
	private void initialize() {
		this.setLayout(null);
	
		this.add(new javax.swing.JLabel("WithdrawView", javax.swing.SwingConstants.CENTER));
		initWithdrawAmountField();
		initWithdrawButton();
		initExitButton();
	}
	
	private void initWithdrawAmountField() {
		JLabel label = new JLabel("Withdraw Amount: ", SwingConstants.RIGHT);
		label.setBounds(25, 140, 140, 35);
		label.setLabelFor(withdrawAmountField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		withdrawAmountField = new JTextField(20);
		withdrawAmountField.setBounds(160, 140, 200, 35);
		withdrawAmountField.addActionListener(this);
		
		this.add(label);
		this.add(withdrawAmountField);
	}
	
	private void initWithdrawButton() {
		withdrawButton = new JButton("Withdraw");
		withdrawButton.setBounds(100, 300, 200, 35);
		withdrawButton.addActionListener(this);
		
		this.add(withdrawButton);
	}
	
	private void initExitButton() {
		exitButton = new JButton("Exit");
		exitButton.setBounds(310, 300, 100, 35);
		exitButton.addActionListener(this);
		
		this.add(exitButton);
	}
	
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		throw new IOException("ERROR: The WithdrawView class is not serializable.");
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
		
		if(source.equals(withdrawButton)) {
			if(manager.withdraw(Double.parseDouble(withdrawAmountField.getText())) == true) {
				System.out.println("Withdraw Successful");
				manager.switchTo(ATM.HOME_VIEW);
			}
			else {
				System.out.println("Withdraw Unsuccessful");
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