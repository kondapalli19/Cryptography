import java.util.Scanner;

public class PlayFair {
    private static char[][] keyMatrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the key for the Playfair cipher:");
        String key = scanner.nextLine().toUpperCase().replaceAll("[^A-Z]", "");

        System.out.println("Enter the message to be encrypted:");
        String message = scanner.nextLine().toUpperCase().replaceAll("[^A-Z]", "");

        initializeKeyMatrix(key);
        String encryptedMessage = encrypt(message);

        System.out.println("Encrypted Message: " + encryptedMessage);

        scanner.close();
    }

    private static void initializeKeyMatrix(String key) {
        keyMatrix = new char[5][5];
        String keyWithoutDuplicates = removeDuplicateChars(key + "ABCDEFGHIKLMNOPQRSTUVWXYZ");

        int k = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                keyMatrix[i][j] = keyWithoutDuplicates.charAt(k++);
            }
        }
    }

    private static String removeDuplicateChars(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (result.indexOf(String.valueOf(str.charAt(i))) == -1) {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }

    private static String encrypt(String message) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < message.length(); i += 2) {
            char firstChar = message.charAt(i);
            char secondChar;
            if (i + 1 < message.length()) {
                secondChar = message.charAt(i + 1);
            } else {
                // If the message length is odd, pad the last character with 'X'
                secondChar = 'Z';
            }

            result.append(encryptDigraph(firstChar, secondChar));
        }
        return result.toString();
    }

    private static String encryptDigraph(char a, char b) {
        int[] positionA = findPosition(a);
        int[] positionB = findPosition(b);

        if (positionA[0] == positionB[0]) {
            return sameRowEncrypt(positionA, positionB);
        } else if (positionA[1] == positionB[1]) {
            return sameColumnEncrypt(positionA, positionB);
        } else {
            return differentRowColumnEncrypt(positionA, positionB);
        }
    }

    private static int[] findPosition(char c) {
        int[] result = new int[2];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (keyMatrix[i][j] == c) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    private static String sameRowEncrypt(int[] positionA, int[] positionB) {
        int row = positionA[0];
        int colA = (positionA[1] + 1) % 5;
        int colB = (positionB[1] + 1) % 5;

        return "" + keyMatrix[row][colA] + keyMatrix[row][colB];
    }

    private static String sameColumnEncrypt(int[] positionA, int[] positionB) {
        int col = positionA[1];
        int rowA = (positionA[0] + 1) % 5;
        int rowB = (positionB[0] + 1) % 5;

        return "" + keyMatrix[rowA][col] + keyMatrix[rowB][col];
    }

    private static String differentRowColumnEncrypt(int[] positionA, int[] positionB) {
        int rowA = positionA[0];
        int colA = positionB[1];
        int rowB = positionB[0];
        int colB = positionA[1];

        return "" + keyMatrix[rowA][colA] + keyMatrix[rowB][colB];
    }
}
