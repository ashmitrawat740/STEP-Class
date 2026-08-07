import java.util.Scanner;

public class PalindromeChecker {

    static boolean isPalindromeIterative(String text) {

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {

            if (text.charAt(left) != text.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }

    static boolean recursiveCheck(String text, int left, int right) {

        if (left >= right)
            return true;

        if (text.charAt(left) != text.charAt(right))
            return false;

        return recursiveCheck(text, left + 1, right - 1);
    }

    static boolean isPalindromeRecursive(String text) {

        return recursiveCheck(text, 0, text.length() - 1);
    }

    static boolean isPalindromeArrayReversal(String text) {

        char[] original = text.toCharArray();
        char[] reverse = text.toCharArray();

        int start = 0;
        int end = reverse.length - 1;

        while (start < end) {

            char temp = reverse[start];
            reverse[start] = reverse[end];
            reverse[end] = temp;

            start++;
            end--;
        }

        return String.valueOf(original).equals(String.valueOf(reverse));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.println("Iterative : " +
                (isPalindromeIterative(text) ? "Palindrome" : "Not Palindrome"));

        System.out.println("Recursive : " +
                (isPalindromeRecursive(text) ? "Palindrome" : "Not Palindrome"));

        System.out.println("Array Reversal : " +
                (isPalindromeArrayReversal(text) ? "Palindrome" : "Not Palindrome"));

        sc.close();
    }
}