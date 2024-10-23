import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rollSum;
        int rollCount;
        int dieOne;
        int dieTwo;
        int goal = 0;
        boolean gameOver;
        boolean goAgain;
        boolean valid;
        String carryOnWith;

        System.out.println("Welcome to the Craps simulator!");
        System.out.println("Rule 1: If the sum is 2, 3, or 12, it is called crapping out and the game is over with a loss.");
        System.out.println("Rule 2: If the sum is 7 or 11 it is called a natural and the game is over with a win");
        System.out.println("Rule 3 For all other values, the sum because the point and the user makes subsequent rolls until \nthey either roll a 7, in which case they lose, or they roll the point sum in which case they win.");

        do {
            goAgain = false;
            gameOver = false;
            rollCount = 0;
            while (!gameOver){
                dieTwo = ((int)(Math.random()*6)) + 1;
                dieOne = ((int)(Math.random()*6)) + 1;
                rollSum = dieTwo + dieOne;
                System.out.println("Dice one: " + dieOne);
                System.out.println("Dice two: " + dieTwo);
                System.out.println("Sum: " + rollSum);
                System.out.println();
                if(rollCount == 0){
                    if(rollSum == 7 || rollSum == 11){
                        System.out.println("You rolled a natural you win.");
                        gameOver = true;
                    } else if(rollSum == 2 || rollSum == 3 || rollSum == 12){
                        System.out.println("You crapped out and losed.");
                        gameOver = true;
                    } else {
                        goal = rollSum;
                        System.out.println("Reroll. Uou most roll a  " + goal + " in order to win. A roll of 7 will result in a loss.");
                    }
                    rollCount++;
                } else {
                    if(rollSum == goal){
                        System.out.println("You matched your first roll you win");
                        gameOver = true;
                    } else if (rollSum == 7) {
                        System.out.println("You rolled a 7 you loss");
                        gameOver = true;
                    } else {
                        System.out.println("Reroll you most roll a " + goal + " in order to win. A roll of 7 will result in a loss");
                    }
                }
            }
            valid = false;

            do {
                System.out.println("Play again? [Y/N]");
                System.out.println();
                carryOnWith = scan.nextLine();
                if(carryOnWith.equalsIgnoreCase("y")){
                    goAgain = true;
                    valid = true;
                } else if (carryOnWith.equalsIgnoreCase("n")) {
                    valid = true;
                } else {
                    System.out.println("You have entered something outside of the range.");
                }
            } while(!valid);
        } while(goAgain);
    }
}