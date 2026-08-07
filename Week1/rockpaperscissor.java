import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {

        if (playerMove.equalsIgnoreCase(computerMove))
            return "Draw";

        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper")))
            return "Player Wins";

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        int rounds = 5;

        int wins = 0;
        int losses = 0;
        int draws = 0;

        String[][] summary = new String[rounds][4];

        for (int i = 0; i < rounds; i++) {

            System.out.print("Enter your move (Rock/Paper/Scissors): ");
            String player = sc.next();

            String computer = moves[random.nextInt(3)];

            String result = playRound(player, computer);

            summary[i][0] = String.valueOf(i + 1);
            summary[i][1] = player;
            summary[i][2] = computer;
            summary[i][3] = result;

            if (result.equals("Player Wins"))
                wins++;
            else if (result.equals("Computer Wins"))
                losses++;
            else
                draws++;

            System.out.println("Computer: " + computer);
            System.out.println(result);
            System.out.println();
        }

        System.out.println("\n----- Final Summary -----");
        System.out.printf("%-8s %-12s %-15s %-15s\n",
                "Round", "Player", "Computer", "Result");

        for (int i = 0; i < rounds; i++) {
            System.out.printf("%-8s %-12s %-15s %-15s\n",
                    summary[i][0], summary[i][1], summary[i][2], summary[i][3]);
        }

        double percentage = (wins * 100.0) / rounds;

        System.out.println("\nWins : " + wins);
        System.out.println("Losses : " + losses);
        System.out.println("Draws : " + draws);
        System.out.printf("Win Percentage : %.2f%%", percentage);

        sc.close();
    }
}