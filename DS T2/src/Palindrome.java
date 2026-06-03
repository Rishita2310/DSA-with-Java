import java.util.Scanner;
public class Palindrome {
    boolean isPalindrome(String s) {
        String rev = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            rev += s.charAt(i);
        }
        return s.equals(rev);
    }
}
class EasyCircularPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String str = sc.nextLine().toLowerCase().replaceAll("[^a-z0-9]", "");

        char[] Q = new char[str.length()];
        int F = 0;
        int R = -1;

        // EnQ characters
        for (int i = 0; i < str.length(); i++) {
            R = (R + 1) % str.length();
            Q[R] = str.charAt(i);
        }

        // Check palindrome by comparing characters from both ends
        boolean isPalindrome = true;
        int left = F;
        int right = R;
        for (int i = 0; i < str.length() / 2; i++) {
            if (Q[left] != Q[right]) {
                isPalindrome = false;
                break;
            }
            left = (left + 1) % str.length();
            right = (right - 1 + str.length()) % str.length(); // move backward circularly
        }
        if (isPalindrome)
            System.out.println("It's a Palindrome.");
        else
            System.out.println("It's NOT a Palindrome.");
    }
}

