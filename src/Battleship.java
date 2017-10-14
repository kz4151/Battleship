import java.util.InputMismatchException;
import java.util.Scanner;

public class Battleship {
    public static void main(String[] args) {
        // This is the main file for the program.
        Game battle = new Game();
        // battle.initShips(true);
        // battle.initShips(false);
        boolean gameOver = false;
        boolean legalCoor;
        int turn = 0;
        Scanner sc = new Scanner(System.in);
        int x;
        int y;
        while (!gameOver) {
            turn++;
            legalCoor = false;
            if (turn % 2 == 0) {
                // Player 2's turn
                System.out.println("Player 2's Turn");
                while (!legalCoor) {
                    System.out.println("Enter a X-coordinate between 0-9.");
                    x = sc.nextInt();
                    System.out.println("Enter a Y-coordinate between 0-9.");
                    y = sc.nextInt();
                    legalCoor = checkUserInput(x, y);
                }
                battle.printP1GameGrid();
                System.out.println("Press any key to end your turn");
                sc.next();
            }
            else {
                // Player 1's turn
                System.out.println("Player 1's Turn");
                while (!legalCoor) {
                    System.out.println("Enter a X-coordinate between 0-9.");
                    x = sc.nextInt();
                    System.out.println("Enter a Y-coordinate between 0-9.");
                    y = sc.nextInt();
                    legalCoor = checkUserInput(x, y);
                }
                battle.printP2GameGrid();
                System.out.println("Press any key to end your turn");
                sc.next();
            }
        }
    }

    public static boolean checkUserInput(int x, int y) {
        if ((x > 10 || x < 0)) {
            System.out.println(
                    "Please input X-Coordinates that are between 0 to 9");
            return false;
        }
        else if (y > 10 || y < 0) {
            System.out.println(
                    "Please input Y-Coordinates that are between 0 to 9");
            return false;
        }
        else {
            return true;
        }
    }
}
