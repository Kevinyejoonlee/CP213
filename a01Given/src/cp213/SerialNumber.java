package cp213;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author kevin lee 210872060
 * @version 2022-09-23
 */
public class SerialNumber {

    /**
     * Determines if a string contains all digits.
     *
     * @param str The string to test.
     * @return true if str is all digits, false otherwise.
     */
    public static boolean allDigits(final String str) {

	boolean allDigits = true;
	for (int i = 0; i < str.length(); i++)

	{
	    char c = str.charAt(i);

	    if (!Character.isDigit(c)) {
		allDigits = false;

	    }

	}

	return allDigits;
    }

    /**
     * Determines if a string is a good serial number. Good serial numbers are of
     * the form 'SN/nnnn-nnn', where 'n' is a digit.
     *
     * @param sn The serial number to test.
     * @return true if the serial number is valid in form, false otherwise.
     */
    public static boolean validSn(final String sn) {
	boolean valid = true;

	if (!sn.substring(0, 3).equals("SN/") || sn.charAt(7) != '-') {
	    valid = false;
	}
	String mod = sn.substring(3, 7) + sn.substring(8, sn.length());
	for (int i = 0; i < mod.length(); i++) {
	    if (mod.charAt(i) < '0' || mod.charAt(i) > '9') {
		valid = false;
	    }
	}
	return valid;
    }

    /**
     * Evaluates serial numbers from a file. Writes valid serial numbers to
     * good_sns, and invalid serial numbers to bad_sns.
     *
     * @param fileIn  a file already open for reading
     * @param goodSns a file already open for writing
     * @param badSns  a file already open for writing
     */
    public static void validSnFile(final Scanner fileIn, final PrintStream goodSns, final PrintStream badSns) {
	while (fileIn.hasNextLine()) {
	    String line = fileIn.nextLine();
	    if (validSn(line.trim())) {
		goodSns.println(line.trim());
	    } else {
		badSns.println(line.trim());
	    }
	}

	return;
    }
}
