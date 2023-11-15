import java.util.*;
public class CaesarCipher {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Plain Text : ");
        String plainText=input.nextLine();
        String cipherText=Encryption(plainText);
        System.out.println("Resultant Cipher Text after Encryption : "+cipherText);
        String plaintoCipher=Decryption(cipherText);
        System.out.println("Resultant Plain Text after Decryption : "+plaintoCipher);
    }
    public static String Encryption(String plainText) {
        StringBuilder cipherText = new StringBuilder();
        int key=3;
        for (int i = 0; i < plainText.length(); i++) {
            char currentChar = plainText.charAt(i);
            if (Character.isLetter(currentChar)) {
                char encryptedChar = (char) ((Character.toUpperCase(currentChar) + key - 'A') % 26 + 'A');
                cipherText.append(encryptedChar);
            } else {
                cipherText.append(currentChar); // Preserve non-alphabetic characters
            }
        }
        return cipherText.toString();
    }
    public static String Decryption(String plainText){
        StringBuilder cipherText = new StringBuilder();
        int key=3;
        for (int i = 0; i < plainText.length(); i++) {
            char currentChar = plainText.charAt(i);
            if (Character.isLetter(currentChar)) {
                char encryptedChar = (char) ((Character.toUpperCase(currentChar) - key - 'A') % 26 + 'A');
                cipherText.append(encryptedChar);
            } else {
                cipherText.append(currentChar); // Preserve non-alphabetic characters
            }
        }
        return cipherText.toString();
    }

}
