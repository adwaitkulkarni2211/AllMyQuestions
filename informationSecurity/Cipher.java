package informationSecurity;
import java.util.*;

public class Cipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the plain text: ");
        String plain = sc.nextLine();
        sc.close();

        System.out.println("Encrypted text: ");
        String en = encrypt(plain, 3);
        System.out.println(en);

        System.out.println("Decrypted text: ");
        String de = decrypt(en, 3);
        System.out.println(de);
    }

    public static String encrypt(String str, int shift) {
        String enstr = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int val;
            if (Character.isUpperCase(ch)) {
                val = (int) ch - 65;
            } else {
                val = (int) ch - 97;
            }

            val = (val + shift) % 26;

            if (Character.isUpperCase(ch)) {
                val = val + 65;
            } else {
                val = val + 97;
            }

            enstr += (char) val;
        }
        return enstr;
    }

    public static String decrypt(String str, int shift) {
        String enstr = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int val;
            if (Character.isUpperCase(ch)) {
                val = (int) ch - 65;
            } else {
                val = (int) ch - 97;
            }

            val = ((val - shift) + 26) % 26;

            if (Character.isUpperCase(ch)) {
                val = val + 65;
            } else {
                val = val + 97;
            }

            enstr += (char) val;
        }
        return enstr;
    }
}