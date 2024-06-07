import java.io.OptionalDataException;
import java.util.Scanner;

public class Game {

    String[][] gameField = new String[11][11];


    public void startGame() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                if (i == 0 && j > 0) {
                    gameField[i][j] = "" + j;
                } else if (i > 0 && j == 0) {
                    gameField[i][j] = "" + ((char) (64 + i));
                } else {
                    gameField[i][j] = "~";
                }

            }
        }
        gameField[0][0] = " ";
    }

    public void printField() {
        for(int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                System.out.print(gameField[i][j] + " ");
            }
            System.out.println();
        }

    }


    public int AJNum(String value) {
        int num1;
        try {
            num1 = Integer.parseInt("" + value.charAt(1) + value.charAt(2));
        } catch (Exception e) {
            num1 = Integer.parseInt("" + value.charAt(1));
        }
        return num1;
    }


    public void shipsField() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
        while (true) {
            String[] value = input.nextLine().split(" ");
            int num1 = AJNum(value[0]);
            int num2 = AJNum(value[1]);
            int AJ1 = (value[0].charAt(0) - 64);
            int AJ2 = (value[1].charAt(0) - 64);
            if (countShips(AJ1, num1, AJ2, num2) == 5 && plaeyerBoolean(AJ1, num1, AJ2, num2)) {
                playerField(AJ1, num1, AJ2, num2);
                break;
            }
        }
        System.out.println("Enter the coordinates of the Battleship (4 cells):");
        while (true) {
            System.out.println("AIR");
            String[] value = input.nextLine().split(" ");
            int num1 = AJNum(value[0]);
            int num2 = AJNum(value[1]);
            int AJ1 = (value[0].charAt(0) - 64);
            int AJ2 = (value[1].charAt(0) - 64);
            if (countShips(AJ1, num1, AJ2, num2) == 4 && plaeyerBoolean(AJ1, num1, AJ2, num2)) {
                playerField(AJ1, num1, AJ2, num2);
                break;
            }
        }
        System.out.println("Enter the coordinates of the Submarine (3 cells):");
        while (true) {
            System.out.println("AIR");
            String[] value = input.nextLine().split(" ");
            int num1 = AJNum(value[0]);
            int num2 = AJNum(value[1]);
            int AJ1 = (value[0].charAt(0) - 64);
            int AJ2 = (value[1].charAt(0) - 64);
            if (countShips(AJ1, num1, AJ2, num2) == 3 && plaeyerBoolean(AJ1, num1, AJ2, num2)) {
                playerField(AJ1, num1, AJ2, num2);
                break;
            }
        }
        System.out.println("Enter the coordinates of the Cruiser (3 cells):");
        while (true) {
            String[] value = input.nextLine().split(" ");
            int num1 = AJNum(value[0]);
            int num2 = AJNum(value[1]);
            int AJ1 = (value[0].charAt(0) - 64);
            int AJ2 = (value[1].charAt(0) - 64);
            if (countShips(AJ1, num1, AJ2, num2) == 3 && plaeyerBoolean(AJ1, num1, AJ2, num2)) {
                playerField(AJ1, num1, AJ2, num2);
                break;
            }
        }
        System.out.println("Enter the coordinates of the Destroyer (2 cells):");
        while (true) {
            System.out.println("AIR");
            String[] value = input.nextLine().split(" ");
            int num1 = AJNum(value[0]);
            int num2 = AJNum(value[1]);
            int AJ1 = (value[0].charAt(0) - 64);
            int AJ2 = (value[1].charAt(0) - 64);
            if (countShips(AJ1, num1, AJ2, num2) == 2 && plaeyerBoolean(AJ1, num1, AJ2, num2)) {
                playerField(AJ1, num1, AJ2, num2);
                break;
            }
        }
    }


    boolean plaeyerBoolean(int AJ1, int num1, int AJ2, int num2) {
        boolean control_AJ_NUM = false;
        if ((num1 <= 10 && num1 >= 1) && (num2 <= 10 && num2 >= 1) && (AJ1 <= 10 && AJ1 >= 1) && (AJ2 <= 10 && AJ2 >= 1)){
            if ((num1 != num2 && AJ1 == AJ2) || ((num1 == num2 && AJ1 != AJ2))) {
                control_AJ_NUM = true;
            }
        }
        return control_AJ_NUM;
    }

//    public void gameGame(String name) {
//
//        System.out.println("Enter the coordinates of the ship:");
//        boolean control_AJ_NUM = false;
//
//        while (control_AJ_NUM == false) {
//
//            if (control_AJ_NUM == false) {
//                System.out.println("Error!");
//                break;
//            } else {
//                playerField(AJ1, num1, AJ2, num2);
//            }
//        }
//    }



    public void playerField(int AJ1, int NUM1, int AJ2, int NUM2) {
        int count = 0;
        String parts = "";
        if (NUM1 < NUM2 && AJ1 == AJ2) {
            for (int i = NUM1; i <= NUM2; i++) {
                this.gameField[AJ1][i] = "X";
                parts += "" + ((char)(AJ1 + 64)) + i + " ";
                count++;
            }
        } else if (NUM1 > NUM2 && AJ1 == AJ2) {
            for (int i = NUM1; i >= NUM2; i--) {
                this.gameField[AJ1][i] = "X";
                parts += "" + ((char)(AJ1 + 64)) + i + " ";
                count++;
            }
        } else if (AJ1 < AJ2 && NUM1 == NUM2) {
            for (int i = AJ1; i <= AJ2; i++) {
                this.gameField[i][NUM1] = "X";
                parts += "" + ((char)(AJ1 + 63 + i)) + NUM1 + " ";
                count++;
            }

        } else if (AJ1 > AJ2 && NUM1 == NUM2) {
            for (int i = AJ1; i >= AJ2; i--) {
                this.gameField[i][NUM1] = "X";
                parts += "" + ((char) (AJ1 + 58 + i)) + NUM1 + " ";
                count++;
            }
        }

    }


    public int countShips(int AJ1, int NUM1, int AJ2, int NUM2) {
        int count = 0;
        if (NUM1 < NUM2 && AJ1 == AJ2) {
            for (int i = NUM1; i <= NUM2; i++) {
                count++;
            }
        } else if (NUM1 > NUM2 && AJ1 == AJ2) {
            for (int i = NUM1; i >= NUM2; i--) {
                count++;
            }
        } else if (AJ1 < AJ2 && NUM1 == NUM2) {
            for (int i = AJ1; i <= AJ2; i++) {
                count++;
            }
        } else if (AJ1 > AJ2 && NUM1 == NUM2) {
            for (int i = AJ1; i >= AJ2; i--) {
                count++;
            }
        }
        return count;
    }


}