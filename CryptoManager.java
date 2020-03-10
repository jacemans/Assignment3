

public class CryptoManager {

	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		boolean stringInBounds = true;

		for (int i = 0; i < plainText.length(); i++)
			if (plainText.charAt(i) < LOWER_BOUND || plainText.charAt(i) > UPPER_BOUND)
				stringInBounds = false;

		return stringInBounds;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		String encrypted = "";
		int ascii = 0;

		for (int i = 0; i < plainText.length(); i++) {
			ascii = plainText.charAt(i) + key;
		
			while (ascii > UPPER_BOUND)
				ascii -= RANGE;
			
			encrypted += Character.toString((char) ascii);
		}
		return encrypted;
	}

	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		String encrypted = "";
		int ascii = 0;

		if (bellasoStr.length() < plainText.length())
			for (int i = 0; i < plainText.length(); i++)
				bellasoStr += bellasoStr.charAt(i);

		for (int j = 0; j < plainText.length(); j++) {
			ascii = plainText.charAt(j) + bellasoStr.charAt(j);
			
			while (ascii > UPPER_BOUND)
				ascii -= RANGE;
			
			encrypted += Character.toString((char) ascii);
		}

		return encrypted;
	}

	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		String plain = "";
		int ascii = 0;
		
		for (int i = 0; i < encryptedText.length(); i++) {
			ascii = encryptedText.charAt(i) - key;
			
			while (ascii < LOWER_BOUND)
				ascii += RANGE;
			
			plain += Character.toString((char) ascii);
		}
		return plain;
	}

	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		String plain = "";
		int ascii = 0;

		if (bellasoStr.length() < encryptedText.length())
			for (int i = 0; i < encryptedText.length(); i++)
				bellasoStr += bellasoStr.charAt(i);

		for (int j = 0; j < encryptedText.length(); j++) {
			ascii = encryptedText.charAt(j) - bellasoStr.charAt(j);
			
			while (ascii < LOWER_BOUND)
				ascii += RANGE;
			
			plain += Character.toString((char) ascii);
		}

		return plain;
	}
}