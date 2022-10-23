package cp213;

/**
 * @author kevin lee, 210872060
 * @version 2022-09-28
 */
public class Cipher {
    // Constants
    public static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final int ALPHA_LENGTH = ALPHA.length();

    /**
     * Encipher a string using a shift cipher. Each letter is replaced by a letter
     * 'n' letters to the right of the original. Thus for example, all shift values
     * evenly divisible by 26 (the length of the English alphabet) replace a letter
     * with itself. Non-letters are left unchanged.
     *
     * @param s string to encipher
     * @param n the number of letters to shift
     * @return the enciphered string in all upper-case
     */
    public static String shift(final String s, final int n) {

	String mod = "";

	// find index of substring s

	// shit values /26 evenly

	// replace letter with its self
	// non letters are left unchanged

	for (int i = 0; i < s.length(); i++) {
	    if (Character.isLetter(s.charAt(i))) {
		int index = ALPHA.indexOf(s.charAt(i));
		if ((index + n) <= 26) {
		    index += n;
		} else {

		    index += n;
		    index -= 26 * (n / 26);
		}

		mod += ALPHA.charAt(index);

	    } else {
		mod += s.charAt(i);
	    }
	}
	return mod;
    }

    /**
     * Encipher a string using the letter positions in ciphertext. Each letter is
     * replaced by the letter in the same ordinal position in the ciphertext.
     * Non-letters are left unchanged. Ex:
     *
     * <pre>
    Alphabet:   ABCDEFGHIJKLMNOPQRSTUVWXYZ
    Ciphertext: AVIBROWNZCEFGHJKLMPQSTUXYD
     * </pre>
     *
     * A is replaced by A, B by V, C by I, D by B, E by R, and so on. Non-letters
     * are ignored.
     *
     * @param s          string to encipher
     * @param ciphertext ciphertext alphabet
     * @return the enciphered string in all upper-case
     */
    public static String substitute(final String s, final String ciphertext) {
	String cipher = "AVIBROWNZCEFGHJKLMPQSTUXYD";
	String mod = "";

	// find index of each chr in alpha
	for (int i = 0; i < s.length(); i++) {

	    if (Character.isLetter(s.charAt(i))) {

		int index = ALPHA.indexOf(s.charAt(i));
		mod += cipher.charAt(index);
	    } else {
		mod += s.charAt(i);

	    }
	}

	return mod.toUpperCase();
    }

}
