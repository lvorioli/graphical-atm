package view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ViewManager;

@SuppressWarnings("serial")
public class HomeView extends JPanel implements ActionListener {
	
	private ViewManager manager;		// manages interactions between the views, model, and database
	private JButton depositButton;
	private JButton withdrawButton;
	private JButton transferButton;
	private JButton personalInformationButton;
	private JButton closeAccountButton;
	private JButton logoutButton;
	private JButton powerButton;
	private JLabel errorMessageLabel;
	
	/**
	 * Constructs an instance (or objects) of the HomeView class.
	 * 
	 * @param manager
	 */
	
	public HomeView(ViewManager manager) {
		super();
		
		this.manager = manager;
		initialize();
	}
	
	///////////////////// PRIVATE METHODS /////////////////////////////////////////////
	
	/*
	 * Initializes the HomeView components.
	 */
	
	private void initialize() {
		this.setLayout(null);
		// TODO
		//
		// this is a placeholder for this view and should be removed once you start
		// building the HomeView.
		
		this.add(new javax.swing.JLabel("HomeView", javax.swing.SwingConstants.CENTER));
		
		initDepositButton();
		initWithdrawButton();
		initTransferButton();
		initPersonalInformationButton();
		initCloseAccountButton();
		initLogoutButton();
		//initErrorMessageLabel();
		initPowerButton();
	}
	
	
	private void initDepositButton() {
		depositButton = new JButton("Deposit");
		depositButton.setBounds(126, 50, 200, 35);
		depositButton.addActionListener(this);
		
		this.add(depositButton);
	}
	private void initWithdrawButton() {
		withdrawButton = new JButton("Withdraw");
		withdrawButton.setBounds(126, 90, 200, 35);
		withdrawButton.addActionListener(this);
		
		this.add(withdrawButton);
	}
	private void initTransferButton() {
		transferButton = new JButton("Transfer");
		transferButton.setBounds(126, 130, 200, 35);
		transferButton.addActionListener(this);
		
		this.add(transferButton);
	}
	private void initPersonalInformationButton() {
		personalInformationButton = new JButton("Personal Information");
		personalInformationButton.setBounds(126, 170, 200, 35);
		personalInformationButton.addActionListener(this);
		
		this.add(personalInformationButton);
	}
	private void initCloseAccountButton() {
		closeAccountButton = new JButton("Close Account");
		closeAccountButton.setBounds(126, 210, 200, 35);
		closeAccountButton.addActionListener(this);
		
		this.add(closeAccountButton);
	}
	private void initLogoutButton() {
		logoutButton = new JButton("Logout");
		logoutButton.setBounds(126, 250, 200, 35);
		logoutButton.addActionListener(this);
		
		this.add(logoutButton);
	}
	
	private void initPowerButton() {
		powerButton = new JButton();
		powerButton.setBounds(5, 5, 50, 50);
		powerButton.addActionListener(this);
		
		try {
			Image image = ImageIO.read(new File("images/power-off.png"));
			powerButton.setIcon(new ImageIcon(image));
		} catch (Exception e) {
			powerButton.setText("OFF");
		}
		
		this.add(powerButton);
	}
	/*
	 * HomeView is not designed to be serialized, and attempts to serialize will throw an IOException.
	 * 
	 * @param oos
	 * @throws IOException
	 */
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		throw new IOException("ERROR: The HomeView class is not serializable.");
	}
	
	///////////////////// OVERRIDDEN METHODS //////////////////////////////////////////
	
	/*
	 * Responds to button clicks and other actions performed in the HomeView.
	 * 
	 * @param e
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO
		//
		// this is where you'll setup your action listener, which is responsible for
		// responding to actions the user might take in this view (an action can be a
		// user clicking a button, typing in a textfield, etc.).
		//
		// feel free to use my action listener in LoginView.java as an example.
	}
}