
/*
 * Description: This programs lets users know whether they stand a chance to be admitted into their program solely based off of averages
 * Author: Kashan Ahmad
 * Date: May 16, 2023
 * Version 1.0: No changes made yet
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.text.DecimalFormat;

public class ApplicationWindow {

	private JFrame frame;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtMark;

	/**
	 * Launch the application.
	 */
	static String[][] studentData = new String[90000][9];// the 2d array that holds studentData
	static ArrayList<ArrayList<String>> tempStudentData = new ArrayList(); // student data
	// variables for user entered data
	static String FirstName;
	static String LastName;
	static String firstUni;
	static String secondUni;
	static String thirdUni;
	static String firstUniDegree;
	static String secondUniDegree;
	static String thirdUniDegree;
	static String userMark;
	// boolean variable to let program know when datasets are empty
	public static boolean start = true;
	public static boolean restart = false;
	static ArrayList<ArrayList<String>> programs = new ArrayList(); // arraylist to hold programs

	// objects
	static UniversityChoices UniChoice = new UniversityChoices();
	static Students student = new Students();

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow window = new ApplicationWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		// Intial popup message
		JOptionPane.showMessageDialog(null,
				"Hi there! Welcome to Universify. \nWe understand that waiting for university offers can be stressful, \nwhich is why we created Universify to help ease some of that stress"
						+ "\nThis program analyzes wheter you may be accepted, waitlisted or rejected to your applied programs \nsolely based off of your average, and other voluntary student averages"
						+ "\nWe are in testing stages for this program, and would appreciate any feedback. \n"
						+ "As we are in testing stages, we can only offer the University of Toronto programs at the moment"
						+ "\nand you will only receive round 1 offers\n\n" + "Terms and conditions:"
						+ "\nYou agree to share the data inputted with other users to determine the posibility of your offers"
						+ "\nYou acknowledge that the offer received from this program has no correspondence to your actual offers"
						+ "\nand plays no role in the decision processs\n"
						+ "By clicking OK, you agree to the terms and conditions",
				"Welcome", JOptionPane.INFORMATION_MESSAGE);

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setForeground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setLayout(null);

		JLabel ApplicationTitle = new JLabel("Universify");
		ApplicationTitle.setForeground(Color.WHITE);
		ApplicationTitle.setBackground(Color.WHITE);
		ApplicationTitle.setFont(new Font("Tahoma", Font.PLAIN, 33));
		ApplicationTitle.setHorizontalAlignment(SwingConstants.CENTER);
		ApplicationTitle.setBounds(20, 11, 647, 57);
		frame.getContentPane().add(ApplicationTitle);

		JLabel UserFirstNameLabel = new JLabel("Please Enter Your First Name:");
		UserFirstNameLabel.setForeground(Color.WHITE);
		UserFirstNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		UserFirstNameLabel.setBounds(20, 99, 206, 14);
		frame.getContentPane().add(UserFirstNameLabel);

		txtFirstName = new JTextField();
		txtFirstName.setBackground(new Color(255, 250, 205));
		txtFirstName.setBounds(222, 98, 132, 20);
		frame.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);

		JLabel UserLastNameLabel = new JLabel("Please Enter Your Last Name:");
		UserLastNameLabel.setForeground(Color.WHITE);
		UserLastNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		UserLastNameLabel.setBounds(20, 145, 206, 14);
		frame.getContentPane().add(UserLastNameLabel);

		txtLastName = new JTextField();
		txtLastName.setBackground(new Color(255, 250, 205));
		txtLastName.setColumns(10);
		txtLastName.setBounds(222, 144, 132, 20);
		frame.getContentPane().add(txtLastName);

		JLabel UserAverageLabel = new JLabel("Please Enter Your Grade 12 Average:");
		UserAverageLabel.setForeground(Color.WHITE);
		UserAverageLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		UserAverageLabel.setBounds(360, 99, 250, 20);
		frame.getContentPane().add(UserAverageLabel);

		txtMark = new JTextField();
		txtMark.setBackground(new Color(255, 250, 205));
		txtMark.setColumns(10);
		txtMark.setBounds(620, 98, 57, 20);
		frame.getContentPane().add(txtMark);

		JComboBox comboBox_Uni1Degree = new JComboBox();
		comboBox_Uni1Degree.setBackground(new Color(255, 250, 205));
		comboBox_Uni1Degree.setModel(new DefaultComboBoxModel(new String[] { "Select University To View Programs" }));
		comboBox_Uni1Degree.setFont(new Font("Tahoma", Font.PLAIN, 10));
		comboBox_Uni1Degree.setToolTipText("");
		comboBox_Uni1Degree.setBounds(188, 318, 489, 22);
		frame.getContentPane().add(comboBox_Uni1Degree);
		frame.setBounds(100, 100, 699, 516);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JComboBox comboBox_Uni2Degree = new JComboBox();
		comboBox_Uni2Degree.setBackground(new Color(255, 250, 205));
		comboBox_Uni2Degree.setFont(new Font("Tahoma", Font.PLAIN, 10));
		comboBox_Uni2Degree.setModel(new DefaultComboBoxModel(new String[] { "Select University To View Programs" }));
		comboBox_Uni2Degree.setToolTipText("");
		comboBox_Uni2Degree.setBounds(188, 360, 489, 22);
		frame.getContentPane().add(comboBox_Uni2Degree);

		JComboBox comboBox_Uni3Degree = new JComboBox();
		comboBox_Uni3Degree.setBackground(new Color(255, 250, 205));
		comboBox_Uni3Degree.setFont(new Font("Tahoma", Font.PLAIN, 10));
		comboBox_Uni3Degree.setModel(new DefaultComboBoxModel(new String[] { "Select University To View Programs" }));
		comboBox_Uni3Degree.setToolTipText("");
		comboBox_Uni3Degree.setBounds(188, 396, 489, 22);
		frame.getContentPane().add(comboBox_Uni3Degree);

		JLabel lblPleaseEnterFirst = new JLabel("Please Enter First Priority University:");
		lblPleaseEnterFirst.setForeground(Color.WHITE);
		lblPleaseEnterFirst.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPleaseEnterFirst.setBounds(20, 189, 250, 20);
		frame.getContentPane().add(lblPleaseEnterFirst);

		JComboBox comboBox_Uni1 = new JComboBox();
		comboBox_Uni1.setBackground(new Color(255, 250, 205));
		comboBox_Uni1.setModel(new DefaultComboBoxModel(new String[] { "Universities:", "University of Toronto",
				"University of Waterloo", "McMaster University", "University of Ottawa", "Carleton University",
				"Toronto Metropolitan University", "Ontario Tech University", "Western University", "York University",
				"University of Guelph", "Queens University", "Algoma University", "Brock University",
				"Lakehead University", "Laurentian University", "Nipissing University", "OCAD University",
				"Trent University", "Wilfrid Laurier University", "University of Windsor" }));
		comboBox_Uni1.setBounds(291, 190, 211, 22);
		comboBox_Uni1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// what happens when uni 1 combo box option is updated

				// call method to update degree combobox based on degrees offered by university
				// chosen
				UpdateComboBox(comboBox_Uni1, comboBox_Uni1Degree);

			}
		});

		frame.getContentPane().add(comboBox_Uni1);

		JLabel lblPleaseEnterSecond = new JLabel("Please Enter Second Priority University:");
		lblPleaseEnterSecond.setForeground(Color.WHITE);
		lblPleaseEnterSecond.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPleaseEnterSecond.setBounds(20, 220, 274, 20);
		frame.getContentPane().add(lblPleaseEnterSecond);

		JComboBox comboBox_Uni2 = new JComboBox();
		comboBox_Uni2.setBackground(new Color(255, 250, 205));
		comboBox_Uni2.setModel(new DefaultComboBoxModel(new String[] { "Universities:", "University of Toronto",
				"University of Waterloo", "McMaster University", "University of Ottawa", "Carleton University",
				"Toronto Metropolitan University", "Ontario Tech University", "Western University", "York University",
				"University of Guelph", "Queens University", "Algoma University", "Brock University",
				"Lakehead University", "Laurentian University", "Nipissing University", "OCAD University",
				"Trent University", "Wilfrid Laurier University", "University of Windsor" }));
		comboBox_Uni2.setToolTipText("");
		comboBox_Uni2.setBounds(291, 223, 211, 22);
		comboBox_Uni2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// what happens when uni2 combobox is updated

				// call method to update degree combobox based on degrees offered by university
				// chosen
				UpdateComboBox(comboBox_Uni2, comboBox_Uni2Degree);

			}
		});
		frame.getContentPane().add(comboBox_Uni2);

		JLabel lblPleaseEnterThird = new JLabel("Please Enter Third Priority University:");
		lblPleaseEnterThird.setForeground(Color.WHITE);
		lblPleaseEnterThird.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPleaseEnterThird.setBounds(20, 251, 257, 20);
		frame.getContentPane().add(lblPleaseEnterThird);

		JComboBox comboBox_Uni3 = new JComboBox();
		comboBox_Uni3.setBackground(new Color(255, 250, 205));
		comboBox_Uni3.setModel(new DefaultComboBoxModel(new String[] { "Universities:", "University of Toronto",
				"University of Waterloo", "McMaster University", "University of Ottawa", "Carleton University",
				"Toronto Metropolitan University", "Ontario Tech University", "Western University", "York University",
				"University of Guelph", "Queens University", "Algoma University", "Brock University",
				"Lakehead University", "Laurentian University", "Nipissing University", "OCAD University",
				"Trent Unviersity", "Wilfrid Laurier University", "University of Windsor" }));
		comboBox_Uni3.setToolTipText("");
		comboBox_Uni3.setBounds(291, 252, 211, 22);
		comboBox_Uni3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// what happens when uni3 combobox is updated

				// call method to update degree combobox based on degrees offered by university
				// chosen
				UpdateComboBox(comboBox_Uni3, comboBox_Uni3Degree);

			}
		});
		frame.getContentPane().add(comboBox_Uni3);

		JLabel lblFirstUniversityProgram = new JLabel("First University Program");
		lblFirstUniversityProgram.setForeground(Color.WHITE);
		lblFirstUniversityProgram.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFirstUniversityProgram.setBounds(5, 317, 170, 20);
		frame.getContentPane().add(lblFirstUniversityProgram);

		JLabel lblSecondUniversityProgram = new JLabel("Second University Program");
		lblSecondUniversityProgram.setForeground(Color.WHITE);
		lblSecondUniversityProgram.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSecondUniversityProgram.setBounds(5, 359, 178, 20);
		frame.getContentPane().add(lblSecondUniversityProgram);

		JLabel lblThirdUniversityProgram = new JLabel("Third University Program");
		lblThirdUniversityProgram.setForeground(Color.WHITE);
		lblThirdUniversityProgram.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThirdUniversityProgram.setBounds(5, 395, 178, 20);
		frame.getContentPane().add(lblThirdUniversityProgram);

		JButton submitButton = new JButton("Submit");
		submitButton.setForeground(Color.WHITE);
		submitButton.setBackground(new Color(123, 104, 238));
		submitButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// what happens when submit button is clicked
				restart(tempStudentData);// make sure student data array list is cleared

				// check if user can proceed
				double mark;
				try {

					mark = Double.parseDouble(txtMark.getText());

					if (mark < 0 || mark > 100)// negative mark not possible and over 100 not possible
						mark = -1; // if user mark is not valid, set mark to -1
				} catch (Exception e2) {// code for improper converting
					mark = -1;
				}

				// store user entered degree and degree options
				String Uni1 = comboBox_Uni1.getSelectedItem().toString();
				String Uni1Degree = comboBox_Uni1Degree.getSelectedItem().toString();
				String Uni2 = comboBox_Uni2.getSelectedItem().toString();
				String Uni2Degree = comboBox_Uni2Degree.getSelectedItem().toString();
				String Uni3 = comboBox_Uni3.getSelectedItem().toString();
				String Uni3Degree = comboBox_Uni3Degree.getSelectedItem().toString();

				// check if all elements of program are filled before proceeding
				if (txtFirstName.getText().equals(null) || txtLastName.getText().equals(null) || mark == -1
						|| comboBox_Uni1.getSelectedItem().equals("Universities:")
						|| comboBox_Uni2.getSelectedItem().equals("Universities:")
						|| comboBox_Uni3.getSelectedItem().equals("Universities:")
						|| ((Uni1.equals(Uni2)) && (Uni1Degree.equals(Uni2Degree)))
						|| ((Uni1.equals(Uni3)) && (Uni1Degree.equals(Uni3Degree)))
						|| ((Uni2.equals(Uni3)) && (Uni2Degree.equals(Uni3Degree)))) {// also check if user entered
																						// proper number
					JOptionPane.showMessageDialog(null,
							"Sorry, application is not completed, or is not completed properly", "Warning",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (!Uni1.equals("University of Toronto") && !Uni2.equals("University of Toronto")
						&& !Uni3.equals("University of Toronto")) {
					JOptionPane.showMessageDialog(null,
							"Please ensure that you are applying to atleast 1 program from the University of Toronto",
							"Warning", JOptionPane.INFORMATION_MESSAGE); // make sure atleat 1 uni chosen is the
																			// University of Toronto for tetsing
																			// purposes
				} else { // if everything clear, proceed
					// get first name
					String tempFirstName = txtFirstName.getText();
					tempFirstName = tempFirstName.toLowerCase();// make user input into lowercase letters
					// tempFirstName.substring(0, 1).toUpperCase(); // first letter
					// tempFirstName.substring(1); // after 1st letter
					FirstName = tempFirstName.substring(0, 1).toUpperCase() + tempFirstName.substring(1);
					// made first letter capital and rest lowercase:
					// System.out.println(FirstName);

					// get second name
					String tempLastName = txtLastName.getText();
					tempLastName = tempLastName.toLowerCase();

					LastName = tempLastName.substring(0, 1).toUpperCase() + tempLastName.substring(1);

					// System.out.println(LastName);

					// format the average into maximum 2 decimals
					// reference: used ChatGPT to figure out how to format decimal, as the
					// numberFormat was was not working
					// prompt: Prompt: why am i getting an error? double
					// randomNumber = (double) ((Math.random() * 40) + 61);
					// randomNumber = nf.format(randomNumber); <----- part of prompt

					DecimalFormat decimalFormat = new DecimalFormat("0.00");
					String formattedNumber = decimalFormat.format(mark);
					userMark = formattedNumber; // format the inputted average to 2 decimal places
					// System.out.println(userMark);

					// STORE user entered university into university variables
					firstUni = comboBox_Uni1.getSelectedItem().toString();
					secondUni = comboBox_Uni2.getSelectedItem().toString();
					thirdUni = comboBox_Uni3.getSelectedItem().toString();

					// store user entered university degree into university degree variables
					firstUniDegree = comboBox_Uni1Degree.getSelectedItem().toString();
					// System.out.println(firstUniDegree);
					secondUniDegree = comboBox_Uni2Degree.getSelectedItem().toString();
					// System.out.println(secondUniDegree);
					thirdUniDegree = comboBox_Uni3Degree.getSelectedItem().toString();
					// System.out.println(thirdUniDegree);

					// store variables into studentData 2d array
					studentData[0][0] = FirstName;
					studentData[0][1] = LastName;
					studentData[0][2] = firstUni;
					studentData[0][3] = secondUni;
					studentData[0][4] = thirdUni;
					studentData[0][5] = firstUniDegree;
					studentData[0][6] = secondUniDegree;
					studentData[0][7] = thirdUniDegree;
					studentData[0][8] = userMark;

					// intialize randomized first name for other students to populate dataset
					student.InitializeRandFirstName(studentData);
					// intialize randomized last name for other students to populate dataset
					student.InitializeRandLastName(studentData);
					// intialize randomized marks for other students to populate dataset
					student.InitializeRandMarks(studentData);
					// intialize randomized university for other students to populate dataset
					UniChoice.initializeRandUnis(studentData, programs);

					// System.out.println("");
					// System.out.println("Sorted array");
					// call method to sort array based off of highest mark to lowest mark
					studentData = SortingData(studentData, 8); // place the 2d array as a parameter and column 8, as
																// that's where the averages are held

					// copy sorted studentData into 2d arraylist
					for (int tempRow = 0; tempRow < studentData.length; tempRow++) {
						ArrayList<String> tempArray = new ArrayList();
						for (int tempCol = 0; tempCol < studentData[0].length; tempCol++) {
							tempArray.add(studentData[tempRow][tempCol]);
						}
						tempStudentData.add(tempArray);
					}
					// System.out.println(tempStudentData);

					if (JOptionPane.showConfirmDialog(null, "Do you want to write studentData into file", "File Writer",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						writeFile(studentData);
					}

					// get each university characteristics
					// intliize each program random average cutoff and program capacity
					UniChoice.ProgramCutoff(programs, restart);
					restart = false;
					// System.out.println(programs);
					UniChoice.programDecisions(programs, tempStudentData);
					// System.out.println(programs);
					if (JOptionPane.showConfirmDialog(null,
							"Do you want to write the dataset with round 1 of admissions into file", "File Writer",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						writeRound1File(tempStudentData);
					}

					// search for where user is placed in dataset just solely based on average
					double key = Double.parseDouble(userMark);
					int left = 0; // set left value to zero
					int right = tempStudentData.size() - 1; // set right value to the last 'spot' in array
					int mid = right / 2; // set the initial middle number

					int result = SearchNumber2(tempStudentData, left, right, key, mid, 8);
					if (result == -1)
						System.out.println("Element is not found or your array is not sorted");
					System.out.println();

					start = restartPrograms(programs, comboBox_Uni1, comboBox_Uni2, comboBox_Uni3, comboBox_Uni1Degree,
							comboBox_Uni2Degree, comboBox_Uni3Degree); // reset programs
					// arraylist
				}
			}
		});
		submitButton.setBounds(535, 433, 132, 35);
		frame.getContentPane().add(submitButton);

	}

	// this method updates the degree comboboxes based on the programs offered by
	// the
	// university chosen by user
	// @param: JComboBox comboBox_Uni - the university combobox. JComboBox
	// comboBox_UniDegree - the degree combobox that needs to be updated
	// @return: n/a
	public static void UpdateComboBox(JComboBox comboBox_Uni, JComboBox comboBox_UniDegree) {
		String[] test = { "No program available" };

		// if the university chosen by user if U of T
		if (comboBox_Uni.getSelectedItem().equals("University of Toronto")) {
			// check if program started
			start = updateStart(start);
			// read the file that contains the programs offered by u of t, and update the
			// degree combobox
			readUniversityOfTorontoPrograms(comboBox_Uni, comboBox_UniDegree, "University of Toronto", start);
		}
		// the rest: still work in progress; have not put the programs offered by these
		// universities in a file
		else if (comboBox_Uni.getSelectedItem().equals("University of Waterloo")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		} else if (comboBox_Uni.getSelectedItem().equals("McMaster University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		} else if (comboBox_Uni.getSelectedItem().equals("University of Ottawa")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		} else if (comboBox_Uni.getSelectedItem().equals("Carleton University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		} else if (comboBox_Uni.getSelectedItem().equals("Toronto Metropolitan University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		} else if (comboBox_Uni.getSelectedItem().equals("Ontario Tech University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		} else if (comboBox_Uni.getSelectedItem().equals("Western University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		} else if (comboBox_Uni.getSelectedItem().equals("York University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		} else if (comboBox_Uni.getSelectedItem().equals("University of Guelph")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		} else if (comboBox_Uni.getSelectedItem().equals("Queens University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		} else if (comboBox_Uni.getSelectedItem().equals("Algoma University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		} else if (comboBox_Uni.getSelectedItem().equals("Brock University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		} else if (comboBox_Uni.getSelectedItem().equals("Lakehead University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		} else if (comboBox_Uni.getSelectedItem().equals("Laurentian University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		} else if (comboBox_Uni.getSelectedItem().equals("Nipissing University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		} else if (comboBox_Uni.getSelectedItem().equals("OCAD University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		} else if (comboBox_Uni.getSelectedItem().equals("Trent University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		} else if (comboBox_Uni.getSelectedItem().equals("Wilfrid Laurier University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		} else if (comboBox_Uni.getSelectedItem().equals("University of Windsor")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		}
	}

	// this method reads the file that contains the program offered by the
	// university chosen, stores them into a 2d arraylist, and updates the combobox
	// options
	// @param: JComboBox comboBox_Uni - the university combobox. JComboBox
	// comboBox_UniDegree - the degree combobox that needs to be updated
	// university - which universities programs should be read and updated. Start -
	// to see whether dataSets are empty or not
	// @return: n/a
	public static void readUniversityOfTorontoPrograms(JComboBox comboBox_Uni, JComboBox comboBox_UniDegree,
			String university, boolean start) {

		String fileName = university + "_Programs.txt"; // the name of the text file containing the university programs
		int count = 0;
		// the first time I read the file, I find out how many lines there are, so I can
		// create an array according to the amount of lines
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			String line = in.readLine(); // skip first line

			line = in.readLine();
			while (line != null) // while not end of file, when value is null
			{

				line = in.readLine();

				count++;// count how many lines there are, by increasing the count by 1 each time we
						// read through the line

			}

			// System.out.println("your file has " + count + " lines");
			in.close();

		} catch (IOException iox) {
			System.out.println("Problem reading " + fileName);
		}
		System.out.println(" ");

		String[][] data = new String[count][2];// create the 2d array, by having the same amount of rows as the file
		// that we read

		try { // this time, when we read the file, we want to put the data into a 2d array
			String fileName1 = university + "_Programs.txt";
			BufferedReader read = new BufferedReader(new FileReader(fileName1));
			String line1 = read.readLine(); // skip first line
			int row = 0;
			line1 = read.readLine();
			while (line1 != null) // while not end of file
			{

				String[] values = line1.split("\t"); // split the elements at each comma, and store in 1D array

				for (int col = 0; col < values.length; col++) { // iterate through the column's of the row being looked
																// at,
					// this loop will go through all the values of the columns of the 2d and 1d
					// array, and store them in
					// the 2d array row, according to the row number being looked at
					data[row][col] = values[col]; // give the index the value
				}
				row++;// for the next 'loop', look at the next array
				line1 = read.readLine();

			}
			read.close();
		} catch (IOException iox) { // exception
			System.out.println("Problem reading " + fileName);
		}

		// created a 1d array to just store the program name, which will be shown in
		// combobox
		String[] tempCourseName = new String[count];
		// String [] tempCourseCode = new String[count];

		for (int i = 0; i < tempCourseName.length; i++) {
			// tempData[i] = data[i][0] + " " + data[i][1];//copy course name and course
			// code
			tempCourseName[i] = data[i][0];// copy program name
			// tempCourseCode[i] = data[i][1];
			// System.out.println(tempCourseName[i]);
		}
		// update the degree combobox with degrees offered by uni chosen
		comboBox_UniDegree.setModel(new DefaultComboBoxModel(tempCourseName));

		// if programs arraylist is not clear/empty
		if (start != true) {

			// check if program codes are equal by comparing the first program code of both
			// datasets
			// do not copy if they are same, as this means that programs is already updated
			// with the university programs
			if (!(data[0][1].toString().equals(programs.get(0).get(1).toString()))) { // if program codes not equal
				System.out.println("made it here!2"); // temp for tetsing
				// copy info from data 2d array to programs 2d arraylist for greater flexibility
				for (int i = 0; i < data.length; i++) {
					ArrayList<String> tempArray = new ArrayList();
					for (int col = 0; col < data[0].length; col++) {
						tempArray.add(data[i][col]);
					}
					programs.add(tempArray); // copy programs into array list
				}
			}

		}
		// if programs 2d arraylist is empty/clear, copy data 2d array into programs
		// arraylist for greater flexibility
		else if (start == true) {
			// copy data 2d array into arraylist
			for (int i = 0; i < data.length; i++) {
				ArrayList<String> tempArray = new ArrayList();
				for (int col = 0; col < data[0].length; col++) {
					tempArray.add(data[i][col]);
				}
				programs.add(tempArray); // copy programs into array list
			}
			start = false;// set start equal to false
		}

	}

	// this method sorts the data based on highest average to lowest average for
	// comparing purposes
	// @param: array is the dataSet that contains studentData, col is the column
	// where the averages are stored
	// @return: update the 2d array to the sorted 2d array
	// Reference: Used chatGPT to give me the code structure for the merge sort:
	// Prompt: code for merge sort to sort to descending data
	private static String[][] SortingData(String[][] array, int col) {
		// if the array has only 1 row, then return it, as no sorting is needed
		if (array.length <= 1) {
			return array;
		}

		// divide the array into 2 halves
		int mid = array.length / 2;
		String[][] left = new String[mid][array[0].length];
		String[][] right = new String[array.length - mid][array[0].length];

		// fill the left array until middle
		for (int i = 0; i < mid; i++) {
			left[i] = array[i];
		}
		// fill the right array until the middle
		for (int i = mid; i < array.length; i++) {
			right[i - mid] = array[i];
		}

		// recursively sort the right and left arrays
		left = SortingData(left, col);
		right = SortingData(right, col);

		// merge the sorted left and right array
		return merge(left, right, col);
	}

	// this method merges the left and right array created by the SortingDataMethod:
	// @param: left array, right array, the column we want to sort by
	// @return: the merged array
	// Reference: Used chatGPT to give me the code structure for the merge sort:
	// Prompt: code for merge sort to sort to descending data
	private static String[][] merge(String[][] left, String[][] right, int col) {
		// create a merged array that will hold the sorted data
		String[][] merged = new String[left.length + right.length][left[0].length];
		int leftIndex = 0;
		int rightIndex = 0;
		int mergedIndex = 0;

		// compare the right and left array elements, and merge them in the correct
		// order
		while (leftIndex < left.length && rightIndex < right.length) {
			double leftValue = Double.parseDouble(left[leftIndex][col]);
			double rightValue = Double.parseDouble(right[rightIndex][col]);

			// compare the elements in the column
			if (leftValue > rightValue) {
				merged[mergedIndex++] = left[leftIndex++];
			} else {
				merged[mergedIndex++] = right[rightIndex++];
			}
		}

		// copy the rest of the elements from left array
		while (leftIndex < left.length) {
			merged[mergedIndex++] = left[leftIndex++];
		}

		// copy rest of elements from right array
		while (rightIndex < right.length) {
			merged[mergedIndex++] = right[rightIndex++];
		}

		// return the merged array
		return merged;
	}

	// this method writes the studentData dataset(2d array) into a file
	// @param: studentData is the 2d array that contaisn the data
	// @return: none
	public static void writeFile(String[][] studentData) {
		String filename = "Student_Info";// create file called

		// write the file
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

			writer.write("First Name/ " + "Last Name/ " + "University/ " + "Mark"); // print out the column titles
			writer.newLine();

			for (int row = 0; row < studentData.length; row++) { // go through every row of 2d array
				for (int col = 0; col < studentData[row].length; col++) { // go through every col of every row of 2d

					writer.write(studentData[row][col] + "\t");// write it in file
				}
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("There is a problem with writing into " + filename);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Wrote file!!!! Check it out");

	}

	// this method writes the studentData dataset(2d arraylist) into a file
	// @param: studentData is the 2d array that contains the data
	// @return: none
	public static void writeRound1File(ArrayList<ArrayList<String>> studentData) {
		String filename = "Student_Info_Round1";// create file called

		// write the file
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

			writer.write("First Name/ " + "Last Name/ " + "University/ " + "Mark"); // print out the column titles
			writer.newLine();

			for (int row = 0; row < studentData.size(); row++) { // go through every row of 2d array
				for (int col = 0; col < studentData.get(row).size(); col++) { // go through every col of every row of 2d

					writer.write(studentData.get(row).get(col) + "\t");// write it in file
				}
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("There is a problem with writing into " + filename);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Wrote file for round 1 offers!!!! Check it out");

	}

	// this method updates the start varaiable, by seeing if the programs 2d array
	// list is empty or not
	// @param: start is the boolean variables that tells program wheter it is
	// starting
	// @return: the updated value of the start variable
	public static boolean updateStart(boolean start) {
		if (programs.isEmpty()) { // if programs does not contain any data, then it is empty, which means program
									// has started or resetted
			return true; // so return true
		} else
			return false;
	}

	// this method searches for the user's averages, and where it is whithin the
	// studentdata set
	// @param: array is the 2D array,
	// left is the left end of the sub array
	// right is the right end of the sub array,
	// key is the user average program wants to find
	// mid is the middle of the sub array,
	// col is the column we search for
	// @return: the row at which the data is found
	private static int SearchNumber2(ArrayList<ArrayList<String>> studentData, int left, int right, double key, int mid,
			int col) {

		if (Double.parseDouble(studentData.get(right).get(col)) <= Double.parseDouble(studentData.get(left).get(col))) { // check
																															// to
																															// see
																															// if
																															// sorted

			if (key == Double.parseDouble(studentData.get(mid).get(col))) { // if user value is found at the middle row
				for (int i = mid; i >= 0; i--) { // go through this for loop so we can insure that we find the
													// initial(first) value
					if (key == Double.parseDouble(studentData.get(i).get(col)))
						mid = i; // update mid value
					else if (key != Double.parseDouble(studentData.get(i).get(col))) // if the index value is not equal
																						// to the key value,
						// then exit out of for loop
						break;
				}
				if (Double.parseDouble(studentData.get(mid).get(col)) == Double
						.parseDouble(studentData.get(studentData.size() - 1).get(col))) {
					// if user value is found at last index in array, then return mid becasue
					// there are no duplicates
					System.out.print("Your number was found in row " + mid);

					String Offer1 = studentData.get(mid).get(9);
					String Offer2 = studentData.get(mid).get(10);
					String Offer3 = studentData.get(mid).get(11);
					JOptionPane.showMessageDialog(null,
							"You are likley to receive a(n) " + Offer1.toLowerCase() + " letter for " + firstUniDegree
									+ " at " + firstUni + "\nYou are likley to receive a(n) " + Offer2.toLowerCase()
									+ " letter for " + secondUniDegree + " at " + secondUni
									+ "\nYou are likley to receive a(n) " + Offer3.toLowerCase() + " letter for "
									+ thirdUniDegree + " at " + thirdUni,
							"Offer", JOptionPane.INFORMATION_MESSAGE);
					System.out.println();
					return mid;

				} else if (Double.parseDouble(studentData.get(mid).get(col)) == Double
						.parseDouble(studentData.get(mid + 1).get(col))) {// check for
					// multiple values
					boolean tempStop = false;
					int count = 0; // to check how many more values there are (duplicates)
					while (tempStop == false) {
						for (int i = mid + 1; i <= studentData.size() - 1; i++) { // look through the array, starting
																					// from mid
							// value
							if (i <= studentData.size() - 1) { // make sure i is not more than amount of array indexes
								if (Double.parseDouble(studentData.get(mid).get(col)) == Double
										.parseDouble(studentData.get(i).get(col))) // if duplicate is
									// found, then
									// add to the
									// counter:
									// count
									count++;

								else { // if user value is not found in the next index we search for, then exit out of
										// for loop
										// and while loop
									tempStop = true;
									break;
								}

							} else
								tempStop = false;
							if (i == studentData.size() - 1) {// make sure while loop doesn't go on infinitely by
								// checking if the i value is equal to the last index in array, then exit
								tempStop = true;
							}
						}
					}
					// time to print where multiple values were found //possible delete
					System.out.print("Your average was found in rows " + mid);
					int index = mid + 1;
					for (int print = 1; print <= count; print++) {

						System.out.print(", " + index);// also print out where the duplicates were found
						index++;
					}
					int index2 = mid;
					for (int print = 0; print <= count; print++) {

						// System.out.print(", " + index);// also print out where the duplicates were
						// found
						if (studentData.get(index2).get(0).equals(FirstName)
								&& studentData.get(index2).get(1).equals(LastName)
								&& studentData.get(index2).get(2).equals(firstUni)
								&& studentData.get(index2).get(3).equals(secondUni)
								&& studentData.get(index2).get(4).equals(thirdUni)
								&& studentData.get(index2).get(5).equals(firstUniDegree)
								&& studentData.get(index2).get(6).equals(secondUniDegree)
								&& studentData.get(index2).get(7).equals(thirdUniDegree)
								&& studentData.get(index2).get(8).equals(userMark))
							break;
						index2++;
					}
					String Offer1 = studentData.get(index2).get(9);
					String Offer2 = studentData.get(index2).get(10);
					String Offer3 = studentData.get(index2).get(11);
					JOptionPane.showMessageDialog(null,
							"You were placed in " + (index2 + 1) + " place out of " + studentData.size()
									+ " students in terms of averages\n" + "You are likely to receive a(n) "
									+ Offer1.toLowerCase() + " letter for " + firstUniDegree + " at " + firstUni
									+ "\nYou are likely to receive a(n) " + Offer2.toLowerCase() + " letter for "
									+ secondUniDegree + " at " + secondUni + "\nYou are likely to receive a(n) "
									+ Offer3.toLowerCase() + " letter for " + thirdUniDegree + " at " + thirdUni,
							"Offer", JOptionPane.INFORMATION_MESSAGE);
					System.out.println("");
				} else { // if no multiple values, then state which row the user value was found in
					System.out.print("Your number was found in row " + mid);
					String Offer1 = studentData.get(mid).get(9);
					String Offer2 = studentData.get(mid).get(10);
					String Offer3 = studentData.get(mid).get(11);
					JOptionPane.showMessageDialog(null,
							"You were placed in " + (mid + 1) + " place out of " + studentData.size()
									+ " students in terms of averages\n" + "You are likely to receive a(n) "
									+ Offer1.toLowerCase() + " letter for " + firstUniDegree + " at " + firstUni
									+ "\nYou are likely to receive a(n) " + Offer2.toLowerCase() + " letter for "
									+ secondUniDegree + " at " + secondUni + "\nYou are likely to receive a(n) "
									+ Offer3.toLowerCase() + " letter for " + thirdUniDegree + " at " + thirdUni,
							"Offer", JOptionPane.INFORMATION_MESSAGE);
					System.out.println();
				}

				return mid;

			} else if (Double.parseDouble(studentData.get(mid).get(col)) < key) {/// search in left sub array
				right = mid - 1;
				mid = left + (right - left) / 2;
				return SearchNumber2(studentData, left, right, key, mid, col);

			} else if (Double.parseDouble(studentData.get(mid).get(col)) > key) { // search in right sub array
				left = mid + 1;
				mid = left + (right - left) / 2;
				return SearchNumber2(studentData, left, right, key, mid, col);
			}

			else { // user number is not found
				return -1; // returning negative since it's not a value in a randomized array and doesn't
							// conflict with the program
			}

		} else // not sorted
			return -1; // return -1 if array not sorted

	}

	// this method clears the studentData arraylist
	// @param: the studentData 2d arraylist
	// @return: n/a
	public static void restart(ArrayList<ArrayList<String>> tempstudentData) {
		tempstudentData.clear();
	}

	// this method clears the programs arraylist, and updates option shown by
	// combobox
	// @param: the studentData 2d arraylist
	// @return: n/a
	public static boolean restartPrograms(ArrayList<ArrayList<String>> programs, JComboBox comboBox_Uni1,
			JComboBox comboBox_Uni2, JComboBox comboBox_Uni3, JComboBox comboBox_Uni1Degree,
			JComboBox comboBox_Uni2Degree, JComboBox comboBox_Uni3Degree) {
		programs.clear();
		comboBox_Uni1.setSelectedItem("Universities:"); // update universities, so that update degree can be activated
														// and doesn't cause error
		comboBox_Uni2.setSelectedItem("Universities:");
		comboBox_Uni3.setSelectedItem("Universities:");
		comboBox_Uni1Degree.setModel(new DefaultComboBoxModel(new String[] { "Select University To View Programs" }));
		comboBox_Uni2Degree.setModel(new DefaultComboBoxModel(new String[] { "Select University To View Programs" }));
		comboBox_Uni3Degree.setModel(new DefaultComboBoxModel(new String[] { "Select University To View Programs" }));
		// restart = true;
		return true;

	}

}
