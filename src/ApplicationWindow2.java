
//test
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

public class ApplicationWindow2 {

	private JFrame frame;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtMark;

	/**
	 * Launch the application.
	 */
	static String[][] studentData = new String[100][6];// change the column number
	static String FirstName;
	static String LastName;
	static String firstUni;
	static String secondUni;
	static String thirdUni;
	static String firstUniDegree;
	static String secondUniDegree;
	static String thirdUniDegree;
	static String userMark;
	static ArrayList<ArrayList<String>> programs = new ArrayList();
	static UniversityChoices UniChoice = new UniversityChoices();
	static Students student = new Students();
	
	public static void main(String[] args) {
		//UniversityChoices UniChoice = new UniversityChoices();
		//Students student = new Students();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow2 window = new ApplicationWindow2();
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
	public ApplicationWindow2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//UniversityChoices UniChoice = new UniversityChoices();
		//Students student = new Students();//create objects
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
		
		JComboBox comboBox_Uni1 = new JComboBox();
		//comboBox_Uni1.setToolTipText("");
		//String [] test = {"Engineering","Medcal"};
		//String [] test2 = {"Physiclogy","Kinesocialogy"};
		comboBox_Uni1.setModel(new DefaultComboBoxModel(new String[] {"Universities:", "University of Toronto", "University of Waterloo", "McMaster University", "University of Ottawa", "Carleton University", "Toronto Metropolitan University", "Ontario Tech University", "Western University", "York University", "University of Guelph", "Queens University", "Algoma University", "Brock University", "Lakehead University", "Laurentian University", "Nipissing University", "OCAD University", "Trent University", "Wilfrid Laurier University", "University of Windsor"}));
		comboBox_Uni1.setBounds(291, 190, 211, 22);
		comboBox_Uni1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// what happens when new item button is clicked
			//	if (comboBox_Uni1.getSelectedItem().equals("University of Toronto")) {
					//comboBox_Uni1Degree.
			//		comboBox_Uni1Degree.setModel(new DefaultComboBoxModel(test));
			//	}
			//	else if (comboBox_Uni1.getSelectedItem().equals("University of Waterloo")) {
			//		comboBox_Uni1Degree.setModel(new DefaultComboBoxModel(test2));
			//	}
			//	else if (comboBox_Uni1.getSelectedItem().equals("University of Waterloo")) {
			//		comboBox_Uni1Degree.setModel(new DefaultComboBoxModel(test2));
			//	}
				UpdateComboBox(comboBox_Uni1, comboBox_Uni1Degree);

			}
		});
		
		frame.getContentPane().add(comboBox_Uni1);
		
		JLabel lblPleaseEnterFirst = new JLabel("Please Enter First Priority University:");
		lblPleaseEnterFirst.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPleaseEnterFirst.setBounds(20, 189, 250, 20);
		frame.getContentPane().add(lblPleaseEnterFirst);
		
		JLabel lblPleaseEnterSecond = new JLabel("Please Enter Second Priority University:");
		lblPleaseEnterSecond.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPleaseEnterSecond.setBounds(20, 220, 274, 20);
		frame.getContentPane().add(lblPleaseEnterSecond);
		
		JLabel lblPleaseEnterThird = new JLabel("Please Enter Third Priority University:");
		lblPleaseEnterThird.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPleaseEnterThird.setBounds(20, 251, 257, 20);
		frame.getContentPane().add(lblPleaseEnterThird);
		
		JComboBox comboBox_Uni2 = new JComboBox();
		comboBox_Uni2.setModel(new DefaultComboBoxModel(new String[] {"Universities:", "University of Toronto", "University of Waterloo", "McMaster University", "University of Ottawa", "Carleton University", "Toronto Metropolitan University", "Ontario Tech University", "Western University", "York University", "University of Guelph", "Queens University", "Algoma University", "Brock University", "Lakehead University", "Laurentian University", "Nipissing University", "OCAD University", "Trent University", "Wilfrid Laurier University", "University of Windsor"}));
		comboBox_Uni2.setToolTipText("");
		comboBox_Uni2.setBounds(291, 223, 211, 22);
		comboBox_Uni2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// what happens when new item button is clicked
	
				UpdateComboBox(comboBox_Uni2, comboBox_Uni2Degree);

			}
		});
		frame.getContentPane().add(comboBox_Uni2);
		
		JComboBox comboBox_Uni3 = new JComboBox();
		comboBox_Uni3.setModel(new DefaultComboBoxModel(new String[] {"Universities:", "University of Toronto", "University of Waterloo", "McMaster University", "University of Ottawa", "Carleton University", "Toronto Metropolitan University", "Ontario Tech University", "Western University", "York University", "University of Guelph", "Queens University", "Algoma University", "Brock University", "Lakehead University", "Laurentian University", "Nipissing University", "OCAD University", "Trent Unviersity", "Wilfrid Laurier University", "University of Windsor"}));
		comboBox_Uni3.setToolTipText("");
		comboBox_Uni3.setBounds(291, 252, 211, 22);
		comboBox_Uni3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// what happens when new item button is clicked
	
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
			public void actionPerformed(ActionEvent e) {// what happens when new item button is clicked
				
				//check if user can proceed
				double mark;
				try {
					
				mark = Double.parseDouble(txtMark.getText());
	
				if (mark < 0 || mark > 100)//negative mark not possible and over 100 not possible
					mark = -1;
			} catch (Exception e2) {// code for improper converting
				mark = -1;
			}
				
				String Uni1 = comboBox_Uni1.getSelectedItem().toString();
				String Uni1Degree = comboBox_Uni1Degree.getSelectedItem().toString();
				String Uni2 = comboBox_Uni2.getSelectedItem().toString();
				String Uni2Degree = comboBox_Uni2Degree.getSelectedItem().toString();
				String Uni3 = comboBox_Uni3.getSelectedItem().toString();
				String Uni3Degree = comboBox_Uni3Degree.getSelectedItem().toString();
				
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
				
				DecimalFormat decimalFormat = new DecimalFormat("0.00");
				String formattedNumber = decimalFormat.format(mark);
				userMark = formattedNumber; //format the inputted average to 2 decimal places
				System.out.println(userMark);
				
				firstUni = comboBox_Uni1.getSelectedItem().toString();
				secondUni = comboBox_Uni2.getSelectedItem().toString();
				thirdUni = comboBox_Uni3.getSelectedItem().toString();
				
				firstUniDegree = comboBox_Uni1Degree.getSelectedItem().toString();
				System.out.println(firstUniDegree);
				secondUniDegree = comboBox_Uni2Degree.getSelectedItem().toString();
				System.out.println(secondUniDegree);
				thirdUniDegree = comboBox_Uni3Degree.getSelectedItem().toString();
				System.out.println(secondUniDegree);
				
				studentData[0][0] = FirstName;
				studentData[0][1] = LastName;
				studentData[0][2] = firstUni;
				studentData[0][3] = secondUni;
				studentData[0][4] = thirdUni;
				studentData[0][5] = userMark;
				
				student.InitializeRandFirstName(studentData);
				student.InitializeRandLastName(studentData);
				student.InitializeRandMarks(studentData);
				//UniChoice.initializeRandUnis(studentData);//UPDATEEEEEEE, COMMENTED OUT BECAUSSE DIDNT HAVE PROPER PARAMETERS
				/*
				int count2 = 1;
				for (int i = 0; i < studentData.length; i++) {
					System.out.print(count2 + ". ");
					for (int col = 0; col < studentData[0].length; col++) {
						System.out.print(studentData[i][col] + ", ");
						// count++;
					}
					count2++;
					System.out.println("");
				}
				*/
				System.out.println("");
				System.out.println("Sorted array");
				// sort array based off of highest mark to lowest mark
				SortingData(studentData, 5);
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
				
				if (JOptionPane.showConfirmDialog(null,
						"Do you want to write data into file",
						"File Writer", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					writeFile(studentData);
				}
				//get University choices
				System.out.println(programs);//sucesfully prints, delete this, was just a checker
				}
				

			}
		});
		submitButton.setBounds(513, 431, 132, 35);
		frame.getContentPane().add(submitButton);
		/*
		JComboBox comboBox_Uni1Degree = new JComboBox();
		comboBox_Uni1Degree.setToolTipText("");
		comboBox_Uni1Degree.setBounds(208, 373, 211, 22);
		frame.getContentPane().add(comboBox_Uni1Degree);
		frame.setBounds(100, 100, 699, 516);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		*/
	}
	public static void UpdateComboBox (JComboBox comboBox_Uni, JComboBox comboBox_UniDegree ) {
		String [] test = {"Engineering","Medcal"};
		String [] test2 = {"Physiclogy","Kinesocialogy"};
		
		if (comboBox_Uni.getSelectedItem().equals("University of Toronto")) {
			//comboBox_Uni1Degree.
			readUniversityOfTorontoPrograms(comboBox_Uni, comboBox_UniDegree, "University of Toronto");
			//comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		}
		else if (comboBox_Uni.getSelectedItem().equals("University of Waterloo")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test2));
		}
		else if (comboBox_Uni.getSelectedItem().equals("McMaster University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		}
		else if (comboBox_Uni.getSelectedItem().equals("University of Ottawa")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test2));
		}
		else if (comboBox_Uni.getSelectedItem().equals("Carleton University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		}
		else if (comboBox_Uni.getSelectedItem().equals("Toronto Metropolitan University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test2));
		}
		else if (comboBox_Uni.getSelectedItem().equals("Ontario Tech University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		}
		else if (comboBox_Uni.getSelectedItem().equals("Western University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test2));
		}
		else if (comboBox_Uni.getSelectedItem().equals("York University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		}
		else if (comboBox_Uni.getSelectedItem().equals("University of Guelph")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test2));
		}
		else if (comboBox_Uni.getSelectedItem().equals("Queens University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		}
		else if (comboBox_Uni.getSelectedItem().equals("Algoma University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test2));
		}
		else if (comboBox_Uni.getSelectedItem().equals("Brock University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		}
		else if (comboBox_Uni.getSelectedItem().equals("Lakehead University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test2));
		}
		else if (comboBox_Uni.getSelectedItem().equals("Laurentian University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		}
		else if (comboBox_Uni.getSelectedItem().equals("Nipissing University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test2));
		}
		else if (comboBox_Uni.getSelectedItem().equals("OCAD University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		}
		else if (comboBox_Uni.getSelectedItem().equals("Trent University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test2));
		}
		else if (comboBox_Uni.getSelectedItem().equals("Wilfrid Laurier University")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test));
		}
		else if (comboBox_Uni.getSelectedItem().equals("University of Windsor")) {
			comboBox_UniDegree.setModel(new DefaultComboBoxModel(test2));
		}
	}
	public static void readUniversityOfTorontoPrograms (JComboBox comboBox_Uni,JComboBox comboBox_UniDegree, String university) {

		String fileName = university+"_Programs.txt"; // the name of the csv file containing student info
		//String line;
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
			//String line1;
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

		String [] tempData = new String[count]; 
		
		for (int i = 0; i<tempData.length; i++) {
			tempData[i] = data[i][0] + " " + data[i][1];//copy course name and course code
			System.out.println(tempData[i]);
		}
		
		comboBox_UniDegree.setModel(new DefaultComboBoxModel(tempData));
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
		for (int i = 0; i<data.length; i++) {
			ArrayList<String> tempArray = new ArrayList();
			for (int col = 0; col < data[0].length;col++) {
				tempArray.add(data[i][col]);
			}
			programs.add(tempArray); //copy programs into array list
		}
		
		
	}
	private static String[][] SortingData(String[][] array, int col) {

		for (int row = 0; row < array.length - 1; row++) {// go through each row
			int minIndex = row; // the starting row has the initial lowest index value
			for (int i = row + 1; i < array.length; i++) {// go through the rows

				double currentValue = Double.parseDouble(array[i][col]); // I used long instead of integer because the
																	// student
																	// number's were too big for int to be used
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
	
	public static void writeFile(String[][] studentData) {
		String filename = "Student_Info";

		// write the file
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
			// \t\t\t\t\t\t\t\t\t\t
			writer.write("First Name/ " + "Last Name/ " + "University/ " + "Mark"); // print out the column titles
			writer.newLine();

			for (int row = 0; row < studentData.length; row++) { // go through every row of 2d array
				for (int col = 0; col < studentData[row].length; col++) { // go through every col of every row of 2d

					// System.out.print(array[row][col] + "\t\t");
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
	public static String[][] analyzeDecisions (String [][] studentData) {
		 ArrayList<ArrayList<Integer>> accepted = new ArrayList();
		 ArrayList<ArrayList<Integer>> watlisted = new ArrayList();
		 ArrayList<ArrayList<Integer>> rejected = new ArrayList();
		 
		 return studentData; //temp return type, change it to updated accepted array
	}
}
