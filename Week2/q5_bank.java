import java.util.Scanner;

public class q5_bank {

    static String normalizeReference(String raw) {
        raw = raw.trim();

        String bank = raw.substring(0, 3).toUpperCase();

        return bank + raw.substring(3);
    }

    static String validateAndFormat(String reference) {

        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        String bank = reference.substring(0, 3);
        String date = reference.substring(3, 9);
        String seq = reference.substring(9, 14);

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(bank.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 0; i < 11; i++) {
            if (!Character.isDigit(reference.charAt(i + 3))) {
                return "Invalid: remaining characters must be digits";
            }
        }

        return "[" + bank + "] DATE:  "
                + date.substring(0, 2) + "/"
                + date.substring(2, 4) + "/"
                + date.substring(4, 6)
                + " | SEQ: " + seq; date.substring(2,4) + "/" + date.substring(0,2)
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String raw = sc.nextLine();

        String reference = normalizeReference(raw);

        System.out.println(validateAndFormat(reference));
    }
}