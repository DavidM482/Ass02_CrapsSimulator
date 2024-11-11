import java.lang.Math;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //variables
        String playAgainYN = "";
        boolean valid = false;
        int sum = 0;
        int roll1 = 0;
        int roll2 = 0;

        System.out.println("Welcome to the Craps simulator!");
        System.out.println("Rule 1: If the sum is 2, 3, or 12 it is called 'crapping out' and the game is over with a loss. ");
        System.out.println("Rule 2: If the sum is 7 or 11 it is called a 'natural' and the game is over with a win.");
        System.out.println("Rule 3: For all other values, the sum becomes 'the point' and the user makes subsequent rolls until");
        System.out.println("they either roll a 7, in which case they lose, or they roll the point sum in which case they win.");

        do {
            roll1 = (int) (Math.random() * 6) + 1;
            roll2 = (int) (Math.random() * 6) + 1;
            sum = roll1 + roll2;
            System.out.printf("\n%-7s %2d", "roll 1:", roll1);
            System.out.printf("\n%-7s %2d", "roll 2:", roll2);
            System.out.printf("\n%-7s %2d\n", "sum:", sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Sorry, you crapped out.");
                valid = true;
            } else if (sum == 7 || sum == 11) {
                System.out.println("You Win!");
                valid = true;
            } else {
                System.out.println("Reroll. You must roll a " + sum + " in order to win. A roll of 7 will result in a loss.");
            }
            while (!valid) {
                roll1 = (int) (Math.random() * 6) + 1;
                roll2 = (int) (Math.random() * 6) + 1;
                System.out.printf("\n%-7s %2d", "Roll 1: ", roll1);
                System.out.printf("\n%-7s %2d", "Roll 2: ",roll2);
                System.out.printf("\n%-7s %2d\n", "Sum:", roll1 + roll2);
                if (roll1 + roll2 == sum) {
                    System.out.println("You win!");
                    valid = true;
                } else if (roll1 + roll2 == 7) {
                    System.out.println("Sorry, you crapped out.");
                    valid = true;
                } else {
                    System.out.println("Reroll. You must roll a " + sum + " in order to win. A roll of 7 will result in a loss.");
                }
            }

            System.out.println("\n\nPlay Again? [Y/N]");
            playAgainYN = scan.nextLine();
            valid = false;
        } while (playAgainYN.equalsIgnoreCase("y") || playAgainYN.equalsIgnoreCase("yes"));
    }
}