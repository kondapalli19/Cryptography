import java.util.Scanner;

public class HillCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the key matrix from the user
        System.out.println("Enter the 2x2 key matrix for Hill Cipher (space-separated elements):");
        int[][] keyMatrix = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                keyMatrix[i][j] = scanner.nextInt();
            }
        }

        // Clear the buffer
        scanner.nextLine();

        // Get the plaintext from the user
        System.out.println("Enter the plaintext (in uppercase):");
        String plaintext = scanner.nextLine();
        
        // Ensure the plaintext length is even
        if (plaintext.length() % 2 != 0) {
            plaintext += 'X'; // Pad with 'X' if the length is odd
        }

        // Encrypt the plaintext
        String ciphertext = encrypt(plaintext, keyMatrix);

        // Display the results
        System.out.println("Encrypted text: " + ciphertext);

        scanner.close();
    }

    // Encrypt a 2-letter block of plaintext using the provided key matrix
    private static String encrypt(String plaintext, int[][] keyMatrix) {
        StringBuilder ciphertext = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i += 2) {
            // Get the current 2-letter block
            char char1 = plaintext.charAt(i);
            char char2 = plaintext.charAt(i + 1);

            // Convert characters to numerical values (A=0, B=1, ..., Z=25)
            int num1 = char1 - 'A';
            int num2 = char2 - 'A';

            // Apply the key matrix multiplication
            int result1 = (keyMatrix[0][0] * num1 + keyMatrix[0][1] * num2) % 26;
            int result2 = (keyMatrix[1][0] * num1 + keyMatrix[1][1] * num2) % 26;

            // Convert the numerical results back to characters
            char encryptedChar1 = (char) (result1 + 'A');
            char encryptedChar2 = (char) (result2 + 'A');

            // Append the encrypted characters to the ciphertext
            ciphertext.append(encryptedChar1).append(encryptedChar2);
        }

        return ciphertext.toString();
    }
}

