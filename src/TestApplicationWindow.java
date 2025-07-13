/*
 * For testing
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


public class TestApplicationWindow {

	private JFrame frame;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtMark;

	/**
	 * Launch the application.
	 */
	static String[][] studentData = new String[100][9];// change the column number and row number //student data
	static ArrayList<ArrayList<String>> tempStudentData = new ArrayList(); //student data
	static String [] degrees = {"Universities:", "University of Toronto", "University of Waterloo", "McMaster University", "University of Ottawa", "Carleton University", "Toronto Metropolitan University", "Ontario Tech University", "Western University", "York University", "University of Guelph", "Queens University", "Algoma University", "Brock University", "Lakehead University", "Laurentian University", "Nipissing University", "OCAD University", "Trent University", "Wilfrid Laurier University", "University of Windsor"};
	//variables for user entered data
	static String FirstName;
	static String LastName;
	static String firstUni;
	static String secondUni;
	static String thirdUni;
	static String firstUniDegree;
	static String secondUniDegree;
	static String thirdUniDegree;
	static String userMark;
	//boolean variable to let program know when datasets are empty
	public static boolean start = true;
	static ArrayList<ArrayList<String>> programs = new ArrayList(); //arraylist to hold programs
	
	//objects
	static UniversityChoices UniChoice = new UniversityChoices();
	static Students student = new Students();
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestApplicationWindow window = new TestApplicationWindow();
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
	public TestApplicationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setForeground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel ApplicationTitle = new JLabel("Universify");
		ApplicationTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		ApplicationTitle.setHorizontalAlignment(SwingConstants.CENTER);
		ApplicationTitle.setBounds(20, 11, 647, 43);
		frame.getContentPane().add(ApplicationTitle);
		
		JLabel UserFirstNameLabel = new JLabel("Please Enter Your First Name:");
		UserFirstNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		UserFirstNameLabel.setBounds(20, 99, 206, 14);
		frame.getContentPane().add(UserFirstNameLabel);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(222, 98, 132, 20);
		frame.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel UserLastNameLabel = new JLabel("Please Enter Your Last Name:");
		UserLastNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		UserLastNameLabel.setBounds(20, 145, 206, 14);
		frame.getContentPane().add(UserLastNameLabel);
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(222, 144, 132, 20);
		frame.getContentPane().add(txtLastName);
		
		JLabel UserAverageLabel = new JLabel("Please Enter Your Grade 12 Average:");
		UserAverageLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		UserAverageLabel.setBounds(360, 99, 250, 20);
		frame.getContentPane().add(UserAverageLabel);
		
		txtMark = new JTextField();
		txtMark.setColumns(10);
		txtMark.setBounds(620, 98, 57, 20);
		frame.getContentPane().add(txtMark);
		
		JComboBox comboBox_Uni1Degree = new JComboBox();
		comboBox_Uni1Degree.setModel(new DefaultComboBoxModel(new String[] {"Select University To View Programs"}));
		comboBox_Uni1Degree.setFont(new Font("Tahoma", Font.PLAIN, 10));
		comboBox_Uni1Degree.setToolTipText("");
		comboBox_Uni1Degree.setBounds(157, 318, 520, 22);
		frame.getContentPane().add(comboBox_Uni1Degree);
		frame.setBounds(100, 100, 699, 516);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JComboBox comboBox_Uni2Degree = new JComboBox();
		comboBox_Uni2Degree.setFont(new Font("Tahoma", Font.PLAIN, 10));
		comboBox_Uni2Degree.setModel(new DefaultComboBoxModel(new String[] {"Select University To View Programs"}));
		comboBox_Uni2Degree.setToolTipText("");
		comboBox_Uni2Degree.setBounds(180, 360, 497, 22);
		frame.getContentPane().add(comboBox_Uni2Degree);
		
		JComboBox comboBox_Uni3Degree = new JComboBox();
		comboBox_Uni3Degree.setFont(new Font("Tahoma", Font.PLAIN, 10));
		comboBox_Uni3Degree.setModel(new DefaultComboBoxModel(new String[] {"Select University To View Programs"}));
		comboBox_Uni3Degree.setToolTipText("");
		comboBox_Uni3Degree.setBounds(180, 396, 497, 22);
		frame.getContentPane().add(comboBox_Uni3Degree);
		
		JLabel lblPleaseEnterFirst = new JLabel("Please Enter First Priority University:");
		lblPleaseEnterFirst.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPleaseEnterFirst.setBounds(20, 189, 250, 20);
		frame.getContentPane().add(lblPleaseEnterFirst);
		
		JComboBox comboBox_Uni1 = new JComboBox();
		comboBox_Uni1.setModel(new DefaultComboBoxModel(new String[] {"Universities:", "University of Toronto", "University of Waterloo", "McMaster University", "University of Ottawa", "Carleton University", "Toronto Metropolitan University", "Ontario Tech University", "Western University", "York University", "University of Guelph", "Queens University", "Algoma University", "Brock University", "Lakehead University", "Laurentian University", "Nipissing University", "OCAD University", "Trent University", "Wilfrid Laurier University", "University of Windsor"}));
		//comboBox_Uni1.setModel(new DefaultComboBoxModel(degrees));
		comboBox_Uni1.setBounds(291, 190, 211, 22);
		comboBox_Uni1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// what happens when new item button is clicked

				//call method to update degree combobox based on degrees offered by university chosen
				UpdateComboBox(comboBox_Uni1, comboBox_Uni1Degree);

			}
		});
		
		frame.getContentPane().add(comboBox_Uni1);
		
		
		JLabel lblPleaseEnterSecond = new JLabel("Please Enter Second Priority University:");
		lblPleaseEnterSecond.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPleaseEnterSecond.setBounds(20, 220, 274, 20);
		frame.getContentPane().add(lblPleaseEnterSecond);
		
		JComboBox comboBox_Uni2 = new JComboBox();
		comboBox_Uni2.setModel(new DefaultComboBoxModel(new String[] {"Universities:", "University of Toronto", "University of Waterloo", "McMaster University", "University of Ottawa", "Carleton University", "Toronto Metropolitan University", "Ontario Tech University", "Western University", "York University", "University of Guelph", "Queens University", "Algoma University", "Brock University", "Lakehead University", "Laurentian University", "Nipissing University", "OCAD University", "Trent University", "Wilfrid Laurier University", "University of Windsor"}));
		comboBox_Uni2.setToolTipText("");
		comboBox_Uni2.setBounds(291, 223, 211, 22);
		comboBox_Uni2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// what happens when new item button is clicked
				
				//call method to update degree combobox based on degrees offered by university chosen
				UpdateComboBox(comboBox_Uni2, comboBox_Uni2Degree);
				
			}
		});
		frame.getContentPane().add(comboBox_Uni2);
		
		
		JLabel lblPleaseEnterThird = new JLabel("Please Enter Third Priority University:");
		lblPleaseEnterThird.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPleaseEnterThird.setBounds(20, 251, 257, 20);
		frame.getContentPane().add(lblPleaseEnterThird);
		
		
		JComboBox comboBox_Uni3 = new JComboBox();
		comboBox_Uni3.setModel(new DefaultComboBoxModel(new String[] {"Universities:", "University of Toronto", "University of Waterloo", "McMaster University", "University of Ottawa", "Carleton University", "Toronto Metropolitan University", "Ontario Tech University", "Western University", "York University", "University of Guelph", "Queens University", "Algoma University", "Brock University", "Lakehead University", "Laurentian University", "Nipissing University", "OCAD University", "Trent Unviersity", "Wilfrid Laurier University", "University of Windsor"}));
		comboBox_Uni3.setToolTipText("");
		comboBox_Uni3.setBounds(291, 252, 211, 22);
		comboBox_Uni3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// what happens when new item button is clicked
	
				//call method to update degree combobox based on degrees offered by university chosen
				UpdateComboBox(comboBox_Uni3, comboBox_Uni3Degree);

			}
		});
		frame.getContentPane().add(comboBox_Uni3);
		
		JLabel lblFirstUniversityProgram = new JLabel("First University Program");
		lblFirstUniversityProgram.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFirstUniversityProgram.setBounds(0, 317, 178, 20);
		frame.getContentPane().add(lblFirstUniversityProgram);
		
		JLabel lblSecondUniversityProgram = new JLabel("Second University Program");
		lblSecondUniversityProgram.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSecondUniversityProgram.setBounds(0, 359, 178, 20);
		frame.getContentPane().add(lblSecondUniversityProgram);
		
		JLabel lblThirdUniversityProgram = new JLabel("Third University Program");
		lblThirdUniversityProgram.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThirdUniversityProgram.setBounds(0, 395, 178, 20);
		frame.getContentPane().add(lblThirdUniversityProgram);
		 
		JButton submitButton = new JButton("Submit");
		submitButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// what happens when submit button is clicked
				restart(tempStudentData);//make sure student data array list is cleared
				
				//check if user can proceed
				double mark;
				try {
					
				mark = Double.parseDouble(txtMark.getText());
	
				if (mark < 0 || mark > 100)//negative mark not possible and over 100 not possible
					mark = -1; //if user mark is not valid, set mark to -1
			} catch (Exception e2) {// code for improper converting
				mark = -1;
			}
				
				//store user entered degree and degree options
				String Uni1 = comboBox_Uni1.getSelectedItem().toString();
				String Uni1Degree = comboBox_Uni1Degree.getSelectedItem().toString();
				String Uni2 = comboBox_Uni2.getSelectedItem().toString();
				String Uni2Degree = comboBox_Uni2Degree.getSelectedItem().toString();
				String Uni3 = comboBox_Uni3.getSelectedItem().toString();
				String Uni3Degree = comboBox_Uni3Degree.getSelectedItem().toString();
				
				//check if all elements of program are filled before proceeding
				if (txtFirstName.getText().equals(null) || txtLastName.getText().equals(null) || mark==-1 || comboBox_Uni1.getSelectedItem().equals("Universities:") || comboBox_Uni2.getSelectedItem().equals("Universities:") || comboBox_Uni3.getSelectedItem().equals("Universities:")
						|| ((Uni1.equals(Uni2))&&(Uni1Degree.equals(Uni2Degree))) || ((Uni1.equals(Uni3))&&(Uni1Degree.equals(Uni3Degree))) || ((Uni2.equals(Uni3))&&(Uni2Degree.equals(Uni3Degree))) ) {//also check if user entered proper number
					JOptionPane.showMessageDialog(null,
							"Sorry, application is not completed, or is not completed properly", "Warning",
							JOptionPane.INFORMATION_MESSAGE);
			}
				else { //if everything clear, proceed
				//get first name
				String tempFirstName = txtFirstName.getText();
				tempFirstName = tempFirstName.toLowerCase();// make user input into lowercase letters
				// tempFirstName.substring(0, 1).toUpperCase(); // first letter
				// tempFirstName.substring(1); // after 1st letter
				FirstName = tempFirstName.substring(0, 1).toUpperCase() + tempFirstName.substring(1); 
				//made first letter capital and rest lowercase:
				System.out.println(FirstName);
				
				//get second name
				String tempLastName = txtLastName.getText();
				tempLastName = tempLastName.toLowerCase();
	
				LastName = tempLastName.substring(0, 1).toUpperCase() + tempLastName.substring(1); 
			
				System.out.println(LastName);
				
				//format the average into maximum 2 decimals
				//reference: used ChatGPT to figure out how to format decimal, as the numberFormat was was not working
				//prompt: ADD PROMPT THAT I SEARCHED
				DecimalFormat decimalFormat = new DecimalFormat("0.00");
				String formattedNumber = decimalFormat.format(mark);
				userMark = formattedNumber; //format the inputted average to 2 decimal places
				System.out.println(userMark);
				
				//STORE user entered university into university variables
				firstUni = comboBox_Uni1.getSelectedItem().toString();
				secondUni = comboBox_Uni2.getSelectedItem().toString();
				thirdUni = comboBox_Uni3.getSelectedItem().toString();
				
				//store user entered university degree into university degree variables
				firstUniDegree = comboBox_Uni1Degree.getSelectedItem().toString();
				System.out.println(firstUniDegree);
				secondUniDegree = comboBox_Uni2Degree.getSelectedItem().toString();
				System.out.println(secondUniDegree);
				thirdUniDegree = comboBox_Uni3Degree.getSelectedItem().toString();
				System.out.println(thirdUniDegree);
				
				//store variables into studentData 2d array
				studentData[0][0] = FirstName;
				studentData[0][1] = LastName;
				studentData[0][2] = firstUni;
				studentData[0][3] = secondUni;
				studentData[0][4] = thirdUni;
				studentData[0][5] = firstUniDegree;
				studentData[0][6] = secondUniDegree;
				studentData[0][7] = thirdUniDegree;
				studentData[0][8] = userMark;
				
				//intialize randomized first name for other students to populate dataset
				student.InitializeRandFirstName(studentData);
				//intialize randomized last name for other students to populate dataset
				student.InitializeRandLastName(studentData);
				//intialize randomized marks for other students to populate dataset
				student.InitializeRandMarks(studentData);
				//intialize randomized university for other students to populate dataset
				UniChoice.initializeRandUnis(studentData, programs);
				
				System.out.println("");
				System.out.println("Sorted array");
				// call method to sort array based off of highest mark to lowest mark
				SortingData(studentData, 8); //place the 2d array as a parameter and column 8, as that's where the averages are held
				
				//display studentDataArray
				int count3 = 1;
				for (int i = 0; i < studentData.length; i++) {
					System.out.print(count3 + ". ");
					for (int col = 0; col < studentData[0].length; col++) {
						System.out.print(studentData[i][col] + ", ");
						// count++;
					}
					count3++;
					System.out.println("");
				}
				
				
				System.out.println("/n/n");
				System.out.println("Sorted ArrayList");
				
				//copy studentData into 2d arraylist
				for (int tempRow=0;tempRow<studentData.length; tempRow++) {
					ArrayList<String> tempArray=new ArrayList();
					for (int tempCol = 0; tempCol<studentData[0].length; tempCol++) {
						tempArray.add(studentData[tempRow][tempCol]);
					}
					tempStudentData.add(tempArray);
				}
				System.out.println(tempStudentData);
				//display studentData held in 2d arraylist
				int count4 = 1;
				for (int i = 0; i < tempStudentData.size(); i++) {
					System.out.print(count4 + ". ");
					for (int col = 0; col < tempStudentData.get(0).size(); col++) {
						System.out.print(tempStudentData.get(i).get(col) + ", ");
						
					}
					count4++;
					System.out.println("");
				}
				
				//System.out.println(programs);//sucesfully prints, delete this, was just a checker
				
				/*
				for(int i =0; i<studentData.length; i++) {
					for (int col = 0; col<studentData[0].length; col++) {
						studentData[i][col] = null;
					}
				}
				*/
				
				
				/*
				//from here VERYYYYYY IMPOTANT YAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAR
				UniChoice.randomPrograms(tempStudentData, programs);
				int count5 = 1;
				for (int i = 0; i < tempStudentData.size(); i++) {
					System.out.print(count5 + ". ");
					for (int col = 0; col < tempStudentData.get(0).size(); col++) {
						System.out.print(tempStudentData.get(i).get(col) + ", ");
						// count++;
					}
					count5++;
					System.out.println(""); //I added this too see if studentdata updateds properly
				}
				*/
				
				if (JOptionPane.showConfirmDialog(null,
						"Do you want to write studentData into file",
						"File Writer", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					writeFile(studentData);
				}
				
				//get each university characteristics 
				//intliize each program random average cutoff and program capacity
				boolean restart = false;
				UniChoice.ProgramCutoff(programs, restart);
				System.out.println(programs);
				UniChoice.programDecisions(programs, tempStudentData);
				System.out.println(programs);
				
				//search for where user is placed in dataset just solely based on average
				double key = Double.parseDouble(userMark);
				int left = 0; // set left value to zero
				int right = tempStudentData.size() - 1; // set right value to the last 'spot' in array
				int mid = right / 2; // set the initial middle number

				int result = SearchNumber2(tempStudentData, left, right, key, mid, 8);
				if (result == -1)
					System.out.println("Element is not found or your array is not sorted");
				System.out.println();
				
				start = restartPrograms(programs, comboBox_Uni1, comboBox_Uni2, comboBox_Uni3); //reset programs
				}
			}
		});
		submitButton.setBounds(513, 431, 132, 35);
		frame.getContentPane().add(submitButton);
		
	}
	
	//this method updates the degree comboboxe based on the programs offered by the university chosen by user
	//@param: JComboBox comboBox_Uni - the university combobox. JComboBox comboBox_UniDegree - the degree combobox that needs to be updated
	//@return: n/a
	public static void UpdateComboBox (JComboBox comboBox_Uni, JComboBox comboBox_UniDegree ) {
		String [] test = {"No program available"};
		//String [] test2 = {"No program available"};
		
		//if the university chosen by user if U of T
		if (comboBox_Uni.getSelectedItem().equals("University of Toronto")) {
			//check if program started
			start = updateStart(start);
			//read the file that contains the programs offered by u of t, and update the degree combobox
			readUniversityOfTorontoPrograms(comboBox_Uni, comboBox_UniDegree, "University of Toronto", start);
		}
		//the rest: still work in progress; have not put the programs offered by these universities in a file
		else if (comboBox_Uni.getSelectedItem().equals("University of Waterloo")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		}
		else if (comboBox_Uni.getSelectedItem().equals("McMaster University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		}
		else if (comboBox_Uni.getSelectedItem().equals("University of Ottawa")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		}
		else if (comboBox_Uni.getSelectedItem().equals("Carleton University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		}
		else if (comboBox_Uni.getSelectedItem().equals("Toronto Metropolitan University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		}
		else if (comboBox_Uni.getSelectedItem().equals("Ontario Tech University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		}
		else if (comboBox_Uni.getSelectedItem().equals("Western University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		}
		else if (comboBox_Uni.getSelectedItem().equals("York University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		}
		else if (comboBox_Uni.getSelectedItem().equals("University of Guelph")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		}
		else if (comboBox_Uni.getSelectedItem().equals("Queens University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		}
		else if (comboBox_Uni.getSelectedItem().equals("Algoma University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		}
		else if (comboBox_Uni.getSelectedItem().equals("Brock University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		}
		else if (comboBox_Uni.getSelectedItem().equals("Lakehead University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		}
		else if (comboBox_Uni.getSelectedItem().equals("Laurentian University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		}
		else if (comboBox_Uni.getSelectedItem().equals("Nipissing University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		}
		else if (comboBox_Uni.getSelectedItem().equals("OCAD University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		}
		else if (comboBox_Uni.getSelectedItem().equals("Trent University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		}
		else if (comboBox_Uni.getSelectedItem().equals("Wilfrid Laurier University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		}
		else if (comboBox_Uni.getSelectedItem().equals("University of Windsor")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		}
	}
	
	//this method reads the file that contains the program offered by the university chosen, stores them into a 2d arraylist, and updates the combobox options
	//@param: JComboBox comboBox_Uni - the university combobox. JComboBox comboBox_UniDegree - the degree combobox that needs to be updated
	//        university - which universities programs should be read and updated. Start - to see whether dataSets are empty or not
	public static void readUniversityOfTorontoPrograms (JComboBox comboBox_Uni,JComboBox comboBox_UniDegree, String university, boolean start) {

		String fileName = university +"_Programs.txt"; // the name of the text file containing the university programs
		int count = 0;
		// the first time I read the file, I find out how many lines there are, so I can
		// create an array according to the amount of lines
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			String line = in.readLine(); //skip first line

			line = in.readLine();
			while (line != null) // while not end of file, when value is null
			{

				line = in.readLine();

				count++;// count how many lines there are, by increasing the count by 1 each time we
						// read through the line

			}

			 System.out.println("your file has " + count + " lines");
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
			String line1 = read.readLine(); //skip first line
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

		//created a 1d array to just store the program name, which will be shown in combobox
		String [] tempCourseName = new String[count]; 
		//String [] tempCourseCode = new String[count]; 
		
		for (int i = 0; i<tempCourseName.length; i++) {
			//tempData[i] = data[i][0] + " " + data[i][1];//copy course name and course code
			tempCourseName[i] = data[i][0];//copy program name
			//tempCourseCode[i] = data[i][1];
			System.out.println(tempCourseName[i]);
		}
		//update the degree combobox with degrees offered by uni chosen
		comboBox_UniDegree.setModel(new DefaultComboBoxModel(tempCourseName));
		
		//print the data 2d array
		int counttemp = 1;
		for (int i = 0; i < data.length; i++) {
			System.out.print(counttemp + ". ");
			for (int col = 0; col < data[0].length; col++) {
				System.out.print(data[i][col] + ", ");
				//counttemp++;
			}
			counttemp++;
			System.out.println("");
		}
		
		//if programs arraylist is not clear/empty
		if (start!=true) {
			
			//check if program codes are equal by comparing the first program code of both datasets 
			//do not copy if they are same, as this means that programs is already updated with the university programs
			if (!(data[0][1].toString().equals(programs.get(0).get(1).toString()))) { //if program codes not equal
				System.out.println("made it here!2"); //temp for tetsing
				//copy info from data 2d array to programs 2d arraylist for greater flexibility 
				for (int i = 0; i<data.length; i++) {
					ArrayList<String> tempArray = new ArrayList();
					for (int col = 0; col < data[0].length;col++) {
						tempArray.add(data[i][col]);
					}
					programs.add(tempArray); //copy programs into array list
				}
			}

		}
		//if programs 2d arraylist is empty/clear, copy data 2d array into programs arraylist for greater flexibility
		else if (start==true){
			System.out.println("made it here");//test, delete
			//copy data 2d array into arraylist
			for (int i = 0; i<data.length; i++) {
				ArrayList<String> tempArray = new ArrayList();
				for (int col = 0; col < data[0].length;col++) {
					tempArray.add(data[i][col]);
				}
				programs.add(tempArray); //copy programs into array list
			}
			start = false;//set start equal to false
			}
		
		
		System.out.println();
		System.out.println("Checking programs array list");
		//print arraylist to see if updated properly
		int counttemp2 = 1;
		for (int i = 0; i < programs.size(); i++) {
			System.out.print(counttemp2 + ". ");
			for (int col = 0; col < programs.get(0).size(); col++) {
				System.out.print(programs.get(i).get(col) + ", ");
				//counttemp++;
			}
			counttemp2++;
			System.out.println("");
		}
		
		
		
	}
	//this method sorts the data based on highest average to lowest average for comparing purposes
	//@param: array is the dataSet that contains studentData, col is the column where the averages are stored
	//@return: update the 2d array to the sorted 2d array
	private static String[][] SortingData(String[][] array, int col) {

		for (int row = 0; row < array.length - 1; row++) {// go through each row
			int minIndex = row; // the starting row has the initial lowest index value
			for (int i = row + 1; i < array.length; i++) {// go through the rows

				double currentValue = Double.parseDouble(array[i][col]); // I used double instead of integer because the
																	// student
																	// averages are stored as decimals
				double minValue = Double.parseDouble(array[minIndex][col]);
				if (currentValue > minValue) { // update the the smallest row value
					minIndex = i;
				}

			}
			double temp = Double.parseDouble(array[minIndex][col]);
			if (Double.parseDouble(array[row][col]) != temp) {// swap if lowest value is not already at the index being
															// looked at
				String[] temp2 = array[minIndex];
				array[minIndex] = array[row];
				array[row] = temp2;
			}
		}
		return array;
	}
	
	//delete this method, don't need it
	/*
	private static ArrayList<ArrayList<String>> tempSortingData(ArrayList<ArrayList<String>> array, int col) {

		for (int row = 0; row < array.size() - 1; row++) {// go through each row
			int minIndex = row; // the starting row has the initial lowest index value
			for (int i = row + 1; i < array.size(); i++) {// go through the rows

				double currentValue = Double.parseDouble(array.get(i).get(col)); // I used long instead of integer because the
																	// student
																	// number's were too big for int to be used
				double minValue = Double.parseDouble(array.get(minIndex).get(col));
				if (currentValue > minValue) { // update the the smallest row value
					minIndex = i;
				}

			}
			double temp = Double.parseDouble(array.get(minIndex).get(col));
			if (Double.parseDouble(array.get(row).get(col)) != temp) {// swap if lowest value is not already at the index being
															// looked at
				ArrayList<String> temp2 = array.get(minIndex);
				//String[] temp2 = array[minIndex];
				//array.get(minIndex) = array.get(row);
				array.set(minIndex, array.get(row));
				//array[minIndex] = array[row];
				array.set(row, temp2);
				//array[row] = temp2;
			}
		}
		return array;
	}
	*/
	
	//this method writes the studentData dataset(2d array) into a file
	//@parsm: studentData is the 2d array that contaisn the data
	//@return: none
	public static void writeFile(String[][] studentData) {
		String filename = "Student_Info";//create file called

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
	
	//this method updates the start varaiable, by seeing if the programs 2d array list is empty or not
	//@param: start is the boolean variables that tells program wheter it is starting
	//@return: the updated value of the start variable 
	public static boolean updateStart(boolean start) {
		if (programs.isEmpty()) { //if programs does not contain any data, then it is empty, which means program has started or resetted
			return true; //so return true
		}
		else 
			return false;
	}
	/*
	private static int SearchName(String[][] array, int left, int right, String key, int mid, int col) {

		if (right >= left) {

			if (key.equals(array[mid][col])) { // if user input name is found at the middle row, we can look for
												// multiple names
				for (int i = mid; i >= 0; i--) { // go through this for loop so we can insure that we find the
													// initial(first) value
					if (key.equals(array[i][col]))
						mid = i; // update mid value
					else if (!key.equals(array[i][col])) // if the index value is not equal to the key value, then exit
															// out of for, becasue we found first value
						// exit out of loop
						break;
				}
				if (array[mid][col].equals(array[array.length - 1][col])) { // if user value is found at last index in
																			// array, then return mid because
																			// there are no duplicates
					System.out.print("The name was found in row " + mid);
					System.out.println();
					return mid;

				} else if (array[mid][col].equals(array[mid + 1][col])) {// check for multiple names
					boolean tempStop = false;
					int count = 0; // to check how many more names there are (duplicates)
					while (tempStop == false) {
						for (int i = mid + 1; i <= array.length - 1; i++) { // look through the array, starting from mid
																			// row
							if (i <= array.length - 1) { // make sure i is not more than amount of array indexes
								if (array[mid][col].equals(array[i][col])) // if duplicate is found, then add to the
																			// counter: count
									count++;

								else { // if user value is not found in the next index we search for, then exit out of
										// for loop
										// and while loop
									tempStop = true;
									break;
								}

							} else
								tempStop = false;
							if (i == array.length - 1) {// make sure while loop doesn't go on infinitely by
								// checking if the i value is equal to the last index in array, then exit
								tempStop = true;
							}
						}
					}
					// time to print where value was found
					System.out.print("Your name was found in rows " + mid);
					int index = mid + 1;
					for (int print = 1; print <= count; print++) {
						System.out.print(", " + index);// also print out where the duplicates were found
						index++;
					}
					System.out.println("");

				} else {// if only one name:
					System.out.print("Your name was found in row " + mid);
					System.out.println();
				}

				return mid;

			} else if (array[mid][col].compareTo(key) > 0) {/// search in left sub array
				right = mid - 1;
				mid = (right - left) / 2;
				return SearchName(array, left, right, key, mid, col);

			} else if (array[mid][col].compareTo(key) < 0) { // search in right sub array
				left = mid + 1;
				mid = (right + left) / 2;
				return SearchName(array, left, right, key, mid, col);
			}

			else { // user number is not found
				return -1; // returning negative since it's not a value in a randomized array and doesn't
							// conflict with the program
			}

		} else // not sorted
			return -1; // return -1 if array not sorted

	}
	*/
	
	/*
	private static int SearchNumber(ArrayList<ArrayList<String>> studentData, int left, int right, double key, int mid, int col) {

		if (Double.parseDouble(studentData.get(right).get(col)) >= Double.parseDouble(studentData.get(left).get(col))) { // check to see if sorted

			if (key == Double.parseDouble(studentData.get(mid).get(col))) { // if user value is found at the middle row
				for (int i = mid; i >= 0; i--) { // go through this for loop so we can insure that we find the
													// initial(first) value
					if (key == Double.parseDouble(studentData.get(i).get(col)))
						mid = i; // update mid value
					else if (key != Double.parseDouble(studentData.get(i).get(col))) // if the index value is not equal to the key value,
																	// then exit out of for loop
						break;
				}
				if (Double.parseDouble(studentData.get(mid).get(col)) == Double.parseDouble(studentData.get(studentData.size() - 1).get(col))) {
					// if user value is found at last index in array, then return mid becasue
					// there are no duplicates
					System.out.print("Your number was found in row " + mid);
					System.out.println();
					return mid;

				} else if (Double.parseDouble(studentData.get(mid).get(col)) == Double.parseDouble(studentData.get(mid + 1).get(col))) {// check for
																									// multiple values
					boolean tempStop = false;
					int count = 0; // to check how many more values there are (duplicates)
					while (tempStop == false) {
						for (int i = mid + 1; i <= studentData.size() - 1; i++) { // look through the array, starting from mid
																			// value
							if (i <= studentData.size() - 1) { // make sure i is not more than amount of array indexes
								if (Double.parseDouble(studentData.get(mid).get(col)) == Double.parseDouble(studentData.get(i).get(col))) // if duplicate is
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
					// time to print where multiple values were found
					System.out.print("Your number was found in rows " + mid);
					int index = mid + 1;
					for (int print = 1; print <= count; print++) {
						System.out.print(", " + index);// also print out where the duplicates were found
						index++;
					}
					System.out.println("");
				} else { // if no multiple values, then state which row the user value was found in
					System.out.print("Your number was found in row " + mid);
					System.out.println();
				}

				return mid;

			} else if (Double.parseDouble(studentData.get(mid).get(col)) > key) {/// search in left sub array
				right = mid - 1;
				mid = (right - left) / 2;
				return SearchNumber(studentData, left, right, key, mid, col);

			} else if (Double.parseDouble(studentData.get(mid).get(col)) < key) { // search in right sub array
				left = mid + 1;
				mid = (right + left) / 2;
				return SearchNumber(studentData, left, right, key, mid, col);
			}

			else { // user number is not found
				return -1; // returning negative since it's not a value in a randomized array and doesn't
							// conflict with the program
			}

		} else // not sorted
			return -1; // return -1 if array not sorted

	}
	*/
	
	//this method searches for the user's averages, and where it is whithin the studentdata set
	//@param: ADDDDDD PARAMATERESSSSSSSSSSS
	//@return: the index at which the data is found 
	private static int SearchNumber2(ArrayList<ArrayList<String>> studentData, int left, int right, double key, int mid, int col) {

		if (Double.parseDouble(studentData.get(right).get(col)) <= Double.parseDouble(studentData.get(left).get(col))) { // check to see if sorted

			if (key == Double.parseDouble(studentData.get(mid).get(col))) { // if user value is found at the middle row
				for (int i = mid; i >= 0; i--) { // go through this for loop so we can insure that we find the
													// initial(first) value
					if (key == Double.parseDouble(studentData.get(i).get(col)))
						mid = i; // update mid value
					else if (key != Double.parseDouble(studentData.get(i).get(col))) // if the index value is not equal to the key value,
																	// then exit out of for loop
						break;
				}
				if (Double.parseDouble(studentData.get(mid).get(col)) == Double.parseDouble(studentData.get(studentData.size() - 1).get(col))) {
					// if user value is found at last index in array, then return mid becasue
					// there are no duplicates
					System.out.print("Your number was found in row " + mid);
					System.out.println();
					return mid;

				} else if (Double.parseDouble(studentData.get(mid).get(col)) == Double.parseDouble(studentData.get(mid + 1).get(col))) {// check for
																									// multiple values
					boolean tempStop = false;
					int count = 0; // to check how many more values there are (duplicates)
					while (tempStop == false) {
						for (int i = mid + 1; i <= studentData.size() - 1; i++) { // look through the array, starting from mid
																			// value
							if (i <= studentData.size() - 1) { // make sure i is not more than amount of array indexes
								if (Double.parseDouble(studentData.get(mid).get(col)) == Double.parseDouble(studentData.get(i).get(col))) // if duplicate is
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
					// time to print where multiple values were found
					System.out.print("Your number was found in rows " + mid);
					int index = mid + 1;
					for (int print = 1; print <= count; print++) {
						System.out.print(", " + index);// also print out where the duplicates were found
						index++;
					}
					System.out.println("");
				} else { // if no multiple values, then state which row the user value was found in
					System.out.print("Your number was found in row " + mid);
					System.out.println();
				}

				return mid;

			} else if (Double.parseDouble(studentData.get(mid).get(col)) < key) {/// search in left sub array
				right = mid - 1;
				mid = (right - left) / 2;
				return SearchNumber2(studentData, left, right, key, mid, col);

			} else if (Double.parseDouble(studentData.get(mid).get(col)) > key) { // search in right sub array
				left = mid + 1;
				mid = (right + left) / 2;
				return SearchNumber2(studentData, left, right, key, mid, col);
			}

			else { // user number is not found
				return -1; // returning negative since it's not a value in a randomized array and doesn't
							// conflict with the program
			}

		} else // not sorted
			return -1; // return -1 if array not sorted

	}
	//this method clears the studentData arraylist
	//@param: the studentData 2d arraylist
	//@return: n/a
	public static void restart(ArrayList<ArrayList<String>> tempstudentData) {
		tempstudentData.clear();
	}
	
	//this method clears the programs arraylist, and updates option shown by combobox
	//@param: the studentData 2d arraylist
	//@return: n/a
	public static boolean restartPrograms(ArrayList<ArrayList<String>> programs, JComboBox comboBox_Uni1, JComboBox comboBox_Uni2, JComboBox comboBox_Uni3) {
		programs.clear();
		//comboBox_Uni1.setModel(new DefaultComboBoxModel(degrees));
		comboBox_Uni1.setSelectedItem("Universities:"); //update universities, so that update degree can be activated and doesn't cause error
		comboBox_Uni2.setSelectedItem("Universities:");
		comboBox_Uni3.setSelectedItem("Universities:");
		return true;
	
	}
	


}

