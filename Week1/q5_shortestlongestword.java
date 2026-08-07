import java.util.Scanner;

public class ShortestLongestWord {

    static String[] findShortestAndLongestWord(String text) {

        text = text.replaceAll("[^a-zA-Z ]", "");

        String[] words = text.trim().split("\\s+");

        String shortest = words[0];
        String longest = words[0];

        for (String word : words) {

            if (word.length() < shortest.length())
                shortest = word;

            if (word.length() > longest.length())
                longest = word;
        }

        return new String[]{shortest, longest};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Sentence: ");
        String sentence = sc.nextLine();

        String[] result = findShortestAndLongestWord(sentence);

        System.out.println("Shortest Word : " + result[0] +
                " (" + result[0].length() + ")");

        System.out.println("Longest Word : " + result[1] +
                " (" + result[1].length() + ")");

        sc.close();
    }
}