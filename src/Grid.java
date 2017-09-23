
public class Grid {
    private char[][] gameGrid;
    private boolean[] airCar;
    private boolean[] battle;
    private boolean[] cruise;
    private boolean[] des1;
    private boolean[] des2;
    private boolean sub1;
    private boolean sub2;

    public Grid() {
        gameGrid = new char[10][10]; // Initializes 10 x 10 game grid
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                gameGrid[i][j] = ' ';
            }
        }
        airCar = new boolean[5];
        battle = new boolean[4];
        cruise = new boolean[3];
        des1 = new boolean[2];
        des2 = new boolean[2];
    }

    public int setShip(int x, int y, boolean vert, int type) {
        // Type: 0 = Air Carrier, 1 = Battleship, 2 = Cruiseship, 3 = Destroyer
        // 1, 4 = Destroyer 2, 5 = Submarine 1, 6 = Submarine 2
        // A = Air Carrier, B = Battleship, C = Cruiseship, D = Destroyer 1, E =
        // Destroyer 2, S =
        // Submarine 1, U = Submarine 2
        if(x > 10 || y > 10) {
            return 0;
        }
        boolean shipSet = false;
        if (type == 5) {
            if(gameGrid[x][y] == ' ') {
                gameGrid[x][y] = 'S';
            }
            else {
                return 2;
            }
        }
        else if (type == 6) {
            if(gameGrid[x][y] == ' ') {
                gameGrid[x][y] = 'U';
            }
            else {
                return 2;
            }
        }
        else {
            if (vert) {
                shipSet = setVertical(x, y, type);
            }
            else {
                shipSet = setHorizontal(x, y, type);
            }
        }
        if(shipSet) {
            System.out.println(1);
            return 1;
        }
        else {
            System.out.println(2);
            return 2;
        }
    }

    public void printGrid() {
        System.out.println(" -----------------------------------------");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(" | " + gameGrid[j][i]);
            }
            System.out.print(" |\n");
            System.out.println(" -----------------------------------------");
        }
    }

    private int getShipSize(int shipType) {
        int shipSize = 0;
        if (shipType == 3 || shipType == 4) {
            shipSize = 2;
        }
        else if (shipType == 2) {
            shipSize = 3;
        }
        else if (shipType == 1) {
            shipSize = 4;
        }
        else {
            shipSize = 5;
        }

        return shipSize;
    }

    private boolean isOccupied(int x, int y, boolean vert, int type) {
        int shipSize = getShipSize(type);
        int tempX = x;
        int tempY = y;
        if (vert) {
            for (int i = 0; i < shipSize; i++) {
                if (gameGrid[x][tempY] != ' ') {
                    return true;
                }
                if(shipSize + y < 11) {
                    tempY++;
                }
                else {
                    tempY--;
                }
            }
        }
        else {
            for (int i = 0; i < shipSize; i++) {
                if (gameGrid[tempX][y] != ' ') {
                    return true;
                }
                if(shipSize + x < 11) {
                    tempX++;
                }
                else {
                    tempX--;
                }
            }
        }
        return false;
    }

    private boolean setVertical(int x, int y, int type) {
        int tempY = y;
        if (!isOccupied(x, y, true, type)) {
            int shipSize = getShipSize(type);
            for (int i = 0; i < shipSize; i++) {
                if (shipSize == 5) {
                    gameGrid[x][tempY] = 'A';
                }
                else if (shipSize == 4) {
                    gameGrid[x][tempY] = 'B';
                }
                else if (shipSize == 3) {
                    gameGrid[x][tempY] = 'C';
                }
                else {
                    if (type == 3) {
                        gameGrid[x][tempY] = 'D';
                    }
                    else {
                        gameGrid[x][tempY] = 'E';
                    }

                }
                if (y + shipSize < 11) {
                    tempY++;
                }
                else {
                    tempY--;
                }
            }
            return true;
        }
        else {
            return false;
        }
    }

    private boolean setHorizontal(int x, int y, int type) {
        int tempX = x;
        if (!isOccupied(x, y, false, type)) {
            int shipSize = getShipSize(type);
            for (int i = 0; i < shipSize; i++) {
                if (shipSize == 5) {
                    gameGrid[tempX][y] = 'A';
                }
                else if (shipSize == 4) {
                    gameGrid[tempX][y] = 'B';
                }
                else if (shipSize == 3) {
                    gameGrid[tempX][y] = 'C';
                }
                else {
                    if (type == 3) {
                        gameGrid[tempX][y] = 'D';
                    }
                    else {
                        gameGrid[tempX][y] = 'E';
                    }

                }
                if (x + shipSize < 11) {
                    tempX++;
                }
                else {
                    tempX--;
                }
            }
            return true;
        }
        else {
            return false;
        }
        
    }

}
