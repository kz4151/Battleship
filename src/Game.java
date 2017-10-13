import java.io.IOException;
import java.util.Scanner;

// Main class for gameplay
public class Game {
    private Grid p1;
    private Grid p2;
    Scanner sc;

    public Game() {
        p1 = new Grid();
        p2 = new Grid();
        sc = new Scanner(System.in);
    }

    // Type: 0 = Air Carrier, 1 = Battleship, 2 = Cruiseship, 3 = Destroyer
    // 1, 4 = Destroyer 2, 5 = Submarine 1, 6 = Submarine 2
    public void initShips(boolean player1) {
        for (int i = 0; i < 7; i++) {
            setShipPositions(i, player1);
            if (player1) {
                printP1Grid();
            }
            else {
                printP2Grid();
            }
        }
        if(player1) {
            System.out.println("Input any character to set up ships for player 2");
            sc.next();
            for(int i = 0; i < 25; i++) {
                System.out.println();
            }
        }
        else {
            System.out.println("Press any character to start the game");
            sc.next();
            for(int i = 0; i < 25; i++) {
                System.out.println();
            }
        }
        
    }

    public void printP1Grid() {
        p1.printGrid();
    }

    public void printP2Grid() {
        p2.printGrid();
    }

    public void setShipPositions(int type, boolean player1) {
        boolean init = false;
        int x;
        int y;
        boolean properOrient = false;
        String shipName = "";
        String orient = "";
        int resultCode = -1;
        shipName = setShipName(type);
        while (!init) {
            System.out.println(
                    "Pick x-coordinate for " + shipName + " between 0-9");
            x = sc.nextInt();
            System.out.println(
                    "Pick y-coordinate for " + shipName + " between 0-9");
            y = sc.nextInt();
            while (!properOrient) {
                System.out.println(
                        "Input V for vertical ship placement. Input H for horizontal ship placement");
                orient = sc.next();
                if (orient.equals("V")) {
                    if (player1) {
                        resultCode = p1.setShip(x, y, true, type);
                    }
                    else {
                        resultCode = p2.setShip(x, y, true, type);
                    }
                    properOrient = true;
                }
                else if (orient.equals("H")) {
                    if (player1) {
                        resultCode = p1.setShip(x, y, false, type);
                    }
                    else {
                        resultCode = p2.setShip(x, y, false, type);
                    }
                    properOrient = true;
                }
                else {
                    System.out.print("Invalid input. ");
                }
            }
            if (resultCode == 0) {
                properOrient = false;
                System.out.println(
                        "Coordinates for both axes has to be in between 0-9");
            }
            else if (resultCode == 2) {
                properOrient = false;
                System.out.println(
                        "Coordinates are already occupied by another ship");
            }
            else {
                init = true;
            }
        }
    }

    private String setShipName(int type) {
        String shipName = " ";
        switch (type) {
        case 0:
            shipName = "Air Carrier";
            break;
        case 1:
            shipName = "Battleship";
            break;
        case 2:
            shipName = "Cruiseship";
            break;
        case 3:
            shipName = "Destroyer 1";
            break;
        case 4:
            shipName = "Destroyer 2";
            break;
        case 5:
            shipName = "Submarine 1";
            break;
        case 6:
            shipName = "Submarine 2";
            break;
        }
        return shipName;
    }

}
