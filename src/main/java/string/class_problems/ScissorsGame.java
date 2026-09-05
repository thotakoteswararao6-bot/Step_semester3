package string.class_problems;

import java.util.*;

public class ScissorsGame{
    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) return "Draw";
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
                (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
                (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random rand = new Random();

        int wins = 0, losses = 0, draws = 0;
        int N = 5;

        System.out.println("=== Rock-Paper-Scissors Game ===");
        for (int i = 1; i <= N; i++) {
            System.out.print("Round " + i + " - Enter your move (Rock/Paper/Scissors): ");
            String playerMove = sc.nextLine();
            String computerMove = moves[rand.nextInt(3)];
            String result = playRound(playerMove, computerMove);

            System.out.println("Round " + i + " — Player: " + playerMove + ", Computer: " + computerMove + " → " + result);

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
        }

        double winPercentage = (wins * 100.0) / N;
        System.out.println("\nFinal Summary:");
        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws + " | Win % = " + winPercentage + "%");
        sc.close();
    }
}
