import java.util.Scanner;

public class VernamCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the key from the user
        System.out.println("Enter the key:");
        String key = scanner.nextLine();

        // Get the plaintext from the user
        System.out.println("Enter the plaintext:");
        String plaintext = scanner.nextLine();

        // Encrypt the plaintext
        String ciphertext = encrypt(plaintext, key);

        // Display the results
        System.out.println("Encrypted text: " + ciphertext);

        scanner.close();
    }

    // Encrypt the plaintext using the Vernam cipher and the provided key
    private static String encrypt(String plaintext, String key) {
        StringBuilder ciphertext = new StringBuilder();

        // Ensure the key is the same length as the plaintext
        if (key.length() != plaintext.length()) {
            System.out.println("Error: Key length must match plaintext length.");
            System.exit(1);
        }

        for (int i = 0; i < plaintext.length(); i++) {
            char plainChar = plaintext.charAt(i);
            char keyChar = key.charAt(i);

            // XOR the characters and convert back to char
            char encryptedChar = (char) (plainChar ^ keyChar);

            // Append the encrypted character to the ciphertext
            ciphertext.append(encryptedChar);
        }

        return ciphertext.toString();
    }
}
