package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ViewManager;

@SuppressWarnings("serial")
public class CreateView extends JPanel implements ActionListener {
	
	private ViewManager manager;		// manages interactions between the views, model, and database
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JComboBox birthDateComboBox;
	private JTextField phoneNumberField;
	private JTextField streetAddressField;
	private JTextField cityField;
	private JComboBox stateComboBox;
	private JTextField postalCodeField;
	private JTextField pinField;
	
	
	/**
	 * Constructs an instance (or object) of the CreateView class.
	 * 
	 * @param manager
	 */
	
	public CreateView(ViewManager manager) {
		super();
		
		this.manager = manager;
		initialize();
	}
	
	///////////////////// PRIVATE METHODS /////////////////////////////////////////////
	
	/*
	 * Initializes the CreateView components.
	 */
	
	private void initialize() {
		this.setLayout(null);
		// TODO
		//
		// this is a placeholder for this view and should be removed once you start
		// building the CreateView.
		
		this.add(new javax.swing.JLabel("CreateView", javax.swing.SwingConstants.CENTER));
		
		initFirstNameField();
		initLastNameField();
	//	initBirthDateComboBox();
		initPhoneNumberField();
		initAddressField();
		initCityField();
		initStateComboBox();
	}
	
	private void initFirstNameField(){
		JLabel label = new JLabel("First Name: ", SwingConstants.RIGHT);
		label.setBounds(100, 100, 95, 35);
		label.setLabelFor(firstNameField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		firstNameField = new JTextField(20);
		firstNameField.setBounds(205, 100, 200, 35);
		firstNameField.addActionListener(this);
		
		this.add(label);
		this.add(firstNameField);
	}
	
	private void initLastNameField(){
		JLabel label = new JLabel("Last Name: ", SwingConstants.RIGHT);
		label.setBounds(100, 140, 95, 35);
		label.setLabelFor(lastNameField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		lastNameField = new JTextField(20);
		lastNameField.setBounds(205, 140, 200, 35);
		lastNameField.addActionListener(this);
		
		this.add(label);
		this.add(lastNameField);
	}
	
	private void initPhoneNumberField() {
		//FIX TEXT FORMAT
		JLabel label = new JLabel("Phone Number: ", SwingConstants.RIGHT);
		label.setBounds(80, 220, 120, 35);
		label.setLabelFor(phoneNumberField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		phoneNumberField = new JTextField(20);
		phoneNumberField.setBounds(205, 220, 200, 35);
		phoneNumberField.addActionListener(this);
		
		this.add(label);
		this.add(phoneNumberField);
	}
	
	private void initAddressField() {
		JLabel label = new JLabel("Address: ", SwingConstants.RIGHT);
		label.setBounds(100, 260, 95, 35);
		label.setLabelFor(streetAddressField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		streetAddressField = new JTextField(20);
		streetAddressField.setBounds(205, 260, 200, 35);
		streetAddressField.addActionListener(this);
		
		this.add(label);
		this.add(streetAddressField);
	}
	private void initCityField() {
		JLabel label = new JLabel("City: ", SwingConstants.RIGHT);
		label.setBounds(100, 300, 95, 35);
		label.setLabelFor(cityField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		cityField = new JTextField(20);
		cityField.setBounds(205, 300, 200, 35);
		cityField.addActionListener(this);
		
		this.add(label);
		this.add(cityField);
	}
	private void initStateComboBox(){
		JLabel label = new JLabel("State: ", SwingConstants.RIGHT);
		label.setBounds(100, 340, 95, 35);
		label.setLabelFor(stateComboBox);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		String[] dates = {"Alabama", "Alaska", "Arizona", "Arkansas", "California",
		        "Colorado", "Connecticut", "Delaware", "Florida", "Georgia",
		        "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas",
		        "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts",
		        "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana",
		        "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico",
		        "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma",
		        "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
		        "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia",
		        "Wisconsin", "Wyoming"};
		stateComboBox = new JComboBox(dates);
		stateComboBox.setBounds(205, 340, 200, 35);
		stateComboBox.addActionListener(this);
		
		this.add(label);
		this.add(stateComboBox);
	}
	
	
	/*
	 * CreateView is not designed to be serialized, and attempts to serialize will throw an IOException.
	 * 
	 * @param oos
	 * @throws IOException
	 */
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		throw new IOException("ERROR: The CreateView class is not serializable.");
	}
	
	///////////////////// OVERRIDDEN METHODS //////////////////////////////////////////
	
	/*
	 * Responds to button clicks and other actions performed in the CreateView.
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