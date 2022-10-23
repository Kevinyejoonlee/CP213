package cp213;

import java.util.Scanner;

/**
 * Class to demonstrate the use of Scanner with a keyboard and File objects.
 *
 * @author Kevin Lee
 * @version 2022-01-08
 */
public class ScannerTest {

    /**
     * returns the number of lines in a file
     *
     * @param source Scanner to process
     * @return number of lines in scanned object
     */
    public static int countLines(final Scanner source) {
	int count = 0;

	// file
	// scanner to read lines
	// while loop
	while (source.hasNextLine()) {
	    source.nextLine();
	    count++;
	}
	return count;
    }

    /**
     * returns number of tokens in a file
     *
     * @param source Scanner to process
     * @return number of tokens in scanned object
     */
    public static int countTokens(final Scanner source) {
	int tokens = 0;

	// for or while loop to count

	while (source.hasNext()) {
	    source.next();
	    tokens++;
	}
	return tokens;
    }

    /**
     * Returns the total of posative integers entered into the program negitive
     * numbers are not allowed when a character ==q the command quits
     *
     *
     *
     * @param keyboard Scanner to process
     * @return total of positive integers entered from keyboard
     */
    public static int readNumbers(final Scanner keyboard) {

	// ask for keyboard input via scanner
	// if posative add if negative coninue
	// break if keyboard key is q

	int total = 0;
	System.out.println("Enter a posative integer: ");
	while (!keyboard.hasNext("q")) {

	    if (keyboard.hasNextInt()) {
		System.out.println("Enter a posative integer: ");
		int myint = keyboard.nextInt();
		if (myint > 0) {
		    total += myint;
		}
	    } else {
		String word = keyboard.next();
		System.out.println(word + " is not an integer or 'q'");
	    }
	}

	return total;

    }
}

///Library/Java/JavaVirtualMachines/jdk-18.0.2.jdk/Contents/Home/bin/javadoc
