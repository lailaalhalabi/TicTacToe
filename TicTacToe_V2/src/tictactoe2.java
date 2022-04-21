import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Stack;

/**
 * @author Laila Alhalabi ID# 40106558. 
 * COMP352. 
 * Assignment 1, version 2.
 * The purpose of this version is to generate all possible combinations of a string consists of X and O without '#' using iteration. 
 * Due date February 7, 2021.
 */
public class tictactoe2 {
	/**
	 * An iterative method that generates all possible combinations of the charecter
	 * array without '#'
	 * @param row array of characters that takes the row of letters
	 * @param write      an object that writes the data to the file
	 */
	public static void UnHide(String row, PrintStream write) {
		Stack<String> rowStack = new Stack<String>(); // Creating a stack object
		rowStack.push(row); // Adding the row into it by using push()
		int squareIndex = 0; // Declaring an index to find the square index
		while (!rowStack.empty()) { // A while loop that loops till the rowStack gets empty.
			String toReturn = rowStack.pop(); // Storing the string in toReturn and removing recent from rowStack by using pop()
			if ((squareIndex = toReturn.indexOf('#')) != -1) { // If the index is found the square index will be replaced by 'X' or 'O'
				toReturn = toReturn.substring(0, squareIndex) + 'X' + toReturn.substring(squareIndex + 1);
				rowStack.push(toReturn); // Adding
				toReturn = toReturn.substring(0, squareIndex) + 'O' + toReturn.substring(squareIndex + 1);
				rowStack.push(toReturn); // Adding
			} else { // If the index is not found then it is going to print
				System.out.println(toReturn);
				write.println(toReturn);
			}
		}
	}

	static int randomLength; // Decalaring a random length for generating a string

	/**
	 * A method that generates a random row with a random size (size is less than 50) given k 
	 * @param k number of squares 
	 * @return random string consists of random characters and k squares
	 */
	public static String rowGenerator(int k) {
		// Generating a random size of the array.
		Random random = new Random();
		randomLength = random.nextInt(50);
		String XO = "XO"; // Declaring characters of the row X and O
		StringBuilder generatedRow = new StringBuilder(randomLength); // Using StringBuilder to build a string
		int count = 0; // To count the squares number
		for (int i = 0; i < randomLength; i++) { // Generating characters based on the generated length.
			while ((!(count == k)) && i < randomLength) { // Adding '#' for k while generatedRow is less than random length.
				generatedRow.append('#'); // Adding squares to the begining of the string.
				count++;
				i++;
			}
			if (count < randomLength) { // Generating random XO after adding squares till reaching the length.
				int index = (int) (XO.length() * Math.random()); // Generating a random index from the string.
				generatedRow.append(XO.charAt(index)); // Adding the character at the generated index.
			}
		}
		return generatedRow.toString(); // Converting the object into a string
	}

	public static void main(String[] args) {
		PrintStream write = null; // Initializing a PrintStream
		File file = new File("iterationOut.txt"); // Creating a file and declaring a PrintStream to output the rows
		String test; // Initializing a string to test
		try {
			write = new PrintStream(new BufferedOutputStream(new FileOutputStream(file))); // Writing to the file
			System.out.println("\t\tTicTacToa Game!");
			write.println("\t\tTicTacToa Game!");
			for (int k = 2; k <= 24; k = k + 2) { // Incrementing number of squares k by 2 till 24
				long start = System.nanoTime(); // Declaring the start time of the program
				test = rowGenerator(k); // Assignning the string to the row generated 
				// Testing the iterative method
				System.out.println("\nITERATIVE TEST FOR " + test + "\n");
				write.println("\nITERATIVE TEST FOR " + test + "\n");
				UnHide(test, write);
				long end = System.nanoTime(); // Declaring the end time of the program
				// Calculating the execution time, converting it to seconds and printing it
				long executionTime = (end - start);
				double seconds = (double) executionTime / 1000000000;
				System.out.println("\n FOR RUN# " + k + ": The size of the generated array is " + randomLength
						+ "\nThe program took " + seconds + " seconds to be executed.\n"
						+ "---------------------------------------------------------------------\n");
				write.print("\n FOR RUN# " + k + ": The size of the generated array is " + randomLength
						+ "\nThe program took " + seconds + " seconds to be executed.\n"
						+ "---------------------------------------------------------------------\n");
			}
		} catch (Exception e) { // Catching an exception
			e.getMessage();
		}
		write.close(); // Closing the writer
	}
}
