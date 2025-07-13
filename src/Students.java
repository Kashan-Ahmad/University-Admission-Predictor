
/*
 * Description: This class is meant to createrandomied students, with first name, last name and a random average to populate the studentData
 * Author: Kashan Ahmad
 * Date: May 17, 2023
 * Version 1.0: No changes made yet
 */
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Students {

	public Students() { // constrcutor for empty students to intialize the student names and averages

	}

	// This methods initializes a random first name for all students in the data set
	// @param: studentData is the dataSet that contains all the student info
	// @return: the updated dataSet
	public String[][] InitializeRandFirstName(String[][] studentData) {// ArrayList<ArrayList<String>> tempStudentData
		for (int i = 1; i < studentData.length; i++) {// initialize random first names
			studentData[i][0] = randFirstName();
		}

		return studentData;
	}

	// This methods initializes a random first last for all students in the data set
	// @param: studentData is the dataSet that contains all the student info
	// @return: the updated dataSet
	public String[][] InitializeRandLastName(String[][] studentData) {
		for (int i = 1; i < studentData.length; i++) {// initialize random first names
			studentData[i][1] = randlastName();
		}
		return studentData;
	}

	// This methods initializes a random average for all students in the data set
	// @param: studentData is the dataSet that contains all the student info
	// @return: the updated dataSet
	public String[][] InitializeRandMarks(String[][] studentData) {
		for (int i = 1; i < studentData.length; i++) {// initialize random mark avereges
			studentData[i][8] = randMark();
		}
		return studentData;
	}

	// This method creates and returns a random average
	// @param: n/a
	// @return: the updated mark stored in a string
	public String randMark() {
		double randomNumber = (double) ((Math.random() * 40) + 60);// choose random average between 60 and 100
		DecimalFormat decimalFormat = new DecimalFormat("0.00");// used chatGPT to figure out how to fomrat decimal
																// because number format didn't work
																// numbers: Prompt: why am i getting an error? double
																// randomNumber = (double) ((Math.random() * 40) + 61);
		// randomNumber = nf.format(randomNumber); <----- part of prompt
		String formattedNumber = decimalFormat.format(randomNumber);
		return formattedNumber;

	}

	// This method creates and returns a random first name
	// @param: n/a
	// @return: the updated first name stored in a string
	public String randFirstName() {
		int randomNumber = (int) (Math.random() * 50);
		String[] firstName = { "Emma", "Liam", "Olivia", "Noah", "Ava", "Sophia", "Isabella", "Mia", "Charlotte",
				"Amelia", "Harper", "Evelyn", "Abigail", "Emily", "Elizabeth", "Sofia", "Avery", "Ella", "Scarlett",
				"Grace", "Chloe", "Victoria", "Riley", "Aria", "Lily", "Zoey", "Penelope", "Layla", "Lillian",
				"Natalie", "Hannah", "Mila", "Leah", "Audrey", "Aurora", "Bella", "Savannah", "Brooklyn", "Lucy",
				"Addison", "Victoria", "Eleanor", "Stella", "Hazel", "Ellie", "Paisley", "Claire", "Skylar", "Violet",
				"Nora" };// used CHAT GPT to pick first names. Prompt was "Create an array of 50 first
							// names"

		String randomName = firstName[randomNumber];
		return randomName;
	}

	// This method creates and returns a random last name
	// @param: n/a
	// @return: the updated last name stored in a string
	public String randlastName() {
		int randomNumber = (int) (Math.random() * 50);

		String[] lastName = { "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore",
				"Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson", "Garcia",
				"Martinez", "Robinson", "Clark", "Rodriguez", "Lewis", "Lee", "Walker", "Hall", "Allen", "Young",
				"King", "Wright", "Lopez", "Hill", "Scott", "Green", "Adams", "Baker", "Gonzalez", "Nelson", "Carter",
				"Mitchell", "Perez", "Roberts", "Turner", "Phillips", "Campbell", "Parker", "Evans", "Edwards",
				"Collins", "Stewart", "Sanchez", "Morris" }; // used CHAT GPT to pick last names. Prompt was "Create an
																// array of 50 last names"
		String randomName = lastName[randomNumber]; // randomly choose last name
		return randomName;
	}
}