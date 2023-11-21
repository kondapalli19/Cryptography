import java.util.Scanner;

public class VigenereCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the keyword from the user
        System.out.println("Enter the keyword (only alphabetic characters, no spaces):");
        String keyword = scanner.next().toUpperCase();

        // Clear the buffer
        scanner.nextLine();

        // Get the plaintext from the user
        System.out.println("Enter the plaintext (only alphabetic characters, no spaces):");
        String plaintext = scanner.next().toUpperCase();

        // Encrypt the plaintext
        String ciphertext = encrypt(plaintext, keyword);

        // Display the results
        System.out.println("Encrypted text: " + ciphertext);

        scanner.close();
    }

    // Encrypt the plaintext using the Vigenere cipher and the provided keyword
    private static String encrypt(String plaintext, String keyword) {
        StringBuilder ciphertext = new StringBuilder();
        int keywordLength = keyword.length();

        for (int i = 0; i < plaintext.length(); i++) {
            char plainChar = plaintext.charAt(i);

            // Ignore non-alphabetic characters
            if (!Character.isAlphabetic(plainChar)) {
                ciphertext.append(plainChar);
                continue;
            }

            // Calculate the shift value based on the corresponding keyword character
            char keywordChar = keyword.charAt(i % keywordLength);
            int shift = keywordChar - 'A';

            // Apply the Caesar cipher to encrypt the current character
            char encryptedChar = (char) ((plainChar + shift - 'A') % 26 + 'A');

            // Append the encrypted character to the ciphertext
            ciphertext.append(encryptedChar);
        }

        return ciphertext.toString();
    }
}
