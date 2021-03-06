import java.util.InputMismatchException;
import java.util.Scanner;

public class Battleship {
    public static void main(String[] args) {
        // This is the main file for the program.
        Game battle = new Game();
        battle.initShips(true);
        battle.initShips(false);
        boolean gameOver = false;
        boolean legalCoor;
        boolean even = false;
        int turn = 0;
        Scanner sc = new Scanner(System.in);
        int x = 0;
        int y = 0;
        while (!gameOver) {
            turn++;
            legalCoor = false;
            if (turn % 2 == 0) {
                // Player 2's turn
                System.out.println("Player 2's Turn");
                battle.printP1GameGrid();
                even = true;
            }
            else {
                // Player 1's turn
                System.out.println("Player 1's Turn");
                battle.printP2GameGrid();
                even = false;
            }
            while (!legalCoor) {
                System.out.println("Enter a X-coordinate between 0-9.");
                x = sc.nextInt();
                System.out.println("Enter a Y-coordinate between 0-9.");
                y = sc.nextInt();
                legalCoor = checkUserInput(x, y);
            }
            if(even) {
                battle.setP1Marker(x, y);
                battle.printP1GameGrid();
                gameOver = battle.checkP1GameOver();
                if(gameOver) {
                    System.out.println("Player 2 has won the game!");
                }
            }
            else {
                battle.setP2Marker(x, y);
                battle.printP2GameGrid();
                gameOver = battle.checkP2GameOver();
                if(gameOver) {
                    System.out.println("Player 1 has won the game!");
                }
            }
            System.out.println("Press any key to end your turn");
            sc.next();
        }
    }

    public static boolean checkUserInput(int x, int y) {
        if ((x > 9 || x < 0)) {
            System.out.println(
                    "Please input X-Coordinates that are between 0 to 9");
            return false;
        }
        else if (y > 9 || y < 0) {
            System.out.println(
                    "Please input Y-Coordinates that are between 0 to 9");
            return false;
        }
        else {
            return true;
        }
    }
}
