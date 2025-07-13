
/*
 * Description: this method intilizes random universities applied to and random programs to the studentData set, and decides wheter students are accepted or not
 * Author: Kashan Ahmad
 * Date: May 18
 * Version 1.0: No changes made yet
 */
import java.util.ArrayList;

public class UniversityChoices {

	// this method analyzes the studentData, program average and capacity to
	// determine whether students are accepted, rejected, or waitlisted into their
	// programs
	// @param: programs is the 2d arraylist that contains the programs, studentData
	// is the 2d array list that contains the student data
	// @return: the updated student data that contains wheteher student got
	// accepted, waitlisted or rejected
	public ArrayList<ArrayList<String>> programDecisions(ArrayList<ArrayList<String>> programs,
			ArrayList<ArrayList<String>> studentData) {

		for (int i = 0; i < studentData.size(); i++) { // go through each student
			while (studentData.get(i).size() <= 11) { // add 3 more columns for acceptance, rejection, or waitlisted for
														// the 3 universities applied to
				studentData.get(i).add("");
			}
			// go through colum 5-8 (where programs are stored)
			for (int col = 5; col < 8; col++) {
				int updatedCol = col + 4; // where the new column will be added
				if (studentData.get(i).get(col).toString().equals("No program available")) {// if there is no program,
																							// enter no offer
					ArrayList<String> NoOffer = new ArrayList();
					NoOffer.add("No offer");
					(studentData.get(i)).set(updatedCol, NoOffer.get(0));// update the array list

				} else { // anylyze u of t programs
					String program = studentData.get(i).get(col);
					int programIndex = -1;
					for (int row = 0; row < programs.size(); row++) { // go through programs array list
						// when program that user applied to is found, store the row at which the
						// program was found
						if (programs.get(row).get(0).equals(program)) {
							programIndex = row; // find program index in program array
							break;
						}
					}

					// check if rejected by checking if student average is below program cutoff
					if (Double.parseDouble(studentData.get(i).get(8)) < Double
							.parseDouble(programs.get(programIndex).get(2))) {
						ArrayList<String> rejected = new ArrayList();
						rejected.add("Rejected");
						(studentData.get(i)).set(updatedCol, rejected.get(0));// update the column to rejection

					} else { // check if accepted or waitlisted
						double studentAverage = Double.parseDouble(studentData.get(i).get(8));// get student average
						int updatedProgramCapacity = Integer.parseInt(programs.get(programIndex).get(4));// get program
																											// capacity
						double programAverage = Double.parseDouble(programs.get(programIndex).get(2));// get program
																										// average

						if ((studentAverage >= programAverage) && (updatedProgramCapacity > 0)) {// if user's average is
																									// greater than or
																									// equal to program
																									// average, and
																									// program capacity
																									// is not 0
							updatedProgramCapacity = updatedProgramCapacity - 1; // update the program capacity amount
							ArrayList<String> accepted = new ArrayList();
							accepted.add("Accepted");
							studentData.get(i).set(updatedCol, accepted.get(0));// update the studentdata by adding the
																				// acceptance
							programs.get(programIndex).set(4, Integer.toString(updatedProgramCapacity)); // Reduce
																											// program
																											// capacity
																											// by 1
						} else {// if not rejected or accepted, put them on waitlist
							ArrayList<String> waitlisted = new ArrayList();
							waitlisted.add("Waitlisted");
							studentData.get(i).set(updatedCol, waitlisted.get(0));
						}
					}

				}
			}
		}

		System.out.println("Programs arraylist: program/course code/average cutoff/total capacity/capacity left");
		int count5 = 1;
		for (int i = 0; i < programs.size(); i++) {
			System.out.print(count5 + ". ");
			for (int col = 0; col < programs.get(0).size(); col++) {
				System.out.print(programs.get(i).get(col) + ", ");
				// count++;
			}
			count5++;
			System.out.println("");
		}
		return studentData;
	}

	// this program creates and initialize a random minimum program average cutoff
	// and program capacity
	// @param: programs is the 2d arraylist that contains all the programs
	public ArrayList<ArrayList<String>> ProgramCutoff(ArrayList<ArrayList<String>> programs, boolean restart) {
		if (restart == false) {
			for (int i = 0; i < programs.size(); i++) {
				// find the average cutoff to be considered
				ArrayList<String> AverageCutoff = new ArrayList();
				String randomNumber = Integer.toString((int) ((Math.random() * 25) + 66));// make max cutoff average 90
				AverageCutoff.add(randomNumber); // replace with randomNumber
				(programs.get(i)).add(2, AverageCutoff.get(0));

				// find the capacity of each program
				ArrayList<String> Capacity = new ArrayList();
				String randomNumber2 = Integer.toString((int) ((Math.random() * 100) + 80));// m
				Capacity.add(randomNumber2);// replace with randomNumber2
				(programs.get(i)).add(3, Capacity.get(0));
				// add this for updated capacity left when doing program decisions
				(programs.get(i)).add(4, Capacity.get(0));
			}
		}
		// if user restart's keep the program capacity and average the same, change the
		// updated capacity
		else if (restart == true) {
			for (int i = 0; i < programs.size(); i++) {
				ArrayList<String> Capacity = new ArrayList();
				String capacity = programs.get(i).get(3);
				Capacity.add(capacity);
				(programs.get(i)).set(4, Capacity.get(0));
			}
		}
		return programs;
	}

	// This method intilized random unis and programs to each student in the
	// studentdata set
	// @param: studentdata is the 2d array that contains all student info. programs
	// is the 2d arraylist that contains all the programs
	// @return n/a
	public String[][] initializeRandUnis(String[][] studentData, ArrayList<ArrayList<String>> programs) {

		for (int i = 1; i < studentData.length; i++) {// initialize random uni choices, go through each student
			boolean cont = true;
			int programSize = programs.size(); // get how many programs there are

			studentData[i][2] = getUniChoice(); // each student has 3 uni choices, first choice is priority. get
												// randomized uni and store in dataset

			if (studentData[i][2].equals("University of Toronto")) {// if the randomized university was u of t
				int randomNumber = (int) (Math.random() * programSize);// randomly choose which program random
																		// people will have if applied to u of t
																		// //programs.size()
				studentData[i][5] = programs.get(randomNumber).get(0);
			} else {
				studentData[i][5] = "No program available"; // since we don't have access to other programs yet, store
															// no program
			}

			studentData[i][3] = getUniChoice(); // get second uni

			if (studentData[i][3].equals("University of Toronto")) { // if ranmoized uni is u of t
				int randomNumber = (int) (Math.random() * programSize);// randomly choose which program random
																		// people will have if applied to u of t
				studentData[i][6] = programs.get(randomNumber).get(0);

				while (cont = true) {
					if (studentData[i][6] == studentData[i][5]) {// if the firs 2 programs are same, change the second
																	// program
						randomNumber = (int) (Math.random() * programSize);
						studentData[i][6] = programs.get(randomNumber).get(0);
					} else {
						cont = false; // programs are not same, so exit
						break;
					}
				}

			} else { // if any other uni, no aces to programs, so no program avaliable
				studentData[i][6] = "No program available";
			}

			cont = true;
			studentData[i][4] = getUniChoice(); // get 3rd uni choice

			if (studentData[i][4].equals("University of Toronto")) { // if program chosen is u of t
				int randomNumber = (int) (Math.random() * programSize);// randomly choose which program
																		// random people will have if
																		// applied to u of t
				studentData[i][7] = programs.get(randomNumber).get(0);

				while (cont = true) { // if any of the programs are same, change 3rd program
					if (studentData[i][7].equals(studentData[i][6]) || studentData[i][7].equals(studentData[i][5])) {
						randomNumber = (int) (Math.random() * programSize);
						studentData[i][7] = programs.get(randomNumber).get(0);
					} else {
						cont = false;// no programs same, so exit out of while loop
						break;
					}
				}
			} else { // if any other uni, exit out of program
				studentData[i][7] = "No program available";
			}
		}
		return studentData;
	}

	// this program return a univerity depending on the randomize number
	// @param: n/a
	// @return: return the randomized university
	public String getUniChoice() {
		int randomNumber = (int) (Math.random() * 11) + 1;// pick a random number

		// return a university name depending on the randomized number
		if (randomNumber == 1) {
			return "University of Toronto";
		} else if (randomNumber == 2) {
			return "University of Waterloo";
		} else if (randomNumber == 3) {
			return "McMaster University";
		} else if (randomNumber == 4) {
			return "University of Ottawa";
		} else if (randomNumber == 5) {
			return "Carleton University";
		} else if (randomNumber == 6) {
			return "Toronto Metropolitan University";
		} else if (randomNumber == 7) {
			return "Ontario Tech University";
		} else if (randomNumber == 8) {
			return "Western University";
		} else if (randomNumber == 9) {
			return "York Univeristy";
		} else if (randomNumber == 10) {
			return "University of Guelph";
		} else if (randomNumber == 11) {
			return "Queens University";
		} else
			return null;
	}

}