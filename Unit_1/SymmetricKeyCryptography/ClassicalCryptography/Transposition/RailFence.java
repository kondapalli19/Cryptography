import java.util.*;
public class RailFence {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Plain Text : ");
        String plainText=input.nextLine();
        String cipherText=Encryption(plainText);
        System.out.println("Resultant Cipher Text after Encryption : "+cipherText);
        String plaintoCipher=Decryption(cipherText);
        System.out.println("Resultant Plain Text after Decryption : "+plaintoCipher);
    }
    public static String Encryption(String plainText){
        StringBuffer cipherText=new StringBuffer();
        for (int i = 0; i < plainText.length(); i+=2) {
            cipherText.append(plainText.charAt(i));
        }
        for (int i = 1; i < plainText.length(); i+=2) {
            cipherText.append(plainText.charAt(i));
        }
        return cipherText.toString();
    }
    public static String Decryption(String cipherText){
        StringBuffer plainText=new StringBuffer();
        for (int i = 0; i < cipherText.length()/2; i++) {
            plainText.append(cipherText.charAt(i));
            if(cipherText.length()%2==0)
            plainText.append(cipherText.charAt((cipherText.length()/2)+i));
            else
            plainText.append(cipherText.charAt((cipherText.length()/2)+i+1));
        }
        if(cipherText.length()%2!=0){
            plainText.append(cipherText.charAt(cipherText.length()/2));
        }
        return plainText.toString();
}
}
